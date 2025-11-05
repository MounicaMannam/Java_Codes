// Week3/Day1/TransferExample.java

class Account {
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
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
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Transfer method
    public void transfer(Account receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transferred $" + amount + " from " + accountHolder + " to " + receiver.accountHolder);
        } else {
            System.out.println("Transfer failed: insufficient balance or invalid amount.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println(accountHolder + " Balance: $" + balance);
    }
}

public class TransferExample {
    public static void main(String[] args) {
        // Creating account objects
        Account a1 = new Account("Mounica", 5000);
        Account a2 = new Account("Roshan", 3000);

        // Display initial balances
        a1.displayBalance();
        a2.displayBalance();

        // Perform transfer
        a1.transfer(a2, 1200);

        // Display updated balances
        System.out.println("\nAfter Transfer:");
        a1.displayBalance();
        a2.displayBalance();
    }
}
