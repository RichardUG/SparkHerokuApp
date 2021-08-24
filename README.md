# TAREA INTRODUCCIÓN MVN-GITY HEROKU

> Trabajo que consta de crear dos clientes, uno de tipo java para pruebas y otro para realizar depliege web, los cuales se comunicaran por medio de protocolos ```HTTP``` con un servidor ```Heroku``` el cual se ecargara de realizar nuestro despliegue web, que sera guiado a sus respectivos destinos por la ejecución de una implementación de ```SparkWeb``` , que ayudara a comunicar y a la vez extraer la información en formade ```JSON``` de las ```APIs``` de ```Alpha entage``` e ```IEX Cloud```, para finalmenete ser transportadas por medio del protocolo y representadas en nuestros clientes

### Pre-requisitos

> Para  elaborar este proyecto requeimos de dos tecnologias:
> * [Maven](https://es.wikipedia.org/wiki/Maven): Herramienta la cual permite realizar la construción de proyectos, realizarles pruebas y otras funciones.
> * [Git](https://es.wikipedia.org/wiki/Git): Software de control de versionamiento centralizado.
> * [Heroku](https://es.wikipedia.org/wiki/Heroku): Heroku es una plataforma como servicio (PaaS) de computación en la Nube que soporta distintos lenguajes de programación.

Para asegurar que el usuario cumple con todos los prerrequisitos para poder ejecutar el programa, es necesario disponer de un Shell o Símbolo del Sistema para ejecutar los siguientes comandos para comprobar que todos los programas están instalados correctamente, para así compilar y ejecutar tanto las pruebas como el programa correctamente.

```
mvn -version
git --version
java -version
```


### Ejecución del proyecto desde linea de comandos
> ### Instalación
>
> Clonamos este repositario desde ```cmd```, con el siguiente comando
>
> ```
> git clone https://github.com/RichardUG/Arep-TallerHeroku
> ```
>
> Si nos encontramos en un dispositivo ```linux``` nos dirigimos al archivo ```procfile``` y reemplazamos el contenido por el siguiente texto
> ```
> web: java $JAVA_OPTS -cp 'target/classes:target/dependency/*' edu.escuelaing.arep.designprimer.SparkWebApp
> ```
> 
> Si nos encontramos en un dispositivo ```windows``` nos dirigimos al archivo procfile y reemplazamos el contenido por el siguiente texto
> ```
> web: java -cp target/classes;target/dependency/* edu.escuelaing.arep.designprimer.SparkWebApp
> ```
> 
> ### Prueba
> 
> Ya habiendo realizado la configuracción correspondiente dependiendo de nuestro sistema operativo, podemos desplegar con heroku localmente, siguierndo los siguientes pasos :
> 
> 1. Ejecutamos el siguiente comando, para que ```mvn``` limpie los modulos que estan ejecutados o escritos y que inicie la ejecución de nuestro proyecto desde 0
> ```
> mvn clean install
> ```
> 2. Ahora ejecutamos el siguiente comando para realizar el despliegue en heroku desde una versión local de nuestro dispositivo
> ```
> heroku local web
> ```
> 3. Ahora tras haber realizado los pasos anteriores, podemos ver el despliegue de nuestro proycto yendo al siguiente link:
> 
> [http://localhost:5000/hello](http://localhost:5000/hello)
> 

### Despliegue directo en heroku
> Para desplegar el programa directamente desde el servicio de ```Heroku``` damos clic al siguiente link.
> 
> [![](/img/deploy.PNG)](https://tallerherokuurrea.herokuapp.com/hello)

## Construido con

* [Maven](https://es.wikipedia.org/wiki/Maven): Herramienta la cual permite realizar la construción de proyectos, realizarles pruebas y otras funciones.
* [Git](https://es.wikipedia.org/wiki/Git): Software de control de versionamiento centralizado.
* [Heroku](https://es.wikipedia.org/wiki/Heroku): Heroku es una plataforma como servicio (PaaS) de computación en la Nube que soporta distintos lenguajes de programación.
* [Intelij](https://es.wikipedia.org/wiki/IntelliJ_IDEA): es un entorno de desarrollo integrado (IDE) para el desarrollo de programas informáticos. Es desarrollado por JetBrains, y está disponible en dos ediciones: edición para la comunidad1 y edición comercial.
* [Java](https://www.oracle.com/java/): Lenguaje de programación de propósito general, es decir, que sirve para muchas cosas, para web, servidores, aplicaciones móviles, entre otros. Java también es un lenguaje orientado a objetos, y con un fuerte tipado de variables.

## Autor
[Richard Santiago Urrea Garcia](https://github.com/RichardUG)

## Licencia & Derechos de Autor
**©** Richard Santiago Urrea Garcia, Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito

Licencia bajo la [GNU General Public License](https://github.com/RichardUG/Arep-TallerHeroku/blob/master/LICENSE).
