import java.util.*;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0)
            throw new InsufficientFundsException("Invalid withdrawal amount!");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds! Available: $" + balance);

        balance -= amount;
        System.out.println("Withdrawal Successful! Remaining Balance: $" + balance);
    }
    public void transfer(Account target, double amount) throws InsufficientFundsException {
        if (amount <= 0)
            throw new InsufficientFundsException("Invalid transfer amount!");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds to transfer!");

        balance -= amount;
        target.balance += amount;
        System.out.println(" Transfer Successful: $" + amount + " sent to " + target.accountHolder);
    }

    public void displayAccount() {
        System.out.printf("Account No: %-10s | Name: %-10s | Balance: $%.2f%n", accountNumber, accountHolder, balance);
    }
}

public class BankingSystemTest {

    private static Account findAccount(Account[] accounts, String accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(accNo)) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] accounts = {
            new Account("ACC101", "Mounica", 8000),
            new Account("ACC102", "Roshan", 6000),
            new Account("ACC103", "Advik", 7500),
            new Account("ACC104", "Akash", 5000)
        };
        int choice;
        do {
            System.out.println("\n ====== BANKING SYSTEM MENU ======");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Search Account by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n Account Details:");
                    for (Account acc : accounts) acc.displayAccount();
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAccNo = sc.next();
                    Account depAcc = findAccount(accounts, depAccNo);
                    if (depAcc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        depAcc.deposit(amount);
                    } else {
                        System.out.println(" Account not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAccNo = sc.next();
                    Account withAcc = findAccount(accounts, withAccNo);
                    if (withAcc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        try {
                            withAcc.withdraw(amount);
                        } catch (InsufficientFundsException e) {
                            System.out.println("Insufficient Funds" + e.getMessage());
                        } finally {
                            System.out.println("Transaction completed.\n");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Source Account Number: ");
                    String srcAccNo = sc.next();
                    System.out.print("Enter Target Account Number: ");
                    String tgtAccNo = sc.next();
                    Account srcAcc = findAccount(accounts, srcAccNo);
                    Account tgtAcc = findAccount(accounts, tgtAccNo);
                    if (srcAcc != null && tgtAcc != null) {
                        System.out.print("Enter amount to transfer: ");
                        double amount = sc.nextDouble();
                        try {
                            srcAcc.transfer(tgtAcc, amount);
                        } catch (InsufficientFundsException e) {
                            System.out.println("Insufficient Funds " + e.getMessage());
                        } finally {
                            System.out.println("Transfer process completed.\n");
                        }
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account Number to Search: ");
                    String searchAccNo = sc.next();
                    Account acc = findAccount(accounts, searchAccNo);
                    if (acc != null) {
                        System.out.println("\n Account Found:");
                        acc.displayAccount();
                    } else {
                        System.out.println(" Account not found!");
                    }
                    break;
                case 6:
                    System.out.println(" Exiting Banking System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
        sc.close();
    }
}
