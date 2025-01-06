package Records;
import java.util.ArrayList;

public class Order {
    private String orderID;
    private String customerID;
    private String vendorID;
    private ArrayList<OrderItem> items;
    private String orderType;
    private double totalAmount;
    private String dateTime;
    private String vendorStatus; // Pending -> Accepted/Rejected
    private String deliveryStatus; // Unassigned -> Delivering/Delivered
    
    public Order(String oid, String cid, String vid, ArrayList<OrderItem> items, String orderType, double totalAmount, String dateTime, String vendorStatus, String deliveryStatus) {
        this.setOrderID(oid);
        this.setCustomerID(cid);
        this.setVendorID(vid);
        this.setItems(items);
        this.setOrderType(orderType);
        this.setTotalAmount(totalAmount);
        this.setDateTime(dateTime);
        this.setVendorStatus(vendorStatus);
        this.setDeliveryStatus(deliveryStatus);
    }
    
    public String getOrderID() {
        return orderID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getVendorID() {
        return vendorID;
    }
    public ArrayList<OrderItem> getItems() {
        return items;
    }
    public String getOrderType() {
        return orderType;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public String getDateTime() {
        return dateTime;
    }
    public String getVendorStatus() {
        return vendorStatus;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    
    public void setOrderID(String oid) {
        this.orderID = oid;
    }
    public void setCustomerID(String cid) {
        this.customerID = cid;
    }
    public void setVendorID(String vid) {
        this.vendorID = vid;
    }
    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }
    public void setDateTime(String time) {
        this.dateTime = time;
    }
    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    public void addItems(String foodName, int quantity, double price) {
        items.add(new OrderItem(foodName, quantity, price));
        totalAmount += quantity * price;
    }
}
