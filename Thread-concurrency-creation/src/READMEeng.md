# 3 Different Ways of Creating a Thread in Java

In Java, there are multiple ways to create and manage threads. Below are three common methods:

## 1. **Lambda for Small Operations with Threads**
Using a **lambda expression** is a concise and modern way to create a thread. It is typically used for small tasks where you need to implement a thread's behavior directly in the thread's creation. With lambdas, the code becomes cleaner, and you avoid unnecessary boilerplate code.

**Key points**:
- Ideal for short, simple tasks.
- Uses `Runnable` interface behind the scenes.
- Eliminates the need for a separate class or anonymous class to implement `Runnable`.
---
## 2. **Extending the `Thread` Class**
In this approach, you create a new class that extends the `Thread` class and override the `run()` method to define the thread's behavior. Afterward, you instantiate your custom thread class and start the thread using `start()`.

**Key points**:
- Best for more complex operations or when you need additional thread-related functionality.
- The `run()` method contains the code to be executed by the thread.
- Direct inheritance of the `Thread` class makes it a bit more restrictive since Java does not support multiple inheritance.
---
## 3. **Using the `Runnable` Interface**
When you need to define the behavior of a thread without inheriting from the `Thread` class, you can implement the `Runnable` interface. This approach allows you to create a separate class for the task, and then pass an instance of that class to the `Thread` constructor.

**Key points**:
- Offers better flexibility compared to extending the `Thread` class.
- Allows for implementing multiple interfaces, as Java doesn't support multiple inheritance.
- Threads are started using `Thread` constructor by passing the `Runnable` instance.

---

