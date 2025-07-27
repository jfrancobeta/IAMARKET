import { Component } from '@angular/core';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './create.component.html',
})
export class CreateComponent {

}
