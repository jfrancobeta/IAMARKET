Backlog - Funcionalidades faltantes en el frontend (implementaciones concretas)

Este archivo lista únicamente las funcionalidades del frontend que están estáticas o incompletas y requieren implementación.

1) Notifications (sin lógica de datos)
- Archivos: mercadoai-frontend/src/app/features/notifications/pages/notifications.component.ts y .html
- Problema: la plantilla estática no consume ningún servicio; las notificaciones están hardcodeadas en la vista.
- Implementación: crear NotificationService para consumir GET /api/notifications, endpoints para marcar como leído, paginación y filtros; soportar actualización en tiempo real (WebSocket/SSE) o polling.

2) Admin - Users (lista estática y filtros no implementados)
- Archivos: mercadoai-frontend/src/app/features/admin/pages/users/users.component.ts y users.component.html
- Problema: componente vacío; la tabla y selects en la plantilla son estáticos.
- Implementación: añadir UserService (GET /api/admin/users), integración de filtros (tipo/estado), paginación, acciones (activar/desactivar, cambiar rol), y confirmaciones UI.

3) Admin - Posts (moderación) (estático)
- Archivos: mercadoai-frontend/src/app/features/admin/pages/posts/posts.component.ts y posts.component.html
- Problema: plantilla muestra ejemplos estáticos y no carga datos de backend.
- Implementación: PostsService con endpoints para listar posts, filtrar por tipo/estado, revisar/aceptar/rechazar; UI de búsqueda y paginación.

4) Admin - Stats (panel vacío)
- Archivos: mercadoai-frontend/src/app/features/admin/pages/stats/stats.component.ts y stats.component.html
- Problema: componente vacío; métricas en la UI son estáticas.
- Implementación: StatsService que consulte endpoints (ej. GET /api/admin/stats) y alimente los widgets (ingresos, pagos pendientes, usuarios activos, proyectos), manejar refresco y errores.

5) Perfil de usuario - Details (sin datos ni edición)
- Archivos: mercadoai-frontend/src/app/features/profile/pages/details-user/details-user.component.ts y .html
- Problema: plantilla con placeholders; no carga perfil real ni portfolio; imágenes son placeholders.
- Implementación: ProfileService para GET /api/profiles/{id}, editar perfil, subir avatar/portafolio (integración Cloudinary/endpoint de upload), mostrar historial de proyectos y calificaciones.

6) Avatares / imágenes estáticas en UI
- Archivos (ejemplos): pagos, mensajes, notificaciones y páginas admin usan `/placeholder.svg` en muchas plantillas (buscar en mercadoai-frontend/src/app/**).
- Problema: la UI no muestra avatars reales ni URLs dinámicas.
- Implementación: propagar campo avatarUrl en DTOs, usar binding [src]="item.avatarUrl || '/placeholder.svg'", e implementar carga/guardado en ProfileService y/o Cloudinary.

7) Modales y selects con valores hardcodeados (ej. modal de pagos)
- Archivos: mercadoai-frontend/src/app/features/payments/pages/payments.component.html y otros.
- Problema: proyectos y métodos de pago mostrados están hardcodeados en el HTML.
- Implementación: cargar lista de proyectos del usuario y métodos de pago desde servicios (ProjectService, PaymentService) y poblar selects; añadir validación de formulario y manejo de envío en el modal.

8) Páginas de administración y vistas sin protección de permisos en UI
- Archivos: varios admin components (users, posts, stats)
- Problema: la UI no condiciona acciones según rol y no usa guardas de ruta.
- Implementación: usar AuthService para condicionar la UI (mostrar/ocultar botones) y proteger rutas con guards (canActivate) basados en roles.

9) Chat (UX y suscripciones)
- Archivos principales: mercadoai-frontend/src/app/features/messages/pages/messages.component.ts y services/chat.service.ts
- Estado: cliente corregido para evitar suscripciones duplicadas; queda mejorar UX:
  - Mostrar estado de conexión (connecting/connected/disconnected).
  - Asegurar que al crear sala nueva y navegar a /messages/:id la sala se seleccione y suscriba inmediatamente (reintentos actuales existen pero testear casos fallidos).
- Implementación: exponer estado desde ChatService y mostrar en UI; añadir tests E2E para flujo creación de sala y primer envío de mensajes.

10) Formularios sin validación o sin feedback consistente
- Archivos: varios (create need/solution, send-proposal, payments modal, filtros)
- Problema: validación es mínima y no hay manejo centralizado de errores del servidor.
- Implementación: aplicar validaciones (Reactive Forms o Template-driven con ngModel), mostrar errores inline y toasts para errores de servidor.

Prioridad recomendada (mínimo viable)
1. Notifications: traer datos reales y acciones básicas (leer/marcar)
2. Profile Details: mostrar/editar perfil y avatars
3. Admin Users & Posts: listas y acciones básicas de moderación
4. Reemplazar placeholders de imágenes en vistas críticas
5. Modal de pagos: poblar dinámicamente y validar envío
6. Chat: indicador de conexión y pruebas E2E para creación de sala

Siguiente paso
- Puedo convertir cada item en tareas (todos) y empezar por Notifications o Profile Details; indícame con cuál empezar.
