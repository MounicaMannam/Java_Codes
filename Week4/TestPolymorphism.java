// Week4/Day2/TestPolymorphism.java

class Account {
    protected int accountId;
    protected String holderName;
    protected double balance;

    public Account(int accountId, String holderName, double balance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        System.out.println("Generic withdraw from Account class.");
    }

    public void display() {
        System.out.println("Account ID: " + accountId + ", Holder: " + holderName + ", Balance: $" + balance);
    }
}

// ✅ Child 1: SavingsAccount
class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accountId, String holderName, double balance) {
        super(accountId, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(holderName + " (Savings) withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println(holderName + " (Savings) - Cannot withdraw below min balance $" + MIN_BALANCE);
        }
    }
}

// ✅ Child 2: CheckingAccount
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountId, String holderName, double balance, double overdraftLimit) {
        super(accountId, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(holderName + " (Checking) withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(holderName + " (Checking) - Overdraft limit exceeded!");
        }
    }
}

// ✅ Test class
public class TestPolymorphism {
    public static void main(String[] args) {

        // Parent references to child objects
        Account a1 = new SavingsAccount(301, "Mounica", 6000);
        Account a2 = new CheckingAccount(302, "Roshan", 2000, 1000);

        System.out.println("--- Testing Polymorphism (Overridden Methods) ---");

        // Call overridden methods
        a1.display();
        a1.withdraw(4500);   // Calls SavingsAccount’s withdraw()
        a1.withdraw(3000);   // Fails due to min balance

        System.out.println();
        a2.display();
        a2.withdraw(2500);   // Calls CheckingAccount’s withdraw()
        a2.withdraw(5000);   // Fails due to overdraft

        System.out.println("\n--- Using array of parent references ---");
        Account[] accounts = { a1, a2 };

        for (Account acc : accounts) {
            acc.display();       // Calls Account.display()
            acc.withdraw(500);   // Calls the respective overridden method dynamically
        }
    }
}
