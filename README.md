# ITCpersonal
Proyecto para tener nota ya que ITC tarda demasiado y Alvaro y yo no queremos suspender profes plz sed generosos con nosotros os queremos y tamos iorando

# Índice de contenidos
1. [Manual de preparación y uso del proyecto](Manual-de-preparación-y-uso-del-proyecto-(Windows-10,-versión-de-febrero-2022))
2. [Manual básico del usuario](Manual-básico-del-usuario)
3. [Manual de desarrollador de Play!](Manual-de-desarrollador-de-Play!-framework)


# Manual de preparación y uso del proyecto (Windows 10, versión de febrero 2022)
--------------------------------------------------------------------------------

### El equipo con el proyecto debe contener la siguiente lista de software instalada;

Java Development Kit 8	(Para el proyecto se usó las versiones 8_201 y 8_321 sin problemas aparentes)
Play! Framework		(El proyecto usa la versión 1.4.5)
FAP                 (Generador de código a instalar desde Play! framework, se usó la versión 3.8.0)
Mariadb Server		(El proyecto usa la versión 10.7 y credenciales de usuario y contraseña 'root')

Entornos de desarrollo utilizados para el desarrollo del proyecto;
* Eclipse IDE For Java Developers and Web Enterprises 9.2021
* Visual Studio Code
* * Visual Studio Code solo requiere abrir la carpeta colaboracion, Eclipse necesita ser configurado al igual que otros (siguiente sección)


### Configuración previa deberá ser realizada para la correcta ejecución del proytecto;

En la ventana 'Variables de Entorno' del equipo..;

* En la lista de variables de 'Path' se debe añadir una ruta hacia la carpeta de Play! Es posible que se encuentre en 'C:\Program Files\play-1.4.5' (aunque uno de los integrates tuvo que añadir en la ruta '\play-1.4.5\play-1.4.5')

* En la lista de variables de 'Path' se debe añadir una ruta hacia la carpeta con el JRE (no JDK) de java 8, terminando en su carpeta interna '/bin'.

* En la variable inferior 'JAVA_HOME' debe contener en su interior la ruta hacia su carpeta JDK (si no existe dicha variable, crearla con el contenido indicado).

* * Si se usa Eclipse, JAVA_HOME deberá contener una versión de Java 11 o superior para funcionar (y podrá usarse la variable de java 8 en PATH).. El proyecto (colaboracion) pasó por un procedimiento (play eclipsify) para permitir trabajar desde este entorno, razón por la que se creó la carpeta conjunta 'EclipseWorkspace'. Se pide al usuario borrar la carpeta oculta '.metadata' en su interior e 'Importar' el proyecto colaboracion (NO acabado en Eclipse) para empezar a utilizarlo.

