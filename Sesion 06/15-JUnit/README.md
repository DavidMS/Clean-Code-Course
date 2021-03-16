# JUnit

JUnit es un marco de prueba de Java y un proyecto de código abierto alojado en Github. 
JUnit 5 (también conocido como Jupiter) es la última versión importante de JUnit. Consta de varios componentes discretos:

- Plataforma JUnit: capa base que permite lanzar diferentes marcos de prueba en la JVM
- Junit Jupiter: es el marco de prueba JUnit 5 lanzado por la plataforma JUnit
- JUnit Vintage - TestEngine heredado que ejecuta pruebas más antiguas

Como el uso de JUnit 5 requiere la presencia de varias bibliotecas, normalmente lo usa con un sistema de compilación 
como Maven o Gradle. JUnit 5 necesita al menos Java 8 para ejecutarse.

## Tipos de Test

### Test Unitarios

Una prueba unitaria es un fragmento de código escrito por un desarrollador que ejecuta una funcionalidad específica en 
el código que se va a probar y afirma un determinado comportamiento o estado. El porcentaje de código que se prueba 
mediante pruebas unitarias generalmente se denomina cobertura de prueba. Una prueba unitaria tiene como objetivo una 
pequeña unidad de código, por ejemplo, un método o una clase. Las dependencias externas deben eliminarse de las pruebas 
unitarias, por ejemplo, reemplazando la dependencia con una implementación de prueba o un objeto (simulado) creado por 
un marco de prueba. Las pruebas unitarias no son adecuadas para probar interfaces de usuario complejas o interacción de 
componentes. Para ello, conviene desarrollar pruebas de integración.

### Test de Integración

Una prueba de integración tiene como objetivo probar el comportamiento de un componente o la integración entre un 
conjunto de componentes. El término prueba funcional a veces se utiliza como sinónimo de prueba de integración. 
Las pruebas de integración verifican que todo el sistema funciona según lo previsto, por lo que están reduciendo 
la necesidad de pruebas manuales intensivas. Este tipo de pruebas le permiten traducir sus historias de usuario en un 
conjunto de pruebas. La prueba se parecería a la interacción esperada del usuario con la aplicación.

### Test de Rendimiento

Las pruebas de rendimiento se utilizan para comparar componentes de software repetidamente. 
Su propósito es garantizar que el código bajo prueba se ejecute lo suficientemente rápido incluso si está bajo una carga alta.

### Test funcionales

Los test funcionales tratan de probar la aplicación de forma que simule el comportamiento de un usuario. Estas pruebas 
se pueden llevar a cabo de manera automatizado o bien por usuarios reales.

## Anotaciones importantes de JUnit

Anotación | Descripción | 
--- | --- | 
@Test | Identifica un método como método de prueba. |
@Disabled("reason") | Desactiva un método de prueba con un motivo opcional. |
@BeforeEach | Ejecutado antes de cada prueba. Se utiliza para preparar el entorno de prueba, por ejemplo, inicializar los campos en la clase de prueba, configurar el entorno, etc. |
@AfterEach | Ejecutado después de cada prueba. Se utiliza para limpiar el entorno de prueba, por ejemplo, eliminar datos temporales, restaurar valores predeterminados, limpiar estructuras de memoria costosas. |
@DisplayName("<Name>") | <Nombre> que mostrará el corredor de pruebas. A diferencia de los nombres de métodos, el nombre puede contener espacios para mejorar la legibilidad. |
@RepeatedTest(<Number>) | Similar a @Test pero repite la prueba un <Number> de veces |
@BeforeAll | Anota un método que se ejecuta una vez, antes del inicio de todas las pruebas. Se utiliza para realizar actividades que requieren mucho tiempo, por ejemplo, para conectarse a una base de datos. Los métodos marcados con esta anotación deben definirse como estáticos para trabajar con JUnit. |
@AfterAll | Anota un método que se ejecuta una vez, una vez finalizadas todas las pruebas. Se utiliza para realizar actividades de limpieza, por ejemplo, para desconectarse de una base de datos. Los métodos anotados con esta anotación deben definirse como estáticos para trabajar con JUnit. |
@TestFactory | Anota un método que es una fábrica para crear pruebas dinámicas |
@Nested | Le permite anidar clases de prueba internas para forzar un cierto orden de ejecución |
@Tag("<TagName>") | Etiquetas un método de prueba, las pruebas en JUnit 5 se pueden filtrar por etiqueta. Por ejemplo, ejecute solo pruebas etiquetadas con "rápido". |
@ExtendWith | Le permite registrar una clase de extensión que agrega funcionalidad a las pruebas |