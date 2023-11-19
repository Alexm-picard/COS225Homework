public class SavingsAccount extends BasicAccount implements InterestEligible{
    protected double rate;
    public void setRate(double x){
        if(x > 0){
            this.rate = x;
        }else{
            throw new IllegalArgumentException("Interest rate must be possitive");
        }
    }
    @Override
    public void applyInterest(){
        this.balance *= 1 + rate;
    }
    @Override
    public void printAccountInfo() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.bankAccount);
        System.out.println(this.balance);
        System.out.println(this.rate);
    }
}