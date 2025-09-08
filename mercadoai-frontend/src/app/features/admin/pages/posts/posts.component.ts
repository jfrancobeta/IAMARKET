import { Component } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';

@Component({
  selector: 'app-posts',
  standalone: true,
  imports: [MainLayoutComponent],
  templateUrl: './posts.component.html',
})
export class PostsComponent {

}
