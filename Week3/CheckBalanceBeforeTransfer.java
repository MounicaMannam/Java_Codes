// Week3/Day1/CheckBalanceBeforeTransfer.java

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

    // Display balance
    public void displayBalance() {
        System.out.println(accountHolder + " Balance: $" + balance);
    }
}

public class CheckBalanceBeforeTransfer {
    public static void main(String[] args) {
        Account a1 = new Account("Mounica", 3000);
        Account a2 = new Account("Roshan", 2000);

        // Display initial balances
        a1.displayBalance();
        a2.displayBalance();

        // Valid transfer
        a1.transfer(a2, 1000);

        // Invalid transfer (insufficient funds)
        a1.transfer(a2, 5000);

        // Display updated balances
        System.out.println("\nAfter Transfers:");
        a1.displayBalance();
        a2.displayBalance();
    }
}
