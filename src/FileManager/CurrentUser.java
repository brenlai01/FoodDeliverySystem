package FileManager;
import Models.User;

// This class is used to store details of the user logged in currently  
// Used to pass objects from frame to frame
public class CurrentUser {
    
    private static User loggedInUser;
    
    public static void setLoggedInUser(User user){
        loggedInUser = user;
    }
    public static User getLoggedInUser(){
        return loggedInUser;
    }
}
