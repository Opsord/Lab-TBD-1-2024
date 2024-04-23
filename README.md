<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Sistema de Emergencias</title>
</head>
<body>
    <h1>Sistema de Emergencias - README</h1>

    <p>Este proyecto es un sistema de gestión de emergencias que permite la coordinación entre voluntarios y coordinadores para responder eficazmente a situaciones de emergencia.</p>

    <h2>Características principales</h2>
    <ul>
        <li>Registro y gestión de voluntarios.</li>
        <li>Asignación de tareas a voluntarios por parte de los coordinadores.</li>
        <li>Seguimiento en tiempo real del estado de las tareas asignadas.</li>
        <li>Generación de reportes de actividad y desempeño.</li>
    </ul>

    <h2>Tecnologías utilizadas</h2>
    <ul>
        <li>Java</li>
        <li>Spring Boot</li>
        <li>MySQL</li>
    </ul>

    <h2>Instalación</h2>

    <h3>Requisitos previos</h3>
    <ul>
        <li>JDK 8 o superior instalado</li>
        <li>Maven</li>
        <li>MySQL Server</li>
    </ul>

    <h3>Pasos para la instalación</h3>
    <ol>
        <li>Clona el repositorio a tu máquina local.</li>
        <li>Crea una base de datos MySQL con el nombre <code>LabTBD-1-2024</code>.</li>
        <li>Ejecutar los script .sql en la carpeta "Database" en el siguiente orden: dbCreate, triggers, procedures, loadData.</li>
        <li>Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA, Eclipse).</li>
        <li>Configura las credenciales de la base de datos en el archivo <code>application.properties</code> ubicado en <code>src/main/resources/</code>.</li>
        <li>Ejecuta la aplicación. La aplicación estará disponible en <a href="http://localhost:8090">http://localhost:8090</a>.</li>
    </ol>

    <h2>Uso</h2>
    <ol>
        <li>Ejecuta el backend y el frontend de la aplicacion en tus editores de codigo favoritos.<li>
        <li>Accede a la aplicación desde tu navegador web.</li>
        <li>Inicia sesión como coordinador o voluntario según corresponda.</li>
        <li>Explora las diferentes funcionalidades ofrecidas por el sistema, como registro de voluntarios, asignación de tareas, seguimiento de tareas, etc.</li>
        <li>¡Comienza a utilizar el sistema para gestionar emergencias de manera eficiente!</li>
    </ol>

    <h2>Contribución</h2>
    <p>Las contribuciones son bienvenidas. Si deseas contribuir al desarrollo de este proyecto, por favor sigue estos pasos:</p>
    <ol>
        <li>Haz un fork del repositorio.</li>
        <li>Crea una rama para tu funcionalidad (<code>git checkout -b feature/AmazingFeature</code>).</li>
        <li>Realiza tus cambios.</li>
        <li>Haz commit de tus cambios (<code>git commit -m 'Add some AmazingFeature'</code>).</li>
        <li>Haz push a la rama (<code>git push origin feature/AmazingFeature</code>).</li>
        <li>Abre un pull request.</li>
    </ol>

    <h2>Soporte</h2>
    <p>Para obtener ayuda o reportar problemas, por favor contacta al equipo de desarrollo.</p>

    <h2>Licencia</h2>
    <p>Este proyecto está bajo la Licencia MIT. Consulta el archivo <code>LICENSE</code> para más detalles.</p>

</body>
</html>
