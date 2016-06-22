# Estándares de programación en Android
Estructura de código
--------------------
La estructura de directorios sigue la siguiente forma:

> |--library-foobar<br>
> |--app<br>
> |...|--libs<br>
> |...|--src<br>
> |...|...|--androidTest<br>
> |...|...|....L java<br>
> |...|...|........L com/futurice/project<br>
> |...|...L main<br>
> |...|.......|--java<br>
> |...|.......|...L com/futurice/project<br>
> |...|.......|--res<br>
> |...|.......L AndroidManifest.xml<br>
> |...|--build.gradle<br>
> |...L proguard-rules.pro<br>
> |--build.gradle<br>
> L settings.gradle<br>

Dentro del directorio java se encuentra el código del proyecto, el cual debe seguir la siguiente arquitectura.

> |--app<br>
> |...|--java<br>
> |.......|--mx.com.saludcercana.nombrepaquete<br>
> |..........|--main<br>
> |..............|--AppController.java<br>
> |..........|--ui<br>
> |.............|--nombreModulo<br>
> |.................| NombreFragment.java<br>
> |.................| NombreActivity.java<br>
> |.............|--...<br>
> |...|.......|--adapter<br>
> |.............|--NombreAdapter.java<br>
> |.............|--...<br>
> |...|.......|--networking<br>
> |.............|--ApiClient.java<br>
> |.............|--ApiService.java<br>
> |...|.......|--realm<br>
> |.............|--RealmManagerjava<br>
> |.............|--schemas<br>
> |.................|--Schema.java<br>
> |.................|--...<br>
> |...|.......|--model<br>
> |.............|--Model.java<br>
> |.............|--...<br>


|  Directorio  |  Descripción  |
|---|---|
|main|Contiene el AppController, clase que se ejecuta simpre al incializar la app.|
|ui|Contiene una carpeta por cada módulo, dentro de ella tiene los fragmentos y actividades siguiendo el estándar xxxxFragment.java y xxxx.Activity.java|
|adapter|Contiene los adaptadores del proyecto, siguiendo el nombre xxxxxAdapter.java|
|networking|Contiene un par de clases dónde se realizan las llamadas a todos los servicios. Las llamadas a servicios se realizarán utilizando Retrofit.|
|realm|Contiene los archivos para administrar la parte de realm, contiene un subdirectorio llamado schemas, donde se encuentran los schemas de la base de datos, el nombre debe ser en singular|
|model| Contiene los modelos de la aplicación en singular.|
Dónde xxx es un nombre en inglés que describe el contenido del código. 

## Estándares de codificación ##
## Librerias

- GSON para parsear JSON a objetos y viceversa 
- Retrofit para networking, considerar el uso de Picasso para cargar y cachear - imágenes y OkHttp para llamadas HTTP más eficientes.
- RxJava para administrar eventos asíncronos.
- Retrolamba es una librería de Java para utilizar la sintaxis Lamba en Android, ayuda a mantener un código compacto y legible en especial cuando se utiliza programación reactiva con RxJava.

## Convención de nombres ##

- Capitalizar las constantes: CONSTANT
- Para los acrónimos seguir de manera estricta la notación de camello, es decir UnitId en lugar de UnitID
- Anteponer el tipo de objeto, por ejemplo para un TextView poner tvName

## Recursos ##

- Nombramiento: Usar la convención de poner como prefijo el tipo de recursos. Por ejemplo fragment_contact_detail.xml, view_primary_button.xml, activity_main.xml
- Layout de los XML’s:
 - Un atributo por linea
 - android:id como el primer atributo siempre.
 - android:layout_*** en segundo lugar
 - style al último
 - /> tag para cerrar en su propia línea
 - No harcodear texto de prueba, utilizar Designtime attributes.
 - Utiliza styles para evitar duplicidad de estilos en el código xml
 - Si es necesario, utiliza varios archivos style para tener mayor organización del código, por ejemplo: styles.xml, styles_home.xml, style_items.xml, etc.
- Utiliza colors.xml para definir los colores a utilizar en la app.

Mala idea:

    <resources>
     <color name="button_foreground">#FFFFFF</color>
      <color name="button_background">#FF2345</color>
      ...
      <color name="comment_foreground">#2345FF</color>
    </resources>

Buena idea:

    <resources>
      <!--grayscale-->
      <color name="white">#FFFFFF</color>
      <color name="gray_light">#DBDBDB</color>
      ...
      <color name="black">#000000</color>
    </resources>

Utilizar dimen.xml para todas las dimensiones del proyecto, utilizar spacing_*** para estandarizar espacios entre vistas.    
    
    <resources>
	    <!--font sizes-->
	    <dimen name="font_larger">22sp</dimen>
	    <dimen name="font_normal">12sp</dimen>
	    ...
	    <dimen name="font_small">2sp</dimen>
	    
	    <!--space between views-->
	    <dimen name="huge_space">22dp</dimen>
	    <dimen name="large_space">12dp</dimen>
	    ...
	    <dimen name="small_space">2dp</dimen>
	</resources>

Strings.xml, utilizar strings.xml para todas las cadenas de la aplicación. Utilizar namespaces para dar un contexto más claro a la cadena. No importa repetir algunos textos

Mala idea:

    <string name="network_error">Network Error</string>
    <string name="call_failed">Call Failed</string>

Buena idea:

    <string name="error.message.network">Network Error</string>
    <string name="error.message.call">Call Failed</string>

## Pruebas unitarias ##

 - Utilizar Robolectric para hacer unit test, no para probar las vistas.
 - Utilizar Robotium para escribir las pruebas de Interface.

## Ofuscamiento de código ##

- Utilizar Proguard para ofuscar y minimizar el código al genera un apk reléase. - - Esto no aplica para apk’s de develop.

## Data storage ##

- Utilizar SharedPreferences solo para banderas y información muy específica
- En caso de requerir almacenar información algo más compleja, pero que no requiera una base de datos, utilizar ContentProviders
- En caso de requerir una base de datos, utilizar Realm como manejador ORM.

## Usa Stetho ##

- Stetho es una herramienta de mucha ayuda en el desarrollo de apps android ya que permite inspeccionar algunos elementos de la aplicación como la base de datos, sharedPreferences y networking.

