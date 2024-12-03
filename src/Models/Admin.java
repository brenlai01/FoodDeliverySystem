package Models;

public class Admin extends User{
    
    public Admin(String usr, String pw, String uid){
        super(usr, pw, uid);
    }
    
    public User createUser(String role, String usr, String pw, String uid, double balance){
        switch (role.toLowerCase()){
            case "customer":
                return new Customer(usr, pw, uid, balance);
            case "vendor":
                return new Vendor(usr, pw, uid, balance);
            case "deliveryrunner":
                return new DeliveryRunner(usr, pw, uid, balance);
            case "maanger":
                return new Manager(usr, pw, uid);  
        }
    }
    
}
