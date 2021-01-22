# 03. Las Funciones en el código limpio

## El tamaño de las funciones importa

- La primera regla de las funciones es que deben ser de tamaño reducido.
- La segunda regla es que deben ser todavía más pequeñas.
- Las funciones deben tener una longitud aproximada de 20 líneas.

```
// Mirar los siguientes archivos
LongFunctions.java, LongFunctionsFixed.java
```

## La estructura de bloques y la indentación de las funciones

**if, else, while** y similares deben tener una línea de longitud que seguramente será la invocación de otra función.

``if(isTestPage(pageData) //Añade valor documental al ser el nombre de función descriptivo``

El nivel de sangrado de una función no debe ser mayor de 1 o 2.

## Una función, una funcionalidad

Las funciones sólo deben hacer una cosa, deben hacerlo bien y debe ser lo único que hagan.
Si una función sólo realiza los pasos situados un nivel por debajo del nombre de la función, entonces hace una cosa.
Las funciones que hacen una sola cosa no se pueden dividir en secciones.

## La regla descendente y el nivel de abstracción único de las funciones

Asegúrese de que las instrucciones de la función se encuentran en el mismo nivel de abstracción.

El objetivo es que el código se lea como un texto de arriba a abajo.
1. *Para incluir configuraciones y detalles, incluimos configuraciones, después el contenido de la página de pruebas y por último los detalles*
2. *Para incluir las configuraciones, incluimos la configuración de suite si se trata de una suite, y después la configuración convencional*
3. *Para incluir la configuración de suite, buscamos la jerarquía principal de la página SuiteSetUp y añadimos una instrucción include con la ruta de dicha página*
4. *Para buscar la jerarquía principal...*

## Las instrucciones de tipo Switch

## La importancia del nombrado de las funciones

## Cómo plantear de forma limpia los argumentos en las funciones

## La programación funcional y las formas monádicas habituales

## Los argumentos de indicador

## Planteando funciones diádicas

## Las tríadas

## Objetos y listas de argumentos

## La importancia de los verbos y las palabras clave

## Los argumentos de salida de una función y sus efectos secundarios

## Separación de consultas

## Una excepción, siempre mejor que un código de error

## La importancia de los bloques try/catch

## NRY, No te repitas

## La programación estructurada

## Creación de funciones limpias