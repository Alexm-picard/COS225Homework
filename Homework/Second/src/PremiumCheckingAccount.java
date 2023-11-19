public class PremiumCheckingAccount extends CheckingAccount{
    protected double rate;
    public void setRate(double x){
        if(x > 0){
            this.rate = x;
        }else{
            throw new IllegalArgumentException("Interest rate must be possitive");
        }
    }
    public void applyInterest(){
        if(this.balance > 5000){
            this.balance *= 1 + rate;
        }
    }
    @Override
    public void printAccountInfo() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.bankAccount);
        System.out.println(this.balance);
        System.out.println("$10 if balance is below $1000");
        System.out.println(this.rate);
    }
}
