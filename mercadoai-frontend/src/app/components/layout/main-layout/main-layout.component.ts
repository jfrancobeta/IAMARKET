import { Component } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { HeaderComponent } from "../header/header.component";

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [SidebarComponent, HeaderComponent],
  templateUrl: './main-layout.component.html',
})
export class MainLayoutComponent {

}
