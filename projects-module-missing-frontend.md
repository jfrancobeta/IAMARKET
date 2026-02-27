Informe: Faltantes e implementaciones "quemadas" en el módulo Projects (Frontend)

Resumen:
Listado de elementos en el frontend del módulo "projects" que están estáticos, con datos hardcodeados o sin handler/implementación, y acciones recomendadas para dejarlos funcionales.

Archivos inspeccionados:
- mercadoai-frontend/src/app/features/projects/pages/projects.component.html
- mercadoai-frontend/src/app/features/projects/pages/projects.component.ts
- mercadoai-frontend/src/app/features/projects/pages/details/details.component.html
- mercadoai-frontend/src/app/features/projects/pages/details/details.component.ts
- mercadoai-frontend/src/app/features/projects/services/proyecto.service.ts

Elementos detectados (qué falta / por implementar):

1) Cards de estadísticas con datos hardcodeados
- Ubicación: projects.component.html (tarjetas superiores)
- Ejemplos: "3", "1", "$20,000", "77%" están escritos en el HTML.
- Acción recomendada: crear un endpoint (p.ej. GET /proyectos/stats) o usar getAll para calcular counts y promedios; exponer método en ProyectoService y bindear los valores en la plantilla.

2) Campo de búsqueda sin binding ni disparador
- Ubicación: projects.component.html, input de buscar (placeholder "Buscar proyectos...") no tiene [(ngModel)] ni (keyup).
- Acción: enlazar a filtros.search con ngModel y llamar loadProjects() en (ngModelChange) o en (keyup.enter) para filtrar.

3) Botón "Filtros" sin funcionalidad
- Ubicación: projects.component.html
- Acción: implementar un panel desplegable de filtros o toggle que permita filtros avanzados; ligar a métodos en ProjectsComponent.

4) Lista de proyectos con sintaxis de servidor y datos parcialmente hardcodeados
- Ubicación: projects.component.html
- Problemas: uso de "@for/@if" en lugar de *ngFor/*ngIf; además aparecen valores hardcodeados dentro de cada tarjeta como "TechCorp Solutions", "Ana García", "Entrega: 15/02/2024" y barras de progreso fijas (75%).
- Acción: convertir a *ngFor="let proyecto of proyectos" y reemplazar los valores estáticos por propiedades reales del DTO (empresa, desarrollador, fechaEntrega, progreso calculado).

5) Botones "Mensaje" y "Chat Directo" sin handlers
- Ubicación: projects.component.html (botón Mensaje) y details.component.html (Chat Directo)
- Acción: añadir (click) que abra la sala de chat o redirija a /messages/:roomId; usar ChatService para crear/seleccionar sala y navegar.

6) Progreso y fechas mostradas de forma estática
- Ubicación: projects.component.html (barra de progreso y porcentajes), details.component.html (posibles valores por defecto)
- Acción: implementar función que calcule porcentaje por hitos/entregables o exponer campo progreso en el backend y bindearlo.

7) Enlaces routerLink con interpolación de cadena (mejorar binding)
- Ejemplo: routerLink="/projects/{{proyecto.id}}" funciona pero es preferible [routerLink]="['/projects', proyecto.id]" para seguridad y claridad.
- Acción: reemplazar interpolaciones por binding de array cuando corresponda.

8) Avatares / imágenes y nombres hardcodeados en cards
- Ubicación: projects.component.html y details.component.html muestran nombres/alt fijos o placeholder images.
- Acción: usar propiedades del DTO (cliente.nombre, desarrollador.nombre, avatarUrl) y fallback a placeholder si no existe.

9) Paginación/estado listable incompleto
- Ubicación: projects.component.ts y template no muestran controles de paginación robustos (existe totalPages pero no controles visibles).
- Acción: añadir componentes de paginación (anteriores/siguientes/páginas) y enlazarlos con filtros.page y loadProjects().

Prioridad recomendada (mínimo para funcionalidad básica):
1. Corregir *ngFor/*ngIf y remover contenido hardcodeado en la lista para que projects renderice correctamente con datos reales.
2. Enlazar búsqueda y paginación (ngModel + loadProjects) para permitir navegación real entre resultados.
3. Implementar handlers de Mensaje/Chat Directo y calcular/mostrar progreso real.

Siguiente paso sugerido:
- Si se autoriza, crear tareas (todos) por cada item crítico y empezar por "projects-convert-list-to-ngfor" y "projects-stats-api".

Si quieres, creo automáticamente los todos y empiezo por el primer item (convertir la lista a *ngFor y quitar valores hardcodeados).