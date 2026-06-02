# infracciones

Sistema de gestión de infracciones de tránsito desarrollado con Spring Boot, JPA, MySQL, HTML, CSS y JavaScript.

## Descripción

Este proyecto permite gestionar de forma simple la información principal de un sistema de infracciones viales. El sistema permite registrar conductores, vehículos, inspectores y actas de constatación desde un panel unificado.

La aplicación cuenta con una interfaz web para cargar datos, consultar registros y administrar la información del sistema.

## Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Thymeleaf
* HTML
* CSS
* JavaScript

## Funcionalidades

* Registro de conductores e infractores.
* Registro de vehículos.
* Registro de inspectores y autoridades de constatación.
* Labrado de actas de infracción de tránsito.
* Panel unificado con pestañas para alta rápida de registros.
* Validaciones en tiempo real en los formularios.
* Búsqueda instantánea en las tablas de registros.

## Orden recomendado de carga

1. Registrar inspector/autoridad.
2. Registrar conductor.
3. Registrar vehículo.
4. Labrar el acta de constatación.

## Base de datos

El proyecto utiliza MySQL.

Antes de ejecutar el sistema, crear una base de datos llamada:

```sql
CREATE DATABASE db_multas_transito;
```

La configuración se encuentra en:

```txt
src/main/resources/application.properties
```

## Ejecución del proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Verificar que MySQL esté ejecutándose.
4. Crear la base de datos `db_multas_transito`.
5. Ejecutar la clase principal del proyecto.
6. Abrir el navegador en:

```txt
http://localhost:8080
```
## Programa Funcionando
<img width="1919" height="973" alt="image" src="https://github.com/user-attachments/assets/8c04adca-8daa-4966-b309-5011cf52a935" />
<img width="1919" height="872" alt="image" src="https://github.com/user-attachments/assets/9ded3351-6dc4-40ed-995f-9b770ae17f11" />
<img width="1263" height="634" alt="image" src="https://github.com/user-attachments/assets/85e94838-5546-42ae-8fe8-e79a241d931f" />

##Aclaracion
A mi me funciona sin version de lombok en el pom.xml y mi puerto es el 3307.
## Autor
Lucas

Materia: Programación Orientada a Objetos

Instituto Tecnológico Universitario

Universidad Nacional de Cuyo
