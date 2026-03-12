# Challenge-Literalura
<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-Database-blue" alt="Postgres">
</p>

# LiterAlura 📚

LiterAlura es una aplicación de consola desarrollada como parte del challenge de back-end de Alura Latam / Oracle Next Education. El objetivo principal es construir un catálogo de libros que interactúa con una API externa, permitiendo registrar y consultar información literaria en una base de datos local.



## 🛠️ Funcionalidades Principales
1. **Buscar libro por título:** Consulta la API de [Gutendex](https://gutendex.com/), obtiene los datos y los registra en la base de datos automáticamente.
2. **Listar libros registrados:** Muestra todos los libros almacenados en la base de datos.
3. **Listar autores registrados:** Consulta los autores de los libros guardados.
4. **Listar autores vivos en un año determinado:** Filtra autores que estaban vivos en un rango de tiempo específico.
5. **Listar libros por idioma:** Filtra los registros según el idioma (ej: EN, ES, FR, PT).

## 🚀 Tecnologías Utilizadas
* **Java 17:** Lenguaje principal.
* **Spring Boot 3.2.4:** Framework base.
* **Spring Data JPA:** Para la capa de persistencia y manejo de la base de datos.
* **PostgreSQL:** Sistema de gestión de base de datos.
* **Gutendex API:** Fuente de datos literarios.



## ⚙️ Configuración y Ejecución

1. **Requisitos previos:**
   * Tener instalado Java 17 o superior.
   * Tener instalado PostgreSQL y una base de datos creada.

2. **Clonar el proyecto:**
   ```bash
   git clone [https://github.com/tu-usuario/literalura.git](https://github.com/tu-usuario/literalura.git)
