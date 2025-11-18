import java.io.*;
import java.util.*;

// Custom exceptions
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Account class
class Account {
    private int accountId;
    private String name;
    private double balance;

    public Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountId() { return accountId; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit must be positive.");
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal must be positive.");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds.");
        balance -= amount;
    }

    public void transfer(Account toAccount, double amount) throws InvalidAmountException, InsufficientFundsException {
        this.withdraw(amount);
        toAccount.deposit(amount);
    }

    public String toFileString() {
        return accountId + "," + name + "," + balance;
    }

    public String toString() {
        return "ID: " + accountId + ", Name: " + name + ", Balance: " + balance;
    }
}

// File operations for accounts
class AccountFileManager {

    public static void saveAccounts(List<Account> accounts, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Account acc : accounts) {
                bw.write(acc.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public static List<Account> loadAccounts(String filename) {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) continue;
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double balance = Double.parseDouble(data[2].trim());
                accounts.add(new Account(id, name, balance));
            }
        } catch (FileNotFoundException e) {
            // File not found is OK if first run
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return accounts;
    }
}

// Main program
public class EnhancedBankingSystem {

    private static Scanner sc = new Scanner(System.in);
    private static final String FILENAME = "accounts.txt";
    private static List<Account> accounts;

    public static void main(String[] args) {

        // Load accounts from file
        accounts = AccountFileManager.loadAccounts(FILENAME);

        System.out.println("=== Enhanced Banking System ===");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Numbers only.");
                sc.nextLine(); // consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    viewAccounts();
                    break;
                case 6:
                    exit = true;
                    AccountFileManager.saveAccounts(accounts, FILENAME);
                    System.out.println("Exiting. Accounts saved to " + FILENAME);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static Account findAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getAccountId() == id) return acc;
        }
        return null;
    }

    private static void createAccount() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new Account(id, name, balance));
        System.out.println("Account created successfully.");
    }

    private static void deposit() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        try {
            acc.deposit(amount);
            System.out.println("Deposit successful. New balance: " + acc.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + acc.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transfer() {
        System.out.print("Enter Source Account ID: ");
        int srcId = sc.nextInt();
        Account src = findAccountById(srcId);
        if (src == null) {
            System.out.println("Source account not found.");
            return;
        }
        System.out.print("Enter Destination Account ID: ");
        int destId = sc.nextInt();
        Account dest = findAccountById(destId);
        if (dest == null) {
            System.out.println("Destination account not found.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        try {
            src.transfer(dest, amount);
            System.out.println("Transfer successful.");
            System.out.println("Source Balance: " + src.getBalance());
            System.out.println("Destination Balance: " + dest.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAccounts() {
        System.out.println("=== All Accounts ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
