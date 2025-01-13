/**
 * The Treasury class manages a synchronized balance with deposit and retire methods.
 * The deposit method increases the balance and notifies waiting threads,
 * while the retire method waits if the balance is insufficient,
 * then reduces the balance once sufficient funds are available.
 */

public class Treasury {
    private int balance = 0;
    public synchronized void deposit(int amount){
        balance += amount;
        System.out.println("You have deposit " + amount);
        notify(); // notifies to the rest of the threads that balance has changed
    }
    public synchronized void retire(int amount) {
        while (balance < amount){
            try {
                System.out.println("Waiting until you can retire");
                wait(); // waiting for a deposit
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance -= amount;
        System.out.println("You have retired " + amount);
    }
}
