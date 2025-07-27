import { Component } from '@angular/core';
import { MainLayoutComponent } from "../layout/main-layout/main-layout.component";

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [MainLayoutComponent],
  templateUrl: './profile.component.html',
})
export class ProfileComponent {

}
