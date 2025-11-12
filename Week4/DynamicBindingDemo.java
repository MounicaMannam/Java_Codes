// Week4/Day2/DynamicBindingDemo.java

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
        System.out.println("Generic withdraw method from Account class.");
    }

    public void display() {
        System.out.println("Account ID: " + accountId + " | Holder: " + accountHolder + " | Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accountId, String accountHolder, double balance) {
        super(accountId, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(accountHolder + " (Savings) withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(accountHolder + " (Savings) - Withdrawal denied: must maintain minimum $" + MIN_BALANCE);
        }
    }
}

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
            System.out.println(accountHolder + " (Checking) - Withdrawal denied: overdraft limit exceeded!");
        }
    }
}

public class DynamicBindingDemo {
    public static void main(String[] args) {
        // ✅ Parent class reference → Child class object
        Account acc1 = new SavingsAccount(201, "Mounica", 5000);
        Account acc2 = new CheckingAccount(202, "Roshan", 2000, 1000);

        System.out.println("--- Dynamic Binding Demonstration ---");
        acc1.display();
        acc2.display();

        // ✅ Method call determined at runtime (not compile time)
        acc1.withdraw(4500); // Executes SavingsAccount.withdraw()
        acc2.withdraw(2500); // Executes CheckingAccount.withdraw()

        // ✅ You can also store in an array or loop through accounts polymorphically
        System.out.println("\n--- Looping through accounts (dynamic method dispatch) ---");
        Account[] accounts = {acc1, acc2};

        for (Account acc : accounts) {
            acc.withdraw(300);  // Calls respective overridden method dynamically
        }
    }
}
