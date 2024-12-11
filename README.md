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
Cada miembro del equipo creó su propia rama para trabajar de manera independiente. Este enfoque permite mantener un control claro sobre las contribuciones individuales y asegura que las modificaciones de cada participante se integren de manera ordenada. A continuación, se describe la estructura de ramas utilizada:

1. **Main:**
   
   - Esta es la rama principal y estable del proyecto.
   - Contiene el código listo para producción y despliegue.
   - Solo se fusionan cambios que han sido revisados y probados.

3. **Desarrollo**
   
   Cada participante del equipo creó una rama personal para el **desarrollo** del proyecto.
   
   - `Maycol`
   - `cesar`
   - `leonardo`
   - `luis`
   - `mariana`
   - `sergio`
     
 5. **Pruebas funcionales**
    
    Se creó una rama para realizar las pruebas funcionales y unitarias:
    - `pruebas-funcionales`

### Guardado de Datos  
El sistema utiliza **H2 Database** como base de datos integrada para almacenar los datos. Durante la ejecución:  

- Los datos se gestionan mediante **Spring Data JPA**, facilitando el manejo de repositorios y operaciones transaccionales.  
- La configuración de persistencia está en el archivo `application.properties`, ubicado en el directorio `src/main/resources`.  
- Los datos se almacenan en un archivo local (`testdb.mv.db`), con soporte para actualizaciones automáticas del esquema.  


---

## 2. Pipeline: Herramientas/Frameworks + Evidencia + Integración con Jenkins

### A. Construcción Automática
- La integración y despliegue continuo para BiblioHub se implementa utilizando Jenkins como herramienta de automatización y Maven como gestor de construcción del proyecto.
     <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/pom.png" alt="maven" width="600">
      </div>

#### Integración con Jenkins
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins.png" alt="maven" width="600">
   </div>

### B. Análisis Estático
El análisis estático fue realizado para garantizar la calidad, seguridad y mantenibilidad del código del proyecto. Esto se implementó utilizando herramientas especializadas que nos ayudaron a identificar defectos en las etapas iniciales del desarrollo.
- Herramientas Utilizadas:
  - SonarQube: Para generar informes detallados sobre métricas de calidad y posibles errores en el código.
  - Jenkins: Integrado con SonarQube para automatizar el análisis estático dentro del pipeline de CI/CD.

#### Informe de SonarQube
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/sonarqube informe.png" alt="informe de sonarqube" width="600">
   </div>
   
- **Complejidad Ciclomática y Cognitiva:**
  Este análisis ayuda a evaluar la mantenibilidad del código y reducir la deuda técnica.

  <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/complejidad.png" alt="complejidad">
   </div>
  
- **Bugs:**
  Se identificaron algunos bugs, entre ellos:

  <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/bugs.png" alt="bugs" width="600">
   </div>
  
- **Code Smells:**
  Se detectaron varios code smells relacionados con duplicación de código. Esto puede dificultar el mantenimiento del sistema.

  <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/code smells 1.png" alt="code smells" width="600">
   </div>

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/code smells 2.png" alt="code smells" width="600">
   </div>

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/code smells 3.png" alt="code smells" width="600">
   </div>
  
#### Integración con Jenkins

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins sonarqube.png" alt="jenkins sonarqube" width="600">
   </div>

### C. Pruebas Unitarias
- Las pruebas unitarias garantizan que cada componente individual del sistema funcione correctamente de manera aislada. En BiblioHub, estas pruebas se implementaron con JUnit.
  
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/junit.png" alt="junit" width="600">
   </div>
   

#### Pruebas
1. **testGetAll_NoKeyword:**
   
   - **Objetivo:** Verificar que el controlador ```getAll``` recupera todos los libros correctamente sin ningún filtro de búsqueda.
   - **Pasos Clave:**
     1. Se configura el repositorio para devolver una lista de objetos ```Tutorial```.
     2. Se verifica que el repositorio ```findAll()``` es llamado.
     3. Se confirma que el modelo contiene los atributos adecuados y la vista "tutorials" se retorna correctamente.
   - **Resultado esperado:** El método debe devolver la vista ```tutorials``` con todos los libros existentes.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testGetAll_NoKeyword.png" alt="testGetAll_NoKeyword" width="600">
      </div>
      
2. **testGetAll_WithKeyword:**
   
   - **Objetivo:** Validar que el método ```getAll``` recupera libros filtrados por una palabra clave específica.
   - **Pasos Clave:**
     1. Proporcionar un ```keyword``` (ej. ```"Test"```).
     2. Configurar el repositorio para que busque libros por título con la palabra clave.
     3. Verificar que el repositorio y el modelo contienen los datos correspondientes.
   - **Resultado esperado:** La vista debe contener los libros que coincidan con la palabra clave proporcionada.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testGetAll_WithKeyword.png" alt="testGetAll_WithKeyword" width="600">
      </div>

