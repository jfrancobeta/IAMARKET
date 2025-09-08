import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CategoriaDTO } from '../../../core/models/Categoria/CategoriaDTO';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { NecesidadSummaryDTO } from '../../../core/models/Necesidad/NecesidadSummaryDTO';
import { CategoriaService } from '../../../core/services/categoria.service';
import { EstadoService } from '../../../core/services/estado.service';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { NeedService } from '../services/need.service';

@Component({
  selector: 'app-needs',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, FormsModule, CommonModule],
  templateUrl: './needs.component.html',
})
export class NeedsComponent implements OnInit {
  constructor(
    private needsService: NeedService,
    private categoriaService: CategoriaService,
    private estadoService: EstadoService
  ) {}

  needs: NecesidadSummaryDTO[] = [];

  filtros = {
    search: '',
    categoria: '',
    estado: '',
    page: 0,
    size: 10,
  };
  categorias: CategoriaDTO[] = [];

  estados: EstadoDTO[] = [];

  totalPages = 0;

  ngOnInit(): void {
    this.loadNeeds();
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
    this.loadNeeds();
  }

  loadNeeds() {
    this.needsService.getAll(this.filtros).subscribe((page) => {
      this.needs = page.content;
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
      this.loadNeeds();
    }
  }
}
