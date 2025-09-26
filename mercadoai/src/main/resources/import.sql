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

--Categorias-- Industrias
INSERT INTO industrias (id, nombre) VALUES (1, 'Tecnología');
INSERT INTO industrias (id, nombre) VALUES (2, 'Finanzas');
INSERT INTO industrias (id, nombre) VALUES (3, 'Salud');
INSERT INTO industrias (id, nombre) VALUES (4, 'Educación');
INSERT INTO industrias (id, nombre) VALUES (5, 'Manufactura');
INSERT INTO industrias (id, nombre) VALUES (6, 'Construcción');
INSERT INTO industrias (id, nombre) VALUES (7, 'Transporte');
INSERT INTO industrias (id, nombre) VALUES (8, 'Agricultura');
INSERT INTO industrias (id, nombre) VALUES (9, 'Energía');
INSERT INTO industrias (id, nombre) VALUES (10, 'Comercio');
INSERT INTO industrias (id, nombre) VALUES (11, 'Turismo');
INSERT INTO industrias (id, nombre) VALUES (12, 'Alimentos y Bebidas');
INSERT INTO industrias (id, nombre) VALUES (13, 'Telecomunicaciones');
INSERT INTO industrias (id, nombre) VALUES (14, 'Automotriz');
INSERT INTO industrias (id, nombre) VALUES (15, 'Publicidad');
INSERT INTO industrias (id, nombre) VALUES (16, 'Consultoría');
INSERT INTO industrias (id, nombre) VALUES (17, 'Legal');
INSERT INTO industrias (id, nombre) VALUES (18, 'Medios de Comunicación');
INSERT INTO industrias (id, nombre) VALUES (19, 'Bienes Raíces');
INSERT INTO industrias (id, nombre) VALUES (20, 'Logística');
INSERT INTO industrias (id, nombre) VALUES (21, 'Minería');
INSERT INTO industrias (id, nombre) VALUES (22, 'Química');
INSERT INTO industrias (id, nombre) VALUES (23, 'Seguros');
INSERT INTO industrias (id, nombre) VALUES (24, 'Arte y Entretenimiento');
INSERT INTO industrias (id, nombre) VALUES (25, 'Deportes');
INSERT INTO industrias (id, nombre) VALUES (26, 'Ambiental');
INSERT INTO industrias (id, nombre) VALUES (27, 'Electrónica');
INSERT INTO industrias (id, nombre) VALUES (28, 'Farmacéutica');
INSERT INTO industrias (id, nombre) VALUES (29, 'Recursos Humanos');
INSERT INTO industrias (id, nombre) VALUES (30, 'Servicios Públicos');

-- Categorías de desarrollo
INSERT INTO categorias (id, nombre) VALUES (1, 'Backend');
INSERT INTO categorias (id, nombre) VALUES (2, 'Frontend');
INSERT INTO categorias (id, nombre) VALUES (3, 'DevOps');
INSERT INTO categorias (id, nombre) VALUES (4, 'Database');
INSERT INTO categorias (id, nombre) VALUES (5, 'Mobile');
INSERT INTO categorias (id, nombre) VALUES (6, 'QA');
INSERT INTO categorias (id, nombre) VALUES (7, 'Security');
INSERT INTO categorias (id, nombre) VALUES (8, 'Cloud');
INSERT INTO categorias (id, nombre) VALUES (9, 'AI & Data Science');
INSERT INTO categorias (id, nombre) VALUES (10, 'UI/UX Design');

