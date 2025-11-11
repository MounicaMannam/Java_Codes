// Week4/Day1/OverrideWithdrawDemo.java

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
            System.out.println(accountHolder + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(accountHolder + " has insufficient funds! Current balance: " + balance);
        }
    }

    public void display() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount overrides withdraw with special rule (minimum balance requirement)
class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(int accountId, String accountHolder, double balance, double interestRate, double minimumBalance) {
        super(accountId, accountHolder, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + " from Savings. New balance: " + balance);
        } else {
            System.out.println("Withdrawal denied! Minimum balance of " + minimumBalance + " must be maintained.");
        }
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ". New balance: " + balance);
    }

    @Override
    public void display() {
        System.out.println("\n--- Savings Account ---");
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}

// CheckingAccount overrides withdraw with overdraft rule
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
            System.out.println(accountHolder + " withdrew " + amount + " (overdraft applied if needed). New balance: " + balance);
        } else {
            System.out.println("Withdrawal denied! Exceeds overdraft limit of " + overdraftLimit);
        }
    }

    @Override
    public void display() {
        System.out.println("\n--- Checking Account ---");
        super.display();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class OverrideWithdrawDemo {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount(101, "Mounica", 8000, 4.5, 2000);
        CheckingAccount c1 = new CheckingAccount(202, "Roshan", 3000, 1000);

        s1.display();
        s1.withdraw(6500);  // Should fail due to min balance rule
        s1.withdraw(5000);  // Should succeed
        s1.addInterest();

        c1.display();
        c1.withdraw(3500);  // Overdraft usage
        c1.withdraw(5000);  // Should fail due to overdraft limit
    }
}
