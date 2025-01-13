/**
 * he TreasuryMain class initializes a Treasury account and creates two threads:
 * one for retiring 350 units (ThreadExtendsTreasuryRetire) and
 * another for depositing 100 units every second for four iterations (ThreadExtendsTreasuryDeposit).
 * Both threads are started concurrently.
 */
public class TreasuryMain {
    public static void main(String[] args){
        Treasury account1 = new Treasury();
        ThreadExtendsTreasuryRetire retire = new ThreadExtendsTreasuryRetire(account1);
        ThreadExtendsTreasuryDeposit deposit = new ThreadExtendsTreasuryDeposit(account1);
        retire.start();
        deposit.start();
    }
}