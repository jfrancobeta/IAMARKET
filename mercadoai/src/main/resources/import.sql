-- Usuario 100% admin (sin perfil)
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (1, 'SuperAdmin', 'admin@admin.com', 'admin', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', NULL, 'Administrador total', '2025-07-30', '2025-07-30', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');

-- Usuarios desarrolladores
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (2, 'John', 'john.doe@example.com', 'johndev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Desarrollador backend', '2025-07-30', '2025-07-30', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (3, 'Jane', 'jane.smith@example.com', 'janedev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Frontend developer', '2025-07-30', '2025-07-30', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (6, 'Carlos', 'carlos.m@example.com', 'carlosdev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Desarrollador fullstack', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (7, 'Sofia', 'sofia.r@example.com', 'sofiadev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Desarrolladora móvil', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (8, 'Diego', 'diego.l@example.com', 'diegodev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Especialista en DevOps', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (9, 'Ana', 'ana.p@example.com', 'anadev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Desarrolladora Python', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (10, 'Luis', 'luis.v@example.com', 'luisdev', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1, 'Desarrollador React/Node.js', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');

-- Usuarios compañía
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (4, 'Laura', 'laura.m@example.com', 'lauracomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Empresa de tecnología', '2025-07-30', '2025-07-30', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (5, 'Michael', 'michael.b@example.com', 'michaelcomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Consultora de software', '2025-07-30', '2025-07-30', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (11, 'Patricia', 'patricia.g@example.com', 'patriciacomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Startup fintech', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (12, 'Roberto', 'roberto.h@example.com', 'robertocomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Empresa de e-commerce', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (13, 'Carmen', 'carmen.s@example.com', 'carmencomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Agencia digital', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (14, 'Fernando', 'fernando.n@example.com', 'fernandocomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Empresa de logística', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');
INSERT INTO usuarios (id, nombre, email, username, password, user_type, descripcion, fecha_creacion, fecha_actualizacion, estado, foto) VALUES (15, 'Valeria', 'valeria.t@example.com', 'valeriacomp', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 0, 'Empresa de salud digital', '2025-08-06', '2025-08-06', true, 'https://res.cloudinary.com/dfjremvhf/image/upload/v1755657501/imagen_obccks.webp');

-- Perfiles desarrollador
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (1, 2, 'Java, Spring Boot', 5, 'https://portfolio.johndev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (2, 3, 'Angular, TypeScript', 3, 'https://portfolio.janedev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (3, 6, 'React, Node.js, MongoDB', 4, 'https://portfolio.carlosdev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (4, 7, 'Flutter, Kotlin, Swift', 6, 'https://portfolio.sofiadev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (5, 8, 'Docker, Kubernetes, AWS', 7, 'https://portfolio.diegodev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (6, 9, 'Python, Django, Machine Learning', 4, 'https://portfolio.anadev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (7, 10, 'React, Node.js, Express', 3, 'https://portfolio.luisdev.com');

-- Perfiles compañía
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (1, 4, 'Tech Solutions', 'Tecnología', 'https://techsolutions.com', 'Bogotá');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (2, 5, 'SoftConsulting', 'Consultoría', 'https://softconsulting.com', 'Medellín');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (3, 11, 'PayTech Solutions', 'Fintech', 'https://paytech.com', 'Cali');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (4, 12, 'EcoMart Digital', 'E-commerce', 'https://ecomart.com', 'Barranquilla');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (5, 13, 'Creative Digital Agency', 'Marketing Digital', 'https://creativedigital.com', 'Bogotá');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (6, 14, 'LogiTech Express', 'Logística', 'https://logitech.com', 'Cartagena');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria, website, ubicacion) VALUES (7, 15, 'HealthTech Colombia', 'Salud Digital', 'https://healthtech.co', 'Medellín');


-- Solo los roles solicitados
INSERT INTO roles (id, nombre) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, nombre) VALUES (2, 'ROLE_DEVELOPER');
INSERT INTO roles (id, nombre) VALUES (3, 'ROLE_COMPANY');


-- Asignar roles
-- SuperAdmin solo admin
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);

-- John y Jane desarrolladores
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);

-- Nuevos desarrolladores
INSERT INTO users_roles (user_id, role_id) VALUES (6, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (7, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (8, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (9, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (10, 2);

-- Laura y Michael compañías
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 3);

-- Nuevas compañías
INSERT INTO users_roles (user_id, role_id) VALUES (11, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (12, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (13, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (14, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (15, 3);

-- Estados
INSERT INTO estados (id, nombre) VALUES (0, 'Pendiente');
INSERT INTO estados (id, nombre) VALUES (1, 'En Proceso');
INSERT INTO estados (id, nombre) VALUES (2, 'Completada');
INSERT INTO estados (id, nombre) VALUES (3, 'Cancelada');

-- Habilidades
INSERT INTO habilidades (id, nombre, descripcion) VALUES (1, 'Java', 'Lenguaje de programación orientado a objetos');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (2, 'Spring Boot', 'Framework para desarrollo de aplicaciones Java');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (3, 'Angular', 'Framework para aplicaciones web frontend');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (4, 'SQL', 'Lenguaje para gestión de bases de datos relacionales');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (5, 'Docker', 'Plataforma para contenedores y despliegue de aplicaciones');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (6, 'Python', 'Lenguaje de programación multiparadigma');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (7, 'JavaScript', 'Lenguaje de programación para desarrollo web');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (8, 'TypeScript', 'Superset de JavaScript con tipado estático');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (9, 'HTML', 'Lenguaje de marcado para páginas web');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (10, 'CSS', 'Lenguaje de estilos para páginas web');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (11, 'React', 'Librería para interfaces de usuario web');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (12, 'Node.js', 'Entorno de ejecución para JavaScript en servidor');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (13, 'Express', 'Framework para aplicaciones web en Node.js');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (14, 'C#', 'Lenguaje de programación orientado a objetos de Microsoft');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (15, 'ASP.NET', 'Framework para aplicaciones web en .NET');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (16, 'PHP', 'Lenguaje de programación para desarrollo web backend');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (17, 'Laravel', 'Framework para aplicaciones web en PHP');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (18, 'Ruby', 'Lenguaje de programación dinámico y orientado a objetos');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (19, 'Rails', 'Framework para aplicaciones web en Ruby');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (20, 'Go', 'Lenguaje de programación eficiente y concurrente');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (21, 'Kotlin', 'Lenguaje de programación moderno para JVM y Android');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (22, 'Swift', 'Lenguaje de programación para iOS y macOS');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (23, 'Flutter', 'Framework para aplicaciones móviles multiplataforma');
INSERT INTO habilidades (id, nombre, descripcion) VALUES (24, 'MongoDB', 'Base de datos NoSQL orientada a documentos');

-- Necesidades

-- Necesidades con expected_deliverables
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (1, 'Desarrollar API REST', 'Crear una API RESTful en Spring Boot', 'Backend', 2500, 4, '2025-08-15', 'Debe incluir autenticación JWT', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (2, 'Frontend Angular', 'Construir interfaz web en Angular', 'Frontend', 1800, 5, '2025-09-01', 'Responsive y con login', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (3, 'Migración a Docker', 'Contenerizar aplicación existente', 'DevOps', 1200, 11, '2025-08-20', 'Documentar pasos de despliegue', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (4, 'Base de datos NoSQL', 'Implementar MongoDB para microservicio', 'Database', 1500, 12, '2025-08-25', 'Alta disponibilidad', 2, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (5, 'App móvil Flutter', 'Desarrollar app multiplataforma', 'Mobile', 3000, 13, '2025-09-10', 'Push notifications y login social', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (6, 'Landing Page', 'Diseñar landing page moderna', 'Frontend', 800, 14, '2025-08-05', 'SEO optimizado', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (7, 'Automatización con Python', 'Script para automatizar reportes', 'Backend', 950, 15, '2025-08-12', 'Soporte para Excel y PDF', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (8, 'Integración de pagos', 'Agregar pagos con Stripe', 'Backend', 1100, 4, '2025-08-18', 'Soporte para tarjetas y transferencias', 2, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (9, 'Dashboard React', 'Dashboard administrativo', 'Frontend', 2000, 5, '2025-09-02', 'Gráficas y filtros', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria, presupuesto, compania_id, fecha_limite, requirements, estado_id, fecha_creacion, fecha_actualizacion) VALUES (10, 'API para móviles', 'Backend para app móvil', 'Backend', 2200, 11, '2025-09-15', 'Autenticación y notificaciones', 0, '2025-07-30', '2025-07-30');

-- Propuestas para las primeras 5 necesidades
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (1, 1, 2, 2300, '2025-08-10', 'Puedo entregar la API con autenticación JWT y documentación.', 0, '2025-08-01');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (2, 1, 3, 2400, '2025-08-12', 'Incluyo pruebas unitarias y despliegue en Heroku.', 1, '2025-08-02');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (3, 2, 6, 1700, '2025-08-20', 'Frontend responsive y login con JWT.', 0, '2025-08-03');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (4, 3, 7, 1150, '2025-08-15', 'Contenerización completa y documentación.', 2, '2025-08-04');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (5, 4, 8, 1450, '2025-08-22', 'Implemento MongoDB y alta disponibilidad.', 1, '2025-08-05');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (6, 5, 9, 2900, '2025-09-05', 'App Flutter con push notifications.', 0, '2025-08-06');
INSERT INTO propuestas (id, necesidad_id, desarrollador_id, precio, entrega, descripcion, estado_id, fecha_creacion)VALUES (6, 5, 9, 2900, '2025-09-05', 'App Flutter con push notifications.', 0, '2025-08-06');

-- Relación necesidades-habilidades (más ejemplos)
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (1, 2);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (1, 1);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (2, 3);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (2, 8);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (3, 5);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (4, 24);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (5, 23);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (6, 9);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (6, 10);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (7, 6);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (7, 4);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (8, 7);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (8, 16);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (9, 11);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (9, 12);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (10, 1);
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (10, 2);

-- Relación necesidades-habilidades
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (1, 2); -- API REST requiere Spring Boot
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (1, 1); -- API REST requiere Java
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (2, 3); -- Frontend requiere Angular
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (2, 8); -- Frontend requiere TypeScript
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (3, 5); -- Docker
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (4, 24); -- MongoDB
INSERT INTO necesidad_habilidad (necesidad_id, habilidad_id) VALUES (5, 23); -- Flutter