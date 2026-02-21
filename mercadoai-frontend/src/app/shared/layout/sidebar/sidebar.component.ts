import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './sidebar.component.html',
})
export class SidebarComponent implements OnInit {
  isAdmin: boolean = false;
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    console.log(this.authService.isAdmin());
    this.isAdmin = this.authService.isAdmin();
    console.log('isAdmin:', this.isAdmin);
  }

}
