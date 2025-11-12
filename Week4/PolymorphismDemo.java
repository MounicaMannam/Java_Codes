// Week4/Day2/PolymorphismDemo.java

class Account {
    protected int accountId;
    protected String accountHolder;
    protected double balance;

    public Account(int accountId, String accountHolder, double balance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance in " + accountHolder + "'s account.");
        }
    }

    public void display() {
        System.out.println("Account ID: " + accountId + " | Holder: " + accountHolder + " | Balance: $" + balance);
    }
}

// ✅ SavingsAccount overrides withdraw() to apply no withdrawal if below minimum balance
class SavingsAccount extends Account {
    private double interestRate;
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accountId, String accountHolder, double balance, double interestRate) {
        super(accountId, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(accountHolder + " (Savings) withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Withdrawal denied for " + accountHolder + ": minimum balance of $" + MIN_BALANCE + " must be maintained.");
        }
    }
}

// ✅ CheckingAccount overrides withdraw() to allow overdraft up to a limit
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountId, String accountHolder, double balance, double overdraftLimit) {
        super(accountId, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " (Checking) withdrew $" + amount + ". Balance after overdraft: $" + balance);
        } else {
            System.out.println("Withdrawal denied for " + accountHolder + ": overdraft limit exceeded!");
        }
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Create different account types
        Account acc1 = new SavingsAccount(101, "Mounica", 5000, 4.5);
        Account acc2 = new CheckingAccount(102, "Roshan", 2000, 1000);

        // ✅ Demonstrate polymorphism
        System.out.println("\n--- Demonstrating Polymorphism ---");
        acc1.display();
        acc2.display();

        // Both calls use the same method name, but behavior differs!
        acc1.withdraw(4500);  // SavingsAccount rule applies (checks min balance)
        acc2.withdraw(2500);  // CheckingAccount rule applies (allows overdraft)
    }
}
