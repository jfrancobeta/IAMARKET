import {
  Component,
  ElementRef,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChatMessageDTO } from '../../../core/models/Chat/ChatMessageDTO';
import { ChatRoomDTO } from '../../../core/models/Chat/ChatRoomDTO';
import { ChatService } from '../services/chat.service';
import { AuthService } from '../../../core/services/auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-messages',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule],
  templateUrl: './messages.component.html',
})
export class MessagesComponent implements OnInit, OnDestroy {
  chatRooms: ChatRoomDTO[] = [];
  selectedRoom: ChatRoomDTO | null = null;
  messages: ChatMessageDTO[] = [];
  newMessage: string = '';
  currentUserId: number | null = null;

  @ViewChild('messageContainer') messageContainer!: ElementRef<HTMLDivElement>;

  constructor(
    private chatService: ChatService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.loadChatRooms();
    this.chatService.connect();

    this.currentUserId = this.authService.user.usuario;
    console.log('Current User ID:', this.currentUserId);
    // Subscribe to new messages
    this.chatService.messages$.subscribe((message) => {
      if (this.selectedRoom && message.chatRoomId === this.selectedRoom.id) {
        this.messages.push(message);
        this.messages = this.messages.sort(
          (a, b) => new Date(a.sentAt).getTime() - new Date(b.sentAt).getTime()
        );
        setTimeout(() => this.scrollToBottom(), 100);
      }
    });

    this.route.paramMap.subscribe((params) => {
      const roomIdParam = params.get('id');
      if (roomIdParam) {
        const selectWhenReady = () => {
          const room = this.chatRooms.find((r) => r.id === +roomIdParam);
          if (room) {
            this.selectRoom(room);
          } else {
            setTimeout(selectWhenReady, 100);
          }
        };
        selectWhenReady();
      }
    });
  }

  ngOnDestroy(): void {
    this.chatService.disconnect();
  }

  loadChatRooms(): void {
    this.chatService.getUserChatRooms().subscribe({
      next: (rooms) => {
        this.chatRooms = rooms;
      },
      error: (err) => console.error('Error loading chat rooms:', err),
    });
  }

  selectRoom(room: ChatRoomDTO): void {
    this.selectedRoom = room;
    this.loadMessages(room.id);
    this.chatService.subscribeToChat(room.id);
  }

  loadMessages(chatRoomId: number): void {
    this.chatService.getRecentMessages(chatRoomId).subscribe({
      next: (messages) => {
        this.messages = messages.sort(
          (a, b) => new Date(a.sentAt).getTime() - new Date(b.sentAt).getTime()
        );
        setTimeout(() => this.scrollToBottom(), 100);
      },
      error: (err) => console.error('Error loading messages:', err),
    });
  }

  sendMessage(): void {
    if (!this.selectedRoom || !this.newMessage.trim()) {
      return;
    }

    this.chatService.sendMessage(this.selectedRoom.id, this.newMessage);
    this.newMessage = '';
  }

  isMyMessage(message: ChatMessageDTO): boolean {
    return message.senderId === this.currentUserId;
  }

  private scrollToBottom(): void {
    if (this.messageContainer) {
      this.messageContainer.nativeElement.scrollTop =
        this.messageContainer.nativeElement.scrollHeight;
    }
  }
}
