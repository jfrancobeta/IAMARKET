import { Component } from '@angular/core';
import { MainLayoutComponent } from "../layout/main-layout/main-layout.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [MainLayoutComponent],
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent {

}
