# 01. INTRODUCCIÓN AL CÓDIGO LIMPIO

## Introducción al concepto de código limpio y su importancia

## ¿Qué se entiende como código incorrecto?

Preguntas

1. ¿Crees que el código limpio está sobrevalorado?
2. ¿Alguna vez te ha supuesto un problema encontrarte con código incorrecto?
3. Motivos por los cuáles has producido código incorrecto (plazos de entrega, pereza, multifoco...)

> Ley de LeBlanc: después es igual a nunca.

## Las consecuencias de un código incorrecto en términos económicos

Se acaban creando dos proyectos y ambos son un desastre.

## La importancia de la actitud frente al cambio

Culpables del código incorrecto: 

¿Requisitos cambiantes?¿Plazos de entrega demasiado exigentes?¿Directores incompetentes?¿Comerciales sin sentido?

La culpa del código incorrecto es **nuestra**. 

¿Operaría un cirujano con las manos sucias sólo porque el paciente se lo pida?

Los directores y comerciales nos exigen la información que necesitan para realizar sus promesas y compromisos, e incluso cuando no recurren a nosotros, no debemos tener miedo a decirles lo que pensamos. Los usuarios acuden a nosotros para validar la forma de encajar los requisitos en el sistema. Somos cómplices en la programación del proyecto y compartimos gran parte de la responsabilidad de los fallos, en especial si tienen que ver con código incorrecto.

## Los conceptos de código limpio

**Bjarne Stroustrup, inventor de C++ y autor de The C++ Programming Language**

> Me gusta que mi código sea elegante y eficaz. La lógica debe ser directa para evitar errores ocultos, las dependencias deben ser mínimas para facilitar el manenimiento, el procesamiento de errores completo y sujeto a una estrategia ariculada, y el rendimiento debe ser óptio para que los usuarios no tiendan a estropear el código con optimizaciones sin sentido. El código limpio hace bien una cosa.

**Grady Booch, autor de Object Oriented Analysis and Design with Applications**

> El código limpio es simple y directo. El código limpio se lee como un texto bien escrito. El código limpio no oculta la intención del diseñador sino que muestra nítidas abstracciones y líneas directas de control.

**Big Dave Thomas, fundador de OTI, el padrino de la estrategia Eclipse**

> El código limpio se puede leer y mejorar por parte de un programador que no sea su autor original. Tiene pruebas de unidad y de aceptación. Tiene nombres con sentido. Ofrece una y no varias formas de hacer algo. Sus dependencias son mínimas, se definen de forma explícita y ofrece una API clara y mínima. El código debe ser culto en función del lenguaje, ya que o toda la información necesaria se puede expresar de forma clara en el código.

**Michael Feathers, autor de Working Effectively with Legacy Code**

> Podría enumerar todas las cualidades del código limpio pero hay una principal que engloba a todas ellas. El código limpio siempre parece que ha sido escrito por alguien a quien le importa. No hay nada evidente que hacer para mejorarlo. El autor del código pensó en todos los aspectos posibles y si intentamos imaginar alguna mejora, volvemos al punto de partida y solo nos queda disfrutar del código que alguien a quien le importa realmente nos ha proporcionado.

**Ron Jeffries, autor de Extreme Programming Installed y Extreme Programming Adventures in C#**

> En los últimos años, comencé y pácticamente terminé con las reglas de código simple de Beck. En orden de prioridad, el código simple:
> - Ejecuta todas las pruebas
> - No contiene duplicados.
> - Expresa todos los conceptos de diseño del sistema.
> - Minimiza el número de entidades como clases, métodos, funciones y similares.

**Ward Cunningham, inventor de Wiki, Fit y uno de los inventores de la programación eXtreme**

> Sabemos que estamos trabajando con código limpio cuando cada rutina que leemos resulta ser lo que esperábamos. Se puede denominar código atracivo cuando el código hace que parezca que el lenguaje se ha creado para el problema en cuestión.

## Las diferencias teóricas del concepto

Las reglas relativas al código limpio o correcto son en cierto modo como una escuela de artes marciales. No hay un arte marcial "verdadero" o que se considere como el "bueno", sin embargo cada alumno, practica las reglas específicas del arte marcial en cuestión hasta perfeccionarlas. Es entonces, cuando las ha dominado, que puede buscar un maestro de otra disciplina para seguir aprendiendo. 

Lo que se aprende en este curso es parecido. Son reglas y consejos que te permitirán crear código correcto. Dominarlas implicará que serás capaz de crear código limpio y mantenible. Eso no significa que sean la única forma de hacerlo.

## La Regla de Boy Scout y los principios del código limpio

> Dejar el campamento más limpio de lo que se ha encontrado