# Consultor de Libros

Este proyecto es una aplicación en Java con Spring Boot para gestionar información sobre libros. La aplicación incluye funcionalidades como el manejo de libros, listar autores vivos en un año específico, consultar libros desde una API externa, y más.

## Requerimientos

- Java 17 o superior
- Spring Boot
- Maven o Gradle
- Base de datos (preferentemente PostgreSQL)

## Estructura del Proyecto

### Paquetes

1. **com.consultorlibros.servicio**: Contiene la lógica de negocio y los métodos principales.
2. **com.consultorlibros.modelo**: Contiene la estructura de los objetos `Libro`.
3. **com.consultorlibros.repositorio**: Interactúa con la base de datos para realizar operaciones CRUD.
4. **com.consultorlibros.controlador**: Define las rutas REST para manejar las solicitudes.

## Funcionalidades Implementadas

1. **Guardar y listar libros**:
   - Puedes guardar un libro en la base de datos.
   - Listar todos los libros registrados.

2. **Listar autores**:
   - Muestra todos los autores registrados, con un prefijo "Autor: " antes de cada nombre.

3. **Listar autores vivos en un año específico**:
   - Se puede consultar qué autores están vivos en un año específico, mostrando un prefijo "Autor: " antes de cada nombre.

4. **Consultar libros desde una API externa**:
   - Puedes obtener libros adicionales desde una API externa (`gutendex.com`).

5. **Combinar datos de la base de datos y la API**:
   - Al consultar los libros, se añaden tanto los libros de la base de datos como los libros obtenidos desde la API.

## Requisitos adicionales

- La base de datos debe estar configurada y lista para recibir conexiones.
- La API externa (`gutendex.com`) debe ser accesible.

## Cómo Iniciar

1. Clona el repositorio:
   ```bash
   git clone <(https://github.com/Nando-AQZ/ConsultaLibros.git)>
