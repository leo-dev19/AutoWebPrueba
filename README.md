# Automatización - Conduit 

Pruebas automatizadas sobre [Conduit](https://conduit.bondaracademy.com/) 

## Alcance de la automatización
Cubre los 3 flujos principales de la aplicación:
* **Registro de usuario (`@RegistrarUsuario`):** Creación de una nueva cuenta y validación del nombre de usuario en la barra de navegación.
* **Publicación de artículo (`@CrearArticulo`):** Inicio de sesión, creación de un artículo (título, descripción, contenido y tag) y verificación del título publicado.
* **Comentario en artículo (`@ComentarArticulo`):** Inicio de sesión, acceso al primer artículo del *Global Feed*, envío de un comentario y validación de su visualización.

## Requisitos previos
* Java JDK 17
* Maven 3.8+
* Google Chrome instalado

## Ejecución de pruebas

### Desde terminal (Maven)
Ejecutar toda la suite (`@Conduit`) y generar el reporte de Serenity:
```bash
mvn clean verify