3. **testAddTutorial:**
   
   - **Objetivo:** Asegurarse de que el método addTutorial retorna el formulario correcto y añade atributos necesarios al modelo.
   - **Pasos Clave:**
     1. Invocar el método ```addTutorial```.
     2. Confirmar que el controlador agrega el objeto Tutorial y el título de la página al modelo.
   - **Resultado esperado:** Se debe retornar la vista ```tutorial_form``` con los atributos apropiados.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testAddTutorial.png" alt="testAddTutorial" width="600">
      </div>
      
4. **testSaveTutorial:**
   
   - **Objetivo:** Probar que el método ```saveTutorial``` guarda un nuevo libro y redirecciona a la vista adecuada.
   - **Pasos Clave:**
     1. Configurar un objeto ```Tutorial```.
     2. Ejecutar el método y verificar que el repositorio y ```RedirectAttributes``` procesen el mensaje de confirmación.
   - **Resultado esperado:** El repositorio debe guardar el tutorial y el mensaje debe aparecer en la vista principal.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testSaveTutorial.png" alt="testSaveTutorial" width="600">
      </div>
            
5. **testEditTutorial:**
   
   - **Objetivo:** Validar que el método ```editTutorial``` permite editar un libro específico.
   - **Pasos Clave:**
     1. Proveer el ID del tutorial y configurar el repositorio para encontrar el objeto correspondiente.
     2. Verificar que el modelo contiene el tutorial y atributos relevantes.
   - **Resultado esperado:** El método debe retornar la vista ```tutorial_form``` con la información actualizada del libro.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testEditTutorial.png" alt="testEditTutorial" width="600">
      </div>
      
6. **testDeleteTutorial:**
   
   - **Objetivo:** Asegurarse de que el método ```deleteTutorial``` elimina correctamente un libro.
   - **Pasos Clave:**
     1. Invocar el método ```deleteTutorial``` con el ID del libro.
     2. Verificar que el repositorio ```deleteById``` y el ```RedirectAttributes``` procesan el mensaje de eliminación.
   - **Resultado esperado:** El repositorio debe guardar el tutorial y el mensaje debe aparecer en la vista principal.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testDeleteTutorial.png" alt="testDeleteTutorial" width="600">
      </div>

7. **testUpdatePublishedStatus:**
   
   - **Objetivo:** Probar el método `updateTutorialPublishedStatus` para cambiar el estado de un libro entre publicado y no publicado.
   - **Pasos Clave:**
     1. Proveer el ID del tutorial y el valor booleano `published`.
     2. Configurar el repositorio para realizar la actualización del estado.
   - **Resultado esperado:** El método debe redireccionar a la vista principal y mostrar el mensaje de confirmación.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testUpdatePublishedStatus.png" alt="testUpdatePublishedStatus" width="600">
      </div>
      
#### Evidencia de Pruebas Unitarias

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/mvn test unit.png" alt="mvn test unit" width="600">
   </div>

#### Integración con Jenkins

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins unit tests.png" alt="jenkins unit" width="600">
   </div>

### D. Pruebas Funcionales
- Las pruebas funcionales verifican la interacción del usuario con la aplicación web y garantizan que las funcionalidades clave se comporten como se espera. Para este propósito, se utilizó Selenium WebDriver.
  
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/selenium pom.png" alt="selenium pom" width="600">
   </div>
   
- Se utilizo el web driver de Chrome:
  
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/web driver chrome.png" alt="web driver chrome" width="600">
   </div>

   
#### Pruebas
1. **testHomePageLoads:**
   
   - **Objetivo:** Verificar que la página principal se carga correctamente y contiene el encabezado esperado.
   - **Pasos Clave:**
     1. Navegar a la URL principal (```http://localhost:8081/```).
     2. Localizar el elemento ```h1``` y comprobar que contiene el texto "BIBLIOHUB".
   - **Resultado esperado:** El encabezado de la página debe mostrar "BIBLIOHUB".
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testHomePageLoads.png" alt="testHomePageLoads" width="600">
      </div>
      
2. **testAddBook:**
   
   - **Objetivo:** Validar que un nuevo libro se puede agregar correctamente al sistema.
   - **Pasos Clave:**
     1. Navegar al formulario de nuevo libro (```http://localhost:8081/Libros/new```).
     2. Rellenar los campos: título, descripción, nivel y estado de publicación.
     3. Enviar el formulario y verificar el mensaje de éxito.
   - **Resultado esperado:** El mensaje de éxito debe contener la palabra "guardado".
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testAddBook.png" alt="testAddBook" width="600">
      </div>

3. **testViewBookList:**
   
   - **Objetivo:** Asegurarse de que la lista de libros se muestra correctamente.
   - **Pasos Clave:**
     1. Navegar a la lista de libros (```http://localhost:8081/Libros```).
     2. Esperar a que la tabla de libros sea visible.
     3. Verificar que la tabla contiene filas.
   - **Resultado esperado:** La tabla debe estar visible y contener datos.
     
      <div align="center">
         <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/testViewBookList.png" alt="testViewBookList" width="600">
      </div>

