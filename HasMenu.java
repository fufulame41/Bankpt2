public void start(){
    boolean keepGoing = true;
    while(keepGoing){
        String response = menu();
        if (response.equals("0")){
            keepGoing = false;
        }   else if (response.equals("1")){
            System.out.println("Checking balance...");
            this.checkBalance();
        }   else if (response.equals("2")){
            System.out.println("Making a deposit...");
            this.makeDeposit();
        }   else if (response.equals("3")){
            System.outprintln("Making a withdrawl...");
            this.makeWithdrawal();
        }   else{
            System.out.println("Not a valid input");
        }
    }
}
