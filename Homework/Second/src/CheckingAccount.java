public class CheckingAccount extends BasicAccount{
    public void chargeFee(){
        if(this.balance < 1000){
            this.balance -= 10;
        }
    }
    @Override
    public void printAccountInfo() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.bankAccount);
        System.out.println(this.balance);
        System.out.println("$10 if balance is below $1000");
    }
}