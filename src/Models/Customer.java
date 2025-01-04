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
        this.complaints = new ArrayList<>(); // Initialize complaints List
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
    
    // Complaint part
    public Complaint submitComplaint(String complaintInfo){
        String complaintID = FileManager.getComplaintIDForCustomer(this.getUid(), "complaint.txt");
        String uniID = FileManager.generateUniqueComplaintID("complaint.txt");
        Complaint newComplaint = new Complaint(this.getUid(), complaintID, uniID, complaintInfo);
        complaints.add(newComplaint); // Add to local complaints list
        ArrayList<Complaint> allComplaints = FileManager.LoadComplaints("complaint.txt"); // Load existing complaints
        allComplaints.add(newComplaint); // Add the new complaint to the list
        FileManager.writeComplaints("complaint.txt", allComplaints); // Save all complaints back to the file
        return newComplaint;
    }
}
