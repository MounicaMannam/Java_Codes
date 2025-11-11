// Week4/Day1/InheritanceDemo.java
class Account {
    protected int accountId;
    protected String accountHolder;
    protected double balance;

    public Account(int accountId, String accountHolder, double balance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds! Current Balance: " + balance);
        }
    }

    public void display() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount inherits from Account
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountId, String accountHolder, double balance, double interestRate) {
        super(accountId, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }

    @Override
    public void display() {
        System.out.println("\n--- Savings Account ---");
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount inherits from Account
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
            System.out.println(amount + " withdrawn (with overdraft). New Balance: " + balance);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }

    @Override
    public void display() {
        System.out.println("\n--- Checking Account ---");
        super.display();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount(1001, "Mounica", 5000, 5.0);
        CheckingAccount c1 = new CheckingAccount(2001, "Roshan", 3000, 1000);

        s1.display();
        s1.addInterest();

        c1.display();
        c1.withdraw(3500);
        c1.withdraw(500);
    }
}
