# Modelo Productor-Consumidor

Este proyecto es una implementación del modelo clásico de **Productor-Consumidor** en programación concurrente utilizando hilos en Java. Este modelo resuelve el problema de la sincronización entre dos hilos que operan sobre un objeto compartido, uno produciendo datos y el otro consumiéndolos.

## 1. Objetivo

El objetivo de este modelo es coordinar la interacción entre un **productor** y un **consumidor** a través de un objeto compartido. El productor genera datos y los pone a disposición del consumidor, mientras que el consumidor consume esos datos. La coordinación se realiza para evitar que el consumidor intente consumir datos antes de que estén disponibles o que el productor intente generar datos cuando ya hay datos pendientes de ser consumidos.

## 2. Componentes Principales

### 2.1. Objeto Compartido

El objeto compartido es el recurso común que utilizan tanto el productor como el consumidor. Contiene dos atributos:

- **Valor:** El dato que es producido y consumido.
- **Disponible:** Un indicador booleano que muestra si el valor está disponible para ser consumido.

El objeto compartido proporciona dos métodos principales:

- **get():** Permite que el consumidor obtenga el valor. Si no hay datos disponibles, el consumidor espera.
- **set(int valor):** Permite que el productor establezca un valor. Si los datos están siendo consumidos, el productor espera.

### 2.2. Productor

El **Productor** es un hilo que genera datos (en este caso, números) y los coloca en el objeto compartido. El productor solo puede colocar un valor cuando el consumidor ha consumido el valor anterior. Si el productor intenta producir mientras el consumidor no ha consumido el valor anterior, el productor espera.

### 2.3. Consumidor

El **Consumidor** es un hilo que consume los datos producidos por el productor. El consumidor solo puede consumir un valor cuando el productor ha puesto un valor disponible. Si no hay datos disponibles, el consumidor espera.

## 3. Sincronización y Espera

El modelo utiliza los métodos **wait()** y **notifyAll()** para gestionar la sincronización entre los hilos. 

- **wait():** El hilo que invoca este método se pone en espera hasta que otro hilo lo despierte mediante **notifyAll()**.
- **notifyAll():** Notifica a todos los hilos en espera que deben continuar con su ejecución.

La implementación asegura que el productor no produzca más datos hasta que el consumidor haya consumido el valor anterior, y viceversa, para evitar problemas de concurrencia.

## 4. Descripción del Flujo

El flujo de ejecución del modelo es el siguiente:

1. El productor genera un valor.
2. El productor pone el valor en el objeto compartido.
3. El consumidor lee el valor del objeto compartido y lo consume.
4. El productor espera a que el consumidor consuma antes de producir el siguiente valor.
5. El consumidor espera a que el productor ponga un valor disponible antes de consumir.

Este ciclo se repite hasta que ambos hilos hayan completado sus tareas.

## 5. Solución al Problema

Este modelo garantiza que:

- El productor no intente producir más valores mientras el consumidor no haya consumido los anteriores.
- El consumidor no intente consumir si no hay datos disponibles.
- Ambos hilos trabajan de manera sincronizada utilizando las técnicas de **bloqueo** y **notificación**.

## 6. Conclusión

El modelo **Productor-Consumidor** es un ejemplo clásico de cómo gestionar la sincronización entre hilos en Java para evitar condiciones de carrera. Este enfoque es esencial en sistemas concurrentes donde múltiples hilos deben compartir recursos de manera segura.
