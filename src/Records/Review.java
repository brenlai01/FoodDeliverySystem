package Records;

public class Review {

    private String customerID;
    private String reviewID;
    private String vendorID;
    private String orderID; // New field for order ID
    private String orderReview; // Review for order (Only vendor can see)
    private int orderRating; // 1 to 5 stars
    private String deliveryID;
    private String deliveryReview; // Review for deliveryRunner (Only runner can see) Manager can see both
    private int deliveryRating;
     
    
    public Review(String customerID, String reviewID, String vendorID, String orderID, String orderReview, int orderRating, 
            String deliveryID, String deliveryReview, int deliveryRating) {
        
        this.customerID = customerID;
        this.reviewID = reviewID;
        this.vendorID = vendorID;
        this.orderID = orderID; // Initialize order ID
        this.deliveryID = deliveryID;
        this.orderReview = orderReview;
        this.orderRating = orderRating;
        this.deliveryReview = deliveryReview;
        this.deliveryRating = deliveryRating;
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
    
    public String getDeliveryID() {
        return deliveryID;
    }

    public String getOrderReview() {
        return orderReview;
    }

    public String getDeliveryReview() {
        return deliveryReview;
    }

    public int getOrderRating() {
        return orderRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }
    
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setOrderReview(String orderReview) {
        this.orderReview = orderReview;
    }

    public void setDeliveryReview(String deliveryReview) {
        this.deliveryReview = deliveryReview;
    }

    public void setOrderRating(int orderRating) {
        this.orderRating = orderRating;
    }

    public void setDeliveryRating(int deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    @Override
    public String toString() {
        return customerID + ":" + reviewID + ":" + vendorID + ":" + orderID + ":"  + orderReview + ":" + orderRating + ":" + deliveryID + ":" + deliveryReview + ":" + deliveryRating;
    }    
}
