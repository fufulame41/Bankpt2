public class SavingsAccount extends CheckingAccount {

    private double interestRate;

    public SavingsAccount(){
        super();
        this.interestRate = 0.0;
    }

    public SavingsAccount(double balance, double interestRate){
        super(balance);
        this.interestRate = interestRate;
    }

    public void calcInterest(){
        double interestAmount = this.getBalance() * this.interestRate;
        this.setBalance(this.getBalance() + interestAmount);
        System.out.println("New balance: " + this.getBalanceString());
    }

    public void setInterestRate(double interestRate){
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Interest rate must be positive.");
        }
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public static void main(String[] args){
        SavingsAccount savings = new SavingsAccount(1000.0, 0.05); 

        savings.checkBalance();
        savings.calcInterest();
        savings.checkBalance();
    }
}
