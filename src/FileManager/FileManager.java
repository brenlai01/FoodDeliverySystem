// This class includes all methods to read and write data into their respective txt files
// How to call method: FileManager.loadUsers("users.txt"), FileManager.writeUsers("users.txt", users)
package FileManager;
import Enum.TransactionType;
import Models.*;
import Records.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    // Mostly called when a user's detail need to be updated
    // e.g.: 
    //      when customer places an order and their balance needs to be deducted, 
    //      their updated balance needs to updated 
    //      in the txt file so this method is called
    
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
    
    // Method to get current date & time
    // Mostly called for creating order records and creating and updateing delivery records
    public static String getDateTime() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        return now.format(formatter);
    }
    
    // Method to load existing receipts from transaction.txt
    // Only used by Admin TopUp & customer deductCredit
    public static ArrayList<Transaction> loadTxns(String filepath) {
        
        ArrayList<Transaction> txns = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            String line;
            while((line = br.readLine()) != null) {
                
                String[] parts = line.split(":");
                if (parts.length == 5) {
                    String receiptID = parts[0];
                    String customerID = parts[1];
                    TransactionType txnType = TransactionType.valueOf(parts[2]);
                    double topUpAmount =  Double.parseDouble(parts[3]);
                    String dateTime = parts[4];
                    txns.add(new Transaction(receiptID, customerID, txnType, topUpAmount, dateTime));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txns;
    }
    
    // Method to write updated txns ArrayList back into transactions.txt
    public static void writeTxns(String filepath, ArrayList<Transaction> transactions) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            
            for (Transaction txn : transactions) {
                bw.write(txn.toString());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Method used to get current number of txns and add 1 to get a txn for the latest txn
    // I chose to create this method here because it is used in two frames
    public static String getTxnID (ArrayList<Transaction> txns) {
        
        int lastTxnID = 0;
        for (Transaction txn : txns) {
            String txnID = txn.getTxnID();
            int txnNum = Integer.parseInt(txnID.substring(1));
            
            if (txnNum > lastTxnID) {
                lastTxnID = txnNum;
            }
        }
        return "T" + (lastTxnID + 1);
    }
    
    
    // Method to load vendors with cuisineType from cusines.txt
    public static ArrayList<Cuisine> loadCuisines(String filepath) {
        
        ArrayList<Cuisine> cuisines = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            String line;
            while((line = br.readLine()) != null) {
                
                String[] parts = line.split(":");
                if (parts.length == 3) {
                    String vendorID = parts[0];
                    String vendorName = parts[1];
                    String cuisine = parts[2];
                    cuisines.add(new Cuisine(vendorID, vendorName, cuisine));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cuisines;
    }
    
    // Method to write update updated cuisine ArrayList
    public static void writeCuisines(String filepath, ArrayList<Cuisine> cuisines) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            
            for (Cuisine cuisine : cuisines) {
                bw.write(cuisine.toString());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    // Method to load foodItems into ArrayList from foodItems.txt
    public static ArrayList<Food> loadFoodItems(String filepath) {
        
        ArrayList<Food> foodItems = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            String line;
            while((line = br.readLine()) != null) {
                
                String[] parts = line.split(":");
                if (parts.length == 5) {
                    String foodID = parts[0];
                    String vendorID = parts[1];
                    String foodName = parts[2];
                    String description = parts[3];
                    double price = Double.parseDouble(parts[4]);
                    foodItems.add(new Food(foodID, vendorID, foodName, description, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItems;
    } 
    
    // Method to write updated foodItems ArrayList into foodItems.txt
    // public static void writeFoodItems
    
    // Method to load orders into ArrayList from orders.txt
    public static ArrayList<Order> loadOrders(String filepath) {
        
        ArrayList<Order> orders = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            String line;
            while((line = br.readLine()) != null) {
                
                String[] parts = line.split(":");
                
                if (parts.length == 9) {
                    String orderID = parts[0];
                    String customerID = parts[1];
                    String vendorID = parts[2];
                    String itemsOrdered = parts[3]; 
                    String orderType = parts[4];
                    double totalAmount = Double.parseDouble(parts[5]);
                    String dateTime = parts[6];
                    String vendorStatus = parts[7];
                    String deliveryStatus = parts[8];

                    ArrayList<OrderItem> items = parseOrderItems(itemsOrdered);
                    
                    Order order = new Order(orderID, customerID, vendorID, items, orderType, totalAmount, dateTime, vendorStatus, deliveryStatus);

                    orders.add(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
   
    
    private static ArrayList<OrderItem> parseOrderItems(String itemsOrdered) {
        
        ArrayList<OrderItem> items = new ArrayList<>();

        if (itemsOrdered == null || itemsOrdered.isEmpty()) {
            System.out.println("Empty or null itemsOrdered string.");
            return items;
        }

        String[] itemArray = itemsOrdered.split(", "); 

        for (String item : itemArray) {
            System.out.println("Processing item: " + item);

            String[] itemParts = item.split("\\s*[Xx]\\s*|\\s*@\\s*"); 

            if (itemParts.length == 3) {

                String foodName = itemParts[0].trim();
                int quantity = Integer.parseInt(itemParts[1].trim());
                double price = Double.parseDouble(itemParts[2].trim());
                items.add(new OrderItem(foodName, quantity, price));
            }
        }
        return items;
    }

    
    // Method to update order status such as vendorStatus and deliveryStatus
    // This method is called when vendorStatus and deliveryStatus in deliveries.txt needs to be updated
    //e.g.
    //      VendorStatus: Pending -> Accepted/Rejected
    //      deliveryStatus: Unassigned -> Delivering/Delivered
   
    public static void writeOrders(String filepath, ArrayList<Order> orders) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Order order : orders) {
                StringBuilder orderLine = new StringBuilder();

                orderLine.append(order.getOrderID()).append(":")
                         .append(order.getCustomerID()).append(":")
                         .append(order.getVendorID()).append(":");

                ArrayList<OrderItem> items = order.getItems();
                System.out.println("Order items:" + order.getItems());

                for (int i = 0; i < items.size(); i++) {
                    OrderItem item = items.get(i);
                    orderLine.append(item.getFoodName()).append(" X ")
                              .append(item.getQuantity()).append(" @ ")
                              .append(item.getPrice());
                    if (i < items.size() - 1) {
                        orderLine.append(", ");
                    }
                }

                orderLine.append(":").append(order.getOrderType())
                         .append(":").append(order.getTotalAmount())
                         .append(":").append(order.getDateTime())
                         .append(":").append(order.getVendorStatus())
                         .append(":").append(order.getDeliveryStatus());

                bw.write(orderLine.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //this is for load the Cancel Order method
    public static ArrayList<Order> loadCancelOrders(String filepath) {
        ArrayList<Order> orders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 9) { // Ensure it matches the expected number of fields
                    String orderID = data[0];
                    String customerID = data[1];
                    String vendorID = data[2];
                    String[] itemStrings = data[3].split(", "); // Split items by comma
                    ArrayList<OrderItem> items = new ArrayList<>();

                    // Parse each item
                    for (String itemString : itemStrings) {
                        String[] itemData = itemString.split(" X | @ ");
                        String foodName = itemData[0];
                        int quantity = Integer.parseInt(itemData[1]);
                        double price = Double.parseDouble(itemData[2]);
                        items.add(new OrderItem(foodName, quantity, price));
                    }

                    String orderType = data[4];
                    double totalAmount = Double.parseDouble(data[5]);
                    String dateTime = data[6];
                    String vendorStatus = data[7];
                    String deliveryStatus = data[8];

                    // Create a new Order object and add it to the list
                    Order order = new Order(orderID, customerID, vendorID, items, orderType, totalAmount, dateTime, vendorStatus, deliveryStatus);
                    orders.add(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Method for customer to make new order to append to orders.txt
    public static void addNewOrder(String filepath, Order order) {
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
        
            StringBuilder orderLine =  new StringBuilder();
                
            orderLine.append(order.getOrderID()).append(":")
                    .append(order.getCustomerID()).append(":")
                    .append(order.getVendorID()).append(":");
            
            ArrayList<OrderItem> items = order.getItems();
            
            for (int i = 0; i < items.size(); i++) {
                OrderItem item = items.get(i);
                orderLine.append(item.getFoodName()).append(" X ")
                        .append(item.getQuantity()).append(" @ ")
                        .append(item.getPrice());
                if (i < items.size() - 1) {
                    orderLine.append(", ");
                }
            }
            
            orderLine.append(":").append(order.getOrderType())
                    .append(":").append(order.getTotalAmount())
                    .append(":").append(order.getDateTime())
                    .append(":").append(order.getVendorStatus())
                    .append(":").append(order.getDeliveryStatus());
            
            bw.write(orderLine.toString());
            bw.newLine();
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Method to generate a order ID
    public static String generateOrderID(String filepath) {
        int lastOrderID = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length > 0) {
                    String orderID = parts[0];
                    int orderNum = Integer.parseInt(orderID.substring(1));
                    if (orderNum > lastOrderID) {
                        lastOrderID = orderNum;
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "O" + (lastOrderID + 1);
    }
    
    //for reorder part    
    public static void addReOrder(String filepath, String orderDetails) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
            bw.write(orderDetails);
            bw.newLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean updateCustomerBalance(String filepath, String customerID, double amount) {
        // Load the current list of users (which includes customers) from the specified file
        ArrayList<User> users = loadUsers(filepath);
        
        // Iterate through the list of users to find the matching customerID
        for (User  user : users) {
            if (user instanceof Customer && user.getUid().equals(customerID)) {
                Customer customer = (Customer) user; // Cast to Customer
                
                // Use the deductCredit method to update the balance
                if (customer.deductCredit(amount)) {
                    // If the deduction was successful, write the updated users back to the file
                    writeUsers(filepath, users);
                    return true; // Indicate success
                } else {
                    // Handle insufficient balance
                    System.out.println("Insufficient balance for customer: " + customerID);
                    return false; // Indicate failure due to insufficient balance
                }
            }
        }
        return false; // Indicate failure if customer not found
    }
    
    
    // Method to load existing deliveries to an ArrayList from deliveries.txt
    public static ArrayList<Delivery> loadDeliveries(String filepath) {
        ArrayList<Delivery> deliveries = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 10) {
                    String deliveryID = parts[0];
                    String orderID = parts[1];
                    String customerID = parts[2];
                    double deliveryCharges = Double.parseDouble(parts[3]);
                    String address = parts[4];
                    String vendorStatus = parts[5];
                    String runnerStatus = parts[6];
                    String deliveryStatus = parts[7]; 
                    String deliveryRunnerID = parts[8];
                    String deliveredTime = parts[9];
                    deliveries.add(new Delivery(deliveryID, orderID, customerID, deliveryCharges, address, runnerStatus, vendorStatus, deliveryStatus, deliveryRunnerID, deliveredTime));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliveries;
    }
    
    // Method to write updated deliveries ArrayList into deliveries.txt
    // Called when a newly created delivery needs to be written into deliveries.txt
    // or when updated runnerStatus, deliveryStatus and deliveryRunnerID in deliveries.txt
    // e.g. runnerStatus: Unassigned -> Accepted
    public static void appendDeliveries(String filepath, Delivery delivery) {
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
           
            String line = delivery.getDeliveryID() + ":" + delivery.getOrderID() 
                    + ":" + delivery.getCustomerID() + ":" + delivery.getDeliveryCharges() 
                    + ":" + delivery.getAddress() + ":" + delivery.getRunnerStatus()
                    + ":" + delivery.getVendorStatus() + ":" + delivery.getDeliveryStatus() 
                    + ":" + delivery.getDeliveryRunnerID() + ":" + delivery.getDeliveredTime();
            bw.write(line);
            bw.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    // Method to generate new DeliveryID
    public static String generateDeliveryID() {
    
        ArrayList<Delivery> deliveries = FileManager.loadDeliveries("deliveries.txt");
        int lastDeliveryID = 0;
        
        for (Delivery delivery : deliveries) {
            String deliveryID = delivery.getDeliveryID();
            int deliveryNum = Integer.parseInt(deliveryID.substring(2));
            
            if (deliveryNum > lastDeliveryID) {
                lastDeliveryID = deliveryNum;
            }
        }
        return "DL" + (lastDeliveryID + 1);
    }
    
    // Method to write the updated deliveries ArrayList into deliveries.txt
    public static void writeDeliveries(String filepath, ArrayList<Delivery> deliveries) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Delivery delivery : deliveries) {
                String line = delivery.getDeliveryID() + ":" + delivery.getOrderID() 
                        + ":" + delivery.getCustomerID() + ":" + delivery.getDeliveryCharges() 
                        + ":" + delivery.getAddress() + ":" + delivery.getRunnerStatus()
                        + ":" + delivery.getVendorStatus() + ":" + delivery.getDeliveryStatus() 
                        + ":" + delivery.getDeliveryRunnerID() + ":" + delivery.getDeliveredTime();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method to load existing notifications
    public static ArrayList<Notification> loadNotifications(String filepath) {
        
        ArrayList<Notification> notifications = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 5) {
                    String notificationID = parts[0];
                    String customerID = parts[1];
                    String message = parts[2];
                    String dateTime = parts[3];
                    String status = parts[4];

                    Notification notification = new Notification(notificationID, customerID, message, dateTime, status);
                    notifications.add(notification);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notifications;
    }
    
    // Method to write notifications
    public static void writeNotifications(String filepath, ArrayList<Notification> notifications) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Notification notification : notifications) {
                String line = String.join(":", 
                    notification.getNotificationID(),
                    notification.getUserID(),
                    notification.getMessage(),
                    notification.getDateTime(),
                    notification.getStatus()
                );
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    // Method to generate notificationID
    public static String getNotificationID(ArrayList<Notification> notifications) {
        int lastID = 0;
        for (Notification notification : notifications) {
            String notificationID = notification.getNotificationID();
            int idNum = Integer.parseInt(notificationID.substring(1));
            if (idNum > lastID) {
                lastID = idNum;
            }
        }
        return "N" + (lastID + 1);
    }
    
    //Complaint part
    //Method to load complaints from complaints.txt
    public static ArrayList<Complaint> LoadComplaints(String filepath){
        
        ArrayList<Complaint> complaints = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(":");
                if (parts.length == 6){
                    String customerID = parts[0];
                    String complaintID = parts[1];
                    String uniID = parts[2];
                    String complaintInfo = parts[3];
                    String managerReply = parts[4];
                    String complaintStatus = parts [5];
                    
                    complaints.add(new Complaint(customerID, complaintID, uniID, 
                            complaintInfo, managerReply, complaintStatus));
                }
            }
        }catch(IOException e){
            e.printStackTrace(); //handle file read errors
        }
        return complaints;
    }
    
    //Method to write complaints to complaints.txt
    public static void writeComplaints(String filepath,ArrayList<Complaint>complaints){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))){
            for (Complaint complaint : complaints){
                bw.write(complaint.toString());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static Complaint submitComplaint(String customerID, String complaintInfo, String filepath) {
        String complaintID = getComplaintIDForCustomer(customerID, filepath);
        String uniID = generateUniqueComplaintID(filepath);
        String managerReply = ""; // Initialize manager reply as empty
        String complaintStatus = "Pending"; // Set initial status to Pending

        // Create a new complaint
        Complaint newComplaint = new Complaint(customerID, complaintID, uniID, complaintInfo, managerReply, complaintStatus);

        // Load existing complaints
        ArrayList<Complaint> allComplaints = LoadComplaints(filepath);
        allComplaints.add(newComplaint); // Add the new complaint to the list

        // Write all complaints back to the file
        writeComplaints(filepath, allComplaints);

        return newComplaint; // Return the newly created complaint
    }
    
    //Check complaintID exist or not
    public static String getComplaintIDForCustomer(String customerID, String filepath){
        ArrayList<Complaint> complaints = LoadComplaints(filepath);
        for (Complaint complaint : complaints){
            if (complaint.getCustomerID().equals(customerID)){
                return complaint.getComplaintID(); //Return existing complaintID
            } 
        }
        return generateNewComplaintID(filepath); //Generate new ID if not exist
    }
    
    //Generate new complaintID
    private static String generateNewComplaintID(String filepath){
        ArrayList<Complaint> complaints = LoadComplaints(filepath);
        int maxID = 0;
        
        for(Complaint complaint : complaints){
            String complaintID = complaint.getComplaintID();
            if (complaintID.startsWith("CP")){
                int id = Integer.parseInt(complaintID.substring(2)); //Exracr numeric part of ID
                if (id > maxID){
                    maxID = id; // Find the maximum ID
                }
            }
        }
        return "CP" + String.format("%02d", maxID + 1); // Generate new ID
    }
    
    public static String generateUniqueComplaintID(String filepath) {
        ArrayList<Complaint> complaints = LoadComplaints(filepath);
        int maxID = 0;
        
        for(Complaint complaint : complaints){
            String uniID = complaint.getUniID();
            if (uniID.startsWith("CU")){
                int id = Integer.parseInt(uniID.substring(2)); //Exracr numeric part of ID
                if (id > maxID){
                    maxID = id; // Find the maximum ID
                }
            }
        }
        return "CU" + String.format("%02d", maxID + 1); // Generate new ID
    }
    
    //Review part
    //Load review function
    public static ArrayList<Review> loadReviews(String filepath) {
        ArrayList<Review> reviews = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 5) {
                    String customerID = parts[0];
                    String reviewID = parts[1];
                    String vendorID = parts[2];
                    String orderID = parts[3];
                    String reviewInfo = parts[4];

                    reviews.add(new Review(customerID, reviewID, vendorID, orderID, reviewInfo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    
    //write review function
    public static void writeReviews(String filepath, ArrayList<Review> reviews) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Review review : reviews) {
                bw.write(review.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void addNewReview(String filepath, Review review) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
            // Write the review to the file
            bw.write(review.toString());
            bw.newLine(); // Add a new line after the review
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for any IO exceptions
        }
    }
    
    // Check reviewID exists or not
    public static String getReviewIDForCustomer(String customerID, String filepath) {
        ArrayList<Review> reviews = loadReviews(filepath); // Load existing reviews
        for (Review review : reviews) {
            if (review.getCustomerID().equals(customerID)) {
                return review.getReviewID(); // Return existing reviewID
            }
        }
        return generateNewReviewID(filepath); // Generate new ID if not exist
    }
    
    // Generate new reviewID
    private static String generateNewReviewID(String filepath) {
        ArrayList<Review> reviews = loadReviews(filepath);
        int maxID = 0;

        for (Review review : reviews) {
            String reviewID = review.getReviewID();
            if (reviewID.startsWith("RV")) { // Assuming review IDs start with 'RV'
                int id = Integer.parseInt(reviewID.substring(2)); // Extract numeric part of ID
                if (id > maxID) {
                    maxID = id; // Find the maximum ID
                }
            }
        }
        return "RV" + String.format("%02d", maxID + 1); // Generate new ID
    }
    

    
    
}    