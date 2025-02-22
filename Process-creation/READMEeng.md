# Concurrent Programming: SumConcurrency and ParallelismExample

This repository contains two Java implementations demonstrating different concurrent programming approaches for summing the elements of a large array. Each implementation highlights key concepts related to thread-based concurrency and parallelism using the Fork/Join framework.

## Files in This Repository

### `SumConcurrency.java`
Uses traditional Java threads to divide the workload into fixed parts and compute the sum of an array.

### `ParallelismExample.java`
Utilizes the Fork/Join framework to recursively split the workload into smaller subtasks and execute them in parallel.

## `SumConcurrency.java`

### Description
This program demonstrates concurrency using Java threads to sum the elements of a large array. The array is divided into equal parts (based on the number of threads), and each thread computes the sum of its assigned portion. Finally, the results from all threads are combined to calculate the total sum.

### Key Features
- **Thread-Based Concurrency**: The array is divided into segments, each processed by an independent thread.
- **Synchronization**: `Thread.join()` ensures the main thread waits for all threads to finish before combining results.
- **Fixed Number of Threads**: The number of threads is predefined and does not dynamically adjust based on workload.

### How It Works
1. An array is initialized with values from `0` to `N-1`.
2. A fixed number of threads is created (e.g., 2).
3. Each thread computes the sum of its assigned section of the array.
4. The main thread waits for all threads to finish (`join()`).
5. The results from all threads are combined to obtain the total sum.

### Example Output
Total sum: 4999999950000000
Execution time: 130ms

### Advantages and Disadvantages
- **Advantages**:
  - Simple implementation.
  - Efficient for small-scale parallel tasks.
- **Limitations**:
  - A fixed number of threads may not fully utilize multi-core CPUs.
  - Manual thread management can become complex for larger workloads.

## `ParallelismExample.java`

### Description
This program leverages the Fork/Join framework, a high-level abstraction for parallel computing in Java. The array is recursively split into smaller segments, and tasks are executed in parallel until the segments are small enough to be processed directly.

### Key Features
- **Fork/Join Framework**: Tasks are recursively divided into smaller subtasks and executed asynchronously using `fork()` and `join()`.
- **Recursive Decomposition**: The workload is dynamically divided based on task size.
- **Threshold-Based Execution**: If the task size falls below a certain threshold, it is computed sequentially.

### How It Works
1. An array is initialized with values from `0` to `N-1`.
2. The task recursively splits the array into two halves:
   - The left half runs asynchronously with `fork()`.
   - The right half runs sequentially with `compute()`.
3. The results from the left and right tasks are combined.
4. This process continues until the subarray size is smaller than the threshold, at which point it is summed directly.

### Example Output
Result: 4999999950000000
Execution time: 80ms


### Advantages and Disadvantages
- **Advantages**:
  - Dynamically balances the workload across all available CPU cores.
  - More efficient for large-scale parallel tasks.
- **Limitations**:
  - Requires knowledge of the Fork/Join framework.
  - Task creation and management may introduce overhead for small tasks.

## Comparison of Both Approaches

| Feature                | SumConcurrency               | ParallelismExample              |
|------------------------|------------------------------|----------------------------------|
| **Execution Model**    | Fixed Threads                | Dynamic Fork/Join Tasks         |
| **Work Division**      | Static                       | Recursive                       |
| **Parallel Execution** | Limited by fixed threads     | Dynamically adjusts to cores    |
| **Synchronization**    | `Thread.join()`              | `fork()` and `join()`           |
| **Use Case**           | Small arrays or simple tasks | Large arrays or complex tasks   |
| **Efficiency**         | Less efficient for large arrays | Highly efficient for large arrays |

## When to Use Each Approach

### Use `SumConcurrency` when:
- The workload is small and predictable.
- Simplicity and code clarity are a priority.
- A fixed number of resources (threads) is available.

### Use `ParallelismExample` when:
- Working with large datasets or computationally intensive tasks.
- Maximizing the use of multi-core processors.
- A dynamic workload balance is required.

## Conclusion
Both programs demonstrate powerful techniques for parallel computing in Java. While `SumConcurrency` is simpler and suitable for small tasks, `ParallelismExample` leverages advanced parallelism features to efficiently handle larger workloads. Understanding these approaches will help you choose the best tool for your concurrency and parallelism needs.
