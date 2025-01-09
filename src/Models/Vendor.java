package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    
        public static boolean removeDeliveryTask(String orderID) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("deliveries.txt"))) {
            StringBuilder updatedDeliveries = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length == 10) {
                    if (!data[1].equals(orderID)) {
                        updatedDeliveries.append(line).append("\n");
                    } else {
                        found = true;
                    }
                }
            }

            if (found) {
                try (FileWriter fw = new FileWriter("deliveries.txt")) {
                    fw.write(updatedDeliveries.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }
    
    public static boolean acceptDeliveryTask(String orderID, String newStatus) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("deliveries.txt"))) {
            StringBuilder updatedDeliveries = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length == 10) {
                    if (data[1].equals(orderID)) {
                        data[5] = newStatus;
                        line = String.join(":", data);
                        found = true;
                    }
                    updatedDeliveries.append(line).append("\n");
                }
            }

            if (found) {
                try (FileWriter fw = new FileWriter("deliveries.txt")) {
                    fw.write(updatedDeliveries.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }
    
    public static void refundUserAmount(String customerID, String dateTime) {
        double amountToRefund = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 4 && data[1].equals(customerID) && data[4].equals(dateTime)) {
                    amountToRefund = Double.parseDouble(data[3]);
                    System.out.println(amountToRefund);
                    break;
                }

            }
        } catch (IOException e) {
            System.err.println("Error reading transactions: " + e.getMessage());
            return;
        }

        // Step 2: Update the user's balance in users.txt
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            StringBuilder updatedUsers = new StringBuilder();
            String line;
            boolean userFound = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 5) { // Assuming user data has at least 5 fields
                    if (data[1].equals(customerID)) { // Check if this is the user we want to update
                        double currentBalance = Double.parseDouble(data[4]); // Balance is at index 4
                        currentBalance += amountToRefund; // Add the refund amount to the current balance
                        data[4] = String.valueOf(currentBalance); // Update the balance in the array
                        userFound = true; // Mark that we found the user
                    }
                }
                updatedUsers.append(String.join(":", data)).append("\n");
            }

            if (userFound) {
                try (FileWriter fw = new FileWriter("users.txt")) {
                    fw.write(updatedUsers.toString());
                }
                System.out.println("User's balance has been updated successfully.");
            } else {
                System.err.println("User ID not found for refund.");
            }
        } catch (IOException e) {
            System.err.println("Error updating user balance: " + e.getMessage());
        }
    }
    
}
