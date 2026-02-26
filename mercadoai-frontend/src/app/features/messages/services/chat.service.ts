import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { Observable, Subject } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Page } from '../../../core/models/shared/page';
import { ChatMessageDTO } from '../../../core/models/Chat/ChatMessageDTO';
import { ChatRoomDTO } from '../../../core/models/Chat/ChatRoomDTO';
import { Client, IMessage, StompSubscription } from '@stomp/stompjs';
import { AuthService } from '../../../core/services/auth.service';

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private BASE_URL = `${environment.apiUrl}api/chat`;
  private WS_URL = `${environment.apiUrl}ws-chat/websocket`;

  private stompClient: Client | null = null;
  private messageSubject = new Subject<ChatMessageDTO>();
  public messages$ = this.messageSubject.asObservable();

  // Track active subscriptions to avoid duplicate subscriptions and allow clean unsubscribe
  private subscriptions = new Map<number, StompSubscription | any>();
  private pendingSubscriptions: number[] = [];

  constructor(private http: HttpClient, private authService: AuthService) {}

  createPrivateChat(otherUserId: number): Observable<ChatRoomDTO> {
    const params = new HttpParams().set('otherUserId', otherUserId.toString());
    return this.http.post<ChatRoomDTO>(`${this.BASE_URL}/rooms/private`, null, {
      params,
    });
  }

  getUserChatRooms(): Observable<ChatRoomDTO[]> {
    return this.http.get<ChatRoomDTO[]>(`${this.BASE_URL}/rooms`);
  }

  getChatMessages(
    chatRoomId: number,
    page: number = 0,
    size: number = 20
  ): Observable<Page<ChatMessageDTO>> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
    return this.http.get<Page<ChatMessageDTO>>(
      `${this.BASE_URL}/rooms/${chatRoomId}/messages`,
      { params }
    );
  }

  getRecentMessages(chatRoomId: number): Observable<ChatMessageDTO[]> {
    return this.http.get<ChatMessageDTO[]>(
      `${this.BASE_URL}/rooms/${chatRoomId}/recent`
    );
  }

  // WebSocket Methods
  connect(): void {
    if (this.stompClient?.active) {
      return;
    }

    this.stompClient = new Client({
      brokerURL: this.WS_URL,
      reconnectDelay: 5000,
      connectHeaders: {
        Authorization: 'Bearer ' + this.authService.token,
      },
      heartbeatIncoming: 4000,
      heartbeatOutgoing: 4000,
      debug: (str) => {
        console.log('STOMP: ' + str);
      },
      onConnect: (frame) => {
        console.log('Connected to WebSocket:', frame);
        // Process any subscriptions requested before the connection was active
        if (this.pendingSubscriptions.length > 0) {
          const pending = [...this.pendingSubscriptions];
          this.pendingSubscriptions = [];
          pending.forEach((id) => this.subscribeToChat(id));
        }
      },
      onStompError: (frame) => {
        console.error('STOMP error:', frame);
      },
      onWebSocketError: (error) => {
        console.error('WebSocket error:', error);
      },
    });

    console.log('Connecting to WebSocket...', this.authService.token);

    this.stompClient.activate();
  }

  subscribeToChat(chatRoomId: number): void {
    // Avoid double subscription
    if (this.subscriptions.has(chatRoomId)) {
      console.log('Already subscribed to chat room', chatRoomId);
      return;
    }

    // If not connected yet, queue the subscription
    if (!this.stompClient?.active) {
      if (!this.pendingSubscriptions.includes(chatRoomId)) {
        this.pendingSubscriptions.push(chatRoomId);
      }
      return;
    }

    const subscription = this.stompClient.subscribe(
      `/topic/chat/${chatRoomId}`,
      (message: IMessage) => {
        const chatMessage: ChatMessageDTO = JSON.parse(message.body);
        this.messageSubject.next(chatMessage);
      }
    );

    this.subscriptions.set(chatRoomId, subscription);
  }

  sendMessage(chatRoomId: number, content: string): void {
    if (!this.stompClient?.active) {
      console.error('WebSocket not connected');
      return;
    }

    this.stompClient.publish({
      destination: '/app/chat.send',
      body: JSON.stringify({
        chatRoomId: chatRoomId,
        content: content,
      }),
      headers: {
        Authorization: 'Bearer ' + this.authService.token,
      },
    });
  }

  disconnect(): void {
    // Unsubscribe all topics to avoid duplicate callbacks on reconnect
    this.subscriptions.forEach((sub) => {
      try {
        sub.unsubscribe();
      } catch (e) {
        // ignore
      }
    });
    this.subscriptions.clear();
    this.pendingSubscriptions = [];

    if (this.stompClient?.active) {
      this.stompClient.deactivate();
      console.log('Disconnected from WebSocket');
    }
  }
}
