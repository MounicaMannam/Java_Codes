// Week3/Day1/PrintAccountDetails.java

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

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
            return true;
        } else {
            System.out.println(accountHolder + " has insufficient balance for withdrawal.");
            return false;
        }
    }

    // Transfer method with balance check
    public void transfer(Account receiver, double amount) {
        System.out.println("\nAttempting to transfer $" + amount + " from " + accountHolder + " to " + receiver.accountHolder + "...");
        if (amount > 0 && amount <= balance) {
            boolean success = this.withdraw(amount);
            if (success) {
                receiver.deposit(amount);
                System.out.println("Transfer successful!");
            }
        } else {
            System.out.println("Transfer failed: insufficient funds or invalid amount.");
        }
    }

    // Display only balance
    public void displayBalance() {
        System.out.println(accountHolder + " Balance: $" + balance);
    }

    // 🔹 Display all account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-----------------------");
    }
}

public class PrintAccountDetails {
    public static void main(String[] args) {
        // Create sample accounts
        Account a1 = new Account("Mounica", "ACC1001", 5000);
        Account a2 = new Account("Roshan", "ACC1002", 3000);

        // Display details
        a1.displayAccountDetails();
        a2.displayAccountDetails();

        // Perform a transaction
        a1.transfer(a2, 1500);

        // Show details again after transfer
        System.out.println("\nAfter Transfer:");
        a1.displayAccountDetails();
        a2.displayAccountDetails();
    }
}