#### Evidencia de Pruebas Funcionales

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/mvn test.png" alt="mvn test" width="600">
   </div>

#### Integración con Jenkins

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins funcional tests.png" alt="jenkins functional" width="600">
   </div>

### E. Pruebas de Performance
- En este apartado se llevaron a cabo pruebas de rendimiento utilizando Apache JMeter para evaluar el desempeño del sistema. Estas pruebas permitieron identificar cuellos de botella y analizar la capacidad de respuesta de la aplicación bajo distintas condiciones de carga. Los parámetros configurados incluyeron lo siguiente:
  
  - **Número de threads:** 50
  - **Ramp-up period:** 10 segundos
  - **Loop count:** 10

#### Casos evaluados
1. **Guardar libro:**
   
   Utiliza un HTTP Request con un método POST para guardar un libro.
   
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/caso 1.png" alt="caso 1" width="600">
   </div>
   
2. **Listar libros:**
   
   Utiliza un HTTP Request con un método GET para listar los libros.
   
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/caso 2.png" alt="caso 2" width="600">
   </div>

3. **Eliminar libro:**
   
   Utiliza un HTTP Request con un método GET para eliminar un libro.
   
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/caso 3.png" alt="caso 3" width="600">
   </div>

4. **Editar libro:**
   
   Utiliza un HTTP Request con un método GET para editar un libro.
   
   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/caso 4.png" alt="caso 4" width="600">
   </div>

#### Resultados de la ejecución de las pruebas de performance

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jmeter report 1.png" alt="jmeter report" width="600">
   </div>

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jmeter report 2.png" alt="jmeter report" width="600">
   </div>

#### Integración de las pruebas de performance con Jenkins
El bloque `stage("Pruebas de Rendimiento - JMeter")` en el pipeline de Jenkins ejecuta pruebas de rendimiento automatizadas utilizando Apache JMeter en modo no gráfico (`-n`). Se especifica el archivo de prueba `bibliohubTest.jmx` y se configuran parámetros como `-l` para guardar los resultados en `resultados.jtl`, `-e` para generar reportes HTML automáticamente y `-o` para almacenar dichos reportes en `C:/Program Files/Jenkins/reporte_rendimiento`. Al finalizar, el bloque `post` limpia el espacio de trabajo con `cleanWs()` para asegurar un entorno limpio y optimizado para futuras ejecuciones.


   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins jmeter.png" alt="jenkins jmeter" width="600">
   </div>

### F. Pruebas de Seguridad
- Se llevan a cabo pruebas de seguridad para asegurar que la aplicación esté protegida contra vulnerabilidades comunes, como inyecciones SQL, XSS y CSRF.

- Se realizan validaciones utilizando ZAP en un entorno controlado. Este entorno ejecuta las pruebas web necesarias para evaluar la seguridad y el rendimiento, empleando la imagen oficial de ZAP disponible en Docker Hub. Estas pruebas generan un informe que permite determinar si la aplicación es segura. Además, se ofrece la posibilidad de configurar los parámetros de las evaluaciones a realizar.
  
    <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/reporte zap.png" alt="reporte zap" width="600">
    </div>
   
#### Integración con Jenkins

   <div align="center">
      <img src="https://github.com/Almabade1/BiblioHub/blob/main/Imagenes/jenkins zap.png" alt="jenkins zap" width="600">
   </div> 

### G. Gestión de Issues
En GitHub Projects, se registran los problemas más relevantes identificados durante las pruebas en SonarQube. También se distribuye el trabajo entre los miembros del equipo mediante tareas, las cuales incluyen:

- **Nombre de la tarea:** Descripción específica de lo que se debe realizar.  
- **Responsable:** Miembro del equipo encargado de llevar a cabo la tarea.  
- **Etiqueta:** Clasificación de la tarea según su prioridad o tipo (por ejemplo, bug, mejora).  
- **Duración estimada:** Tiempo aproximado para completar la tarea.

---

## 3. Conclusiones

El proyecto **BiblioHub** logró desarrollar una aplicación robusta y eficiente para la gestión de libros, implementando tecnologías como Spring Boot y Thymeleaf. Se automatizó el ciclo de vida del desarrollo mediante Jenkins y se garantizaron estándares de calidad con pruebas unitarias y análisis de código estático con SonarQube. A pesar de algunos desafíos, como la coordinación entre miembros del equipo y la detección de problemas de duplicación de código, el sistema cumple con los objetivos planteados. Las pruebas de rendimiento y seguridad confirmaron la estabilidad y viabilidad de la aplicación. Se identificaron áreas de mejora, como la escalabilidad y la optimización de pruebas automatizadas, lo que proporciona una base sólida para futuras actualizaciones y expansiones del proyecto.

