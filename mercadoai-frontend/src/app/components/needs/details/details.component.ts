import { Component } from '@angular/core';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './details.component.html',
})
export class DetailsComponent {

}
