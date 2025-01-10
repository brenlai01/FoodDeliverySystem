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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderID: ").append(orderID)
          .append(", CustomerID: ").append(customerID)
          .append(", VendorID: ").append(vendorID)
          .append(", Items: [");

        for (OrderItem item : items) {
            sb.append(item.toString()).append(", "); // Assuming OrderItem has a proper toString() method
        }

        // Remove the last comma and space if there are items
        if (!items.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        
        sb.append("], TotalAmount: ").append(totalAmount)
          .append(", VendorStatus: ").append(vendorStatus)
          .append(", DeliveryStatus: ").append(deliveryStatus);
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        Order order = (Order) obj; // Cast to Order
        return orderID.equals(order.orderID); // Compare orderID for equality
    }

    @Override
    public int hashCode() {
        return orderID.hashCode(); // Ensure hashCode is consistent with equals
    }
}
