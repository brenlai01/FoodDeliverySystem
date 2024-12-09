package Models;

public class Vendor extends User{
    
    private double balance;
    
    public Vendor(String usr, String pw, String uid, double balance) {
        super(usr, pw, uid);
        this.setBalance(balance);
    }
    
    
    
    @Override
    public double getBalance(){
        return balance;
    }
    
    @Override
    public void setBalance(double balance){
        this.balance = balance;
    }
    
}
