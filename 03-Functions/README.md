# 03. Las Funciones en el código limpio

## El tamaño de las funciones importa

- La primera regla de las funciones es que deben ser de tamaño reducido.
- La segunda regla es que deben ser todavía más pequeñas.
- Las funciones deben tener una longitud aproximada de 20 líneas.

```java
LongFunctions.java
```

**Ejercicio.** Refactorizar LongFunctions.java

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

Clase `SwitchToRefactor`

**Ejercicio.** Refactorizar la clase SwitchToRefactor.

## La importancia del nombrado de las funciones

No tenga miedo a usar nombres largos o complejos. Es muy importante que el nombre de una función de una idea muy clara de lo que hace la función.

## Cómo plantear de forma limpia los argumentos en las funciones

El número ideal de argumentos para una función es cero. Después de uno (monádico) y dos (diádico). Siempre que sea posible, evite la presencia de tres argumentos (triádico). Más de tres argumentos (poliádico) requiere de una justificación especial.

## La programación funcional y las formas monádicas habituales

Hay dos motivos principales para pasar un sólo argumento.

1. Realizar una pregunta sobre el argumento `fileExists('myFile)`
2. Modificar el argumento, transformarlo en otra cosa y devolverlo. `fileOpen('file')`

Asegúrese de que la distinción entre ambos casos es clara.

En el caso de que la función sea un evento, asegúrese de hacer la distinción con el segundo caso devolviendo void.

## Los argumentos de indicador

Los argumentos de indicador son horribles. Indica que la función hace más de una cosa, algo si es true y otra cosa si es false.

## Planteando funciones diádicas

## Las tríadas

## Objetos y listas de argumentos

```java
Circle makeCircle(double x, double y, double radius);
Circle makeCircle(Point center, double radius);
```

```java
String.format("%s worked %.2f hours", name, hours);
public String format(String format, Object... args);
```

## La importancia de los verbos y las palabras clave

En formato monádico, la función y el argumento deben formar un par de verbo y sustantivo.

```java
write(name);
writeField(name); // Así indicamos que name es un field

assertEquals(expected, actual);
assertExpectedEquals(expected, actual); // Así indicamos el orden en el nombre
```

## Los argumentos de salida de una función y sus efectos secundarios

¿Qué está mal en este método?

```java
public class UserValidator {
    
    private Cryptographer cryptographer;
    
    public boolean checkPassword(String userName, String password) {
        User user = UserGateway.findByName(userName);
        if(user != User.NULL) {
            String codePhrase = user.getPhraseEncodedByPassword();
            String phrase = cryptographer.decrypt(codePhrase, password);
            if("Valid Password".equals(phrase)) {
                Session.initialize();
                return true;
            }
        }
        return false;
    }
}
```

## Separación de consultas

Las funciones deben hacer algo o responder a algo, pero no ambas cosas.

```java
// PROBLEMA
appendFooter(s); --> Un argumento de entrada que en realidad es de salida.
appendFooter(StringBuffer report); --> En la definición es mas claro, pero no es suficiente

// SOLUCIÓN
report.appendFooter(); --> Es más claro y conciso
```

```java
public boolean set(String attribute, String value);

if(set("username", "david")){...} // Es confuso. username === david o username = david

if(attributeExists("username")) {
    setAttribute("username", "david");    
}
```

## Una excepción, siempre mejor que un código de error

Los códigos de error incumplen la separación de comandos de consulta. Hace que los comandos usados asciendan a expresiones en los predicados de las instrucciones if. Genera estructuras anidadas.

```java
// MAL
if(deletePage(page) == E_OK) {
    if(registry.deleteReference(page.name) == E_OK) {
        logger.log("page deleted");    
    } else {
        logger.log("configKey not deleted");    
    }
}
else {
    logger.log("delete failed");
    return E_ERROR;
}
```

**Ejercicio.** Implementar el método anterior usando Excepciones.

## La importancia de los bloques try/catch

Las funciones deben hacer una cosa y el procesamiento de errores es una de ellas. Si una función incluye la palabra clave try, debe ser la primera de la función y  no debe hacer nada más después de los bloques try/catch/finally.

**Ejercicio.** Corregir el método anterior.

## NRY, No te repitas

## La programación estructurada

Dijkstra afirma que todas las funciones y todos los bloques de una función deben tener una entrada y una salida. Aunque esto no es tan importante en el caso de funciones de tamaño reducido.

## Creación de funciones limpias

**Ejercicio.** Completar la clase SetupTeardownIncluder