import java.util.InputMismatchException;
import java.util.Scanner;

class Account {
    protected int accountId;
    protected String holderName;
    protected double balance;

    public Account(int accountId, String holderName, double balance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds! Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ", Remaining Balance: " + balance);
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account acc = new Account(101, "Mounica", 5000);

        System.out.println("---- Exception Handling Demo ----");

        // ---------------- DEPOSIT ----------------
        try {
            System.out.print("Enter amount to deposit: ");
            double dep = sc.nextDouble();
            acc.deposit(dep);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter only numbers.");
            sc.nextLine(); // clear buffer
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ---------------- WITHDRAW ----------------
        try {
            System.out.print("Enter amount to withdraw: ");
            double wd = sc.nextDouble();
            acc.withdraw(wd);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter only numbers.");
            sc.nextLine(); // clear buffer
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction completed.");
        }

        sc.close();
    }
}
