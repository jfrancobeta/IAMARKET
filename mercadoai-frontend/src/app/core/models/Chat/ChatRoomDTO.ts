export interface ChatRoomDTO {
  id: number;
  name: string;
  isPrivate: boolean;
  participantIds: number[];
  lastMessageTime?: string;
  unreadCount?: number;
}