import { Component } from '@angular/core';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-details-solutions',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './details-solutions.component.html',
})
export class DetailsSolutionsComponent {

}
