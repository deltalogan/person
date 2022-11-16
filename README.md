# AFIP Person project for Spring Boot

_alta, baja, modificación y búsqueda de una persona en base de datos de AFIP_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_https://eclipse.c3sl.ufpr.br/oomph/epp/2022-09/R/eclipse-inst-jre-win64.exe_
_https://download.oracle.com/java/18/archive/jdk-18.0.2.1_windows-x64_bin.msi_
_https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip_
_https://cdn.mysql.com//Downloads/MySQLInstaller/mysql-installer-community-8.0.31.0.msi_
_https://objects.githubusercontent.com/github-production-release-asset-2e65be/56899284/46a05b7f-9609-4e38-bfdf-810544c8da0d?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20221116%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20221116T134452Z&X-Amz-Expires=300&X-Amz-Signature=540f2bd64d3ecfeb24b5615fc10533712d890a648ad3f8ae5243f13ec6d70af0&X-Amz-SignedHeaders=host&actor_id=0&key_id=0&repo_id=56899284&response-content-disposition=attachment%3B%20filename%3DInsomnia.Core-2022.6.0.exe&response-content-type=application%2Foctet-stream_

```

### Instalación 🔧

_Registrar variable de entorno JAVA_HOME para tú JDK_

_Procedimiento_
1. En el panel de control:...
2. Pulse el botón Variables de entorno.
3. Pulse el botón Nuevo en la sección de variables del sistema.
4. Añada el nombre de variable JAVA_HOME y especifique una vía de acceso al directorio JDK.
5. Guarde los cambios.

```
Ejemplo: C:\Program Files (x86)\Java\jdk1.8.0_351
```
_Registrar variable Path_

_Procedimiento_
1. Pulse el botón Editar.
2. Pulse el botón Nuevo.
3. Añada la especificación vía de acceso %JAVA_HOME%\bin.
4. Pulse el botón Aceptar.
5. Guarde los cambios.

```
Ejemplo: %JAVA_HOME%\bin
```

_Registrar variable de entorno MAVEN_HOME para tú MAVEN_

_Procedimiento_
1. En el panel de control:...
2. Pulse el botón Variables de entorno.
3. Pulse el botón Nuevo en la sección de variables del sistema.
4. Añada el nombre de variable JAVA_HOME y especifique una vía de acceso al directorio MAVEN.
5. Guarde los cambios.

```
Ejemplo: C:\Program Files (x86)\apache-maven-3.8.6
```
_Registrar variable Path_

_Procedimiento_
1. Pulse el botón Editar.
2. Pulse el botón Nuevo.
3. Añada la especificación vía de acceso %MAVEN_HOME%\bin.
4. Pulse el botón Aceptar.
5. Guarde los cambios.

```
Ejemplo: %MAVEN_HOME%\bin
```

_para corroborar instalación y registro de variable correcta de JDK, presionar combinación de teclas: tecla Windows + r, y escribir en la ventana de ejecución lo siguiente: cmd, dentro de la consola escribir lo siguiente: java -version seguido de tecla enter_
_para corroborar instalación y registro de variable correcta de MAVEN, presionar combinación de teclas: tecla Windows + r, y escribir en la ventana de ejecución lo siguiente: cmd, dentro de la consola escribir lo siguiente: mvn -v seguido de tecla enter_

## Ejecutando las pruebas ⚙️

_ALTA de usuario_

### Analice las pruebas end-to-end 🔩

_Aquí vamos a proceder a probar el alta de un usuario en AFIP_

```
para la siguiente ruta: http://localhost:8080/person vamos a elegir el método POST en Insomnia enviando el siguiente JSON

