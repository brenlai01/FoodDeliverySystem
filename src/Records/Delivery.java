package Records;

public class Delivery {
    private String deliveryID;        
    private String orderID;           
    private String customerID;
    private double deliveryCharges;   
    private String address;
    private String vendorStatus;    // Pending -> Accepted/Rejected
    private String runnerStatus;   // Unassigned -> Accepted/ or no change
    private String deliveryStatus;    // Pending -> Assigned/Delivered
    private String deliveryRunnerID;    // N/A -> D001
    private String deliveredTime;
    
public Delivery(String deliveryID, String orderID, String customerID, 
        double deliveryCharges, String address, String runnerStatus, String vendorStatus, 
        String deliveryStatus, String deliveryRunnerID, String deliveredTime) {
    
        this.setDeliveryID(deliveryID);
        this.setOrderID(orderID);
        this.setCustomerID(customerID);
        this.setDeliveryCharges(deliveryCharges);
        this.setAddress(address);
        this.setRunnerStatus(runnerStatus);
        this.setVendorStatus(vendorStatus);
        this.setDeliveryStatus(deliveryStatus);
        this.setDeliveryRunnerID(deliveryRunnerID);
        this.setDeliveredTime(deliveredTime);
    }

    // Getters and Setters
    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDeliveryRunnerID() {
        return deliveryRunnerID;
    }

    public void setDeliveryRunnerID(String deliveryRunnerID) {
        this.deliveryRunnerID = deliveryRunnerID;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(String deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getRunnerStatus() {
        return runnerStatus;
    }

    public void setRunnerStatus(String runnerStatus) {
        this.runnerStatus = runnerStatus;
    }
    
    public String getVendorStatus() {
        return vendorStatus;
    }
    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
    }
}
