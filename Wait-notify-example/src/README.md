# Treasury System with Threads

This program demonstrates thread synchronization in Java using the `wait()` and `notify()` methods. It simulates a basic treasury system where threads can deposit and withdraw money from a shared account. The system ensures that no withdrawal occurs unless there is sufficient balance.

## Key Concepts Used

### 1. **`wait()` Method**
- The `wait()` method is used to pause the execution of a thread until another thread notifies it.
- When called, the thread releases the lock on the object and enters a waiting state.
- In this program, `wait()` is used in the `retire()` method to pause the withdrawal thread when the balance is insufficient.

### 2. **`notify()` Method**
- The `notify()` method wakes up one of the threads waiting on the same object's monitor.
- It is used in the `deposit()` method to signal the withdrawal thread (`retire()`) that a deposit has been made and the balance might now be sufficient.

## Program Flow

1. **Initialization**
    - A `Treasury` object is created to represent the shared account.
    - Two threads are instantiated:
        - **Deposit Thread**: Adds money to the treasury in a loop.
        - **Withdrawal Thread**: Attempts to withdraw a fixed amount from the treasury.

2. **Execution of Deposit Thread**
    - The `deposit()` method adds a fixed amount (100) to the balance.
    - After each deposit, it calls `notify()` to wake up the withdrawal thread if it is waiting.
    - The thread sleeps for 1 second between deposits.

3. **Execution of Withdrawal Thread**
    - The `retire()` method checks if the balance is sufficient for withdrawal (350).
    - If the balance is insufficient, the thread enters a waiting state using `wait()`.
    - Once notified, it rechecks the balance and proceeds if sufficient funds are available.

4. **Synchronization**
    - The `synchronized` keyword ensures that only one thread can access the `deposit()` or `retire()` methods at a time.
    - This prevents race conditions and ensures thread-safe operations.

## Example Output (Flow)
```plaintext
Waiting until you can retire
You have deposit 100
You have deposit 100
You have deposit 100
You have deposit 100
You have retired 350
```
- Initially, the withdrawal thread (`retire()`) waits because the balance is zero.
- The deposit thread (`deposit()`) adds money in increments of 100 and notifies the withdrawal thread each time.
- Once the balance reaches 350 or more, the withdrawal thread wakes up and completes the operation.

## Conclusion
This example illustrates how to use `wait()` and `notify()` for effective communication between threads, ensuring that operations like deposits and withdrawals are executed in the correct order and without conflict.
