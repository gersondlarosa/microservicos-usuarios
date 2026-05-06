# 🚀 Microservicio de Usuarios (Alumnos)

Este microservicio forma parte de una arquitectura distribuida basada en **Spring Cloud**. Se encarga de la gestión integral de los alumnos, permitiendo su registro, edición, eliminación y consulta dentro del ecosistema de la aplicación.

## 🛠️ Tecnologías Utilizadas

* **Java:** 17
* **Spring Boot:** 4.0.5
* **Spring Cloud:** 2025.1.1 (Netflix Eureka Client)
* **Spring Data JPA:** Gestión de persistencia.
* **Base de Datos:** MySQL / MariaDB.
* **Herramientas:** Maven, Lombok (opcional), Hibernate.

## 🏗️ Arquitectura y Componentes

El proyecto sigue una arquitectura limpia dividida en capas:
* **Entity (`Alumno`):** Mapeo de la tabla `alumnos` con auditoría automática de fecha (`PrePersist`).
* **Repository (`AlumnoRepository`):** Uso de `CrudRepository` para operaciones básicas.
* **Service:** Lógica de negocio con transaccionalidad (`@Transactional`).
* **Controller:** Exposición de servicios REST.
* **Netflix Eureka:** Registro automático como cliente en el servidor de descubrimiento.

## ⚙️ Configuración del Entorno

Asegúrate de tener configurado tu archivo `application.properties` con los datos de tu base de datos local:

```properties
spring.application.name=microservicos-usuarios
server.port=${PORT:0} # Puerto dinámico para escalabilidad

# Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/db_microservicios_examenes
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect

# Discovery Service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

🚀 Instalación y Ejecución
Clonar el repositorio.

Configurar la base de datos db_microservicios_examenes en MySQL.

Importar como Maven Project en Spring Tool Suite (STS).

Ejecutar el servicio Eureka Server (necesario para el registro).

Ejecutar MicroservicosUsuariosApplication.java como Spring Boot App.

Desarrollado con ❤️ por Gerson De La Rosa
