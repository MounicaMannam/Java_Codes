// Week4/Day1/AddInterestDemo.java

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
        System.out.println(accountHolder + " deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds! Current balance: $" + balance);
        }
    }

    public void display() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate; // in percentage

    public SavingsAccount(int accountId, String accountHolder, double balance, double interestRate) {
        super(accountId, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // ✅ Add interest method
    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest of $" + String.format("%.2f", interest) + " added. New balance: $" + String.format("%.2f", balance));
    }

    @Override
    public void display() {
        System.out.println("\n--- Savings Account ---");
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class AddInterestDemo {
    public static void main(String[] args) {
        // Create savings account
        SavingsAccount s1 = new SavingsAccount(101, "Mounica", 8000, 5.0);

        s1.display();
        s1.deposit(2000);
        s1.addInterest();  // Apply interest
        s1.withdraw(1500);
        s1.addInterest();  // Apply again to see balance growth
        s1.display();
    }
}
