# BiblioHub

## Integrantes del Proyecto (Grupo 3)
- Sifuentes Castillo, Luis Alberto
- Balceda Delgado, Mariana
- Martinez Santos, Luz Cristina
- Baca Carretero, Leonardo
- Quiroz Ardiles, Sergio Daniel
- Monzon Infante, Cesar
- Cruz Bravo, Maycol Augusto

## Índice
1. [Propósito del Proyecto](#1-propósito-del-proyecto)  
   - [Descripción](#descripción)  
   - [Funcionalidades principales](#funcionalidades-principales)  
   - [Objetivo](#objetivo)  
   - [Ramas](#ramas)  
   - [Guardado de Datos](#guardado-de-datos)  
2. [Pipeline: Herramientas/Frameworks + Evidencia + Integración con Jenkins](#2-pipeline-herramientasframeworks--evidencia--integración-con-jenkins)  
   - [A. Construcción Automática](#a-construcción-automática)  
     - [Integración con Jenkins](#integración-con-jenkins)  
   - [B. Análisis Estático](#b-análisis-estático)  
     - [Informe de SonarQube](#informe-de-sonarqube)  
     - [Integración con Jenkins](#integración-con-jenkins-1)  
   - [C. Pruebas Unitarias](#c-pruebas-unitarias)  
     - [Pruebas](#pruebas)  
     - [Evidencia de Pruebas Unitarias](#evidencia-de-pruebas-unitarias)  
     - [Integración con Jenkins](#integración-con-jenkins-2)  
   - [D. Pruebas Funcionales](#d-pruebas-funcionales)  
     - [Pruebas](#pruebas-1)  
     - [Evidencia de Pruebas Funcionales](#evidencia-de-pruebas-funcionales)  
     - [Integración con Jenkins](#integración-con-jenkins-3)  
   - [E. Pruebas de Performance](#e-pruebas-de-performance)  
     - [Casos evaluados](#casos-evaluados)  
     - [Resultados de la ejecución de las pruebas de performance](#resultados-de-la-ejecución-de-las-pruebas-de-performance)  
     - [Integración de las pruebas de performance con Jenkins](#integración-de-las-pruebas-de-performance-con-jenkins)  
   - [F. Pruebas de Seguridad](#f-pruebas-de-seguridad)  
     - [Integración con Jenkins](#integración-con-jenkins-4)  
   - [G. Gestión de Issues](#g-gestión-de-issues)  
3. [Conclusiones](#3-conclusiones)  

---

## 1. Propósito del Proyecto

### Descripción
La aplicación web desarrollada permite gestionar un sistema de administración de libros, utilizando Spring Boot y Thymeleaf para la interfaz.

<div align="center">
  <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_.png" alt="home image" width="600">
</div>

### Objetivo
Crear una plataforma intuitiva y robusta para la administración eficiente de libros, con soporte para pruebas automatizadas y buen desempeño bajo carga.

### Funcionalidades principales
- **Añadir Libros:** Botón para agregar un nuevo libro al sistema, redirigiendo al formulario correspondiente.
- **Buscar Libros:**
  - Utiliza un campo de búsqueda para localizar libros por su título.
  - Botón para limpiar el campo de búsqueda y reiniciar la vista.
- **Listar Libros:** Una tabla muestra información clave de cada libro:
  - **ID**: Identificador único.
  - **Título**: Nombre del libro.
  - **Descripción**: Resumen del contenido.
  - **Complejidad**: Nivel de dificultad asociado al libro.
  - **Stock**: Estado de publicación o disponibilidad.

  La tabla se actualiza según los resultados de búsqueda.

  <div align="center">
     <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros.png" alt="book table" width="600">
  </div>

  <div align="center">
     <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros_keyword=el.png" alt="search list" width="600">
  </div>
  
- **Acciones sobre libros:**
  - **Editar**: Modifica los datos de un libro existente.
    
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros_70.png" alt="edit book" width="600">
      </div>

  - **Eliminar**: Despliega un modal de confirmación antes de borrar un libro.
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros_modal.png" alt="delete book modal" width="600">
      </div>

  - **Habilitar/Deshabilitar**: Cambia el estado de publicación del libro.
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros_stock.png" alt="edit alert" width="600">
      </div>

- **Acciones sobre libros:** Al realizar una acción (como agregar, actualizar o eliminar), se muestran mensajes de confirmación en una alerta destacada.
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/localhost_8081_Libros_aviso.png" alt="edit alert" width="600">
      </div>


### Ramas
- **master:** Breve descripción de la rama.

### Guardado de Datos
- Breve explicación del mecanismo de almacenamiento.
- Menciona tecnologías relevantes (e.g., Spring Data JPA, H2, etc.).

---

## 2. Pipeline: Herramientas/Frameworks + Evidencia + Integración con Jenkins

### A. Construcción Automática
- Describe cómo se realiza la construcción automática.

#### Integración con Jenkins
Explica cómo Jenkins está integrado en esta etapa.

### B. Análisis Estático
- Breve descripción del análisis estático y sus objetivos.

#### Informe de SonarQube
- **Complejidad Ciclomática y Cognitiva:** Detalla su importancia.
- **Bugs:** Resume los problemas identificados.
- **Code Smells:** Explica los principales problemas encontrados.

#### Integración con Jenkins
Describe cómo Jenkins automatiza este análisis.

### C. Pruebas Unitarias
- Breve introducción sobre las pruebas unitarias.

#### Pruebas
1. **testSomething:** Describe su objetivo y pasos clave.

#### Evidencia de Pruebas Unitarias
Explica los resultados generales de las pruebas.

#### Integración con Jenkins
Detalla cómo Jenkins ejecuta estas pruebas automáticamente.

### D. Pruebas Funcionales
- Breve introducción sobre las pruebas funcionales.

#### Pruebas
1. **testSomething:** Describe su objetivo y pasos clave.

#### Evidencia de Pruebas Funcionales
Explica los resultados generales de las pruebas funcionales.

#### Integración con Jenkins
Detalla cómo Jenkins ejecuta estas pruebas automáticamente.

### E. Pruebas de Performance
- Introducción a las pruebas de rendimiento.

#### Casos evaluados
1. **Caso 1:** Breve descripción del caso.

#### Resultados de la ejecución de las pruebas de performance
Explica los resultados obtenidos durante las pruebas.

#### Integración de las pruebas de performance con Jenkins
Detalla cómo Jenkins ejecuta y reporta estas pruebas.

### F. Pruebas de Seguridad
- Breve descripción de las pruebas de seguridad realizadas.

#### Integración con Jenkins
Explica cómo Jenkins automatiza estas pruebas.

### G. Gestión de Issues
- Describe cómo se registran y gestionan los issues en GitHub Projects.
- Incluye detalles como responsables, etiquetas, y duración estimada.

---

## 3. Conclusiones
Resume los logros principales del proyecto, las tecnologías usadas y los resultados obtenidos.
