package Models;
import java.util.ArrayList;

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
            case "delivery runner":
                return new DeliveryRunner(usr, pw, uid, balance);
            case "manager":
                return new Manager(usr, pw, uid);
            default:
                System.out.println("Invalid role specified.");
                return null;
        }
    }
    
    public void topUpCredit(Customer customer, double amount) {
        customer.addCredit(amount);
        System.out.println("Credit topped up successfully for " + customer.getUsername());
    }
    
    public boolean updateUser(ArrayList<User> users, String uid, String newUsername, String newPassword, double newBalance) {
        
        for (User user : users) {
            if (user.getUid().equals(uid)) {
                if (!newUsername.isEmpty()){
                    user.setUsername(newUsername);
                }
                if (!newPassword.isEmpty()) {
                    user.setPassword(newPassword);
                }
                if (newBalance >= 0){
                   user.setBalance(newBalance);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void setBalance(double balance) {
        
    }
}
