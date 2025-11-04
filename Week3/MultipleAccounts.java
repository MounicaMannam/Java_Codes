// Week3/Day1/MultipleAccounts.java
import java.util.*;

class Account {
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for " + accountHolder);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Display account details
    public void display() {
        System.out.println("Account Holder: " + accountHolder + " | Balance: $" + balance);
    }

    public String getName() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}

public class MultipleAccounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Create multiple accounts
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Creating Account " + i + " ---");
            System.out.print("Enter account holder name: ");
            String name = sc.nextLine();

            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); // consume newline

            accounts.add(new Account(name, balance));
        }

        // Menu for operations
        int choice;
        do {
            System.out.println("\n=== Bank Operations Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String depName = sc.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depAmt = sc.nextDouble();
                    sc.nextLine();

                    Account depAcc = findAccount(accounts, depName);
                    if (depAcc != null) depAcc.deposit(depAmt);
                    else System.out.println("Account not found!");
                    break;

                case 2:
                    System.out.print("Enter account holder name: ");
                    String withName = sc.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withAmt = sc.nextDouble();
                    sc.nextLine();

                    Account withAcc = findAccount(accounts, withName);
                    if (withAcc != null) withAcc.withdraw(withAmt);
                    else System.out.println("Account not found!");
                    break;

                case 3:
                    System.out.println("\n--- All Account Details ---");
                    for (Account a : accounts) {
                        a.display();
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Helper method to find account by name
    private static Account findAccount(List<Account> accounts, String name) {
        for (Account acc : accounts) {
            if (acc.getName().equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }
}
