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
