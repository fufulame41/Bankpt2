public class Admin extends User{

    public Admin(){
        super(); 
    }

    @Override
    public String menu(){
        return """
               Admin Menu:
               0) Exit
               1) Full Customer Report
               2) Add a User
               3) Apply Interest
               """;
    }

    public void start(){
        System.out.println("Admin functionality is managed in the Bank class.");
    }

    public String getReport(){
        return "Admin Report: This section can display admin-specific details if required.";
    }
}
