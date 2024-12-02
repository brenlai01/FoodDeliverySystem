package Models;

public class User {
    private String username;
    private String password;
    private String UID;
    
    public User(String usr, String pw, String uid){
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
