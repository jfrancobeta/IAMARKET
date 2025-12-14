export interface ChatMessageDTO {
  id: number;
  chatRoomId: number;
  senderId: number;
  senderName: string;
  content: string;
  sentAt: string;
  read: boolean;
}