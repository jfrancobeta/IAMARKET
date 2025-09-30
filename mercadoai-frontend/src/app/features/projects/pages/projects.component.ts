import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { ProyectoService } from '../services/proyecto.service';
import { ProyectoDTO } from '../../../core/models/Proyecto/ProyectoDTO';
import { ProyectoSummaryDTO } from '../../../core/models/Proyecto/ProyectoSummaryDTO';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { EstadoService } from '../../../core/services/estado.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule],
  templateUrl: './projects.component.html',
})
export class ProjectsComponent implements OnInit {
  proyectos: ProyectoSummaryDTO[] = [];
  totalPages = 0;

  filtros = {
    page: 0,
    size: 10,
    estado: '',
    tipo: '',
    search: ''
  };

  estados: EstadoDTO[] = [];

  constructor(private proyectoService: ProyectoService,
    private estadoService: EstadoService
  ) {}

  ngOnInit(): void {
    this.loadProjects();
    this.loadEstados();
  }

  loadProjects(): void {
    this.proyectoService.getAll(this.filtros).subscribe((page) => {
      this.proyectos = page.content;
      this.totalPages = page.totalPages;
      console.log(this.proyectos);
    });
  }
  loadEstados(): void {
    this.estadoService.getAll().subscribe((data) => {
      this.estados = data;
    }); 
  }

}
