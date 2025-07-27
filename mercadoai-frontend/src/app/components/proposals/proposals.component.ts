import { Component } from '@angular/core';
import { MainLayoutComponent } from "../layout/main-layout/main-layout.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-proposals',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './proposals.component.html',
})
export class ProposalsComponent {

}