-- Perfiles desarrollador
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (1, 2, 'Java, Spring Boot', 5, 'https://portfolio.johndev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (2, 3, 'Angular, TypeScript', 3, 'https://portfolio.janedev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (3, 6, 'React, Node.js, MongoDB', 4, 'https://portfolio.carlosdev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (4, 7, 'Flutter, Kotlin, Swift', 6, 'https://portfolio.sofiadev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (5, 8, 'Docker, Kubernetes, AWS', 7, 'https://portfolio.diegodev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (6, 9, 'Python, Django, Machine Learning', 4, 'https://portfolio.anadev.com');
INSERT INTO perfil_desarrollador (id, usuario_id, habilidades, experiencia, portafolioURL) VALUES (7, 10, 'React, Node.js, Express', 3, 'https://portfolio.luisdev.com');

-- Perfiles compañía
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (1, 4, 'Tech Solutions', 1, 'https://techsolutions.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (2, 5, 'SoftConsulting', 2, 'https://softconsulting.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (3, 11, 'PayTech Solutions', 3, 'https://paytech.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (4, 12, 'EcoMart Digital', 4, 'https://ecomart.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (5, 13, 'Creative Digital Agency', 5, 'https://creativedigital.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (6, 14, 'LogiTech Express', 6, 'https://logitech.com');
INSERT INTO perfil_compania (id, usuario_id, nombre_compania, industria_id, website) VALUES (7, 15, 'HealthTech Colombia', 7, 'https://healthtech.co');


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

-- Paises
INSERT INTO paises (id, nombre, codigo_iso) VALUES (1, 'Afganistán', 'AF');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (2, 'Albania', 'AL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (3, 'Alemania', 'DE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (4, 'Andorra', 'AD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (5, 'Angola', 'AO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (6, 'Antigua y Barbuda', 'AG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (7, 'Arabia Saudita', 'SA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (8, 'Argelia', 'DZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (9, 'Argentina', 'AR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (10, 'Armenia', 'AM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (11, 'Australia', 'AU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (12, 'Austria', 'AT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (13, 'Azerbaiyán', 'AZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (14, 'Bahamas', 'BS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (15, 'Bangladés', 'BD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (16, 'Barbados', 'BB');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (17, 'Baréin', 'BH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (18, 'Bélgica', 'BE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (19, 'Belice', 'BZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (20, 'Benín', 'BJ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (21, 'Bielorrusia', 'BY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (22, 'Birmania', 'MM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (23, 'Bolivia', 'BO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (24, 'Bosnia y Herzegovina', 'BA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (25, 'Botsuana', 'BW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (26, 'Brasil', 'BR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (27, 'Brunéi', 'BN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (28, 'Bulgaria', 'BG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (29, 'Burkina Faso', 'BF');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (30, 'Burundi', 'BI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (31, 'Bután', 'BT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (32, 'Cabo Verde', 'CV');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (33, 'Camboya', 'KH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (34, 'Camerún', 'CM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (35, 'Canadá', 'CA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (36, 'Catar', 'QA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (37, 'Chad', 'TD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (38, 'Chile', 'CL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (39, 'China', 'CN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (40, 'Chipre', 'CY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (41, 'Colombia', 'CO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (42, 'Comoras', 'KM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (43, 'Corea del Norte', 'KP');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (44, 'Corea del Sur', 'KR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (45, 'Costa de Marfil', 'CI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (46, 'Costa Rica', 'CR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (47, 'Croacia', 'HR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (48, 'Cuba', 'CU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (49, 'Dinamarca', 'DK');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (50, 'Dominica', 'DM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (51, 'Ecuador', 'EC');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (52, 'Egipto', 'EG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (53, 'El Salvador', 'SV');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (54, 'Emiratos Árabes Unidos', 'AE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (55, 'Eritrea', 'ER');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (56, 'Eslovaquia', 'SK');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (57, 'Eslovenia', 'SI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (58, 'España', 'ES');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (59, 'Estados Unidos', 'US');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (60, 'Estonia', 'EE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (61, 'Etiopía', 'ET');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (62, 'Filipinas', 'PH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (63, 'Finlandia', 'FI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (64, 'Fiyi', 'FJ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (65, 'Francia', 'FR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (66, 'Gabón', 'GA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (67, 'Gambia', 'GM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (68, 'Georgia', 'GE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (69, 'Ghana', 'GH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (70, 'Granada', 'GD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (71, 'Grecia', 'GR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (72, 'Guatemala', 'GT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (73, 'Guinea', 'GN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (74, 'Guinea Ecuatorial', 'GQ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (75, 'Guinea-Bisáu', 'GW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (76, 'Guyana', 'GY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (77, 'Haití', 'HT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (78, 'Honduras', 'HN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (79, 'Hungría', 'HU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (80, 'India', 'IN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (81, 'Indonesia', 'ID');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (82, 'Irak', 'IQ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (83, 'Irán', 'IR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (84, 'Irlanda', 'IE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (85, 'Islandia', 'IS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (86, 'Islas Marshall', 'MH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (87, 'Islas Salomón', 'SB');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (88, 'Israel', 'IL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (89, 'Italia', 'IT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (90, 'Jamaica', 'JM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (91, 'Japón', 'JP');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (92, 'Jordania', 'JO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (93, 'Kazajistán', 'KZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (94, 'Kenia', 'KE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (95, 'Kirguistán', 'KG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (96, 'Kiribati', 'KI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (97, 'Kuwait', 'KW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (98, 'Laos', 'LA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (99, 'Lesoto', 'LS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (100, 'Letonia', 'LV');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (101, 'Líbano', 'LB');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (102, 'Liberia', 'LR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (103, 'Libia', 'LY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (104, 'Liechtenstein', 'LI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (105, 'Lituania', 'LT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (106, 'Luxemburgo', 'LU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (107, 'Madagascar', 'MG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (108, 'Malasia', 'MY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (109, 'Malaui', 'MW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (110, 'Maldivas', 'MV');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (111, 'Malí', 'ML');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (112, 'Malta', 'MT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (113, 'Marruecos', 'MA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (114, 'Mauricio', 'MU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (115, 'Mauritania', 'MR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (116, 'México', 'MX');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (117, 'Micronesia', 'FM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (118, 'Moldavia', 'MD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (119, 'Mónaco', 'MC');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (120, 'Mongolia', 'MN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (121, 'Montenegro', 'ME');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (122, 'Mozambique', 'MZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (123, 'Namibia', 'NA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (124, 'Nauru', 'NR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (125, 'Nepal', 'NP');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (126, 'Nicaragua', 'NI');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (127, 'Níger', 'NE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (128, 'Nigeria', 'NG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (129, 'Noruega', 'NO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (130, 'Nueva Zelanda', 'NZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (131, 'Omán', 'OM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (132, 'Países Bajos', 'NL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (133, 'Pakistán', 'PK');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (134, 'Palaos', 'PW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (135, 'Panamá', 'PA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (136, 'Papúa Nueva Guinea', 'PG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (137, 'Paraguay', 'PY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (138, 'Perú', 'PE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (139, 'Polonia', 'PL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (140, 'Portugal', 'PT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (141, 'Reino Unido', 'GB');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (142, 'República Centroafricana', 'CF');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (143, 'República Checa', 'CZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (144, 'República del Congo', 'CG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (145, 'República Democrática del Congo', 'CD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (146, 'República Dominicana', 'DO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (147, 'República Sudafricana', 'ZA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (148, 'Ruanda', 'RW');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (149, 'Rumanía', 'RO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (150, 'Rusia', 'RU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (151, 'Samoa', 'WS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (152, 'San Cristóbal y Nieves', 'KN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (153, 'San Marino', 'SM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (154, 'San Vicente y las Granadinas', 'VC');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (155, 'Santa Lucía', 'LC');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (156, 'Santo Tomé y Príncipe', 'ST');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (157, 'Senegal', 'SN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (158, 'Serbia', 'RS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (159, 'Seychelles', 'SC');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (160, 'Sierra Leona', 'SL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (161, 'Singapur', 'SG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (162, 'Siria', 'SY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (163, 'Somalia', 'SO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (164, 'Sri Lanka', 'LK');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (165, 'Suazilandia', 'SZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (166, 'Sudán', 'SD');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (167, 'Sudán del Sur', 'SS');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (168, 'Suecia', 'SE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (169, 'Suiza', 'CH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (170, 'Surinam', 'SR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (171, 'Tailandia', 'TH');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (172, 'Tanzania', 'TZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (173, 'Tayikistán', 'TJ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (174, 'Timor Oriental', 'TL');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (175, 'Togo', 'TG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (176, 'Tonga', 'TO');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (177, 'Trinidad y Tobago', 'TT');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (178, 'Túnez', 'TN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (179, 'Turkmenistán', 'TM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (180, 'Turquía', 'TR');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (181, 'Tuvalu', 'TV');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (182, 'Ucrania', 'UA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (183, 'Uganda', 'UG');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (184, 'Uruguay', 'UY');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (185, 'Uzbekistán', 'UZ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (186, 'Vanuatu', 'VU');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (187, 'Vaticano', 'VA');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (188, 'Venezuela', 'VE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (189, 'Vietnam', 'VN');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (190, 'Yemen', 'YE');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (191, 'Yibuti', 'DJ');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (192, 'Zambia', 'ZM');
INSERT INTO paises (id, nombre, codigo_iso) VALUES (193, 'Zimbabue', 'ZW');
 
-- Necesidades
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (1, 'Desarrollar API REST', 'Crear una API RESTful en Spring Boot', 1, 2500, 4, '2025-08-15', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (2, 'Frontend Angular', 'Construir interfaz web en Angular', 2, 1800, 5, '2025-09-01', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (3, 'Migración a Docker', 'Contenerizar aplicación existente', 3, 1200, 11, '2025-08-20', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (4, 'Base de datos NoSQL', 'Implementar MongoDB para microservicio', 4, 1500, 12, '2025-08-25', 2, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (5, 'App móvil Flutter', 'Desarrollar app multiplataforma', 5, 3000, 13, '2025-09-10', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (6, 'Landing Page', 'Diseñar landing page moderna', 2, 800, 14, '2025-08-05', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (7, 'Automatización con Python', 'Script para automatizar reportes', 1, 950, 15, '2025-08-12', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (8, 'Integración de pagos', 'Agregar pagos con Stripe', 1, 1100, 4, '2025-08-18', 2, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (9, 'Dashboard React', 'Dashboard administrativo', 2, 2000, 5, '2025-09-02', 1, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, presupuesto, compania_id, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (10, 'API para móviles', 'Backend para app móvil', 1, 2200, 11, '2025-09-15', 0, '2025-07-30', '2025-07-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (11, 'Optimización de consultas SQL', 'Mejorar el rendimiento de la base de datos', 4, 4, 1200, '2025-09-20', 0, '2025-08-01', '2025-08-01');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (12, 'Implementar CI/CD', 'Configurar pipelines en GitHub Actions', 3, 5, 1800, '2025-09-25', 1, '2025-08-02', '2025-08-02');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (13, 'Desarrollo de chatbot', 'Crear chatbot con IA para atención al cliente', 9, 11, 2500, '2025-09-30', 2, '2025-08-03', '2025-08-03');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (14, 'Auditoría de seguridad', 'Revisar vulnerabilidades en la aplicación', 7, 12, 2000, '2025-10-05', 1, '2025-08-04', '2025-08-04');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (15, 'Rediseño de interfaz', 'Actualizar UI/UX de la plataforma', 10, 13, 2200, '2025-10-10', 0, '2025-08-05', '2025-08-05');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (16, 'Automatización de reportes', 'Generar reportes automáticos en Excel', 6, 14, 900, '2025-10-15', 2, '2025-08-06', '2025-08-06');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (17, 'Integración con Google Maps', 'Agregar mapas interactivos a la web', 2, 15, 1300, '2025-10-20', 1, '2025-08-07', '2025-08-07');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (18, 'Despliegue en AWS', 'Migrar servicios a la nube de AWS', 8, 4, 2700, '2025-10-25', 0, '2025-08-08', '2025-08-08');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (19, 'Sistema de notificaciones push', 'Implementar notificaciones en app móvil', 5, 5, 1600, '2025-10-30', 2, '2025-08-09', '2025-08-09');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (20, 'Validación de formularios', 'Mejorar validaciones en frontend', 2, 11, 800, '2025-11-04', 1, '2025-08-10', '2025-08-10');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (21, 'API GraphQL', 'Desarrollar API GraphQL para microservicios', 1, 12, 2100, '2025-11-09', 0, '2025-08-11', '2025-08-11');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (22, 'Pruebas automatizadas', 'Configurar pruebas unitarias y de integración', 6, 13, 1400, '2025-11-14', 2, '2025-08-12', '2025-08-12');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (23, 'Optimización de imágenes', 'Reducir peso de imágenes en la web', 10, 14, 700, '2025-11-19', 1, '2025-08-13', '2025-08-13');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (24, 'Integración con Stripe', 'Agregar pagos con Stripe en e-commerce', 1, 15, 1800, '2025-11-24', 0, '2025-08-14', '2025-08-14');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (25, 'Migración a PostgreSQL', 'Cambiar base de datos a PostgreSQL', 4, 4, 1600, '2025-11-29', 2, '2025-08-15', '2025-08-15');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (26, 'Desarrollo de landing page', 'Crear landing page para campaña', 2, 5, 900, '2025-12-04', 1, '2025-08-16', '2025-08-16');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (27, 'Implementar OAuth2', 'Seguridad con OAuth2 en backend', 7, 11, 2000, '2025-12-09', 0, '2025-08-17', '2025-08-17');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (28, 'Desarrollo de app iOS', 'App nativa para iPhone', 5, 12, 3200, '2025-12-14', 2, '2025-08-18', '2025-08-18');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (29, 'Monitorización de logs', 'Implementar monitoreo de logs en microservicios', 3, 13, 1100, '2025-12-19', 1, '2025-08-19', '2025-08-19');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (30, 'Optimización de SEO', 'Mejorar posicionamiento web', 10, 14, 1500, '2025-12-24', 0, '2025-08-20', '2025-08-20');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (31, 'Desarrollo de microservicios', 'Crear arquitectura de microservicios', 1, 15, 2700, '2025-12-29', 2, '2025-08-21', '2025-08-21');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (32, 'Implementar SSO', 'Single Sign-On en la plataforma', 7, 4, 1900, '2026-01-03', 1, '2025-08-22', '2025-08-22');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id, presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (33, 'Desarrollo de app Android', 'App nativa para Android', 5, 5, 3100, '2026-01-08', 0, '2025-08-23', '2025-08-23');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (34, 'Automatización de backups', 'Configurar backups automáticos', 3, 11, 1200, '2026-01-13', 2, '2025-08-24', '2025-08-24');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (35, 'Integración con PayPal', 'Agregar pagos con PayPal', 1, 12, 1700, '2026-01-18', 1, '2025-08-25', '2025-08-25');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (36, 'Desarrollo de dashboard', 'Dashboard para administración', 2, 13, 2000, '2026-01-23', 0, '2025-08-26', '2025-08-26');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (37, 'Implementar WebSockets', 'Comunicación en tiempo real', 1, 14, 1600, '2026-01-28', 2, '2025-08-27', '2025-08-27');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (38, 'Desarrollo de portal de clientes', 'Portal web para clientes', 2, 15, 2500, '2026-02-02', 1, '2025-08-28', '2025-08-28');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (39, 'Implementar Redis', 'Cache con Redis en microservicios', 4, 4, 1300, '2026-02-07', 0, '2025-08-29', '2025-08-29');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (40, 'Desarrollo de sistema de tickets', 'Sistema para soporte técnico', 1, 5, 2100, '2026-02-12', 2, '2025-08-30', '2025-08-30');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (41, 'Optimización de CSS', 'Mejorar estilos y rendimiento', 10, 11, 900, '2026-02-17', 1, '2025-08-31', '2025-08-31');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (42, 'Implementar autenticación 2FA', 'Seguridad con doble factor', 7, 12, 1700, '2026-02-22', 0, '2025-09-01', '2025-09-01');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (43, 'Desarrollo de blog corporativo', 'Blog para noticias y artículos', 2, 13, 1200, '2026-02-27', 2, '2025-09-02', '2025-09-02');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (44, 'Integración con Firebase', 'Notificaciones y autenticación con Firebase', 5, 14, 1800, '2026-03-04', 1, '2025-09-03', '2025-09-03');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (45, 'Desarrollo de sistema de encuestas', 'Encuestas online para clientes', 2, 15, 1400, '2026-03-09', 0, '2025-09-04', '2025-09-04');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (46, 'Implementar CI con Jenkins', 'Automatizar despliegues con Jenkins', 3, 4, 2000, '2026-03-14', 2, '2025-09-05', '2025-09-05');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (47, 'Desarrollo de sistema de reservas', 'Reservas online para eventos', 1, 5, 2300, '2026-03-19', 1, '2025-09-06', '2025-09-06');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (48, 'Optimización de queries MongoDB', 'Mejorar rendimiento en MongoDB', 4, 11, 1200, '2026-03-24', 0, '2025-09-07', '2025-09-07');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (49, 'Desarrollo de app multiplataforma', 'App para iOS y Android con Flutter', 5, 12, 3200, '2026-03-29', 2, '2025-09-08', '2025-09-08');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (50, 'Implementar login social', 'Login con Google y Facebook', 7, 13, 1500, '2026-04-03', 1, '2025-09-09', '2025-09-09');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (51, 'Desarrollo de sistema de facturación', 'Facturación electrónica para clientes', 1, 14, 2100, '2026-04-08', 0, '2025-09-10', '2025-09-10');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (52, 'Optimización de frontend', 'Mejorar velocidad de carga', 2, 15, 1300, '2026-04-13', 2, '2025-09-11', '2025-09-11');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (53, 'Desarrollo de sistema de inventario', 'Inventario en tiempo real', 4, 4, 1700, '2026-04-18', 1, '2025-09-12', '2025-09-12');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (54, 'Implementar pagos recurrentes', 'Suscripciones mensuales en la plataforma', 1, 5, 1900, '2026-04-23', 0, '2025-09-13', '2025-09-13');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (55, 'Desarrollo de sistema de mensajería', 'Mensajería interna para usuarios', 2, 11, 1500, '2026-04-28', 2, '2025-09-14', '2025-09-14');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (56, 'Optimización de backend', 'Mejorar lógica y rendimiento', 1, 12, 1700, '2026-05-03', 1, '2025-09-15', '2025-09-15');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (57, 'Desarrollo de sistema de encuestas', 'Encuestas para clientes y empleados', 2, 13, 1200, '2026-05-08', 0, '2025-09-16', '2025-09-16');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (58, 'Implementar pagos con MercadoPago', 'Integración de MercadoPago', 1, 14, 1800, '2026-05-13', 2, '2025-09-17', '2025-09-17');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (59, 'Desarrollo de sistema de reservas', 'Reservas para hoteles y eventos', 5, 15, 2500, '2026-05-18', 1, '2025-09-18', '2025-09-18');
INSERT INTO necesidades (id, titulo, descripcion, categoria_id, compania_id,presupuesto, fecha_limite, estado_id, fecha_creacion, fecha_actualizacion) VALUES (60, 'Optimización de queries SQL', 'Mejorar consultas en base de datos', 4, 4, 1200, '2026-05-23', 0, '2025-09-19', '2025-09-19');

INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (1, 'Debe incluir autenticación JWT');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (1, 'Pruebas unitarias obligatorias');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (2, 'Responsive y con login');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (2, 'Compatibilidad con navegadores modernos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (2, 'Integración con API REST');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (3, 'Documentar pasos de despliegue');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (3, 'Contenerización con Docker');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (4, 'Alta disponibilidad');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (4, 'Escalabilidad horizontal');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (5, 'Push notifications y login social');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (5, 'Integración con Firebase');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (6, 'SEO optimizado');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (6, 'Carga rápida en dispositivos móviles');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (7, 'Soporte para Excel y PDF');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (7, 'Automatización de reportes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (8, 'Soporte para tarjetas y transferencias');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (8, 'Validación de pagos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (9, 'Gráficas y filtros');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (9, 'Exportación de datos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (10, 'Autenticación y notificaciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (10, 'Registro de actividad de usuario');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (11, 'Optimizar índices y consultas SQL');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (11, 'Evitar consultas N+1');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (12, 'Pipeline debe incluir pruebas automáticas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (12, 'Despliegue continuo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (13, 'Integración con API de mensajería');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (13, 'Soporte para chatbots multicanal');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (14, 'Informe de vulnerabilidades y recomendaciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (14, 'Pruebas de penetración');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (15, 'Diseño responsivo y accesible');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (15, 'Cumplir estándares WCAG');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (16, 'Exportar reportes en formato Excel y PDF');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (16, 'Filtros avanzados en reportes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (17, 'Uso de Google Maps API');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (17, 'Geolocalización en tiempo real');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (18, 'Despliegue automatizado en AWS');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (18, 'Configuración de escalabilidad');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (19, 'Notificaciones push en Android y iOS');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (19, 'Soporte para múltiples dispositivos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (20, 'Validaciones en tiempo real en frontend');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (20, 'Mensajes de error claros');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (21, 'Documentación de la API GraphQL');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (21, 'Ejemplos de consultas y mutaciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (22, 'Cobertura mínima de pruebas del 80%');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (22, 'Pruebas de integración');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (23, 'Optimizar imágenes para web');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (23, 'Compresión automática de imágenes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (24, 'Integración segura con Stripe');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (24, 'Validación de pagos y reembolsos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (25, 'Migración sin pérdida de datos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (25, 'Pruebas de migración');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (26, 'Landing page con formulario de contacto');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (26, 'Integración con Google Analytics');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (27, 'Implementar OAuth2 con roles');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (27, 'Gestión de permisos granular');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (28, 'App iOS compatible con iPhone y iPad');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (28, 'Push notifications');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (29, 'Monitorización con alertas automáticas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (29, 'Dashboard de monitoreo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (30, 'SEO audit y mejoras sugeridas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (30, 'Optimización de meta tags');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (31, 'Microservicios con comunicación REST');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (31, 'Documentación OpenAPI');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (32, 'SSO compatible con Google y Microsoft');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (32, 'Integración con Azure AD');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (33, 'App Android con notificaciones push');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (33, 'Compatibilidad con Android 10+');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (34, 'Backups diarios y restauración fácil');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (34, 'Notificación de fallos en backups');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (35, 'Integración con PayPal y validación de pagos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (35, 'Soporte para pagos recurrentes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (36, 'Dashboard con gráficos interactivos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (36, 'Exportación de reportes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (37, 'WebSockets para chat en tiempo real');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (37, 'Historial de mensajes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (38, 'Portal con registro y login de clientes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (38, 'Recuperación de contraseña');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (39, 'Cache con Redis y persistencia');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (39, 'Evitar duplicidad de datos en cache');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (40, 'Sistema de tickets con historial');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (40, 'Notificaciones por email');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (41, 'Optimización de CSS para móviles');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (41, 'Compatibilidad con pantallas pequeñas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (42, 'Autenticación 2FA con SMS y email');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (42, 'Gestión de dispositivos confiables');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (43, 'Blog con editor de texto enriquecido');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (43, 'Soporte para imágenes y videos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (44, 'Integración con Firebase para notificaciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (44, 'Autenticación con Google');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (45, 'Encuestas con exportación de resultados');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (45, 'Soporte para encuestas anónimas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (46, 'Despliegue continuo con Jenkins');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (46, 'Pipeline con pruebas automáticas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (47, 'Reservas con confirmación por email');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (47, 'Calendario interactivo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (48, 'Optimización de queries en MongoDB');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (48, 'Índices adecuados en colecciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (49, 'App Flutter con login social');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (49, 'Push notifications');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (50, 'Login social con Google y Facebook');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (50, 'Recuperación de contraseña');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (51, 'Facturación electrónica con validación legal');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (51, 'Exportación de facturas en PDF');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (52, 'Frontend optimizado para SEO');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (52, 'Carga rápida en dispositivos móviles');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (53, 'Inventario con alertas de stock bajo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (53, 'Historial de movimientos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (54, 'Pagos recurrentes con recordatorio automático');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (54, 'Gestión de suscripciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (55, 'Mensajería interna con notificaciones');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (55, 'Soporte para archivos adjuntos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (56, 'Backend con logging y monitoreo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (56, 'Alertas automáticas de errores');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (57, 'Encuestas anónimas y públicas');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (57, 'Exportación de resultados');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (58, 'Integración con MercadoPago y Stripe');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (58, 'Validación de pagos');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (59, 'Reservas con calendario interactivo');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (59, 'Confirmación por email');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (60, 'Consultas SQL optimizadas para grandes volúmenes');
INSERT INTO necesidad_requirements (necesidad_id, requirements) VALUES (60, 'Evitar bloqueos y deadlocks');

INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (1, 'Documentación técnica');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (1, 'Manual de usuario');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (2, 'Diseño responsivo completo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (2, 'Pruebas unitarias');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (3, 'Guía de despliegue en Docker');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (4, 'Configuración de alta disponibilidad');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (5, 'App publicada en stores');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (6, 'SEO audit report');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (7, 'Script funcional para Excel y PDF');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (8, 'Integración de Stripe validada');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (9, 'Dashboard con gráficas interactivas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (10, 'API documentada para móviles');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (1, 'Documentación técnica');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (1, 'Manual de usuario');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (2, 'Diseño responsivo completo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (2, 'Pruebas unitarias');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (2, 'Código fuente en repositorio');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (3, 'Guía de despliegue en Docker');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (3, 'Contenedores listos para producción');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (4, 'Configuración de alta disponibilidad');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (4, 'Informe de pruebas de estrés');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (5, 'App publicada en stores');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (5, 'Manual de instalación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (6, 'SEO audit report');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (6, 'Informe de optimización');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (7, 'Script funcional para Excel y PDF');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (7, 'Documentación de uso');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (8, 'Integración de Stripe validada');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (8, 'Pruebas de pago exitosas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (9, 'Dashboard con gráficas interactivas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (9, 'Manual de administración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (10, 'API documentada para móviles');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (10, 'Ejemplos de integración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (11, 'Consultas SQL optimizadas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (11, 'Informe de rendimiento');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (12, 'Pipeline CI/CD funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (12, 'Reporte de pruebas automáticas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (13, 'Chatbot funcional');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (13, 'Guía de entrenamiento de IA');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (14, 'Informe de vulnerabilidades');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (14, 'Recomendaciones de seguridad');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (15, 'Prototipo UI/UX');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (15, 'Mockups aprobados');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (16, 'Reportes en Excel y PDF');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (16, 'Manual de filtros');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (17, 'Mapa interactivo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (17, 'Documentación de integración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (18, 'Servicios desplegados en AWS');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (18, 'Guía de despliegue');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (19, 'Notificaciones push activas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (19, 'Manual de configuración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (20, 'Frontend validado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (20, 'Informe de validaciones');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (21, 'API GraphQL funcional');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (21, 'Documentación de queries');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (22, 'Pruebas automatizadas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (22, 'Reporte de cobertura');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (23, 'Imágenes optimizadas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (23, 'Informe de compresión');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (24, 'Pagos con Stripe funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (24, 'Manual de integración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (25, 'Base de datos migrada');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (25, 'Informe de migración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (26, 'Landing page publicada');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (26, 'Reporte de visitas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (27, 'OAuth2 implementado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (27, 'Manual de roles');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (28, 'App iOS lista para App Store');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (28, 'Guía de publicación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (29, 'Dashboard de monitoreo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (29, 'Alertas configuradas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (30, 'Informe SEO');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (30, 'Checklist de mejoras');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (31, 'Arquitectura de microservicios');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (31, 'Documentación OpenAPI');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (32, 'SSO funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (32, 'Guía de integración SSO');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (33, 'App Android publicada');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (33, 'Manual de usuario Android');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (34, 'Backups automáticos');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (34, 'Guía de restauración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (35, 'Pagos con PayPal funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (35, 'Manual de pagos');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (36, 'Dashboard funcional');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (36, 'Exportación de datos');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (37, 'Chat en tiempo real');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (37, 'Historial de mensajes');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (38, 'Portal de clientes');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (38, 'Guía de registro');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (39, 'Cache con Redis');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (39, 'Informe de persistencia');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (40, 'Sistema de tickets');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (40, 'Manual de soporte');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (41, 'CSS optimizado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (41, 'Informe de compatibilidad');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (42, 'Autenticación 2FA');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (42, 'Guía de dispositivos');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (43, 'Blog corporativo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (43, 'Manual de publicación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (44, 'Firebase integrado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (44, 'Guía de autenticación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (45, 'Encuestas funcionales');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (45, 'Exportación de resultados');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (46, 'CI con Jenkins');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (46, 'Reporte de despliegue');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (47, 'Sistema de reservas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (47, 'Manual de reservas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (48, 'Queries MongoDB optimizadas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (48, 'Informe de rendimiento');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (49, 'App multiplataforma');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (49, 'Guía de instalación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (50, 'Login social funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (50, 'Manual de recuperación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (51, 'Sistema de facturación');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (51, 'Facturas en PDF');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (52, 'Frontend optimizado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (52, 'Informe de velocidad');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (53, 'Sistema de inventario');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (53, 'Manual de inventario');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (54, 'Pagos recurrentes funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (54, 'Guía de suscripciones');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (55, 'Sistema de mensajería');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (55, 'Manual de archivos adjuntos');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (56, 'Backend optimizado');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (56, 'Reporte de monitoreo');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (57, 'Encuestas listas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (57, 'Resultados exportados');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (58, 'Pagos MercadoPago funcionando');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (58, 'Manual de integración');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (59, 'Sistema de reservas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (59, 'Calendario funcional');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (60, 'Consultas SQL optimizadas');
INSERT INTO necesidad_expected_deliverables (necesidad_id, expected_deliverables) VALUES (60, 'Informe de bloqueos y deadlocks');


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

-- Calificaciones (20 ejemplos)
-- Calificaciones para desarrolladores
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (1, 4, 2, 5, 'Excelente trabajo en la API, muy profesional', '2025-08-01');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (2, 5, 2, 4, 'Buen desempeño, cumplió con los tiempos', '2025-08-03');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (3, 11, 2, 5, 'Muy satisfecho con el resultado', '2025-08-05');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (4, 4, 3, 4, 'Buena implementación del frontend', '2025-08-02');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (5, 12, 3, 3, 'Trabajo aceptable, algunas mejoras necesarias', '2025-08-04');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (6, 13, 6, 5, 'Desarrollador fullstack excepcional', '2025-08-06');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (7, 14, 6, 4, 'Cumplió con las expectativas', '2025-08-07');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (8, 15, 7, 5, 'Experta en desarrollo móvil', '2025-08-08');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (9, 4, 7, 4, 'Buen trabajo con Flutter', '2025-08-09');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (10, 5, 8, 5, 'Especialista en DevOps muy competente', '2025-08-10');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (11, 11, 8, 4, 'Buen manejo de Docker y Kubernetes', '2025-08-11');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (12, 12, 9, 5, 'Excelente en Python y ML', '2025-08-12');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (13, 13, 9, 4, 'Muy profesional y puntual', '2025-08-13');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (14, 14, 10, 4, 'Buen desarrollador React/Node', '2025-08-14');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (15, 15, 10, 5, 'Trabajo excepcional, muy recomendado', '2025-08-15');

-- Calificaciones para compañías (desde desarrolladores)
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (16, 2, 4, 5, 'Empresa muy profesional, pagos puntuales', '2025-08-01');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (17, 3, 5, 4, 'Buena comunicación y requisitos claros', '2025-08-02');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (18, 6, 11, 5, 'Excelente startup para trabajar', '2025-08-03');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (19, 7, 12, 4, 'Proyecto interesante, buen ambiente', '2025-08-04');
INSERT INTO calificaciones (id, usuario_id, usuario_calificado_id, calificacion, comentario, fecha_calificacion) VALUES (20, 8, 13, 5, 'Agencia muy organizada y profesional', '2025-08-05');

-- Soluciones 
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion)VALUES (1, 2, 'API RESTful Spring Boot', 'API lista para producción con autenticación JWT', 1200, 15, 3, 1, 2, 10, 'DIAS', '2025-08-01', '2025-08-01');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion)VALUES (2, 3, 'Frontend Angular Responsive', 'Interfaz web moderna y responsiva', 900, 10, 2, 2, 1, 7, 'DIAS', '2025-08-02', '2025-08-02');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion)VALUES (3, 6, 'Landing Page React', 'Landing page optimizada para SEO', 700, 8, 1, 2, 0, 5, 'DIAS', '2025-08-03', '2025-08-03');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion)VALUES (4, 7, 'App Flutter Multiplataforma', 'Aplicación móvil para iOS y Android', 2000, 20, 5, 5, 2, 14, 'DIAS', '2025-08-04', '2025-08-04');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion)VALUES (5, 8, 'Pipeline CI/CD con GitHub Actions', 'Automatización de despliegues y pruebas', 1100, 7, 2, 3, 1, 6, 'DIAS', '2025-08-05', '2025-08-05');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (6, 9, 'Script Python para Reportes', 'Automatización de reportes en Excel y PDF', 800, 12, 3, 1, 2, 5, 'DIAS', '2025-08-06', '2025-08-06');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (7, 10, 'Backend Node.js Express', 'API REST con autenticación y documentación', 1300, 9, 2, 1, 0, 8, 'DIAS', '2025-08-07', '2025-08-07');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (8, 2, 'Microservicio Java', 'Microservicio escalable con Spring Boot', 1500, 11, 2, 1, 1, 12, 'DIAS', '2025-08-08', '2025-08-08');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (9, 3, 'SPA Angular', 'Single Page Application con Angular y RxJS', 1000, 13, 3, 2, 2, 9, 'DIAS', '2025-08-09', '2025-08-09');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (10, 6, 'API GraphQL', 'API GraphQL para microservicios', 1400, 6, 1, 1, 0, 10, 'DIAS', '2025-08-10', '2025-08-10');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (11, 7, 'App iOS Nativa', 'Aplicación nativa para iPhone', 2200, 14, 4, 5, 1, 15, 'DIAS', '2025-08-11', '2025-08-11');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (12, 8, 'Infraestructura AWS', 'Despliegue automatizado en AWS', 1800, 10, 2, 8, 2, 7, 'DIAS', '2025-08-12', '2025-08-12');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (13, 9, 'Machine Learning con Python', 'Modelo de ML para predicción de datos', 1700, 8, 2, 9, 0, 12, 'DIAS', '2025-08-13', '2025-08-13');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (14, 10, 'Sistema de Autenticación', 'Login social y autenticación JWT', 900, 7, 1, 7, 1, 6, 'DIAS', '2025-08-14', '2025-08-14');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (15, 2, 'API RESTful con Documentación', 'API con Swagger y OpenAPI', 1100, 9, 2, 1, 2, 8, 'DIAS', '2025-08-15', '2025-08-15');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (16, 3, 'Panel de Administración Angular', 'Dashboard administrativo con gráficos', 1200, 12, 3, 2, 0, 10, 'DIAS', '2025-08-16', '2025-08-16');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (17, 6, 'API REST Node.js', 'API escalable con Express y MongoDB', 1300, 11, 2, 1, 1, 9, 'DIAS', '2025-08-17', '2025-08-17');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (18, 7, 'App Android Nativa', 'Aplicación nativa para Android', 2100, 13, 4, 5, 2, 14, 'DIAS', '2025-08-18', '2025-08-18');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (19, 8, 'DevOps con Docker y Kubernetes', 'Automatización de despliegues en contenedores', 1600, 8, 2, 3, 0, 7, 'DIAS', '2025-08-19', '2025-08-19');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (20, 9, 'Sistema de Notificaciones Push', 'Notificaciones para apps móviles', 1000, 7, 1, 5, 1, 6, 'DIAS', '2025-08-20', '2025-08-20');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (21, 10, 'API RESTful Python Django', 'API robusta con Django REST Framework', 1250, 10, 2, 1, 2, 8, 'DIAS', '2025-08-21', '2025-08-21');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (22, 2, 'Sistema de Inventario', 'Inventario en tiempo real con alertas', 1400, 9, 2, 4, 0, 12, 'DIAS', '2025-08-22', '2025-08-22');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (23, 3, 'UI/UX Design Web', 'Diseño de interfaces web modernas', 800, 6, 1, 10, 1, 5, 'DIAS', '2025-08-23', '2025-08-23');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (24, 6, 'API RESTful PHP Laravel', 'API segura y documentada con Laravel', 1100, 8, 2, 1, 2, 9, 'DIAS', '2025-08-24', '2025-08-24');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (25, 7, 'App Flutter con Firebase', 'App móvil con login social y notificaciones', 1800, 14, 3, 5, 0, 13, 'DIAS', '2025-08-25', '2025-08-25');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (26, 8, 'Despliegue en Azure', 'Automatización de despliegues en Azure', 1700, 7, 2, 8, 1, 8, 'DIAS', '2025-08-26', '2025-08-26');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (27, 9, 'Modelo de IA para Clasificación', 'Modelo de clasificación de datos', 1600, 9, 2, 9, 2, 11, 'DIAS', '2025-08-27', '2025-08-27');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (28, 10, 'Sistema de Seguridad Web', 'Auditoría y hardening de aplicaciones', 1300, 8, 1, 7, 0, 7, 'DIAS', '2025-08-28', '2025-08-28');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (29, 2, 'API RESTful Go', 'API eficiente y concurrente con Go', 1500, 10, 2, 1, 1, 10, 'DIAS', '2025-08-29', '2025-08-29');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (30, 3, 'SPA React', 'Single Page Application con React y Redux', 1200, 11, 3, 2, 2, 8, 'DIAS', '2025-08-30', '2025-08-30');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (31, 6, 'API RESTful Ruby on Rails', 'API escalable con Rails', 1400, 7, 2, 1, 0, 9, 'DIAS', '2025-08-31', '2025-08-31');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (32, 7, 'App Móvil Kotlin', 'App Android nativa con Kotlin', 1700, 13, 4, 5, 1, 12, 'DIAS', '2025-09-01', '2025-09-01');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (33, 8, 'Infraestructura GCP', 'Despliegue automatizado en Google Cloud', 1800, 8, 2, 8, 2, 8, 'DIAS', '2025-09-02', '2025-09-02');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (34, 9, 'Modelo de IA para Predicción', 'Modelo de predicción de series temporales', 1700, 10, 2, 9, 0, 13, 'DIAS', '2025-09-03', '2025-09-03');
INSERT INTO soluciones (id, desarrollador_id, titulo, descripcion, precio, vistas, pedidos, categoria_id, estado_id, tiempo_entrega, unidad_entrega, fecha_creacion, fecha_actualizacion) VALUES (35, 10, 'Sistema de Autenticación OAuth2', 'Login seguro con OAuth2', 1200, 9, 2, 7, 1, 7, 'DIAS', '2025-09-04', '2025-09-04');

INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (1, 1); -- Java
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (1, 2); -- Spring Boot
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (2, 3); -- Angular
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (2, 8); -- TypeScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (3, 11); -- React
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (3, 9); -- HTML
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (4, 23); -- Flutter
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (4, 21); -- Kotlin
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (5, 5); -- Docker
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (5, 12);
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (6, 6); -- Python
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (6, 4); -- SQL
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (7, 12); -- Node.js
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (7, 13); -- Express
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (8, 1); -- Java
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (8, 2); -- Spring Boot
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (9, 3); -- Angular
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (9, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (10, 11); -- React
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (10, 12); -- Node.js
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (11, 22); -- Swift
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (12, 5); -- Docker
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (12, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (13, 6); -- Python
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (13, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (14, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (14, 8); -- TypeScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (15, 1); -- Java
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (15, 2); -- Spring Boot
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (16, 3); -- Angular
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (16, 8); -- TypeScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (17, 12); -- Node.js
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (17, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (18, 21); -- Kotlin
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (18, 23); -- Flutter
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (19, 5); -- Docker
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (19, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (20, 23); -- Flutter
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (20, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (21, 6); -- Python
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (21, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (22, 4); -- SQL
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (22, 1); -- Java
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (23, 10); -- CSS
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (23, 9); -- HTML
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (24, 16); -- PHP
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (24, 17); -- Laravel
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (25, 23); -- Flutter
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (25, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (26, 5); -- Docker
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (26, 12); -- Node.js
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (27, 6); -- Python
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (27, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (28, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (28, 13); -- Express
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (29, 20); -- Go
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (29, 4); -- SQL
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (30, 11); -- React
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (30, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (31, 18); -- Ruby
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (31, 19); -- Rails
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (32, 21); -- Kotlin
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (32, 23); -- Flutter
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (33, 5); -- Docker
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (33, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (34, 6); -- Python
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (34, 24); -- MongoDB
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (35, 7); -- JavaScript
INSERT INTO solucion_habilidad (solucion_id, habilidad_id) VALUES (35, 8);

INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (1, 'Autenticación JWT');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (1, 'Documentación Swagger');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (2, 'Responsive design');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (2, 'Soporte para PWA');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (3, 'SEO optimizado');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (3, 'Carga rápida');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (4, 'Push notifications');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (4, 'Login social');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (5, 'Pipeline multi-stage');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (5, 'Integración con Slack');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (6, 'Reportes automáticos');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (6, 'Exportación a PDF');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (7, 'API REST');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (7, 'Autenticación JWT');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (8, 'Microservicio escalable');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (8, 'Documentación OpenAPI');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (9, 'SPA con Angular');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (9, 'Soporte RxJS');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (10, 'API GraphQL');
INSERT INTO solucion_caracteristicas (solucion_id, caracteristicas) VALUES (10, 'Documentación GraphQL');

INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (1, 'Base de datos MySQL');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (1, 'Servidor Tomcat');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (2, 'API REST disponible');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (2, 'Cuenta Google Cloud');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (3, 'Dominio propio');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (3, 'Acceso a Google Analytics');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (4, 'Cuenta Firebase');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (4, 'Apple Developer Account');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (5, 'Repositorio GitHub');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (5, 'Acceso a servidor de pruebas');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (6, 'Acceso a base de datos');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (6, 'Plantilla de reportes');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (7, 'Servidor Node.js');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (7, 'Base de datos MongoDB');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (8, 'Acceso a repositorio Git');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (8, 'Servidor de pruebas');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (9, 'Cuenta Google Cloud');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (9, 'API REST disponible');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (10, 'Servidor GraphQL');
INSERT INTO solucion_requisitos (solucion_id, requisitos) VALUES (10, 'Base de datos configurada');

-- Hitos para Soluciones
-- Hitos para Solucion 1: API REST con Spring Boot
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (1, 'Análisis de Requisitos', 'Definir endpoints y estructura de la API', '2025-10-05', 1);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (2, 'Desarrollo Backend', 'Implementar controladores y servicios', '2025-10-15', 1);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (3, 'Testing y Documentación', 'Pruebas unitarias y documentación Swagger', '2025-10-25', 1);

-- Hitos para Solucion 2: Frontend React
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (4, 'Diseño UI/UX', 'Mockups y wireframes de la aplicación', '2025-10-08', 2);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (5, 'Desarrollo Frontend', 'Implementar componentes React', '2025-10-18', 2);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (6, 'Integración y Testing', 'Conectar con API y pruebas E2E', '2025-10-28', 2);

-- Hitos para Solucion 3: Sitio Web Corporativo
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (7, 'Arquitectura de Información', 'Definir estructura y contenido del sitio', '2025-10-06', 3);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (8, 'Desarrollo y Diseño', 'Implementar páginas y estilos', '2025-10-16', 3);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (9, 'SEO y Optimización', 'Configurar SEO y optimizar performance', '2025-10-26', 3);

-- Hitos para Solucion 4: App Móvil Nativa
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (10, 'Prototipo Funcional', 'Diseño de pantallas y flujo de usuario', '2025-10-10', 4);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (11, 'Desarrollo Nativo', 'Implementar funcionalidades core', '2025-10-20', 4);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (12, 'Publicación en Stores', 'Preparar y subir a App Store y Play Store', '2025-10-30', 4);

-- Hitos para Solucion 5: Pipeline CI/CD
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (13, 'Configuración Inicial', 'Setup de repositorio y herramientas', '2025-10-07', 5);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (14, 'Pipeline Development', 'Configurar stages de build, test y deploy', '2025-10-17', 5);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (15, 'Monitoreo y Alertas', 'Configurar notificaciones y métricas', '2025-10-27', 5);

-- Hitos para Necesidades
-- Hitos para Necesidad 1: Sistema de Gestión Empresarial
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (100, 'Análisis y Diseño', 'Levantamiento de requisitos y arquitectura del sistema', '2025-11-15', 1);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (101, 'Desarrollo Módulos Core', 'Implementar módulos de usuarios, productos y ventas', '2025-12-15', 1);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (102, 'Integración y Testing', 'Integrar módulos y realizar pruebas completas', '2025-01-15', 1);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (103, 'Capacitación y Despliegue', 'Entrenar usuarios y poner en producción', '2025-02-01', 1);

-- Hitos para Necesidad 2: Plataforma E-commerce
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (104, 'Setup Inicial y Catálogo', 'Configurar plataforma y cargar productos', '2025-11-10', 2);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (105, 'Sistema de Pagos', 'Integrar pasarelas de pago y checkout', '2025-12-01', 2);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (106, 'Funcionalidades Avanzadas', 'Carrito, wishlist, reviews y recomendaciones', '2025-12-20', 2);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (107, 'Testing y Launch', 'Pruebas completas y lanzamiento oficial', '2025-01-10', 2);

-- Hitos para Necesidad 3: App de Delivery
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (108, 'MVP y Prototipo', 'Desarrollar funcionalidades básicas de pedidos', '2025-11-20', 3);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (109, 'Geolocalización y Tracking', 'Implementar mapas y seguimiento en tiempo real', '2025-12-10', 3);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (110, 'Sistema de Pagos y Notificaciones', 'Integrar pagos móviles y push notifications', '2025-12-25', 3);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (111, 'Beta Testing y Lanzamiento', 'Pruebas con usuarios reales y lanzamiento', '2025-01-15', 3);

-- Hitos para Necesidad 4: Sistema de Inventario
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (112, 'Diseño de Base de Datos', 'Modelar estructura de datos y relaciones', '2025-11-05', 4);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (113, 'Módulo de Inventario', 'CRUD de productos, categorías y stock', '2025-11-25', 4);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (114, 'Reportes y Analytics', 'Generar reportes de stock y movimientos', '2025-12-15', 4);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (115, 'Integración con Ventas', 'Conectar con sistema de ventas existente', '2025-12-30', 4);

-- Hitos para Necesidad 5: Portal de Clientes
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (116, 'Autenticación y Perfiles', 'Sistema de login y gestión de perfiles', '2025-11-12', 5);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (117, 'Dashboard de Cliente', 'Panel con historial de pedidos y facturas', '2025-12-02', 5);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (118, 'Sistema de Tickets', 'Módulo de soporte y seguimiento de tickets', '2025-12-20', 5);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, necesidad_id) VALUES (119, 'Notificaciones y Comunicación', 'Email, SMS y notificaciones en app', '2025-01-08', 5);

-- Hitos adicionales para más soluciones
-- Hitos para Solucion 6: Sistema de Autenticación
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (120, 'Análisis de Seguridad', 'Definir políticas de seguridad y compliance', '2025-10-12', 6);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (121, 'Implementación OAuth', 'Configurar OAuth 2.0 y JWT', '2025-10-22', 6);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (122, 'Testing de Penetración', 'Pruebas de seguridad y vulnerabilidades', '2025-11-02', 6);

-- Hitos para Solucion 7: Dashboard Analytics
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (123, 'Diseño de Métricas', 'Definir KPIs y visualizaciones', '2025-10-14', 7);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (124, 'Desarrollo de Charts', 'Implementar gráficos y reportes', '2025-10-24', 7);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (125, 'Optimización Performance', 'Optimizar queries y caching', '2025-11-04', 7);

-- Hitos para Solucion 8: Integración de APIs
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (126, 'Mapeo de Endpoints', 'Documentar APIs externas a integrar', '2025-10-16', 8);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (127, 'Desarrollo Middleware', 'Crear capa de integración y transformación', '2025-10-26', 8);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (128, 'Testing de Integración', 'Pruebas end-to-end con APIs externas', '2025-11-06', 8);

-- Hitos para Solucion 9: Base de Datos Optimizada
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (129, 'Análisis de Schema', 'Revisar estructura actual y optimizaciones', '2025-10-18', 9);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (130, 'Implementación de Índices', 'Crear índices y optimizar queries', '2025-10-28', 9);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (131, 'Monitoreo y Tuning', 'Configurar monitoreo y ajuste fino', '2025-11-08', 9);

-- Hitos para Solucion 10: Sistema de Microservicios
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (132, 'Arquitectura de Microservicios', 'Diseñar decomposición y comunicación', '2025-10-20', 10);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (133, 'Implementación de Servicios', 'Desarrollar servicios core independientes', '2025-10-30', 10);
INSERT INTO hitos (id, nombre, descripcion, fecha_entrega, solucion_id) VALUES (134, 'Gateway y Orquestación', 'API Gateway y service discovery', '2025-11-10', 10);

-- Entregables de ejemplo para algunos hitos
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (1, 'Documento de Requisitos API', 'pdf', 'documents/api-requirements.pdf', '2025-10-05', 1);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (2, 'Código Fuente Backend', 'zip', 'code/backend-v1.0.zip', '2025-10-15', 2);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (3, 'Documentación Swagger', 'json', 'docs/api-swagger.json', '2025-10-25', 3);

INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (4, 'Mockups UI/UX', 'figma', 'design/ui-mockups.fig', '2025-10-08', 4);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (5, 'Aplicación React', 'zip', 'code/frontend-react.zip', '2025-10-18', 5);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (6, 'Reporte de Testing E2E', 'pdf', 'testing/e2e-results.pdf', '2025-10-28', 6);

INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (7, 'Arquitectura de Información', 'pdf', 'docs/site-architecture.pdf', '2025-10-06', 7);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (8, 'Sitio Web Completo', 'zip', 'code/corporate-website.zip', '2025-10-16', 8);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (9, 'Reporte SEO', 'pdf', 'seo/seo-optimization-report.pdf', '2025-10-26', 9);

INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (10, 'Prototipo App Móvil', 'apk', 'mobile/prototype-v1.0.apk', '2025-10-10', 10);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (11, 'App iOS/Android', 'zip', 'mobile/native-apps.zip', '2025-10-20', 11);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (12, 'Guía de Publicación', 'pdf', 'docs/store-publication-guide.pdf', '2025-10-30', 12);

-- Más entregables para hitos de necesidades
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (13, 'Documento de Arquitectura ERP', 'pdf', 'docs/erp-architecture.pdf', '2025-11-15', 100);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (14, 'Módulos Core Desarrollados', 'zip', 'code/erp-core-modules.zip', '2025-12-15', 101);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (15, 'Reporte de Testing Integral', 'pdf', 'testing/erp-integration-tests.pdf', '2025-01-15', 102);

INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (16, 'Catálogo de Productos', 'csv', 'data/product-catalog.csv', '2025-11-10', 104);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (17, 'Sistema de Pagos Configurado', 'pdf', 'docs/payment-gateway-config.pdf', '2025-12-01', 105);
INSERT INTO entregables (id, nombre, tipo_archivo, url_archivo, fecha_entrega, hito_id) VALUES (18, 'Plataforma E-commerce Live', 'url', 'https://ecommerce.cliente.com', '2025-01-10', 107);