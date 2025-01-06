
package Records;

public class Review {
    private String customerID;
    private String reviewID;
    private String vendorID;
    private String orderID; // New field for order ID
    private String reviewInfo;
    
    public Review(String customerID, String reviewID, String vendorID, String orderID, String reviewInfo) {
        this.customerID = customerID;
        this.reviewID = reviewID;
        this.vendorID = vendorID;
        this.orderID = orderID; // Initialize order ID
        this.reviewInfo = reviewInfo;
    }
    
    public String getCustomerID() {
        return customerID;
    }

    public String getReviewID() {
        return reviewID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getOrderID() {
        return orderID; // Getter for order ID
    }

    public String getReviewInfo() {
        return reviewInfo;
    }
    
    public void setReviewInfo(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

    @Override
    public String toString() {
        return customerID + ":" + reviewID + ":" + vendorID + ":" + orderID + ":" + reviewInfo; // Include order ID in string representation
    }    
}
