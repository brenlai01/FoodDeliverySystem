package Records;

public class FoodImage{
    
    private String foodID;
    private String imageFile;
    
    public FoodImage(String foodID, String imageFile){
        this.foodID = foodID;
        this.imageFile = imageFile;
    }
    
    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getFoodID() {
        return foodID;
    }

    public String getImageFile() {
        return imageFile;
    }
}
