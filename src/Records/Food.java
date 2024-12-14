package Records;


public class Food {
    private String foodID;
    private String vendorID;
    private String foodName;
    private String description;
    private double price;
    
    public Food(String fid, String vid, String foodName, String description, double price){
        this.setFoodID(fid);
        this.setVendorID(vid);
        this.setFoodName(foodName);
        this.setDesciption(description);
        this.setPrice(price);
    }
    
    public String getFoodID() {
        return foodID;
    }
    public void setFoodID(String fid){
        this.foodID = fid;
    }
    
    public String getVendorID() {
        return vendorID;
    }
    public void setVendorID(String vid){
        this.vendorID = vid;
    }
    
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDesciption(String description){
        this.description = description;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
