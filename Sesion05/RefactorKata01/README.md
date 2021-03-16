# RefactorKata

====================================
Especificación de requisitos de rosas doradas
====================================

Hola y bienvenido al equipo de Gilded Rose. Como sabes, somos una pequeña posada con una ubicación privilegiada en un
ciudad prominente dirigida por un posadero amistoso llamado Allison. También compramos y vendemos solo los mejores productos.
Desafortunadamente, la calidad de nuestros productos se degrada constantemente a medida que se acerca la fecha de caducidad. Nosotros
tenemos un sistema que actualiza nuestro inventario por nosotros. Fue desarrollado por un tipo serio llamado
Leeroy, que ha pasado a nuevas aventuras. Su tarea es agregar la nueva función a nuestro sistema para que
podemos comenzar a vender una nueva categoría de artículos. Primero una introducción a nuestro sistema:

- Todos los artículos tienen un valor SellIn que indica el número de días que tenemos para vender el artículo
- Todos los artículos tienen un valor de Calidad que indica el valor del artículo.
- Al final de cada día, nuestro sistema reduce ambos valores para cada artículo.

Bastante simple, ¿verdad? Bueno, aquí es donde se pone interesante:

- Una vez que ha pasado la fecha de caducidad, la calidad se degrada dos veces más rápido
- La calidad de un artículo nunca es negativa.
- "Aged Brie" en realidad aumenta en calidad a medida que envejece
- La calidad de un artículo nunca supera los 50
- "Sulfuras", al ser un artículo legendario, nunca tiene que venderse ni disminuye su calidad
- Los "pases entre bastidores", como el queso brie añejo, aumentan en calidad a medida que se acerca su valor SellIn;
La calidad aumenta en 2 cuando hay 10 días o menos y en 3 cuando hay 5 días o menos pero
La calidad cae a 0 después del concierto

Recientemente hemos contratado a un proveedor de artículos conjurados. Esto requiere una actualización de nuestro sistema:

- Los elementos "conjurados" se degradan en calidad dos veces más rápido que los elementos normales

No dude en realizar cambios en el método UpdateQuality y agregar cualquier código nuevo siempre que todo
todavía funciona correctamente. Sin embargo, no modifique la clase de artículo o la propiedad de artículos, ya que pertenecen a la
duende en la esquina que se enfurecerá instantáneamente y te disparará ya que no cree en el código compartido
propiedad (puede hacer que el método UpdateQuality y la propiedad Items sean estáticos si lo desea, cubriremos
para ti).

Solo para aclarar, un artículo nunca puede tener un aumento de calidad por encima de 50, sin embargo, "Sulfuras" es un
artículo legendario y, como tal, su Calidad es 80 y nunca cambia.
