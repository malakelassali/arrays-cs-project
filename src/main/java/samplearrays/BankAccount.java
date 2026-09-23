package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    int size= 0;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions= new double[1000];
    public BankAccount(String name, int startingBalance){
        this.name= name;
        this.currentBalance= startingBalance;
    }

    public void deposit(double amount){
        if (amount>0) {
            currentBalance+= amount;
            transactions[size++] = amount;
            System.out.println("Successful deposit of " + amount + " MAD by " + this.name + ". New balance: " + this.currentBalance + " MAD");
        } else System.out.println("Deposit failed!");
    }

    public void withdraw(double amount){
        if (amount>0 && currentBalance-amount >= 0) {
            currentBalance-= amount;
            transactions[size++] = -amount;
            System.out.println("Successful withdrawal of " + amount + " MAD by " + this.name + ". New balance: " + this.currentBalance + " MAD");
        } else System.out.println("Withdrawal failed!");
    }

    public void displayTransactions(){
        for (double t : transactions) {
            if (t>0) {
                System.out.println("Deposit: " + t + " MAD");
            } else if (t<0) {
                System.out.println("Withdrawal: " + t  + " MAD");
            }
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + this.currentBalance + " MAD");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
