import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { SolucionSummaryDTO } from '../../../core/models/Solucion/SolucionSummaryDTO';
import { SolutionService } from '../services/solution.service';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { CategoriaDTO } from '../../../core/models/Categoria/CategoriaDTO';
import { EstadoService } from '../../../core/services/estado.service';
import { CategoriaService } from '../../../core/services/categoria.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-solutions',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, FormsModule, CommonModule],
  templateUrl: './solutions.component.html',
})
export class SolutionsComponent implements OnInit {
  soluciones: SolucionSummaryDTO[] = [];

  filtros = {
    search: '',
    categoria: '',
    estado: '',
    page: 0,
    size: 6,
  };

  constructor(
    private solutionService: SolutionService,
    private categoriaService: CategoriaService,
    private estadoService: EstadoService
  ) {}

  categorias: CategoriaDTO[] = [];

  estados: EstadoDTO[] = [];

  totalPages = 0;
  ngOnInit(): void {
    this.loadSoluciones();
    this.loadCategorias();
    this.loadEstados();
  }

  clearFilters() {
    this.filtros = {
      search: '',
      categoria: '',
      estado: '',
      page: 0,
      size: 10,
    };
    this.loadSoluciones();
  }

  loadSoluciones() {
    this.solutionService.getAll(this.filtros).subscribe((page) => {
      this.soluciones = page.content;
      this.totalPages = page.totalPages;
    });
  }

  loadCategorias() {
    this.categoriaService.getAll().subscribe((categorias) => {
      this.categorias = categorias;
    });
  }

  loadEstados() {
    this.estadoService.getAll().subscribe((estados) => {
      this.estados = estados;
    });
  }

  changePage(page: number) {
    if (page >= 0 && page < this.totalPages) {
      this.filtros.page = page;
      this.loadSoluciones();
    }
  }
}
