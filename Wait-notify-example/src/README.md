# Sistema de Tesorería con Hilos

Este programa demuestra la sincronización de hilos en Java utilizando los métodos `wait()` y `notify()`. Simula un sistema básico de tesorería donde los hilos pueden depositar y retirar dinero de una cuenta compartida. El sistema asegura que no se realice un retiro a menos que haya suficiente saldo.

## Conceptos Clave Utilizados

### 1. **Método `wait()`**
- El método `wait()` se utiliza para pausar la ejecución de un hilo hasta que otro hilo lo notifique.
- Cuando se llama, el hilo libera el bloqueo sobre el objeto y entra en un estado de espera.
- En este programa, `wait()` se utiliza en el método `retire()` para pausar el hilo de retiro cuando el saldo es insuficiente.

### 2. **Método `notify()`**
- El método `notify()` despierta uno de los hilos que está esperando en el mismo monitor del objeto.
- Se utiliza en el método `deposit()` para señalizar al hilo de retiro (`retire()`) que se ha realizado un depósito y que el saldo ahora podría ser suficiente.

## Flujo del Programa

1. **Inicialización**
    - Se crea un objeto `Treasury` que representa la cuenta compartida.
    - Se instancian dos hilos:
        - **Hilo de Depósito**: Añade dinero a la tesorería en un bucle.
        - **Hilo de Retiro**: Intenta retirar una cantidad fija de dinero de la tesorería.

2. **Ejecución del Hilo de Depósito**
    - El método `deposit()` añade una cantidad fija (100) al saldo.
    - Después de cada depósito, llama a `notify()` para despertar al hilo de retiro si está esperando.
    - El hilo duerme durante 1 segundo entre depósitos.

3. **Ejecución del Hilo de Retiro**
    - El método `retire()` verifica si el saldo es suficiente para el retiro (350).
    - Si el saldo es insuficiente, el hilo entra en un estado de espera usando `wait()`.
    - Una vez notificado, vuelve a verificar el saldo y procede si hay suficientes fondos disponibles.

4. **Sincronización**
    - La palabra clave `synchronized` asegura que solo un hilo pueda acceder a los métodos `deposit()` o `retire()` a la vez.
    - Esto previene condiciones de carrera y asegura operaciones seguras entre hilos.

## Ejemplo de Salida (Flujo)
``` plaintext
Esperando hasta que puedas retirar
Has depositado 100
Has depositado 100
Has depositado 100
Has depositado 100
Has retirado 350 
```
- Inicialmente, el hilo de retiro (retire()) espera porque el saldo es cero.
- El hilo de depósito (deposit()) agrega dinero en incrementos de 100 y notifica al hilo de retiro cada vez.
- Una vez que el saldo llega a 350 o más, el hilo de retiro se despierta y completa la operación.

## Conclusión
Este ejemplo ilustra cómo utilizar wait() y notify() para una comunicación efectiva entre hilos, asegurando que operaciones como depósitos y retiros se ejecuten en el orden correcto y sin conflictos.
