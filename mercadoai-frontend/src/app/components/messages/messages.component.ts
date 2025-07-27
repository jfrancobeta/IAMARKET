import { Component } from '@angular/core';
import { MainLayoutComponent } from "../layout/main-layout/main-layout.component";

@Component({
  selector: 'app-messages',
  standalone: true,
  imports: [MainLayoutComponent],
  templateUrl: './messages.component.html',
})
export class MessagesComponent {

}
