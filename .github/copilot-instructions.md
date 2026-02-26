Purpose

This file provides concise repository-specific guidance for Copilot/Copilot-CLI sessions: how to build, run, test, and where to look for the high-level architecture and repository conventions.

Quick commands

Backend (Java Spring Boot - mercadoai/)
- Install & build (Linux/macOS):
  - cd mercadoai && ./mvnw package
- Build & run (Windows):
  - cd mercadoai && mvnw.cmd spring-boot:run
- Run tests (all):
  - cd mercadoai && ./mvnw test
- Run a single test class or method:
  - cd mercadoai && ./mvnw -Dtest=MyTestClass#myTestMethod test
  - (mvn or mvnw both supported; on Windows use mvnw.cmd)
- Lint: No repository-level Java linter/checkstyle is configured in pom.xml (add plugin if needed).

Frontend (Angular 17 - mercadoai-frontend/)
- Install deps:
  - cd mercadoai-frontend && npm install
- Start dev server:
  - cd mercadoai-frontend && npm run start    # runs `ng serve`
- Build production bundle:
  - cd mercadoai-frontend && npm run build
- Run frontend tests (Karma/Jasmine):
  - cd mercadoai-frontend && npm run test
- Run a single frontend spec:
  - Use focused Jasmine helpers (fit / fdescribe) in the spec file to run a single test locally (Karma config here uses standard Angular setup).
- Lint: No npm `lint` script is present in package.json (add ESLint / stylelint if required).

High-level architecture (big picture)

- Monorepo with two main projects at repository root:
  1) mercadoai/ — Spring Boot (Java 17) backend. Built with Maven (mvn or bundled mvnw). Uses layered architecture: controllers, services, repositories, DTOs, MapStruct mappers, models, and auth filters.
  2) mercadoai-frontend/ — Angular 17 SPA generated with Angular CLI (ng). Uses Karma/Jasmine for unit tests, STOMP websockets for chat (@stomp/stompjs) and standard Angular conventions.

- Backend responsibilities and notable integrations:
  - Authentication: JWT-based (JwtTokenProvider, JwtAuthenticationFilter, JwtValidationFilter, SecurityConfig) and a JwtChannelInterceptor for WebSocket authentication.
  - Persistence: JPA repositories under repository/*; pom.xml includes MySQL and PostgreSQL drivers (runtime).
  - DTOs & Mapping: DTOs are defined under dto/* and MapStruct mappers under mapper/* (mapstruct and annotation processor configured in pom.xml).
  - External services/configs: CloudinaryConfig, PaypalSetup, WebSocketConfig, SwaggerConfig and a global exception handler (GlobalExceptionHandler).
  - Web layer: Controllers are grouped by feature under controllers/<Feature> (e.g., controllers/Usuario, controllers/Chat).

Key repository conventions and patterns (what to expect)

- Package-by-feature grouping: controllers/, service/, repository/, dto/, mapper/ and model/ are organized by domain feature; look in mercadoai/src/main/java/com/jfranco/aimercado/mercadoai/ for the top-level layout.
- DTO naming conventions: *CreateDTO, *DTO, *SummaryDTO, *UpdateDTO — follow these when adding new endpoints.
- Service interfaces use I* (e.g., IUsuarioService) with implementation named *Impl.
- MapStruct mappers live in mapper/<Feature> and are used for DTO ↔ model conversions (mapstruct processor is required at compile time).
- Repository naming: <Entity>Repository or feature-namespaced repositories under repository/<Feature>/
- Exception handling: Use ResourceNotFoundException for missing entities and rely on GlobalExceptionHandler for consistent API error responses.
- WebSockets: Chat controllers and WebSocketConfig use a JWT interceptor; ensure the same JWT extraction logic is used for HTTP filters and WebSocket channels.
- Tests:
  - Backend: standard Maven test layout (src/test/java). Use `-Dtest=` to run targeted unit tests.
  - Frontend: use fit/fdescribe to run a single unit test locally under Karma.

Where to look for more context

- proyecto.txt at repo root contains product requirements and functional specs used by the project team.
- Backend entry points and interesting configs:
  - mercadoai/pom.xml (build and dependencies)
  - mercadoai/src/main/resources/ (application.properties / profiles)
  - mercadoai/src/main/java/... (controllers, service, repository, auth and config packages)
- Frontend package.json: mercadoai-frontend/package.json (scripts and devDependencies)

When modifying or adding features

- Keep the layered separation: controllers should delegate to services; services orchestrate business logic and repositories; DTOs and MapStruct mappers handle payload translation.
- Follow naming conventions for DTOs, services, mappers and repository packages to keep the project consistent.

Files checked and merged

- Incorporated high-level details from pom.xml and mercadoai-frontend/package.json and the project requirements in proyecto.txt.

If updates are needed

- If a specific CI, linter, or test runner should be added to the repo (e.g., GitHub Actions workflow, ESLint for frontend, or Checkstyle/SpotBugs for backend), note that here and a follow-up patch can add the minimal config plus automation.

---

Do you want me to configure any MCP servers relevant to this project (for example Playwright for end-to-end testing of the Angular frontend)?
