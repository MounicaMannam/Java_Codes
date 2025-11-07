// Week3/Day4/FindAccountByID.java
import java.util.Scanner;

class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public Account(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("-------------------------");
    }
}

public class FindAccountByID {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ✅ Create sample accounts
        Account[] accounts = {
            new Account("Mounica", "ACC101", 7500.00),
            new Account("Roshan", "ACC102", 5600.00),
            new Account("Advik", "ACC103", 9000.00),
            new Account("Viv", "ACC104", 6200.00),
            new Account("Akash", "ACC105", 4800.00)
        };

        System.out.print("Enter Account Number to search: ");
        String searchID = sc.nextLine();

        boolean found = false;

        // ✅ Search for account by ID
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(searchID)) {
                System.out.println("\n Account Found!");
                acc.displayAccount();
                found = true;
                break;
            }
        }

        // If not found
        if (!found) {
            System.out.println("\n Account not found for ID: " + searchID);
        }

        sc.close();
    }
}
