package Models;

import Records.Review;

public class Customer extends User {
    private double balance;

    public Customer(String uid, String username, String password, double balance) {
        super(uid, username, password);
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void addCredit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credit added successfully. New balance: RM " + balance);
        } else {
            System.out.println("Invalid amount. Credit not added.");
        }
    }

    public boolean deductCredit(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
            return false;
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Credit deducted successfully. Remaining balance: RM " + balance);
            return true;
        } else {
            System.out.println("Invalid amount. Transaction failed.");
            return false;
        }
    }
    
    
    /*public String writereview(ArrayList <Review> review, String review, String uid){
        
    }*/
}
