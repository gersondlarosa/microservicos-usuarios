# Microservicio de Usuarios (`microservicios-usuarios`)

Este microservicio se encarga de gestionar toda la lógica de negocio y persistencia relacionada con los **Usuarios/Alumnos** dentro del ecosistema de la aplicación. Está diseñado bajo una arquitectura limpia y desacoplada, utilizando herencia de controladores y servicios genéricos, y registrándose automáticamente como un cliente en el servidor de descubrimiento.

## 🚀 Tecnologías y Requisitos

* **Java:** 17
* **Framework Principal:** Spring Boot 4.0.5
* **Ecosistema Cloud:** Spring Cloud 2025.1.1 (Netflix Eureka Client)
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL / MariaDB

---

## 🏗️ Arquitectura y Componentes Clave

El microservicio destaca por reutilizar componentes genéricos y librerías externas:

1. **Reutilización de Código (`commons`):**
   * Hereda el comportamiento CRUD básico del controlador (`CommonController`) y la capa de servicios (`CommonService` / `CommonServiceImpl`) desde un módulo común compartido.
   * Importa de manera externa la entidad de dominio `Alumno` desde el jar local `commons-alumnos`.

2. **Escaneo de Entidades Externas:**
   Debido a que la entidad `Alumno` reside en un paquete externo fuera del escaneo automático del microservicio, se configura explícitamente en la clase principal:
   ```java
   @EntityScan({"com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno"})
Descubrimiento Dinámico:Cuenta con la anotación @EnableDiscoveryClient para auto-registrarse de forma dinámica en el servidor Eureka, permitiendo balanceo de carga y enrutamiento inteligente (ej. a través de un API Gateway).⚙️ Configuración del Entorno (application.properties)El microservicio está configurado para ejecutarse en entornos dinámicos y persistir datos localmente:Puerto: Puerto dinámico (server.port=${PORT:0}), ideal para levantar múltiples instancias locales sin conflictos de puertos.Registro en Eureka: Reporta al servidor en la dirección por defecto http://localhost:8761/eureka utilizando asignación basada en IP preferente.Base de Datos: Conexión hacia la base de datos db_microservicios_examenes en MySQL local con generación de DDL automática activada (spring.jpa.generate-ddl=true).🗺️ Endpoints del API RESTAdemás de los métodos heredados del CRUD genérico (Listar, Ver por ID, Crear y Eliminar), este controlador expone de manera específica la actualización del Alumno:MétodoEndpointDescripciónCuerpo de la Petición (JSON)PUT/{id}Modifica los datos de un alumno existenteArchivo JSON con los campos a modificar (nombre, apellido, email)Ejemplo de Petición para Editar (PUT)URL: http://localhost:[PUERTO_ASIGNADO]/1Body (JSON):JSON{
  "nombre": "Atenas",
  "apellido": "Santana",
  "email": "ate_santana@gmail.com"
}
🛠️ Compilación y Despliegue LocalRequisito Previo ObligatorioDado que este proyecto depende críticamente de tus módulos compartidos locales, asegúrate de haber compilado e instalado previamente en tu repositorio local de Maven los proyectos correspondientes de commons:Bash# Ejecutar primero en la raíz de tus proyectos 'commons' y 'commons-alumnos'
mvn clean install
Ejecución del MicroservicioUna vez listos los prerequisitos, puedes compilar e iniciar este microservicio ejecutando:Bashmvn spring-boot:run
