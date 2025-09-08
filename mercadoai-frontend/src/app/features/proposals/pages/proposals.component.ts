import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';

@Component({
  selector: 'app-proposals',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './proposals.component.html',
})
export class ProposalsComponent {

}
