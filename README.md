# 🚀 Sistema de Pagos Estudiantiles - Spring Boot + Angular

![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Material UI](https://img.shields.io/badge/Angular_Material-0081CB?style=for-the-badge&logo=angular&logoColor=white)

Aplicación web para gestionar pagos de estudiantes, con registro de transacciones, estados (pendientes/realizados) y panel administrativo.

## 📌 Funcionalidades Principales

### Backend (Spring Boot)
- ✅ API REST para CRUD de estudiantes y pagos
- ✅ Conexión a base de datos (H2)
- ✅ Validación de datos y manejo de excepciones

### Frontend (Angular + Material)
- 🔍 Búsqueda y filtrado de estudiantes/pagos
- ➕ Formularios para agregar/editar pagos
- 📊 Visualización de estados (Pendiente/Realizado)
- 🔄 Gestión de fechas y montos

## 🛠️ Tecnologías Utilizadas

| Capa         | Tecnologías                                                                 |
|--------------|-----------------------------------------------------------------------------|
| **Frontend** | Angular 19, Angular Material, TypeScript, RxJS, HTML5/CSS3                  |
| **Backend**  | Spring Boot 3+, Spring Data JPA, Spring Security (opcional), Lombok         |
| **Base de Datos** | H2                                                                     |
| **Herramientas** | Maven, Git, Visual Studio Code                           |

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
- JDK 17+
- Node.js 16+
- Angular CLI (`npm install -g @angular/cli`)
- Maven 3.8+
- Base de datos configurada (o H2 embebida)

#### Backend (Spring Boot)
```bash
cd sistema_pagos_backend

# Configura la base de datos en application.properties:
# spring.datasource.url=jdbc:mysql://localhost:3306/pagos_db
# spring.datasource.username=tu_usuario
# spring.datasource.password=tu_contraseña

mvn spring-boot:run
```

### Frontend (Angular)
```bash
cd sistema_pagos_frontend

npm install
ng serve --open  # Abre http://localhost:4200
```

### 📸 Capturas de Pantalla

## Vista de Estudiantes
![Screenshot 2025-05-05 at 11-33-35 SistemaPagosFrontend](https://github.com/user-attachments/assets/a7ed7f13-b9ae-4a1b-b18d-f41f8f17e146)


## Vista de Pagos
![Screenshot 2025-05-05 at 11-33-23 SistemaPagosFrontend](https://github.com/user-attachments/assets/8480dda7-725a-411c-8ffd-c292adb8f97b)

## Vista de Login
![Screenshot 2025-05-05 at 11-33-58 SistemaPagosFrontend](https://github.com/user-attachments/assets/ccdef6aa-108a-4b14-8fc1-e37547c88eca)

## Vista de Nuevo Pago
![Screenshot 2025-05-05 at 11-34-18 SistemaPagosFrontend](https://github.com/user-attachments/assets/b4a96755-884f-4d50-a66d-7e9582a8d543)
