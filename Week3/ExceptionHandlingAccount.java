// Week3/Day2/ExceptionHandlingAccount.java

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

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

    // Withdraw method with exception handling
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account: " + accountHolder);
        }
        balance -= amount;
        System.out.println(accountHolder + " withdrew $" + amount);
    }

    // Transfer method using try-catch-finally
    public void transfer(Account receiver, double amount) {
        System.out.println("\nAttempting to transfer $" + amount + " from " + accountHolder + " to " + receiver.accountHolder + "...");
        try {
            this.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer successful!");
        } catch (InsufficientFundsException e) {
            System.out.println(" Transfer failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Unexpected error: " + e.getMessage());
        } finally {
            System.out.println(" Transaction attempt completed for " + accountHolder + ".");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("-----------------------");
    }
}

public class ExceptionHandlingAccount {
    public static void main(String[] args) {
        Account a1 = new Account("Mounica", "ACC101", 2000);
        Account a2 = new Account("Roshan", "ACC102", 1000);

        a1.displayAccountDetails();
        a2.displayAccountDetails();

        // Valid transfer
        a1.transfer(a2, 500);

        // Transfer with insufficient funds
        a2.transfer(a1, 2000);

        // Show final account states
        System.out.println("\nAfter transactions:");
        a1.displayAccountDetails();
        a2.displayAccountDetails();
    }
}
