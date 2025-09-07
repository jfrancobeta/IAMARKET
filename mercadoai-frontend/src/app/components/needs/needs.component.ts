import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../layout/main-layout/main-layout.component';
import { NeedService } from '../../services/need.service';
import { RouterModule } from '@angular/router';
import { NecesidadSummaryDTO } from '../../models/Necesidad/NecesidadSummaryDTO';
import { FormsModule } from '@angular/forms';
import { CategoriaDTO } from '../../models/Categoria/CategoriaDTO';
import { CategoriaService } from '../../services/categoria.service';
import { CommonModule } from '@angular/common';
import { EstadoDTO } from '../../models/Estado/EstadoDTO';
import { EstadoService } from '../../services/estado.service';

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
