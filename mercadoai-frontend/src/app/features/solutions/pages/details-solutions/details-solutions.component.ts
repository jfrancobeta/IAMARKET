import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';

@Component({
  selector: 'app-details-solutions',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './details-solutions.component.html',
})
export class DetailsSolutionsComponent {

}
