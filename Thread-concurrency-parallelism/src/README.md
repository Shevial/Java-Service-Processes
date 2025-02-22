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
