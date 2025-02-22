# Diferentes Maneras de Crear un Hilo en Java  

En Java, hay múltiples formas de crear y gestionar hilos. A continuación, se presentan tres métodos comunes:  

## 1. Uso de Expresión Lambda para Operaciones Pequeñas  

Usar una expresión lambda es una forma moderna y concisa de crear un hilo. Se emplea principalmente para tareas pequeñas en las que se define el comportamiento del hilo directamente en el momento de su creación.  

### Puntos clave:  
- Ideal para tareas cortas y simples.  
- Utiliza la interfaz `Runnable` en segundo plano.  
- Elimina la necesidad de una clase separada o una clase anónima para implementar `Runnable`.  

## 2. Extender la Clase Thread  

En este enfoque, se crea una nueva clase que extiende la clase `Thread` y se sobrescribe el método `run()` para definir el comportamiento del hilo. Posteriormente, se instancia la clase personalizada y se inicia el hilo con `start()`.  

### Puntos clave:  
- Mejor para operaciones más complejas o cuando se necesita funcionalidad adicional relacionada con hilos.  
- El método `run()` contiene el código que ejecutará el hilo.  
- La herencia directa de `Thread` es más restrictiva, ya que Java no admite herencia múltiple.  

## 3. Implementar la Interfaz Runnable  

Cuando se necesita definir el comportamiento de un hilo sin heredar de la clase `Thread`, se puede implementar la interfaz `Runnable`. Este método permite crear una clase separada para la tarea y luego pasar una instancia de esa clase al constructor de `Thread`.  

### Puntos clave:  
- Ofrece mayor flexibilidad en comparación con extender `Thread`.  
- Permite la implementación de múltiples interfaces, ya que Java no admite herencia múltiple.  
- Los hilos se inician utilizando el constructor `Thread`, pasando la instancia de `Runnable`.  

---

## Explicación de los Archivos  

### `ThreadExtends.java`
- Clase que extiende `Thread` y sobrescribe el método `run()`.  
- Ejecuta un bucle de 4 iteraciones en el que imprime el nombre del hilo y el número de iteración.  
- Incluye una pausa de 1 segundo (`Thread.sleep(1000)`) entre iteraciones.  

### `ThreadExtendsMain.java`
- Crea e inicia dos instancias de `ThreadExtends`.  
- Asigna nombres a los hilos antes de iniciarlos.  

### `ThreadLambdaMain.java`
- Crea un hilo usando `Thread` y define su comportamiento con una expresión lambda.  
- Imprime el nombre, la prioridad del hilo y el número de iteración en un bucle de 4 repeticiones.  
- También incluye pausas de 1 segundo entre iteraciones.  

### `ThreadRunnable.java`
- Implementa la interfaz `Runnable` y define el método `run()`.  
- Ejecuta un bucle de 4 iteraciones donde imprime el nombre del hilo y el número de iteración.  
- También incluye pausas de 1 segundo.  

### `ThreadRunnableMain.java`
- Crea dos hilos pasando una instancia de `ThreadRunnable` al constructor de `Thread`.  
- Asigna nombres a los hilos y los inicia con `start()`.  
