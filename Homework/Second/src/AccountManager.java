public class AccountManager {
    public static void main(String args[]){
        CheckingAccount first = new CheckingAccount();
        SavingsAccount second = new SavingsAccount();
        PremiumCheckingAccount third = new PremiumCheckingAccount();
        first.setInfo(500.0,"1");
        second.setInfo(1000,"2");
        second.setRate(0.01);
        third.setInfo(6000, "3");
        third.setRate(.015);
        first.chargeFee();
        third.chargeFee();
        second.applyInterest();
        third.applyInterest();
        first.printAccountInfo();
        second.printAccountInfo();
        third.printAccountInfo();
    }
}
