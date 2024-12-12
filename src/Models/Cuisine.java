package Models;

public class Cuisine{
    private String vendorID;
    private String vendorName;
    private String cuisine;
    
    public Cuisine(String vid, String vname, String cuisine) {
        this.setVendorID(vid);
        this.setVendorName(vname);
        this.setCuisine(cuisine);
    }
    
    public String getVendorID(){
        return vendorID;
    }
    public void setVendorID(String vid){
        this.vendorID = vid;
    }
    
    public String getVendorname(){
        return vendorName;
    }
    public void setVendorName(String vname){
        this.vendorName= vname;
    }
    
    public String getCuisine(){
        return cuisine;
    }
    public void setCuisine(String cuisine){
        this.cuisine = cuisine;
    }
    
    @Override
    public String toString(){
        return vendorID + ":" + vendorName + ":" + cuisine;
    }
}
