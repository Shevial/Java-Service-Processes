/**
 * This Java class ThreadExtendsTreasuryDeposit,
 * extends Thread to repeatedly deposit money into a Treasury account.
 * It runs in a loop, depositing 100 units every second for four iterations,
 * with error handling for interruptions.
 */

public class ThreadExtendsTreasuryDeposit extends Thread {
    private Treasury account;
    public ThreadExtendsTreasuryDeposit(Treasury account){
        this.account = account;
    }
    public void run(){
        for(int i = 1; i < 5; i++){
            account.deposit(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}