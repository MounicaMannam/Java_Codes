// Week3/Day3/CustomExceptionDemo.java

// Custom exception for invalid operations
class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}

// Account class demonstrating custom exception usage
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

    // Deposit method with validation
    public void deposit(double amount) throws InvalidOperationException {
        if (amount <= 0) {
            throw new InvalidOperationException("Deposit amount must be positive!");
        }
        balance += amount;
        System.out.println("" + accountHolder + " deposited $" + amount);
    }

    // Withdraw method with validation
    public void withdraw(double amount) throws InvalidOperationException {
        if (amount <= 0) {
            throw new InvalidOperationException(" Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new InvalidOperationException("Insufficient balance for " + accountHolder);
        }
        balance -= amount;
        System.out.println(" " + accountHolder + " withdrew $" + amount);
    }

    // Transfer method with validation
    public void transfer(Account receiver, double amount) throws InvalidOperationException {
        if (receiver == null) {
            throw new InvalidOperationException(" Receiver account not found!");
        }
        if (amount <= 0) {
            throw new InvalidOperationException("Transfer amount must be greater than zero!");
        }
        if (amount > balance) {
            throw new InvalidOperationException(" Not enough funds for transfer!");
        }

        this.withdraw(amount);
        receiver.deposit(amount);
        System.out.println("Transfer of $" + amount + " from " + accountHolder + " to " + receiver.accountHolder + " successful!");
    }

    public void displayAccount() {
        System.out.println(accountHolder + " (" + accountNumber + ") - Balance: $" + balance);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        Account a1 = new Account("Mounica", "ACC201", 1000);
        Account a2 = new Account("Roshan", "ACC202", 2000);

        try {
            a1.deposit(500);
            a2.withdraw(300);
            a1.transfer(a2, 700);
            a2.transfer(a1, -200); // Invalid transfer
        } 
        catch (InvalidOperationException e) {
            System.out.println(" Exception caught: " + e.getMessage());
        } 
        finally {
            System.out.println("\n Final Account Status:");
            a1.displayAccount();
            a2.displayAccount();
        }
    }
}
