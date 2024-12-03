package Models;

public class Customer extends User{
    
    private double balance;
    
    public Customer(String usr, String pw, String uid, double balance) {
        super(usr, pw, uid);
        this.setBalance(balance);
    }
    
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
