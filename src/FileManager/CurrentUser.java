// This class is used to make sure each frame knows what type of user is logged in by calling getLoggedInUser() method
/* Make sure the frame includes this at the start of the program
Example using admin:

    private Admin admin;
    
    public AdminFrame() {
        this.admin = (Admin) CurrentUser.getLoggedInUser();
        initComponents();
    }
*/

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
