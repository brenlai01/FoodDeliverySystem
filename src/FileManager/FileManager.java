package FileManager;
import Models.*;
import Records.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    
    // Method used to load all users into their respective types in an ArrayList from users.txt when starting the program
    public static ArrayList<User> loadUsers(String filepath){
        
        ArrayList<User> users = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            
            String line; 
            while ((line = br.readLine()) != null) {
                
                String[] parts = line.trim().split(":");
                
                if (parts.length == 5) {
                    String role = parts[0];
                    String UID = parts[1];
                    String username = parts[2];
                    String password = parts[3];
                    double balance = Double.parseDouble(parts[4]);
                    
                    User user = switch (role.toLowerCase()) {
                        case "admin" -> new Admin(UID, username, password);
                        case "customer" -> new Customer(UID, username, password, balance);
                        case "vendor" -> new Vendor(UID, username, password, balance);
                        case "deliveryrunner" -> new DeliveryRunner(UID, username, password, balance);
                        default -> null;
                    };      
                   
                    if (user != null) {
                        users.add(user);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }
    
    // Method used to write newly created users to users.txt
    public static void writeUsers(String filepath, ArrayList<User> users) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (User user : users) {
                
                String line = user.getClass().getSimpleName().toLowerCase() + ":" +
                        user.getUid() + ":" +
                        user.getUsername() + ":" +
                        user.getPassword() + ":" +
                        user.getBalance();
                
                bw.write(line); // Write new user
                bw.newLine(); // insert \n at the 
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    // Method to load existing receipts from receipts.txt
    public static ArrayList<Transaction> loadReceipts(String filepath) {
        
        ArrayList<Transaction> txns = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            String line;
            while((line = br.readLine()) != null) {
                
                String[] parts = line.split(":");
                if (parts.length == 5) {
                    String receiptID = parts[0];
                    String customerID = parts[1];
                    String txnType = parts[2];
                    double topUpAmount =  Double.parseDouble(parts[3]);
                    String date = parts[4];
                    txns.add(new Transaction(receiptID, customerID, txnType, topUpAmount, date));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txns;
    }
    
    // Method to write receipt ArrayList back into receipts.txt
    public static void writeReceipts(String filepath, ArrayList<Transaction> transactions) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            
            for (Transaction txn : transactions) {
                bw.write(txn.toString());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}


