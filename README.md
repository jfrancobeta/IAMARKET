# IAMARKET

> Plataforma de mercado inteligente con autenticación JWT, tiempo real vía WebSockets y pagos integrados.

[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-17-DD0031?logo=angular&logoColor=white)](https://angular.io/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

---

## Tabla de Contenidos

- [Descripción](#descripción)
- [Arquitectura](#arquitectura)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Ejecución Local](#instalación-y-ejecución-local)
- [Variables de Entorno](#variables-de-entorno)
- [API — Endpoints Principales](#api--endpoints-principales)
- [Pruebas](#pruebas)
- [Despliegue](#despliegue)
- [Seguridad](#seguridad)
- [Guía de Contribución](#guía-de-contribución)
- [Troubleshooting](#troubleshooting)
- [Referencias y Contacto](#referencias-y-contacto)

---

## Descripción

**IAMARKET** es un monorepo que agrupa el backend y el frontend de una aplicación de mercado full-stack. Permite a los usuarios publicar, buscar y adquirir productos con actualizaciones en tiempo real, autenticación segura y flujos de pago mediante PayPal. Las imágenes se gestionan en la nube a través de Cloudinary.

| Proyecto | Stack | Descripción |
|---|---|---|
| `mercadoai` | Java 17 · Spring Boot · Maven | API REST + WebSockets/STOMP |
| `mercadoai-frontend` | Angular 17 · TypeScript · STOMP.js | SPA con comunicación en tiempo real |

---

## Arquitectura

```
IAMARKET/
├── mercadoai/                  # Backend — Spring Boot
│   ├── src/main/java/
│   │   ├── controllers/        # Capa de presentación (REST)
│   │   ├── services/           # Lógica de negocio
│   │   ├── repositories/       # Acceso a datos (JPA)
│   │   ├── models/             # Entidades JPA
│   │   ├── dto/                # Data Transfer Objects
│   │   ├── mapper/             # MapStruct mappers
│   │   └── config/             # Seguridad, WebSocket, Swagger…
│   ├── src/test/
│   ├── Dockerfile
│   └── pom.xml
│
└── mercadoai-frontend/         # Frontend — Angular 17
    ├── src/
    │   ├── app/
    │   │   ├── components/
    │   │   ├── services/
    │   │   └── models/
    │   └── environments/
    ├── angular.json
    ├── vercel.json
    └── package.json
```

### Flujo de Autenticación

```
Cliente ──── POST /api/auth/login ────► JwtTokenProvider
                                              │
                                    genera Access Token (JWT)
                                              │
Cliente ◄── { token } ───────────────────────┘
   │
   └── Authorization: Bearer <token> ──► JwtAuthenticationFilter ──► Recurso protegido
```

### Comunicación en Tiempo Real

```
Cliente ──── CONNECT (STOMP sobre WebSocket) ──► WebSocketConfig
                                                        │
                                               JwtChannelInterceptor (valida token)
                                                        │
                                              ◄── SUBSCRIBE /topic/... ──►
```

---

## Requisitos Previos

| Herramienta | Versión mínima | Comprobación |
|---|---|---|
| Java JDK | 17 | `java -version` |
| Maven (mvnw incluido) | 3.8+ | `./mvnw -v` |
| Node.js | 18 LTS | `node -v` |
| npm | 9+ | `npm -v` |
| Base de datos | MySQL 8 / PostgreSQL 15 | — |
| (Opcional) Docker | 24+ | `docker -v` |

---

## Instalación y Ejecución Local

### 1 — Clonar el repositorio

```bash
git clone https://github.com/<org>/iamarket.git
cd iamarket
```

### 2 — Configurar variables de entorno

Copia el archivo de ejemplo y completa los valores reales (ver sección [Variables de Entorno](#variables-de-entorno)):

```bash
cp mercadoai/.env.example mercadoai/.env
```

### 3 — Backend (`mercadoai`)

#### Linux / macOS

```bash
cd mercadoai
./mvnw spring-boot:run
```

#### Windows

```cmd
cd mercadoai
mvnw.cmd spring-boot:run
```

> El servidor arranca por defecto en `http://localhost:8080`.  
> La documentación Swagger estará disponible en `http://localhost:8080/swagger-ui/index.html`.

### 4 — Frontend (`mercadoai-frontend`)

En una terminal separada:

```bash
cd mercadoai-frontend
npm install
npm run start
```

> La aplicación arranca en `http://localhost:4200` y realiza proxy a `localhost:8080`.

---

## Variables de Entorno

Crea el archivo `mercadoai/.env` (o configura las variables en tu sistema/CI) basándote en la siguiente plantilla:

```dotenv
# ── Base de Datos ──────────────────────────────────────────────
DB_URL=jdbc:mysql://localhost:3306/iamarket
DB_USERNAME=root
DB_PASSWORD=tu_password
DB_DRIVER=com.mysql.cj.jdbc.Driver

# ── JWT ────────────────────────────────────────────────────────
JWT_SECRET=cambia_este_secreto_por_uno_seguro_de_256_bits
JWT_EXPIRATION=86400000        # milisegundos (24 h)

# ── Cloudinary ─────────────────────────────────────────────────
CLOUDINARY_CLOUD_NAME=tu_cloud_name
CLOUDINARY_API_KEY=tu_api_key
CLOUDINARY_API_SECRET=tu_api_secret

# ── PayPal ─────────────────────────────────────────────────────
PAYPAL_CLIENT_ID=tu_client_id
PAYPAL_SECRET=tu_client_secret
PAYPAL_MODE=sandbox            # sandbox | live

# ── Spring ─────────────────────────────────────────────────────
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=dev     # dev | prod
```

> ⚠️ **Nunca** commitees el archivo `.env` con valores reales. El `.gitignore` ya lo excluye; verifica que sea así antes de cada push.

---

## Despliegue

### Docker (backend)

```bash
# Construir imagen
docker build -t iamarket-backend ./mercadoai

# Ejecutar pasando variables de entorno
docker run -p 8080:8080 \
  --env-file mercadoai/.env \
  iamarket-backend
```

> El `Dockerfile` se encuentra en `mercadoai/Dockerfile`. Ajusta el `ENTRYPOINT` si cambias el nombre del artefacto.

### Vercel (frontend)

El proyecto ya incluye `vercel.json` con las reglas de rewrite para la SPA:

```bash
cd mercadoai-frontend
npx vercel --prod
```

Configura las variables de entorno (`VITE_API_URL`, etc.) directamente en el panel de Vercel → *Settings → Environment Variables*.

---

## Seguridad

- **JWT_SECRET** debe tener al menos 256 bits de entropía. Genera uno con:
  ```bash
  openssl rand -base64 64
  ```
- Nunca uses `SPRING_PROFILES_ACTIVE=dev` en producción; este perfil puede exponer endpoints de diagnóstico.
- Rota las credenciales de Cloudinary y PayPal ante cualquier sospecha de filtración.
- El filtro `JwtValidationFilter` valida firma y expiración en cada request; asegúrate de que el reloj del servidor esté sincronizado (NTP).
- Para producción, configura HTTPS y establece las cabeceras de seguridad en el `SecurityConfig` de Spring.
- Revisa periódicamente las dependencias con:
  ```bash
  # Backend
  ./mvnw dependency-check:check

  # Frontend
  npm audit
  ```

---

## Guía de Contribución

### Flujo de trabajo

1. Haz fork del repositorio y crea una rama descriptiva:
   ```bash
   git checkout -b feat/nombre-de-la-feature
   # o
   git checkout -b fix/descripcion-del-bug
   ```
2. Realiza tus cambios siguiendo los estándares de código del proyecto.
3. Asegúrate de que todas las pruebas pasen antes de abrir una PR.
4. Abre una Pull Request describiendo el problema, la solución y capturas si aplica.

### Estilo de commits (Conventional Commits)

```
<tipo>(alcance): descripción corta en imperativo

feat(products): agregar filtrado por categoría
fix(auth): corregir expiración de token en zona UTC
docs(readme): actualizar instrucciones de despliegue
refactor(mapper): simplificar ProductMapper con MapStruct
test(services): añadir tests unitarios para UserService
chore(deps): actualizar Spring Boot a 3.2.5
```

### Antes de abrir una PR

```bash
# Backend — compilar y ejecutar tests
./mvnw verify

# Frontend — lint y tests
npm run lint
npm run test -- --watch=false --browsers=ChromeHeadless
```

---

## Troubleshooting

| Síntoma | Causa probable | Solución |
|---|---|---|
| `Connection refused` al iniciar el backend | Base de datos no disponible | Verifica que el servidor DB esté corriendo y que `DB_URL` sea correcto |
| `401 Unauthorized` en todas las peticiones | JWT_SECRET no configurado o distinto entre reinicios | Asegúrate de que `JWT_SECRET` sea fijo y esté en el entorno |
| WebSocket no conecta (`Error during WebSocket handshake`) | CORS mal configurado | Revisa `WebSocketConfig` y añade el origen del frontend a la lista permitida |
| `npm run start` falla con error de proxy | Backend no está corriendo | Arranca el backend antes que el frontend |
| Imágenes no se suben (500 de Cloudinary) | Credenciales inválidas o límite alcanzado | Verifica `CLOUDINARY_*` en el panel de Cloudinary |
| Pago PayPal devuelve error `INVALID_CLIENT` | Credenciales sandbox/live mezcladas | Asegúrate de que `PAYPAL_MODE` coincida con las credenciales usadas |
| Build de Maven falla en `mvnw: Permission denied` | Maven Wrapper sin permisos de ejecución | `chmod +x mercadoai/mvnw` |

---

## Referencias y Contacto

| Recurso | Enlace |
|---|---|
| Documentación Spring Boot | https://docs.spring.io/spring-boot/docs/current/reference/html/ |
| Angular Docs | https://angular.dev |
| MapStruct | https://mapstruct.org/documentation/stable/reference/html/ |
| Cloudinary Java SDK | https://cloudinary.com/documentation/java_integration |
| PayPal REST SDK | https://developer.paypal.com/api/rest/ |
| STOMP over WebSocket | https://stomp.github.io/ |
| Vercel Deployment | https://vercel.com/docs |
| JWT.io (debugger) | https://jwt.io |

**Mantenedor principal:** [@jfrancobeta](https://github.com/jfrancobeta) · `juandavid.francob@gmail.com`

Para reportar vulnerabilidades de seguridad, **no** abras un issue público — contactame.

---

<p align="center">
  Hecho con ☕ y Spring Boot · MIT License
</p>
