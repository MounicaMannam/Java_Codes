import java.util.Scanner;

// Custom exception for invalid amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed: Insufficient funds.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {

        Account acc = new Account(5000);

        System.out.println("Initial Balance: " + acc.getBalance());
        System.out.println("-----------------------------------");

        // Test invalid deposit
        try {
            acc.deposit(-200);  // invalid amount
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test insufficient funds
        try {
            acc.withdraw(8000); // insufficient funds
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test valid operations
        try {
            acc.deposit(1000);
            System.out.println("Deposited 1000. New balance: " + acc.getBalance());

            acc.withdraw(2000);
            System.out.println("Withdrew 2000. New balance: " + acc.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("-----------------------------------");
        System.out.println("Final Balance: " + acc.getBalance());
    }
}
