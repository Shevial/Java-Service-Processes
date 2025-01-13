/**
 * This Java class, ThreadExtendsTreasuryRetire, extends Thread to retire funds from a Treasury account.
 * When executed, it calls the retire method to withdraw 350 units from the account.
 */
public class ThreadExtendsTreasuryRetire extends Thread{
    private Treasury account;
    public ThreadExtendsTreasuryRetire(Treasury account){
        this.account = account;
    }
    public void run(){
        account.retire(350);
    }
}
