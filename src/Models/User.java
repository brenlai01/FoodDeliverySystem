package Models;

public class User {
    private String UID;
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
    public String getPassword(){
        return password;
    }
    public void setUsername(String usr){
        this.username = usr;
    }
    public void setPassword(String pw){
        this.password = pw;
    }
    public void setUID(String uid){
        this.UID = uid;
    }
}
