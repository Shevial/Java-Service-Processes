public class ThreadExtendsTreasuryRetire extends Thread{
    private Treasury account;
    public ThreadExtendsTreasuryRetire(Treasury account){
        this.account = account;
    }
    public void run(){
        account.retire(350);
    }
}
