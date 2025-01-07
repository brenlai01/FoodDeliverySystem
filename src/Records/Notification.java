package Records;

public class Notification {
    private String notificationID;
    private String userID;
    private String message; // For customer: order updates, top up, delivery updates.
    private String dateTime;
    private String status; // read or unread
    
    public Notification(String nid, String uid, String msg, String dateTime, String status) {
        this.setNotificationID(nid);
        this.setUserID(uid);
        this.setMessage(msg);
        this.setDateTime(dateTime);
        this.setStatus(status);
    }
    
    public String getNotificationID() {
        return notificationID;
    }
    public void setNotificationID(String nid) {
        this.notificationID = nid;
    }
    
    public String getUserID() {
        return userID;
    }
    public void setUserID(String cid) {
        this.userID = cid;
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
