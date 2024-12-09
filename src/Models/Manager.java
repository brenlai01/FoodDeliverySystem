package Models;

public class Manager extends User{
    public Manager(String usr, String pw, String uid) {
        super(usr, pw, uid);
    }
    
    @Override
    public void setBalance(double balance) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
