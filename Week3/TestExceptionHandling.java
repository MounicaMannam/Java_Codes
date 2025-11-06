// Week3/Day3/TestExceptionHandling.java

// Custom exception class for invalid operations
class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}

// Account class demonstrating exception handling in different scenarios
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

    // Deposit with validation
    public void deposit(double amount) throws InvalidOperationException {
        if (amount <= 0) {
            throw new InvalidOperationException("Deposit amount must be greater than zero!");
        }
        balance += amount;
        System.out.println(accountHolder + " deposited $" + amount);
    }

    // Withdraw with validation
    public void withdraw(double amount) throws InvalidOperationException {
        if (amount <= 0) {
            throw new InvalidOperationException("Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new InvalidOperationException("Insufficient funds for " + accountHolder);
        }
        balance -= amount;
        System.out.println(accountHolder + " withdrew $" + amount);
    }

    // Transfer with exception checks
    public void transfer(Account receiver, double amount) throws InvalidOperationException {
        if (receiver == null) {
            throw new InvalidOperationException("Receiver account cannot be null!");
        }
        if (amount <= 0) {
            throw new InvalidOperationException("Transfer amount must be greater than zero!");
        }
        if (amount > balance) {
            throw new InvalidOperationException("Not enough funds for transfer!");
        }

        this.withdraw(amount);
        receiver.deposit(amount);
        System.out.println("Transferred $" + amount + " from " + accountHolder + " to " + receiver.accountHolder);
    }

    // Display account summary
    public void displayAccount() {
        System.out.println(accountHolder + " (" + accountNumber + ") → Balance: $" + balance);
    }
}

public class TestExceptionHandling {
    public static void main(String[] args) {
        Account a1 = new Account("Mounica", "ACC301", 1000);
        Account a2 = new Account("Roshan", "ACC302", 500);

        System.out.println("=== TESTING EXCEPTION SCENARIOS ===");

        try {
            // ✅ Valid operations
            a1.deposit(300);
            a2.withdraw(200);
            a1.transfer(a2, 500);

            //  Invalid operations to trigger exceptions
            a1.deposit(-100);           // negative deposit
            a2.withdraw(2000);          // withdraw more than balance
            a1.transfer(a2, 2000);      // transfer more than available
            a2.transfer(null, 100);     // transfer to null
        } 
        catch (InvalidOperationException e) {
            System.out.println(" Exception caught: " + e.getMessage());
        } 
        finally {
            System.out.println("\n Final Account Summary:");
            a1.displayAccount();
            a2.displayAccount();
            System.out.println("=== End of Test ===");
        }
    }
}
