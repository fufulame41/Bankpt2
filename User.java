import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    private String userName;
    private String PIN;
    private Scanner scanner = new Scanner(System.in);

    // Default constructor
    public User() {
        this.userName = "";
        this.PIN = "";
    }

    // Parameterized constructor
    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Setter for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter for PIN
    public String getPIN() {
        return PIN;
    }

    // Setter for PIN
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    // Login method with user input
    public boolean login() {
        System.out.println("Enter username:");
        String inputUserName = scanner.nextLine();
        System.out.println("Enter PIN:");
        String inputPIN = scanner.nextLine();

        return login(inputUserName, inputPIN);
    }

    // Login method with parameters
    public boolean login(String userName, String PIN) {
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }

    // Abstract method for generating user-specific reports
    public abstract String getReport();

    // Implement the HasMenu interface methods
    @Override
    public abstract String menu();

    @Override
    public abstract void start();
}
