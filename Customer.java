public class Customer extends User{
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer(){
        super(); 
        this.checking = new CheckingAccount();
        this.savings = new SavingsAccount();
    }

    public Customer(String userName, String PIN){
        super(userName, PIN); 
        this.checking = new CheckingAccount();
        this.savings = new SavingsAccount();
    }

    @Override
    public String menu(){
        return """
               Customer Menu:
               0) Exit
               1) Manage Checking Account
               2) Manage Savings Account
               3) Change PIN
               """;
    }

    @Override
    public void start(){
        System.out.println("Welcome, " + getUserName() + "!");
        boolean exit = false;

        while (!exit){
            System.out.println(menu());
            int choice = (int) getDouble(); 
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> checking.start(); 
                case 2 -> savings.start(); 
                case 3 -> changePin(); 
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void changePin(){
        System.out.println("Enter new PIN:");
        String newPin = scanner.nextLine(); 
        setPIN(newPin);
        System.out.println("PIN successfully changed.");
    }

    @Override
    public String getReport(){
        return """
               Customer Report:
               Username: %s
               Checking Account Balance: %s
               Savings Account Balance: %s
               """.formatted(getUserName(), 
                              checking.getBalanceString(), 
                              savings.getBalanceString());
    }

    public static void main(String[] args){
        Customer customer = new Customer("Alice", "0000");

        System.out.println(customer.getReport());
        customer.start();
    }
}
