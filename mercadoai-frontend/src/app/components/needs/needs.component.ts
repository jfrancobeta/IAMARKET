import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from "../layout/main-layout/main-layout.component";
import { NeedService } from '../../services/need.service';
import { Necesidad } from '../../models/need/Necesidad';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-needs',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './needs.component.html',
 
})
export class NeedsComponent implements OnInit {

  constructor(private needsService: NeedService) { } 

  needs: Necesidad[] = [];

  ngOnInit(): void {
    this.needsService.getAll().subscribe(needs => {
      this.needs = needs;
      console.log('Needs loaded:', this.needs);
    });
  }



}
