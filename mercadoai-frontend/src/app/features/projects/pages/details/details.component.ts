import { Component } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [MainLayoutComponent, RouterLink],
  templateUrl: './details.component.html',
})
export class DetailsComponent {

}
