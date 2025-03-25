import java.util.Scanner;

public class CheckingAccount implements HasMenu {

    private double balance;
    private Scanner scanner = new Scanner(System.in);

    public CheckingAccount(){
        this.balance = 0.0;
    }

    public CheckingAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getBalanceString(){
        return String.format("$%.2f", balance);
    }

    public void checkBalance(){
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    public void makeDeposit(){
        System.out.println("Making a deposit...");
        System.out.println("How much to deposit?");
        double amount = getDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("New balance: " + getBalanceString());
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    public void makeWithdrawal(){
        System.out.println("Making a withdrawal...");
        System.out.println("How much to withdraw?");
        double amount = getDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("New balance: " + getBalanceString());
        } else {
            System.out.println("Invalid amount or insufficient funds. Withdrawal failed.");
        }
    }

    private double getDouble(){
        try {
            return Double.parseDouble(sResult);
        } catch (Exception e){
            System.out.println("Invalid input. changing to 0");
            result = 0d;
        }
            return result;
        }

    @Override
    public String menu(){
        return """
               Checking Account Menu:
               0) Quit
               1) Check Balance
               2) Make a Deposit
               3) Make a Withdrawal
               """;
    }

    @Override
    public void start(){
        boolean exit = false;
        while (!exit) {
            System.out.println(menu());
            int choice = (int) getDouble(); 
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> checkBalance();
                case 2 -> makeDeposit();
                case 3 -> makeWithdrawal();
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void main(String[] args){
        CheckingAccount account = new CheckingAccount(100.0);
    }
}
