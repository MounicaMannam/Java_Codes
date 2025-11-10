// Week3/Day5/BankingSystemSimulator.java
import java.util.*;

// ✅ Custom exception class for handling invalid operations
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// ✅ Account class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method with exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new InsufficientFundsException("Invalid withdrawal amount!");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds! Available balance: $" + balance);
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: $" + balance);
    }

    // Transfer method
    public void transfer(Account target, double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new InsufficientFundsException("Invalid transfer amount!");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds for transfer! Available: $" + balance);
        balance -= amount;
        target.balance += amount;
        System.out.println("Transfer successful! $" + amount + " sent to " + target.getAccountHolder());
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("-------------------------------");
    }
}

// ✅ Main Banking System class
public class BankingSystemSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create multiple accounts
        Account[] accounts = {
            new Account("ACC101", "Mounica", 7000.0),
            new Account("ACC102", "Roshan", 5000.0),
            new Account("ACC103", "Advik", 8000.0),
            new Account("ACC104", "Viv", 6500.0),
            new Account("ACC105", "Akash", 4500.0)
        };

        int choice;
        do {
            System.out.println("\n======= Banking System Menu =======");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Search Account by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Account Details ---");
                    for (Account acc : accounts) acc.displayAccount();
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depID = sc.nextLine();
                    Account depAcc = findAccount(accounts, depID);
                    if (depAcc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        depAcc.deposit(amount);
                    } else System.out.println(" Account not found!");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withID = sc.nextLine();
                    Account withAcc = findAccount(accounts, withID);
                    if (withAcc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        try {
                            withAcc.withdraw(amount);
                        } catch (InsufficientFundsException e) {
                            System.out.println("Insufficient Funds" + e.getMessage());
                        } finally {
                            System.out.println("Withdrawal process completed.");
                        }
                    } else System.out.println(" Account not found!");
                    break;

                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    String senderID = sc.nextLine();
                    Account sender = findAccount(accounts, senderID);

                    System.out.print("Enter Receiver Account Number: ");
                    String receiverID = sc.nextLine();
                    Account receiver = findAccount(accounts, receiverID);

                    if (sender != null && receiver != null) {
                        System.out.print("Enter amount to transfer: ");
                        double amount = sc.nextDouble();
                        try {
                            sender.transfer(receiver, amount);
                        } catch (InsufficientFundsException e) {
                            System.out.println("Insufficient Funds " + e.getMessage());
                        } finally {
                            System.out.println("Transfer process completed.");
                        }
                    } else System.out.println(" Invalid account(s) entered!");
                    break;

                case 5:
                    System.out.print("Enter Account Number to search: ");
                    String searchID = sc.nextLine();
                    Account acc = findAccount(accounts, searchID);
                    if (acc != null) acc.displayAccount();
                    else System.out.println(" Account not found!");
                    break;

                case 6:
                    System.out.println(" Thank you for using our Banking System!");
                    break;

                default:
                    System.out.println(" Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Helper function to find account by ID
    private static Account findAccount(Account[] accounts, String id) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(id))
                return acc;
        }
        return null;
    }
}
