public class TreasuryMain {
    public static void main(String[] args){
        Treasury account1 = new Treasury();
        ThreadExtendsTreasuryRetire retire = new ThreadExtendsTreasuryRetire(account1);
        ThreadExtendsTreasuryDeposit deposit = new ThreadExtendsTreasuryDeposit(account1);
        retire.start();
        deposit.start();
    }
}