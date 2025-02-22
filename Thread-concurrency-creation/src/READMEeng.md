# Different Ways of Creating a Thread in Java  

In Java, there are multiple ways to create and manage threads. Below are three common methods:  

## 1. Using Lambda Expressions for Small Operations  

Using a lambda expression is a modern and concise way to create a thread. It is mainly used for small tasks where you define the thread's behavior directly at the moment of creation.  

### Key Points:  
- Ideal for short, simple tasks.  
- Uses the `Runnable` interface behind the scenes.  
- Eliminates the need for a separate class or an anonymous class to implement `Runnable`.  

## 2. Extending the Thread Class  

In this approach, you create a new class that extends the `Thread` class and override the `run()` method to define the thread's behavior. Then, you instantiate your custom thread class and start the thread using `start()`.  

### Key Points:  
- Best for more complex operations or when additional thread-related functionality is needed.  
- The `run()` method contains the code to be executed by the thread.  
- Direct inheritance from `Thread` is more restrictive since Java does not support multiple inheritance.  

## 3. Implementing the Runnable Interface  

When you need to define the behavior of a thread without inheriting from the `Thread` class, you can implement the `Runnable` interface. This approach allows you to create a separate class for the task and then pass an instance of that class to the `Thread` constructor.  

### Key Points:  
- Provides better flexibility compared to extending `Thread`.  
- Allows for implementing multiple interfaces, as Java does not support multiple inheritance.  
- Threads are started using the `Thread` constructor by passing the `Runnable` instance.  

---

## Explanation of the Files  

### `ThreadExtends.java`
- A class that extends `Thread` and overrides the `run()` method.  
- Runs a loop for four iterations, printing the thread name and the iteration number.  
- Includes a 1-second pause (`Thread.sleep(1000)`) between iterations.  

### `ThreadExtendsMain.java`
- Creates and starts two instances of `ThreadExtends`.  
- Assigns names to the threads before starting them.  

### `ThreadLambdaMain.java`
- Creates a thread using `Thread` and defines its behavior with a lambda expression.  
- Prints the thread name, priority, and iteration number in a loop of four repetitions.  
- Also includes 1-second pauses between iterations.  

### `ThreadRunnable.java`
- Implements the `Runnable` interface and defines the `run()` method.  
- Runs a loop for four iterations, printing the thread name and iteration number.  
- Includes 1-second pauses.  

### `ThreadRunnableMain.java`
- Creates two threads by passing an instance of `ThreadRunnable` to the `Thread` constructor.  
- Assigns names to the threads and starts them using `start()`.  

