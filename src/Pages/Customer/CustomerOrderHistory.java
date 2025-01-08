/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Customer;

import FileManager.*;
import static FileManager.FileManager.*;
import Records.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CustomerOrderHistory extends javax.swing.JFrame {

    /**
     * Creates new form CustomerReview
     */
    public CustomerOrderHistory() {
        initComponents();
        OrderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderHistoryTableMouseClicked(evt);
            }
        });
        CustomerIDLabel.setText("Customer ID: " + CurrentUser.getLoggedInUser().getUid());
        refreshData();
    }
    
    private void OrderHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow != -1) {
            ReviewTextArea.setText((String) OrderHistoryTable.getValueAt(selectedRow, 4));
        }
    }
    
    public void refreshData() {
        try {
            DefaultTableModel model = (DefaultTableModel) OrderHistoryTable.getModel();
            model.setRowCount(0); // Clear existing data
            
            String orderFile = "orders.txt";
            String reviewFile = "review.txt";
            FileReader fr = new FileReader(orderFile);
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            String loggedInCustomerId = CurrentUser .getLoggedInUser ().getUid(); // Get the logged-in customer ID
            
            ArrayList<Review> reviews = FileManager.loadReviews(reviewFile); // Load reviews from the reviews file
            
            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length == 9) { // Ensure it matches the expected number of fields in orders.txt
                    if (data[1].equals(loggedInCustomerId)) { // Check if the order belongs to the logged-in customer
                        String orderID = data[0]; // Assuming orderID is the first field
                        String reviewInfo = ""; // Default to empty string
                        
                        // Find the review for this order
                        for (Review review : reviews) {
                            if (review.getOrderID().equals(orderID)) {
                                reviewInfo = review.getReviewInfo(); // Get the review info
                                break; // Exit the loop once the review is found
                            }
                        }
                        
                        String[] orderData = {
                            data[3], // Food Name
                            data[5], // Price
                            data[4], // Order Type
                            data[6],  // Order Date
                            reviewInfo,
                            data[2], //vendor ID (not display)
                            data[0]
                        };
                        model.addRow(orderData);
                    }
                }
            }
             br.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading order data: " + e.getMessage());
        }
    }
    
    // Method to load reviews from the reviews.txt file