{
	"name" : "Ricardo Jose",
	"lastName" : "Traversaro",
	"cuil" : "20297524527",
	"dni" : "29752452",
	"email" : "telteodorologan@gmail.com"
}
```

### Y las pruebas de estilo de codificación ⌨️

_nos debería devolver algo similar a lo siguiente:_

{
	"id": 1,
	"email": "telteodorologan@gmail.com",
	"dni": "29752452",
	"cuil": "20297524527",
	"name": "Ricardo Jose",
	"lastName": "Traversaro",
	"birthday": null
}

```
como verán en el campo id sé nos asigno el valor 1, eso quiere decir que ya tenemos nuestro primer registro almacenado en la base de datos

_MODIFICACIÓN de usuario_

### Analice las pruebas end-to-end 🔩

_Aquí vamos a proceder a probar la modificación de un usuario en AFIP_

```
para la siguiente ruta: http://localhost:8080/person vamos a elegir el método POST en Insomnia enviando el siguiente JSON

{
	"id" : "1",
	"name" : "Ricardo Jose",
	"lastName" : "Traversaro",
	"cuil" : "20297524527",
	"dni" : "29752452",
	"email" : "deltalogan@yahoo.com.ar"
}
```

### Y las pruebas de estilo de codificación ⌨️

_nos debería devolver algo similar a lo siguiente:_

{
	"id": 1,
	"email": "deltalogan@yahoo.com.ar",
	"dni": "29752452",
	"cuil": "20297524527",
	"name": "Ricardo Jose",
	"lastName": "Traversaro",
	"birthday": null
}

```
como verán el campo id es el mismo (1), pero está vez sé actualizó la casilla de correo electrónico con el nuevo valor en la base de datos

_BAJA de usuario_

### Analice las pruebas end-to-end 🔩

_Aquí vamos a proceder a probar la baja de un usuario en AFIP_

```
para la siguiente ruta: http://localhost:8080/person/1 vamos a elegir el método DELETE en Insomnia

```

### Y las pruebas de estilo de codificación ⌨️

_nos debería devolver algo similar a lo siguiente:_

Se eliminó el usuario con id1

```
como verán, utilizando el método DELETE en el Insomina desde la siguiente ruta: http://localhost:8080/person/1 (teniendo en cuenta que después de lo que sigue de person/ es el número de id de la persona), podremos eliminar un usuario en la base de datos

_BÚSQUEDA de usuario_

### Analice las pruebas end-to-end 🔩

_Aquí vamos a proceder a probar la búsqueda de un usuario en AFIP_

```
para la siguiente ruta: http://localhost:8080/person/query?cuil=20297524527 vamos a elegir el método GET en Insomnia

```

### Y las pruebas de estilo de codificación ⌨️

_nos debería devolver algo similar a lo siguiente:_

[
	{
		"id": 5,
		"email": "deltalogan@yahoo.com.ar",
		"dni": "29752452",
		"cuil": "20297524527",
		"name": "Ricardo Jose",
		"lastName": "Traversaro",
		"birthday": null
	}
]

```
como verán, utilizando el método GET en el Insomina desde la siguiente ruta: http://localhost:8080/person/query?cuil=20297524527 (teniendo en cuenta que después de lo que sigue de person/query? es el atributo que sé generó previamente como servicio de búsqueda seguido del símbolo = y el valor que sé quiera buscar)
```

## Despliegue 📦

_recordar desde el IDE de Eclipse dirigirse a Help → Eclipse Marketplace… → en el cuadro de búsqueda escribir lo siguiente: Spring Tools 4_

## Construido con 🛠️

_Herramientas que sé utilizaron para esté proyecto_

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [MySql](https://www.mysql.com/) - Motor de base de datos
* [Insomnia](https://insomnia.rest/) - Aplicación que nos permite realizar pruebas API
* [Eclipse](https://www.eclipse.org/) - IDE - Entorno de desarrollo integrado
* [Java](https://www.java.com/es/) - JVM

## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/tu/proyecto/tags).

## Autores ✒️

_Autores_

* **Ricardo José Traversaro** - *Trabajo Inicial* [mailto:telteodorologan@gmail.com]