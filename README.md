# Sistema de Emergencias - README

Este proyecto es un sistema de gestión de emergencias que permite la coordinación entre voluntarios y coordinadores para responder eficazmente a situaciones de emergencia.

## Características principales

- Registro y gestión de voluntarios.
- Asignación de tareas a voluntarios por parte de los coordinadores.
- Seguimiento en tiempo real del estado de las tareas asignadas.
- Generación de reportes de actividad y desempeño.

## Tecnologías utilizadas

- Java
- Spring Boot
- MySQL

## Instalación

### Requisitos previos

- JDK 8 o superior instalado
- Maven
- MySQL Server

### Pasos para la instalación

1. Clona el repositorio a tu máquina local.
2. Crea una base de datos MySQL con el nombre `LabTBD-1-2024`.
3. Ejecutar los script .sql en la carpeta "Database" en el siguiente orden: dbCreate, triggers, procedures, loadData.
4. Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA, Eclipse).
5. Configura las credenciales de la base de datos en el archivo `application.properties` ubicado en `src/main/resources/`.
6. Ejecuta la aplicación. La aplicación estará disponible en [http://localhost:8090](http://localhost:8090).

## Uso

1. Ejecuta el backend y el frontend de la aplicación en tus editores de código favoritos.
2. Accede a la aplicación desde tu navegador web.
3. Inicia sesión como coordinador o voluntario según corresponda.
4. Explora las diferentes funcionalidades ofrecidas por el sistema, como registro de voluntarios, asignación de tareas, seguimiento de tareas, etc.
5. ¡Comienza a utilizar el sistema para gestionar emergencias de manera eficiente!

## Contribución

Las contribuciones son bienvenidas. Si deseas contribuir al desarrollo de este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad (`git checkout -b feature/AmazingFeature`).
3. Realiza tus cambios.
4. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`).
5. Haz push a la rama (`git push origin feature/AmazingFeature`).
6. Abre un pull request.

## Soporte

Para obtener ayuda o reportar problemas, por favor contacta al equipo de desarrollo.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