//    private ArrayList<Review> loadReviews(String filepath) {
//        ArrayList<Review> reviewsList = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(":");
//                if (parts.length == 5) { // Assuming the format is customerID:reviewID:vendorID:orderID:reviewInfo
//                    String customerID = parts[0];
//                    String reviewID = parts[1];
//                    String vendorID = parts[2];
//                    String orderID = parts[3];
//                    String reviewInfo = parts[4];
//                    reviewsList.add(new Review(customerID, reviewID, vendorID, orderID, reviewInfo)); // Add to the list
//                }
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Error reading review data: " + e.getMessage());
//        }
//        return reviewsList; // Return the list of reviews
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrderHistoryLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        OrderHistoryLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderHistoryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReviewTextArea = new javax.swing.JTextArea();
        ReviewLabel = new javax.swing.JLabel();
        ReorderButton = new javax.swing.JButton();
        SubmitReviewButton = new javax.swing.JButton();
        DeleteReviewButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        CustomerIDLabel = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();

        OrderHistoryLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        OrderHistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderHistoryLabel.setText("Order History");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrderHistoryLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        OrderHistoryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderHistoryLabel1.setText("Order History");

        OrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Price", "Order Type", "Order Time", "Vendor Status", "Review", "Vendor ID", "Order ID"
            }
        ));
        jScrollPane1.setViewportView(OrderHistoryTable);
        if (OrderHistoryTable.getColumnModel().getColumnCount() > 0) {
            OrderHistoryTable.getColumnModel().getColumn(1).setMinWidth(80);
            OrderHistoryTable.getColumnModel().getColumn(1).setMaxWidth(80);
            OrderHistoryTable.getColumnModel().getColumn(2).setMinWidth(150);
            OrderHistoryTable.getColumnModel().getColumn(2).setMaxWidth(150);
            OrderHistoryTable.getColumnModel().getColumn(3).setMinWidth(170);
            OrderHistoryTable.getColumnModel().getColumn(3).setMaxWidth(170);
            OrderHistoryTable.getColumnModel().getColumn(5).setMinWidth(300);
            OrderHistoryTable.getColumnModel().getColumn(5).setMaxWidth(300);
            OrderHistoryTable.getColumnModel().getColumn(6).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(6).setMaxWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        ReviewTextArea.setColumns(20);
        ReviewTextArea.setRows(5);
        jScrollPane2.setViewportView(ReviewTextArea);

        ReviewLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        ReviewLabel.setText("Review:");

        ReorderButton.setText("Reorder");
        ReorderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReorderButtonActionPerformed(evt);
            }
        });

        SubmitReviewButton.setText("Submit");
        SubmitReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitReviewButtonActionPerformed(evt);
            }
        });

        DeleteReviewButton.setText("Delete");
        DeleteReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteReviewButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Return");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        CustomerIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CustomerIDLabel.setText("Customer ID:");

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderHistoryLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CustomerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(504, 504, 504)
                                        .addComponent(ReorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ReviewLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(DeleteReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                        .addComponent(SubmitReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OrderHistoryLabel1)
                .addGap(22, 22, 22)
                .addComponent(CustomerIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ReviewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReorderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReorderButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        
        // Check if a row is selected
        if (selectedRow != -1) {
            // Retrieve order details from the selected row
            String foodName = (String) OrderHistoryTable.getValueAt(selectedRow, 0);
            String priceString = (String) OrderHistoryTable.getValueAt(selectedRow, 1);
            double price = Double.parseDouble(priceString);
            String orderType = (String) OrderHistoryTable.getValueAt(selectedRow, 2);
            String originalOrderTime = (String) OrderHistoryTable.getValueAt(selectedRow, 3);
            String customerID = CurrentUser .getLoggedInUser ().getUid();
            String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 5);
            String vendorStatus = "Pending";
            String deliveryStatus = "Unassigned";
            String orderID = FileManager.getReOrderID("orders.txt");
            //Get current date and time
            String newOrderTime = FileManager.getDateTime();
            
            
            String newOrder = String.format("%s:%s:%s:%s:%s:%.1f:%s:%s:%s",
                    orderID,
                    customerID,
                    vendorID,
                    foodName,
                    orderType,
                    price,
                    newOrderTime,
                    vendorStatus,
                    deliveryStatus);
            
            // Update customer balance
            FileManager.updateCustomerBalance("orders.txt", CurrentUser .getLoggedInUser ().getUid(), price);
            
            // Append the new order to the orders.txt file
            FileManager.addReOrder("orders.txt", newOrder);

            // Show a success message to the user
            JOptionPane.showMessageDialog(null, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Show an error message if no order is selected
            JOptionPane.showMessageDialog(null, "Please select an order to reorder.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        refreshData();
    }//GEN-LAST:event_ReorderButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        new CustomerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void SubmitReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitReviewButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to review.");
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 6); // Assuming order ID is in the first column
        String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 5); // Assuming vendor ID is in the fifth column
        String reviewInfo = ReviewTextArea.getText(); // Assuming you have a JTextArea named reviewTextArea
        String customerID = CurrentUser .getLoggedInUser ().getUid();
    
        if (reviewInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Review cannot be empty.");
            return;
        }

        // Check if a review already exists for this order
        ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
        boolean reviewExists = false;

        for (Review review : reviews) {
            if (review.getOrderID().equals(orderID) && review.getCustomerID().equals(customerID)) {
                // Update existing review
                review.setReviewInfo(reviewInfo);
                reviewExists = true;
                break;
            }
        }

        if (reviewExists) {
            // Update the review in the file
            FileManager.writeReviews("review.txt", reviews);
            JOptionPane.showMessageDialog(this, "Review updated successfully.");
            ReviewTextArea.setText("");
        } else {
            // Create a new review
            String reviewID = FileManager.getReviewIDForCustomer(customerID, "review.txt"); // Get or generate review ID
            Review newReview = new Review(customerID, reviewID, vendorID, orderID, reviewInfo);
            FileManager.addNewReview("review.txt", newReview);
            JOptionPane.showMessageDialog(this, "Review submitted successfully.");
            ReviewTextArea.setText("");
        }

    refreshData();
    }//GEN-LAST:event_SubmitReviewButtonActionPerformed

    private void DeleteReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteReviewButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to delete the review.");
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 6); // Assuming order ID is in the first column
        String customerID = CurrentUser .getLoggedInUser ().getUid();

        // Load existing reviews
        ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
        boolean reviewFound = false;

        for (Review review : reviews) {
            if (review.getOrderID().equals(orderID) && review.getCustomerID().equals(customerID)) {
                reviews.remove(review); // Remove the review
                reviewFound = true;
                break;
            }
        }

        if (reviewFound) {
            // Write the updated reviews back to the file
            FileManager.writeReviews("review.txt", reviews);
            JOptionPane.showMessageDialog(this, "Review deleted successfully.");
            ReviewTextArea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No review found for this order.");
        }

        refreshData();
    }//GEN-LAST:event_DeleteReviewButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        SubmitReviewButtonActionPerformed(evt);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerOrderHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerIDLabel;
    private javax.swing.JButton DeleteReviewButton;
    private javax.swing.JLabel OrderHistoryLabel;
    private javax.swing.JLabel OrderHistoryLabel1;
    private javax.swing.JTable OrderHistoryTable;
    private javax.swing.JButton ReorderButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel ReviewLabel;
    private javax.swing.JTextArea ReviewTextArea;
    private javax.swing.JButton SubmitReviewButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
