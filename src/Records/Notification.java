package Records;

public class Notification {
    private String notificationID;
    private String customerID;
    private String message; // For customer: order updates, top up, delivery updates.
    private String dateTime;
    private String status; // read or unread
    
    public Notification(String nid, String cid, String msg, String dateTime, String status) {
        
    }
    
    public String getNotificationID() {
        return notificationID;
    }
    public void setNotificationID(String nid) {
        this.notificationID = nid;
    }
    
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String cid) {
        this.customerID = cid;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String msg) {
        this.message = msg;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
