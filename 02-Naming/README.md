# 02. La importancia de los nombres

## El nombre debe revelar las intenciones

### Ejemplos de variables mal escritas

```java
int d; // tiempo transcurrido en días
```
Este comentario es innecesario.

### Ejemplos de variables bien escritas

```java 
int elapsedTimeinDays
int daysSinceCreation
int daysSinceModification
int fileAgeInDays
```

## La función `getThem(List<int[]> theList)`

## El problema de la desinformación voluntaria a través del nombrado

### Variables que provocan desinformación

```java
int hp, aix, sco; // Nombres de plataformas o variantes de Unix.
HashSet accountList; // Es un set y se le llama list. Usar accountGroup, accounts...
```
```java
// Nombres de variables con variaciones mínimas        
int XYZControllerForEfficientHandlingOfStrings;
int XYZControllerForEfficientStorageOfStrings;
```

## Distinciones con sentido

```java
public static void copyChars(char a1[], char a2[]) {
    for(int i = 0; i < a1.lenght; i++) {
        a2[i] = a1[i];
    }
}
```
```java
public static void copyChars(char source[], char destination[]) {
    for(int i = 0; i < source.lenght; i++) {
        destination[i] = source[i];    
    }    
}
```

## Distinciones pobres

`Product, ProductInfo, ProductData`

`getActiveAccount(),  getActiveAccounts(), getActiveAccountInfo()`

No incluir el **tipo** de variable en el **nombre** de una variable.

## Usar nombres que se puedan pronunciar

```java
import java.util.Date;

class DtaRcrd102 {
    private Date geymdhms;
    private Date modymdhms;
    private final String pszgint = "102";
}
```
```java
class Customer {
    private Date generationTimestamp;
    private Date modificationTimestamp;
    private final String recordId = "102";
}
```

## La longitud de un nombre debe corresponderse al tamaño de su ámbito

```java
class NamesLenght {
    /**
     * FATAL
     */
    int s;
    int[] t;
    
    public void example() {
        for(int j = 0; j < 34; j++) {
            s += (t[j]*4/5);
        }
    }

    /**
     * BIEN
     */
    int realDaysPerIdealDay = 4;
    final int WORK_DAYS_PER_WEEK = 5;
    final int NUMBER_OF_TASKS = 34;
    int[] taskEstimate;
    int sum = 0;
    
    public void exampleOK() {
        for(int j = 0; j < NUMBER_OF_TASKS; j++) {
            int realTaskDays = taskEstimate[j] + realDaysPerIdealDay;
            int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
            sum += realTaskWeeks;
        }    
    }
}
```

## Nombres de clases

**OK**

`Customer, WikiPage, Account, AddressParser`

**EVITAR**

`Manager, Processor, Data, Info`

El nombre de una clase no debe ser un **verbo**

## Nombres de métodos

Los métodos deben tener nombres de **verbo** como `postPayment, deletePage, save`

Al sobrecargar constructores, usar **métodos de factoría estáticos** con nombres que describan los argumentos.

`Complex fulcrumPoint = new Complex.FromRealNumber(23.0);`

## Una palabra por concepto

Es confuso usar `fetch, retrieve y get`

Es confuso tener un controlador, un administrador y un manager en el mismo proyecto.

## No usar juegos de palabras

Imagina que en un proyecto tienes un método en distintas clases que se llama add() y lo que hace es crear un nuevo valor,
sumando o concatenando dos valores existentes.

Si alguien necesita crear un método en otra clase para añadir un elemento a una colección, podría decidir llamarle add
por coherencia, ya que hay muhcas clases con un método add en el código, pero no sería correcto porque son diferentes semánticamente.

En este caso deberíamos crear un método llamado insert o append.

## Usar nombres de dominios de soluciones

Términos informáticos, algoritmos, nombres de patrones.

`AccountVisitor //Patrón Visitor`

## Usar nombres de dominios de problemas

Separar los conceptos de dominio de soluciones y de problemas es parte del trabajo de un buen programador y diseñador.
El código que tenga más relación con los conceptos del dominio de problemas tendrá nombres extraídos de dicho dominio.

## Añadir contexto con sentido

`accountAddress` y `customerAddress` son nombres perfectos como instancias de clase Address pero no sirven como nombres 
de clase Address. Address podría refererise tb a MAC o URI. En este caso deberíamos usar PostalAddress como nombre de clase.

## No añadir contextos innecesarios

Gas Station Deluxe. ¿Añadimos GSD como prefijo a todas las clases? No tiene ningún sentido. No añade info util.

Mirar clase `RefactorHolic`
