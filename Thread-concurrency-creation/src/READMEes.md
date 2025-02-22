# 3 Formas Diferentes de Crear un Hilo en Java

En Java, existen múltiples formas de crear y gestionar hilos. A continuación, se presentan tres métodos comunes:

## 1. Lambda para Operaciones Pequeñas con Hilos

Usar una expresión lambda es una forma concisa y moderna de crear un hilo. Se utiliza típicamente para tareas pequeñas donde se implementa el comportamiento del hilo directamente en su creación. Con las lambdas, el código se vuelve más limpio y se evita el código repetitivo innecesario.

**Puntos Clave:**
- Ideal para tareas cortas y simples.
- Utiliza la interfaz `Runnable` internamente.
- Elimina la necesidad de una clase separada o una clase anónima para implementar `Runnable`.

## 2. Extendiendo la Clase Thread

En este enfoque, se crea una nueva clase que extiende la clase `Thread` y se sobreescribe el método `run()` para definir el comportamiento del hilo. Posteriormente, se instancia la clase de hilo personalizada y se inicia el hilo utilizando `start()`.

**Puntos Clave:**
- Mejor para operaciones más complejas o cuando se necesita funcionalidad adicional relacionada con hilos.
- El método `run()` contiene el código que será ejecutado por el hilo.
- La herencia directa de la clase `Thread` resulta algo restrictiva, ya que Java no admite la herencia múltiple.

## 3. Usando la Interfaz Runnable

Cuando se necesita definir el comportamiento de un hilo sin heredar de la clase `Thread`, se puede implementar la interfaz `Runnable`. Este enfoque permite crear una clase separada para la tarea, y luego pasar una instancia de esa clase al constructor de `Thread`.

**Puntos Clave:**
- Ofrece mayor flexibilidad en comparación con extender la clase `Thread`.
- Permite implementar múltiples interfaces, dado que Java no soporta la herencia múltiple.
- Los hilos se inician utilizando el constructor de `Thread` pasando la instancia de `Runnable`.
