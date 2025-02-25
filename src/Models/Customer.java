package Models;

import FileManager.FileManager;
import Records.*;
import java.util.ArrayList;

public class Customer extends User {
    private double balance;
    private ArrayList<Order> orders;
    private ArrayList<Complaint> complaints;
    

    public Customer(String uid, String username, String password, double balance) {
        super(uid, username, password);
        this.setBalance(balance);
        this.complaints = new ArrayList<Complaint>(); // Initialize complaints List
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
        
        if (this.getBalance() >= amount) {
            this.setBalance(this.getBalance() - amount);
            return true;
        }
        return false;
    }
    
    public ArrayList<Order> getOrderHistory() {
        return orders;
    }
    
    public Order placeOrder(String oid, String cid, String vid, ArrayList<OrderItem> items, String orderType, double totalAmount, String dateTime, String vendorStatus, String deliveryStatus) {
        Order newOrder = new Order(oid, cid, vid, items, orderType, totalAmount, dateTime, vendorStatus, deliveryStatus);
        orders.add(newOrder);
        return newOrder;
    }
}
