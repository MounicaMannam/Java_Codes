// Week3/Day4/ArrayOfAccounts.java

class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public Account(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount for " + accountHolder);
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds for " + accountHolder);
        }
    }

    // Display account details
    public void display() {
        System.out.println(accountHolder + " (" + accountNumber + ") → Balance: $" + balance);
    }
}

public class ArrayOfAccounts {
    public static void main(String[] args) {
        // ✅ Create an array of Account objects
        Account[] accounts = new Account[3];

        // Initialize each account
        accounts[0] = new Account("Mounica", "ACC401", 5000);
        accounts[1] = new Account("Roshan", "ACC402", 3500);
        accounts[2] = new Account("Viv", "ACC403", 7000);

        System.out.println("=== Initial Account Details ===");
        for (Account acc : accounts) {
            acc.display();
        }

        // Perform some operations
        System.out.println("\n=== Performing Transactions ===");
        accounts[0].deposit(1500);   // Mounica deposits
        accounts[1].withdraw(1000);  // Roshan withdraws
        accounts[2].deposit(500);    // Viv deposits

        System.out.println("\n=== Updated Account Details ===");
        for (Account acc : accounts) {
            acc.display();
        }
    }
}
