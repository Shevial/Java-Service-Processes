# Concurrent Programming: SumConcurrency and ParallelismExample

This repository contains two Java implementations that demonstrate different approaches to concurrent programming for summing the elements of a large array. Each implementation highlights key concepts of thread-based concurrency and parallelism using the **Fork/Join framework**.

## Files in This Repository

1. **SumConcurrency.java**
   - Uses traditional Java threads to divide the work into fixed parts and sum the array.
2. **ParallelismExample.java**
   - Uses the Fork/Join framework to recursively divide the work into smaller subtasks and execute them in parallel.

---

## SumConcurrency.java

### Overview
This program demonstrates concurrency using fixed Java threads to sum the elements of a large array. The array is divided into equal parts (based on the number of threads), and each thread computes the sum for its portion. Finally, the results from all threads are combined to calculate the total sum.

### Key Features
- **Thread-based concurrency**:
  - The array is divided into chunks.
  - Each chunk is processed by a separate thread.
- **Synchronization**:
  - `Thread.join()` ensures that the main thread waits for all threads to complete before combining results.
- **Fixed number of threads**:
  - The number of threads is predetermined and does not dynamically adjust based on workload.

### How It Works
1. The array is initialized with integers from 0 to \(N-1\).
2. A fixed number of threads is created (e.g., 2).
3. Each thread calculates the sum for its assigned section of the array.
4. The main thread waits for all threads to finish (`join()`).
5. Results from all threads are combined into the total sum.

### Example Output
```
La suma total es: 4999999950000000
Tiempo de ejecución: 130ms
```

### Pros and Cons
**Advantages:**
- Simple to implement.
- Effective for small-scale parallel tasks.

**Limitations:**
- Fixed thread count may not fully utilize multi-core CPUs.
- Threads are manually managed, which can become complex with larger workloads.

---

## ParallelismExample.java

### Overview
This program demonstrates parallelism using the **Fork/Join Framework**, a high-level abstraction for parallel computation in Java. The array is divided recursively into smaller chunks, and the tasks are executed in parallel until the chunks are small enough to compute directly.

### Key Features
- **Fork/Join Framework**:
  - Tasks are split recursively into smaller subtasks.
  - Subtasks are executed asynchronously using `fork()` and combined using `join()`.
- **Recursive decomposition**:
  - The workload is divided dynamically based on the size of the task.
- **Threshold-based execution**:
  - If the task size falls below a certain threshold, it is computed sequentially.

### How It Works
1. The array is initialized with integers from 0 to \(N-1\).
2. The task divides the array into two halves recursively:
   - The left half is executed asynchronously with `fork()`.
   - The right half is executed sequentially with `compute()`.
3. The results from the left and right tasks are combined.
4. The process continues until the size of the subarray is below the threshold, at which point it is summed directly.

### Example Output
```
Result: 4999999950000000
Execution time: 80ms
```

### Pros and Cons
**Advantages:**
- Dynamically adjusts workload across available CPU cores.
- More efficient for large-scale parallel tasks.

**Limitations:**
- Requires understanding of Fork/Join Framework.
- Overhead from task creation and management may impact performance for small workloads.

---

## Comparing Both Approaches

| Feature                      | SumConcurrency                  | ParallelismExample           |
|------------------------------|----------------------------------|------------------------------|
| **Execution Model**          | Fixed threads                   | Dynamic Fork/Join tasks      |
| **Work Division**            | Static                          | Recursive                    |
| **Parallel Execution**       | Limited by fixed thread count   | Dynamically adjusts to cores |
| **Synchronization**          | `Thread.join()`                 | `fork()` and `join()`        |
| **Use Case**                 | Smaller arrays or simple tasks  | Large arrays or complex tasks|
| **Efficiency**               | Less efficient for large arrays | Highly efficient for large arrays|

---

## When to Use Each Approach
- **Use SumConcurrency**:
  - When the workload is small and predictable.
  - When simplicity and clarity are priorities.
  - When you have a fixed number of resources (e.g., threads).

- **Use ParallelismExample**:
  - For large datasets or computationally intensive tasks.
  - To fully utilize multi-core processors.
  - When dynamic workload balancing is required.

---

## Conclusion
Both programs showcase powerful techniques for parallel computation in Java. While `SumConcurrency` is simpler and works well for smaller tasks, `ParallelismExample` leverages advanced parallelism features to efficiently handle larger workloads. Understanding these approaches will help you choose the right tool for your specific concurrency and parallelism needs.
