// Week3/Day4/IterateAccounts.java

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

    // Display account info
    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("-------------------------");
    }
}

public class IterateAccounts {
    public static void main(String[] args) {

        // ✅ Create array of Account objects
        Account[] accounts = {
            new Account("Mounica", "ACC501", 8000),
            new Account("Roshan", "ACC502", 4500),
            new Account("Advik", "ACC503", 9200),
            new Account("Viv", "ACC504", 6000)
        };

        System.out.println("=== Displaying All Accounts (Using for-each loop) ===\n");

        // ✅ Iterate using enhanced for loop
        for (Account acc : accounts) {
            acc.displayAccount();
        }

        System.out.println("=== Displaying Accounts Using Traditional for loop ===\n");

        // ✅ Iterate using index-based for loop
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account #" + (i + 1));
            accounts[i].displayAccount();
        }

        System.out.println("=== Displaying Accounts Using While Loop ===\n");

        // ✅ Iterate using while loop
        int index = 0;
        while (index < accounts.length) {
            accounts[index].displayAccount();
            index++;
        }
    }
}
