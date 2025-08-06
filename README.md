# Foro API - Spring Boot 3

API RESTful desarrollada con Spring Boot 3 y MySQL para gestionar un foro de preguntas y respuestas. Cuenta con autenticación basada en JWT, migraciones con Flyway, y pruebas de endpoints mediante Insomnia.

## 📌 Funcionalidades principales

- Registro y login de usuarios
- Creación de temas (posts)
- Listado, visualización, actualización y eliminación de temas
- Protección de rutas mediante JWT
- Validación de datos con Bean Validation
- Persistencia en base de datos MySQL
- Migraciones automáticas con Flyway

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Flyway
- Maven
- Insomnia (para pruebas de endpoints)
- Git y GitHub

## 🗂️ Estructura del proyecto

src/
└── main/
├── java/com/foroapi
│ ├── auth/ # Autenticación y generación de tokens
│ ├── controller/ # Controladores REST
│ ├── domain/ # Entidades del modelo
│ ├── dto/ # Clases de transferencia de datos
│ ├── repository/ # Repositorios (Spring Data JPA)
│ └── service/ # Lógica de negocio
└── resources/
├── application.properties
└── db/migration/ # Archivos Flyway (e.g. V1__init_schema.sql)

## 🧪 Cómo probar el proyecto

1. Cloná el repositorio:

```bash
git clone https://github.com/NicolasSanchez96/foro-api.git
cd foro-api
2.Configurá tu base de datos MySQL y asegurate de crear una base llamada foro_db.

3.En el archivo application.properties, verificá los datos de conexión:

spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

4.Ejecutá la aplicación desde IntelliJ o con Maven:
./mvnw spring-boot:run
5.Las migraciones de Flyway se aplican automáticamente al iniciar la app.

🔐 Autenticación con JWT
La API cuenta con login y registro:

POST /auth/register → Registra un nuevo usuario

POST /auth/login → Devuelve un token JWT válido

Cómo usar el token
Agregarlo en cada request a endpoints protegidos con el header:
Authorization: Bearer <token>

🔧 Migraciones con Flyway
La app usa Flyway para crear y versionar la base de datos.

Los archivos .sql están en src/main/resources/db/migration.

Se ejecutan automáticamente al levantar la app.


Endpoints principales
Migración inicial aplicada: V1__init_schema.sql

| Método | Ruta             | Descripción                  | Autenticación |
| ------ | ---------------- | ---------------------------- | ------------- |
| POST   | `/auth/register` | Registro de usuario          | ❌             |
| POST   | `/auth/login`    | Login y obtención de JWT     | ❌             |
| POST   | `/temas`         | Crear un nuevo tema          | ✅             |
| GET    | `/temas`         | Listar todos los temas       | ✅             |
| GET    | `/temas/{id}`    | Obtener detalle de un tema   | ✅             |
| PUT    | `/temas/{id}`    | Actualizar un tema existente | ✅             |
| DELETE | `/temas/{id}`    | Eliminar un tema             | ✅             |

🧪 Pruebas realizadas con Insomnia
Login y registro: funcionando correctamente (200, 201)

Acceso a rutas protegidas sin token: 401

Acceso con token inválido o expirado: 403

CRUD de temas probado con y sin token

🚀 Estado actual
✅ Proyecto funcional, probado y subido a GitHub.
✅ Migraciones y autenticación completadas.
✅ Estructura lista para escalar o integrar más funcionalidades.

🧑‍💻 Autor
Nicolás Sánchez
https://github.com/NicolasSanchez96



