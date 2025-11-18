import java.io.*;
import java.util.*;

class Account {
    protected String holderName;
    protected double balance;

    public Account(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + " to " + holderName);
    }

    public void withdraw(double amount) {
        System.out.println("Withdraw method should be overridden in subclasses.");
    }

    public void display() {
        System.out.println(holderName + "  Balance: " + balance);
    }

    public String getAccountInfo() {
        return this.getClass().getSimpleName() + "," + holderName + "," + balance;
    }
}


class SavingsAccount extends Account {
    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance in Savings.");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings");
        }
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + 500) {  
            System.out.println("Overdraft limit exceeded in Checking.");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Checking");
        }
    }
}


public class Week4Test {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("Alice", 4000));
        accounts.add(new CheckingAccount("Bob", 3000));

        for (Account acc : accounts) {
            acc.deposit(1000);
            acc.withdraw(3500);
            acc.display();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (Account acc : accounts) {
                writer.write(acc.getAccountInfo());
                writer.newLine();
            }
            System.out.println("Accounts saved to accounts.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            System.out.println("\nLoaded Accounts:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Here -> " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}