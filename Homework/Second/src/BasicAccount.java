public abstract class BasicAccount{
    protected String bankAccount;
    protected double balance;
    public void setInfo(double x, String y){
        this.balance = x;
        this.bankAccount = y;
    }
    public void deposit(String accountNum, int amount){
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount must be a non-negative number");
        }
        if(accountNum == this.bankAccount) {
            this.balance += amount;
        }else{
            throw new IllegalArgumentException("Wrong Account number");
        }
    }
    public void withdraw(String accountNum, int amount){
        if(this.balance - amount < 0){
            throw new IllegalArgumentException("Account will go negitive, pick a smaller amount to withdraw");
        }
        if(amount < 0){
            throw new IllegalArgumentException("Withdraw amount must be a non-negative number");
        }
        if(accountNum == this.bankAccount) {
            this.balance -= amount;
        }else{
            throw new IllegalArgumentException("Wrong Account number");
        }
    }
    public abstract void printAccountInfo();
}