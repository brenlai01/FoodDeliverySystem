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
    
    public boolean deleteUser(ArrayList<User> users, String uid) {
        
        for (int i = 0; i < users.size() ; i++) {
            User user = users.get(i);
            
            if (user.getUid().equals(uid)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean topUpCredit(ArrayList<User> users, String cid, double amount) {
        
        for (User user : users) {
            if (user instanceof Customer && user.getUid().equals(cid)) {
                Customer customer = (Customer) user;
                double newBalance = customer.getBalance() + amount;
                customer.setBalance(newBalance);
                return true;
            }
        }
        return false;
    }

    @Override
    public void setBalance(double balance) {
        
    }
}
