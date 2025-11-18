import java.util.InputMismatchException;
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
            throw new InvalidAmountException("Deposit amount must be greater than 0.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class TestErrorScenarios {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account acc = new Account(3000);

        System.out.println("=== Test Error Scenarios ===");
        System.out.println("Initial Balance: " + acc.getBalance());
        System.out.println("----------------------------------");

        // Test 1: Invalid Deposit
        try {
            System.out.println("Testing invalid deposit (-500)...");
            acc.deposit(-500);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Invalid Withdraw
        try {
            System.out.println("Testing invalid withdraw (-100)...");
            acc.withdraw(-100);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Insufficient Funds
        try {
            System.out.println("Testing withdraw more than balance (10000)...");
            acc.withdraw(10000);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 4: InputMismatchException
        try {
            System.out.print("Enter a deposit amount (type a word to test error): ");
            double value = sc.nextDouble();
            acc.deposit(value);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Numbers only.");
            sc.nextLine(); // clear invalid input
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("----------------------------------");
        System.out.println("Final Balance: " + acc.getBalance());
    }
}
