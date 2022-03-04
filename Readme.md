# Índice de contenidos
0. [Introducción](#introduccion)
1. [Requisitos de usuario](#requisitos-de-usuario)
2. [Pila tecnológica](#pila-tecnologica-y-comparando-entre-pilas)
3. [Manual de preparación y uso del proyecto](#manual-de-preparativos-y-uso-del-proyecto)
4. [Manual simple del usuario](#manual-simple-del-usuario)
5. [Manual del desarrollador de Play!](#manual-del-desarrollador-de-play-framework)
6. [Base de datos; Descripción, modelos, diagramas y casos de uso](#base-de-datos-caracteristicas-relevantes)
7. [Usabilidad; Prototipo y diseño gráfico](#proyecto-prototipo-y-aspectos-de-usabilidad)
8. [Planificación y organización](#planificacion-y-organizacion)
9. [Conclusiones, opiniones y reflexiones](#conclusiones-opiniones-y-reflexiones)
10. [Enlaces y referencias](#enlaces-y-referencias)


# Introduccion
--------------

ITCpersonal trata de un repositorio con un proyecto auxiliar (colaboracion) basado en el proyecto verdadero que el Instituto Tecnológico de Canarias (También llamado ITC) tenía pensado para nosotros. El proyecto original está falto de archivo y configuración VPN esenciales para la importación de dependencias, del código total del proyecto y de la base de datos necesarias para poder trabajar, por lo que este repositorio se creó y desarrolló en la mitad de tiempo que debería haber tenido (medio mes de trabajo en espera).

La idea detrás de este proyecto, realizado por Brian García Gómez y Alvaro Carreras Motas, comprende de un set de páginas web para manipular de forma gráficamente amigable y completa una base de datos con tres tablas interrelacionadas y un chat local totalmente funcional.

La necesidad detrás de este proyecto es la de desarrollar un proyecto que pueda ser valorado por el profesorado del centro IES El Rincón. La necesidad detrás del proyecto del cuál este proyecto está basado es la de proporcionar formularios de convocatorias a subvenciones las cuales están registradas en la base de datos propia del ITC.

Como apartado extra, este proyecto también fue creado con la conveniencia de aprender a utilizar Play! junto al generador de código del Gobierno de Canarias (cuyas siglas son F.A.P.), puesto que el verdadero proyecto utiliza ambas tecnologías para funcionar.


# Requisitos de usuario
----------------------

El proyecto se creó utilizando el framework denominado Play!, el cuál utiliza técnicas de mínimo consumo de recursos por parte del dispositivo y por parte de la base de datos que utilice (es más, Play! está preparado para manejar inmensos volúmenes de datos procurando la mayor velocidad de procesamiento posible, además de funcionar como una aplicación a través de la web.

Gracias a esto, el proyecto resulta en un muy buen balance entre ligereza y agilidad, y se presenta como una aplicación multiplataforma.. Por lo que los requisitos de usuarios son prácticamente nulos, ya que un dispositivo con un motor de búsqueda e internet, sin importar sus prestaciones, sería suficiente.


# Pila tecnologica y comparando entre pilas
-------------------------------------------

La pila tecnológica está formada únicamente con un framework; Play!

Este framework es un full-stack, es decir, que se compone tanto del frontend como del backend, por lo que los dos stacks (frontend y backend) son manejados conjuntamente.

A diferencia de otras pilas tecnológicas y frameworks, Play! también tiene su modo de organizarse con el famoso MVC (organización en tres carpetas; Modelo, Vista y Controlador), pero este framework directamente te fuerza a organizarte bien (debido a sus técnicas automatizadas de mínimo consumo), además de que también se puede mantener muy organizado otros aspectos de suma importancia tales como las dependencias, rutas accesibles y configuración de datos de uso.

Aunque no hay que negar que ciertamente existen frameworks populares que fácilmente compiten con este framework, tales como las dos pilas tecnológicas que muchas veces se ponen en conjunto; Ionic (frontend) y Spring Hibernate (backend). Sobre esto debo decir que Play! No tiene etiquetas HTML propias como Ionic (permitiendo dar estilos de forma fácil y agradable usado en conjunto con Angular JS para administrar etiquetas HTML (aunque Angular está supuestamente abandonado desde hace 1 año aproximadamente)) ni la agilidad para el desarrollador como Spring Hibernate (Cuya importación de dependencias es usualmente automática en cuanto este framework detecta ciertas líneas de código, no como en Play! que hay que indicarlo manualmente).

Podría quedarme mucho más tiempo hablando de pilas tecnológicas diferentes a Play!, pero creo que queda bastante claro que está compitiendo fieramente entre otras populares por las prestaciones que ofrecen.


# Manual de preparativos y uso del proyecto
-------------------------------------------

Este proyecto se ha desarrollado a mediados de Febrero de 2022, en equipos con Windows 10 Home

### El equipo con el proyecto debe contener la siguiente lista de software instalada;

Java Development Kit 8	(Para el proyecto se usó las versiones 8_201 y 8_321 sin problemas aparentes)
Play! Framework		      (El proyecto usa la versión 1.4.5)
Mariadb Server		      (El proyecto usa la versión 10.7 y credenciales de usuario y contraseña 'root')

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


# Manual simple del usuario
---------------------------

### Operaciones básicas sobre base de datos

En la dirección 'localhost:\admin' es posible realizar las cuatro operaciones básicas de base de datos sobre todas las tablas de forma extremadamente intuitiva. Hay que tener en cuenta que la tabla 'Users' requiere de acceso por credenciales (las cuales están dentro de esta tabla y encriptadas de forma segura) antes de poder ser manipulada, por lo que si no se ha creado usuario alguno, por favor siga las instrucciones del párrafo inmediatamente superior.


### Ayudas

Hablando del controlador 'Users.java', al acceder a éste desde 'localhost:9000\admin' se debe poder visualizar botones en la parte inferior de la lista de usuarios, los cuales generan páginas PDF de informes o Reports. Los últimos dos botones llevan a informes instructivos sobre el uso de datos de usuarios y de manipulación de su tabla.


### Chat

Desde la página de bienvenida (localhost:9000), en la esquina superior izquierda, se puede encontrar la palabra 'websocket' subrayada, presionando aquí lleva a un chat básico para hablar con otros usuarios. Como este proyecto es local, solo es posible utilizar el mismo equipo y dos ventanas abiertas para charlar a través de este chat.



# Manual del desarrollador de Play Framework
--------------------------------------------

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



# Base de datos caracteristicas relevantes
------------------------------------------

### Descripción

La base de datos se denomina 'subvencion' y contiene 5 tablas internas, cada una con sus respectivas columnas;

* User - Discrimina usuarios por permiso a secciones de web cuyos datos a manipular son más concretos, únicos y sensibles:
* * id     - Identificación única de usuario.
* * nombre - Nombre completo del usuario.
* * firma  - Clave de acceso encriptada obtenida de la identificación previa de un usuario como individuo físico (más información en https://firmaelectronica.gob.es/)
* * rol    - Define el poder administrativo del usuario; Administrador o usuario regular.

* Informacion (Datos de convocatoria (usuarios afiliados a esta información se tratan en la tabla 'Rellena')):
* * id                 - Identificador único de datos de convocatoria.
* * familiaNumerosa    - Campo booleano (true/false) para indicar si la familia del usuario afiliado es numerosa.
* * familiaNumerosaPdf - Campo para archivos PDF que acrediten el estado de familia numerosa.
* * discapacidad       - Valor true/false para indicar si el usuario afiliado presenta dificultades mentales y/o motrices.
* * discapacidadPdf    - Campo para archivos PDF que acrediten las dificultades mentales y/o motrices del usuario afiliado.
* * rentaPdf           - Campo para archivos PDF que informen sobre la renta económica del usuario afiliado.
* * Estudios           - Campo de texto indicativo del nivel de estudios que el usuario afiliado va a cursar.

* Datos_personales (Información sensible identificativo de persona física (usuarios asociados son tratados en la tabla 'Tiene')):
* * id        - Identificador único de los datos.
* * nombre    - Campo de texto cuyo contenido hace ilusión al primer sustantivo propio identificativo de un ser humano.
* * apellido1 - Campo de texto cuyo contenido hace ilusión al segundo sustantivo propio identificativo de un ser humano.
* * apellido2 - Campo de texto cuyo contenido hace ilusión al tercer sustantivo propio identificativo de un ser humano.
* * dni       - Campo de ocho números y una letra que identifican a un ser humano como persona física de un territorio.
* * correo    - Campo de texto con dirección de correo electrónico perteneciente al usuario al que se le asocian estos datos.
* * tlf       - Campo numérico que hace referencia a un número de teléfono por el que se puede contactac al usuario asociado.

* Tiene (Tabla de asociación entre registros de tabla User y Datos_personales):
* * idUser  - Campo de clave ajena a la clave primaria de User (id, usada como identificación de usuario único)
* * idDatos - Campo de clave ajena a la clave primaria de Datos_Personales (id, usada como identificación de serie de datos único)

* Rellena (Tabla de asociación entre registros de tabla User e Informacion):
-- idUser - Campo de clave ajena a la clave primaria de User (id, usada como identificación de usuario único)
-- idInfo - Campo de clave ajena a la clave primaria de Informacion (id, usada como identificación de conocatoria único)


### Modelos

En el esquema relacional inferior se puede apreciar como se interrelacionan las tablas de la base de datos y los tipos de datos que se guardan en su interior (versión desactualizada por el cambio de dato de String a boolean en ciertos campos de Informacion)

![image](https://user-images.githubusercontent.com/71889035/156456833-140a6aa7-31b3-4eef-9ba4-d676278fa260.png)


### Diagrama de datos Entidad-Relación

En el diagrama inferior se puede apreciar las relaciones entre tablas a modo de entidades y de aquellas entidades-relaciones, junto a sus respectivas columnas, indicando de forma breve que cada serie de datos personales es asociada a uno y solo a un usuario, y un usuario rellena uno, y solo un formulario de convocatoria.

![image](https://user-images.githubusercontent.com/71889035/156457450-4c7b9170-226e-4fdd-9cad-445efcb4e423.png)


### Casos de uso

En lo que respecta a usuarios con acceso a la base de datos, solo existen dos tipos de usuarios; Usuario regular y Admin.

Cada uno tiene acciones que se le permite, y uno tiene mayor poder administrativo que el otro, todo para preveér el mejor mantenimiento y cuidado posible sobre la base de datos en general.

Existe un tercer usuario no considerado en la siguiente imagen explicativa de casos de uso, puesto que un usuario no registrado no debería poder realizar acciones en una página de convocatorias a menos de haberse identificado (y así guardar sus datos, y que sola y exclusivamente acceda a sus propios datos).

![image](https://user-images.githubusercontent.com/71889035/156458008-56dca81c-3033-4ecd-8a94-c54aa83571f3.png)



# Proyecto prototipo y aspectos de usabilidad
---------------------------------------------

En la raiz de este repositorio se encuentra el archivo 'Prototipo itcpersonal', creado a partir de la herramienta de creación de interfaz gráfica denominada Justinmind.

Dicho archivo contiene 10 páginas gráficas, las cuales conforman el set de páginas web del proyecto propio.


### Prototipo; Principal

El set de páginas web comienza a partir de la siguiente página web, dando la información principal de sobre datos sensibles y convocatorias relacionadas con del Gobierno de Canarias y su sede de servicios;

![Principal@1x](https://user-images.githubusercontent.com/71889035/156664182-18ca9523-6f4b-40d0-829b-be0b753a08ae.png)


### Prototipo; convocatorias de subvencion

Las siguientes páginas web pertenecen a un subset, las cuales se encargan de manejar las convocatorias (en el caso de que el usuario quiera realizar dichas convocatorias por aquí en vez de a través de la sede de servicios del Gobierno de Canarias) y los datos personales del usuario;

![subvencion-info@1x](https://user-images.githubusercontent.com/71889035/156665123-1c2beb81-7933-40bb-ac70-34e10438e207.png)
![subvencion-datos@1x](https://user-images.githubusercontent.com/71889035/156665147-2ff0574f-f59d-4b6e-acbe-bdf9535e6bec.png)
![subvencion-requisitos@1x](https://user-images.githubusercontent.com/71889035/156665155-b2159294-84fa-4de0-9419-98cb66aed7a9.png)
![subvencion-firma@1x](https://user-images.githubusercontent.com/71889035/156665159-ab44a03d-d0b5-4597-849c-fd30c97b0768.png)


### Prototipo; Gestión administrativa de la base de datos y datos sensibles

Las siguientes páginas web pertenecen a un subset, las cuales se encargan de manejar datos de la base de datos subvencion, una de ellas requeriendo acceso a través de credenciales que deben haber sido registradas previamente (más información en el manual del desarrollador);

![admin-general@1x](https://user-images.githubusercontent.com/71889035/156666242-76e0adb2-9690-430a-a77f-3fa33d5aa8b0.png)
![admin-reading@1x](https://user-images.githubusercontent.com/71889035/156666229-c8fc9d50-f4d9-40df-be9a-73f9a82332c2.png)
![admin-addition@1x](https://user-images.githubusercontent.com/71889035/156666253-368fb8ea-efa6-470f-80ba-d8a834f0613e.png)
![admin-edition-deletion@1x](https://user-images.githubusercontent.com/71889035/156666257-23f66302-3810-4b93-a8ba-56c29897fb7d.png)
![admin-login@1x](https://user-images.githubusercontent.com/71889035/156666274-22cceea0-e9c2-47d1-ad89-2d09a4a67054.png)


### Aspectos de usabilidad; Lista de aspectos considerados y justificación

Este es el listado de las opciones tenidas en cuenta a la hora de crear y desarrollar el proyecto;

* Útil              - Capaz de cumplir las tareas específicas por las que fue diseñado.
* Fácil de usar     - Eficiente, veloz y con menor cantidad de errores posibles. Cómoda de utilizar.
* Fácil de aprender - No se requiere de mucho tiempo en aprender su funcionalidad, sea fácil de recordar y entender.
* Eficiente         - Se mide el esfuerzo para conseguir un objetivo y se consigue un balance adecuado para el usuario.
* Ofrece beneficios - La funcionalidad de la aplicación posée una recompensa por su correcto uso.
* Simplicidad       - Se evade en la medida de lo posible que el proyecto tenga un aspecto 'sobrecargado'.

* El usuario es capaz de iniciar acciones
* El usuario es capaz de interactuar con la aplicación
* Estética de diseño; Los atributos visuales concentran la atención del usuario y un entorno agradable facilida el entendimiento
* Simplicidad del diseño; Información mínima imprescindible e interfaz SIMPLE y Fácil de aprender y recordar.

* Diseño visual - Un buen diseño visual se centra en aumentar la comunicación.
* Color         - Conjunto de colores mínimos y apropiados aplicados, y uso de colores apagados, sutiles y complementarios.
* Disposición de formularios; Localización visual de componentes limpia, crea un flujo visual de datos sin problemas al usuario.

* Familiaridad del usuario - Ambiente flexible para el rápido aprendizaje del usuario, términos adecuados para aquellos que usan esta aplicación.
* Consistencia - Operaciones similares se activan de la misma forma. Ergonomía presente mediante menús, barra de acciones e iconos de fácil acceso e identificación.
* Mínima sorpresa - El comportamiento de la aplicación no provoca sorpresa a los usuarios.

Todos los aspectos mencionados tienen el mismo objetivo, hacer de esta aplicación lo más dinámica, atractiva, cómoda y simple posible, que los usuarios que desean consultar y/o rellenar convocatorias del Gobierno de Canarias se sientan bienvenidos.


### Aspectos de usabilidad; Proceso de estudio de usuabilidad seguido.

Habíamos sido comunicado sobre la idea principal del proyecto sobre el cuál este proyecto está basado; Subvenciones y formulario de convocatorias.

El tema de subvenciones y convocatorias ha sido siempre algo muy oficial del Gobierno de Canarias, y como es típico de las cosas más oficiales, leer textos sobre políticas o mera información del trato de datos es algo que a muchos se les ha hecho imposible, comentando incluso que 'no parece que el texto esté en español'.

Los aspectos de usabilidad que queremos conseguir a partir de esto se ve muy claro (y es visible desde el prototipo de este proyecto); Hacer de convocatorias, subvenciones y formularios algo fácil de entender y manejar, con interfaz lo más simple y amigable posible.

- Consideramos que este proyecto debe tener una muy buen diseñada página de entrada que explique nuestra idea con claridad y proporcionar enlaces de ayuda y/o hacia otras secciones de la misma página web.. y a partir de ahí, dividirse según el deseo del individuo (hacer convocatorias, rellenar datos personales o gestionar datos oficiales de nuestra base de datos).


### Aspectos de usabilidad; Interfaz gráfica finalmente desarrollada

Un set de poco más de 12 páginas web fueron creados al final del desarrollo de esta aplicación. Estas páginas web, junto a aquellos aspectos de usabilidad que cumplen, son las siguientes;

#### Pagina principal

Cumple los aspectos de usabilidad..;
* El usuario es capaz de iniciar acciones
* El usuario es capaz de interactuar con la aplicación

![principal](https://user-images.githubusercontent.com/71889035/156693562-b84a0614-2294-4c20-bd30-136aafd60143.PNG)






# Planificacion y organizacion
------------------------------

Si has leído el final del apartado de introducción del proyecto, te habrás dado cuenta de que los dos miembros que forman el equipo de desarrollo de este proyecto hemos tenido medio mes para desarrollar desde cero este proyecto sin conocer el correcto funcionamiento de la pila tecnológica, cuando debería haber sido un mes completo.

Nuestra organización de cara al proyecto fue que ambos nos comunicamos entre sí para enviar correos al Instituto Tecnológico de Canarias para recibir los materiales necesarios para empezar, mientras completabamos casi todas las tareas caducadas del mes anterior con prisas, dado que muchas de estas estaban fuera de plazo.

En un momento dado, cuando vimos que los dos equipos que trabajan con ITC tenían el mismo problema y crearon su propio proyecto, decidimos que no podíamos perder más tiempo, y creamos este repositorio con todo el espacio de trabajo (por lo cuál utilizamos archivos PDF guía que nos suministró ITC) por la mera necesidad de ir a las prácticas de empresa.

A partir de aquí y casi de forma automática, decidimos aportar un sistema simple de organización debido al muy pequeño tamaño del equipo, el cuál trata de que cada uno hace una parte separada del otro y que esté en la rúbrica de evaluación del proyecto (aunque cada uno comunica al otro sus acciones y ambos actúan como líder del equipo. Probablemente elegimos esta organización para avanzar lo más rápido posible sin que nos afecte mentalmente en cuanto a estrés de trabajo urgente.

* A lo anterior hay que añadir que utilizamos para ayudarnos la herramienta Git proveniente de Github y la herramienta web Trello, que en resumen se trata de (entre otros) un tablón con lista de notas personalizables en la que marcamos las tareas que hacer, en proceso y completadas.

Si hay algo más que pueda añadir, es que a la hora de pedir ayuda, intentamos ayudar por encima al otro a ver fallos fácil de ver que por desgaste mental el otro no podía ver, pero la verdadera ayuda provino de una exorbitante cantidad de tiempo gastado en investigación de funcionamiento de Play! y derivados (como dependencias, módulos, etc..), aunque también contamos con la ayuda del profesorado del IES El Ricón y del alumnado dispuesto a ayudarnos.


# Conclusiones opiniones y reflexiones
--------------------------------------

Nota: Aquí hablamos de Play! 1.4.5, así que ciertos aspectos podrían haber cambiado sin que nosotros lo sepamos.

### Conclusión

Ventajas

* La administración de Play! es relativamente fácil cuando se trabaja por un largo periodo con él.
* La organización está extremadamente bien hecha.
* Consume recursos mínimos (Según los desarrolladores de Play!)
* Proporciona comandos de consola de fácil manejo a través del Símbolo del Sistema u otros tipos de terminales.
* Play! proporciona una documentación a sus desarrolladores.
* Existe una extensa variedad de módulos disponibles.
* Los errores de compilación resultan ser frecuentemente fáciles de identificar gracias a Play! cuando es iniciado como proyecto.
* Soporte a través de comandos de consola para trabajar con diferentes tipos de entorno de desarrollo con peculiaridades, tales como Eclipse o Netbeans.

Desventajas

* Peculiaridades de administración de Play!, puesto que este framework fuerza al profesional a que utilize nombres concretos, use ubicaciones exactas con nombres exactos en cada parte y métodos con nombre concreto para que el proyecto pueda arrancar.
* Los problemas generados trabajando con Play! son frecuentes y no existe apenas documentación para hacerles frente, además de que puede ser extremadamente complicado encontrar ayuda en la web sobre ellos por alguna razón.
* La importación de módulos raramente resulta fácil de realizar, y no parece haber un lugar simple con todos los módulos de Play! y en donde se muestre como agregarlos al proyecto.
* Está falto de documentación. Es cierto que su documentación es relativamente buena, pero falla demasiado a la hora de ayudar a aquellos que trabajan con Play!, especialmente sobre aspectos más populares como puede ser la generación y edición de informes, tests de código (TDD o Test-Driven Development), encriptación de datos, conectividad con websockets, etc..


### Opiniones

Trabajar con Play! nos ha causado demasiados problemas, la falta de documentación es tal que nos obligaba a detenernos por ratos demasiado prolongados y a pedir ayuda a la web, profesorado del IES El Rincón o alumnado, los cuales casi siempre ofrecieron la ayuda necesaria en comparación con Play!.

Puede ser que Play! tenga mejor documentación que otros frameworks, pero en comparación con estos, buscar ayuda en la web es frecuentemente mucho más fácil, ejemplo de esto es la pila tecnológica de Ionic (frontend) y Spring Hibernate (backend).

Además, utilizar Play! requiere mucha concentración y paciencia, no solo por la falta de documentación, sino también por la forma en la que Play! se administra para ser funcional.


### Reflexiones

Por el momento no recomendariamos hacer uso de Play!, a menos de que los desarrolladores de Play! puedan ofrecer documentación que de verdad proporcione ayuda al programador, por ejemplo en una página dejar claro todas y cada una de las peculiaridades de Play de forma que se pueda comprender, o una página con todos los errores alguna vez encontrados en Play! y más, en donde se muestre la forma de solucionarlos.

A esto se le suma hacer más fácil de comprender el proceso que conlleva el enrutamiento (esto es explicar de forma clara el funcionamiento del enrutamiento en el fichero 'routes', además de hacer algo innovador y fácil de comprender y utilizar, por ejemplo algo parecido a lo que ionic ofrece con etiquetas HTML que proporcionan estilos de forma profesional.


# Enlaces y referencias
-----------------------

Documentación de Play! framework, versión 1.4.5. - https://www.playframework.com/documentation/1.4.x/home

Desde el enlace anterior se puede acceder a las páginas que hemos consultado repetidamente, como por ejemplo el tutorial que seguimos de 'yabe' (sin utilizar su template a la hora de crear el proyecto). Realmente la ayuda en enlaces y referencias provienen de incontables páginas web en Internet, pero principalmente las investigaciones empezaban a partir de la documentación de referencia de Play! framework 1.4.5.
