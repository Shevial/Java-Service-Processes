# Programación Concurrente: SumConcurrency y ParallelismExample  

Este repositorio contiene dos implementaciones en Java que demuestran diferentes enfoques de programación concurrente para sumar los elementos de un array grande. Cada implementación resalta conceptos clave sobre la concurrencia basada en hilos y el paralelismo utilizando el framework Fork/Join.  

## Archivos en Este Repositorio  

### `SumConcurrency.java`  
- Utiliza hilos tradicionales de Java para dividir el trabajo en partes fijas y calcular la suma del array.  

### `ParallelismExample.java`  
- Usa el framework Fork/Join para dividir recursivamente el trabajo en subtareas más pequeñas y ejecutarlas en paralelo.  

---

## `SumConcurrency.java`  

### Descripción  
Este programa demuestra la concurrencia utilizando hilos de Java para sumar los elementos de un array grande. El array se divide en partes iguales (según el número de hilos), y cada hilo calcula la suma de su porción. Finalmente, los resultados de todos los hilos se combinan para calcular la suma total.  

### Características Clave  

#### **Concurrencia basada en hilos**  
- El array se divide en segmentos.  
- Cada segmento es procesado por un hilo independiente.  

#### **Sincronización**  
- `Thread.join()` garantiza que el hilo principal espere a que todos los hilos finalicen antes de combinar los resultados.  

#### **Número fijo de hilos**  
- La cantidad de hilos es predefinida y no se ajusta dinámicamente según la carga de trabajo.  

### **Cómo Funciona**  
1. Se inicializa un array con valores desde 0 hasta (N-1).  
2. Se crean un número fijo de hilos (ejemplo: 2).  
3. Cada hilo calcula la suma de su sección asignada del array.  
4. El hilo principal espera a que todos los hilos finalicen (`join()`).  
5. Los resultados de todos los hilos se combinan en la suma total.  

### **Ejemplo de Salida**  
```
La suma total es: 4999999950000000  
Tiempo de ejecución: 130ms  
```

### **Ventajas y Desventajas**  

✅ **Ventajas:**  
- Implementación sencilla.  
- Eficiente para tareas paralelas de pequeña escala.  

❌ **Limitaciones:**  
- El número fijo de hilos puede no aprovechar completamente los CPU multi-núcleo.  
- La gestión manual de los hilos puede volverse compleja con cargas de trabajo más grandes.  

---

## `ParallelismExample.java`  

### Descripción  
Este programa utiliza el framework Fork/Join, una abstracción de alto nivel para la computación paralela en Java. El array se divide recursivamente en segmentos más pequeños, y las tareas se ejecutan en paralelo hasta que los segmentos sean lo suficientemente pequeños para ser procesados directamente.  

### Características Clave  

#### **Framework Fork/Join**  
- Las tareas se dividen recursivamente en subtareas más pequeñas.  
- Las subtareas se ejecutan de manera asíncrona con `fork()` y se combinan con `join()`.  

#### **Descomposición recursiva**  
- La carga de trabajo se divide dinámicamente según el tamaño de la tarea.  

#### **Ejecución basada en umbrales**  
- Si el tamaño de la tarea cae por debajo de un cierto umbral, se calcula secuencialmente.  

### **Cómo Funciona**  
1. Se inicializa un array con valores desde 0 hasta (N-1).  
2. La tarea divide el array en dos mitades recursivamente:  
   - La mitad izquierda se ejecuta asíncronamente con `fork()`.  
   - La mitad derecha se ejecuta secuencialmente con `compute()`.  
3. Los resultados de las tareas izquierda y derecha se combinan.  
4. El proceso continúa hasta que el tamaño del subarray es menor que el umbral, momento en el que se suma directamente.  

### **Ejemplo de Salida**  
```
Resultado: 4999999950000000  
Tiempo de ejecución: 80ms  
```

### **Ventajas y Desventajas**  

✅ **Ventajas:**  
- Ajusta dinámicamente la carga de trabajo en todos los núcleos disponibles del CPU.  
- Más eficiente para tareas paralelas de gran escala.  

❌ **Limitaciones:**  
- Requiere conocimientos del framework Fork/Join.  
- La creación y gestión de tareas puede generar sobrecarga en tareas pequeñas.  

---

## Comparación de Ambos Enfoques  

| Característica          | `SumConcurrency`       | `ParallelismExample`  |
|------------------------|----------------------|----------------------|
| **Modelo de ejecución**  | Hilos fijos          | Tareas dinámicas Fork/Join |
| **División del trabajo** | Estática            | Recursiva           |
| **Ejecución en paralelo** | Limitada por cantidad de hilos fijos | Se ajusta dinámicamente a los núcleos |
| **Sincronización**       | `Thread.join()`      | `fork()` y `join()` |
| **Caso de uso**          | Arrays pequeños o tareas simples | Arrays grandes o tareas complejas |
| **Eficiencia**          | Menos eficiente en arrays grandes | Altamente eficiente en arrays grandes |

---

## ¿Cuándo Usar Cada Enfoque?  

✅ **Usar `SumConcurrency` cuando:**  
- La carga de trabajo es pequeña y predecible.  
- La simplicidad y claridad del código son prioritarias.  
- Se tiene un número fijo de recursos (hilos).  

✅ **Usar `ParallelismExample` cuando:**  
- Se trabaja con grandes volúmenes de datos o tareas computacionalmente intensivas.  
- Se busca aprovechar al máximo los procesadores multi-núcleo.  
- Se requiere un balance dinámico de carga de trabajo.  

---

## Conclusión  
Ambos programas muestran técnicas potentes para la computación paralela en Java. Mientras que `SumConcurrency` es más simple y adecuado para tareas pequeñas, `ParallelismExample` aprovecha características avanzadas de paralelismo para manejar cargas de trabajo más grandes de manera eficiente. Comprender estos enfoques te ayudará a elegir la mejor herramienta para tus necesidades de concurrencia y paralelismo.


