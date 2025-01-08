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