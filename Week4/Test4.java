import java.io.*;
import java.util.*;

class Account{
    protected String holdername;
    protected double balance;

    public Account(String holdername,double balance){
        this.holdername=holdername;
        this.balance=balance;
     }

    public void deposit(double amount){
        if (amount<=0){
            System.out.println("Deposited amount must be positive.");
        return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + " to " + holdername);
    }

    public void withdraw(double amount){
        System.out.println("withdraw amount comes from the base class");
    }

    public void display(){
        System.out.println("Account Holder:"+holdername);
        System.out.println("Account Balance:"+balance);
    }

    public String getAccount(){

    }
}

class SavingsAccount extends Account(){
    @Override

    public SavingsAccount(String holdername,double balance)
    Super(holdername,balance);

    public void withdraw(double amount){
        if (balance<amount){
            System.out.println("Invalid amount");
        }
        balance =-amount;
        System.out.println(holdername+ "balance"+balance+);
    }
}

class CheckingsAccount extends Account(){
    public CheckingsAccount(String holdername,double balance)
    super(holdername,balance);
}