package Records;


public class OrderItem {
    
    private String foodName;
    private int quantity;
    private double price;
    
    public OrderItem(String foodName, int quantity, double price) {
        this.setFoodName(foodName);
        this.setQuantity(quantity);
        this.setPrice(price);
    }
    
    public String getFoodName() {
        return foodName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setFoodName(String name) {
        this.foodName = name;
    }
    public void setQuantity(int num) {
        this.quantity = num;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return foodName + " X " + quantity + " @ " + price;
    }
}

