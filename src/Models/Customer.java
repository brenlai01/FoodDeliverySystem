package Models;

import Records.*;
import java.util.ArrayList;

public class Customer extends User {
    
    private double balance;
    private ArrayList<Order> orders;
    

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

    public boolean deductCredit(double amount) {
        if (amount > balance) {
            return false;
        } else if (amount > 0) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid amount. Transaction failed.");
            return false;
        }
    }
    
    public ArrayList<Order> getOrderHistory() {
        return orders;
    }
    
    public Order placeOrder(String oid, String cid, String vid, ArrayList<OrderItem> items, double totalAmount, String dateTime, String vendorStatus, String deliveryStatus) {
        Order newOrder = new Order(oid, cid, vid, items, totalAmount, dateTime, vendorStatus, deliveryStatus);
        orders.add(newOrder);
        return newOrder;
    }
    
    
    /*public String writereview(ArrayList <Review> review, String review, String uid){
        
    }*/
}