* * * Play framework tiene varios comandos diferentes para soportar distintos entornos de desarrollo tales como Eclipse, desde el enlace (https://www.playframework.com/documentation/1.4.x/ide) se puede encontrar documentación sobre este tema.


Ahora, con tal de saber usar el Símbolo del Sistema, saber navegar hasta la ubicación raíz del proyecto y saber ejecutar 'play run' (iniciar proyecto), 'play deps' (actualizar dependencias y módulos) y 'play deps --sync --forceCopy' (reponer dependencias), no deberíamos tener problemas en iniciar el proyecto y visualizarlo desde la dirección 'localhost:9000' en un motor de búsqueda.

* Hay un aspecto que puede ser necesario preconfigurar, y esto es la creación de un usuario en base de datos debido a que se piden credenciales en la interfaz gráfica para acceder a esta base de datos, dichas credenciales están dentro (de primeras no existen datos en su interior).. Una solución rápida es comentar la anotación '@With(Secure.class)' del controlador 'Users.java' (deshabilitando el requerimiento de credenciales sobre la ventana del controlador de usuarios) y crear desde la intefaz gráfica un nuevo usuario (y descomendar la anotación para que el proyecto actúe como fue creado).


# Manual básico del usuario

### Operaciones básicas sobre base de datos

En la dirección 'localhost:\admin' es posible realizar las cuatro operaciones básicas de base de datos sobre todas las tablas de forma extremadamente intuitiva. Hay que tener en cuenta que la tabla 'Users' requiere de acceso por credenciales (las cuales están dentro de esta tabla y encriptadas de forma segura) antes de poder ser manipulada, por lo que si no se ha creado usuario alguno, por favor siga las instrucciones del párrafo inmediatamente superior.


### Ayudas

Hablando del controlador 'Users.java', al acceder a éste desde 'localhost:9000\admin' se debe poder visualizar botones en la parte inferior de la lista de usuarios, los cuales generan páginas PDF de informes o Reports. Los últimos dos botones llevan a informes instructivos sobre el uso de datos de usuarios y de manipulación de su tabla.


### Chat

Desde la página de bienvenida (localhost:9000), en la esquina superior izquierda, se puede encontrar la palabra 'websocket' subrayada, presionando aquí lleva a un chat básico para hablar con otros usuarios. Como este proyecto es local, solo es posible utilizar el mismo equipo y dos ventanas abiertas para charlar a través de este chat.



# Manual de desarrollador de Play! framework

Este framework está preparado para, mediante técnicas internas, consumir lo menos posible de recursos del equipo, y esto conlleva a ciertas automatizaciones que desarrolladores de este framework necesitan saber.. Aunque voy a explicar lo más importante, la documentación de esta versión de Play! es accesible desde el enlace 'https://www.playframework.com/documentation/1.4.x/home'.


### Modelos y controladores

Play! Utiliza una nomenclatura exacta a la hora de hacer llamadas entre modelos y controladores. Un modelo y su controlador se deben diferenciar literalmente por una 's' en el controlador (si el modelo es User, su controlador debe llamarse Users).

* Sin embargo, existe una anotación para controladores que nos permite llamar al controlador como queramos, y es '@CRUD.For(modelo.class)'. Con tal de utilizarlo con el modelo correspondiente y justo encima de la definición del controlador debería de funcionar.

* Como curiosidad, en el enlace 'https://stackoverflow.com/questions/9107701/play-framework-crud-naming-convention' se explica que NO se diferencia por una 's', sino poque al final haya exactamente una letra cualquiera (el modelo puede llamarse User y el controlador Userh, Usera, etc..)


### Enrutamientos a ficheros HTML

Otra peculiaridad de Play! es su manera de invocar páginas web. Existe un proceso por el que, a través de nomenclatura de ficheros y métodos, Play! redirecciona al usuario a través de su interfaz gráfica e invoca los debidos ficheros HTML.. Explicado en pasos separados:

* En 'routes' añadimos una línea con sus debidas tabulaciones (siguiendo las otras), la cual sería 'GET /(ruta deseada inexistente)   (Nombre clase java en 'controllers' (sin extensión 'java') y de carpeta en 'views').(nombre método de la clase en 'controllers' y del archivo html (sin extensión HTML)) con llamada a 'render()')'. Esto último explicado abajo.

* En la clase java escrita, añadimos la función 'public static void (nombre método escrito) throws Exception {render(); }'. El método render() invocará a una página web cuyo nombre será el de la función que lo usa.


### Herencia entre ficheros HTML, y etiquetas especiales

Play! permite algo inusual en otros frameworks, y esto es que un archivo HTML haga uso del contenido de otro archivo HTML a través de una de las etiquetas especiales que nos brinda este framework, de las cuales también hablaré por encima.

* En el archivo HTML 'index' en la carpeta 'views', se pueden ver dos etiquetas relevantes a la herencia; "#{extends 'main.html' /}" para heredar de ésta y #{welcome /} para invocar su contenido. También se puede ver otra etiqueta especial "#{set title:'Home'}" para que la ventana se llame 'Home' desde el motor de búsqueda.

* * Intentaría explicar como funcionan pero no me podido averiguar como hace la etiqueta especial 'welcome' para invocar el contenido de 'main.html'

* En el archivo HTML 'main' en la carpeta 'views', se puede observar otras etiquetas especiales que presumo que son para invocar varios archivos de estilos, de javascript y otra más "#{doLayout /}" que presumo de alguna forma invoca la bien definida página web mostrada al acceder a 'localhost:9000' con el proyecto iniciado.


### Extra; Llamada a recursos locales en el proyecto

He experimentado problemas en cuanto a llamadas a diferentes recursos en el mismo proyecto, tales como ficheros de estilo o imágenes, por lo que decidí añadir esta sección extra.

* Por ejemplo, la etiqueta HTML que viene por defecto de Play! que define la ubicación del fichero de estilos 'link rel="stylesheet" media="screen" href="@{'/public/stylesheets/(nombre fichero css)'}' da error si no elimino la parte 'media="screen"'.

* Para el tema de imagen, investigué por unas 5 horas para ver como mostrar una imagen, y tras muchos intentos descubrí que la forma explicada en la web no funcionaba para mi, pero un híbrido entre la forma más encontrada y la de javascript vanilla sí. Para aquellos que tampoco saben como, esta fue mi solución; 'img src="@{'/public/images/(imagen y extensión)'}"/'.
