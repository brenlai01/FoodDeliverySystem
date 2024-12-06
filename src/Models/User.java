package Models;

public class User {
    private String uid;
    private String username;
    private String password;
    
    public User(String uid, String usr, String pw){
        this.setUsername(usr);
        this.setPassword(pw);
        this.setUID(uid);
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String usr){
        this.username = usr;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String pw){
        this.password = pw;
    }
    
    public String getUid(){
        return uid;
    }
    public void setUID(String uid){
        this.uid = uid;
    }
    
    public double getBalance() {
        return 0.0; // Default balance for Admin & Manager in users.txt
    }
}
