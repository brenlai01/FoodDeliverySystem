package Pages.Customer;

import FileManager.*;
import Models.Customer;
import Models.User;
import Records.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomerOrderHistory extends javax.swing.JFrame {

    public CustomerOrderHistory() {
        initComponents();
        OrderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderHistoryTableMouseClicked(evt);
            }
        });
        CustomerIDLabel.setText("Customer ID: " + CurrentUser.getLoggedInUser().getUid());
        BalanceLabel.setText("Balance: RM" + String.format("%.2f", CurrentUser.getLoggedInUser().getBalance()));
        refreshData();
    }
    
    private void OrderHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow != -1) {
            // Retrieve the review from the sixth column (index 6)
            String reviewInfo = (String) OrderHistoryTable.getValueAt(selectedRow, 6);
            ReviewTextArea.setText(reviewInfo); // Show the existing review
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
                        
                        String formattedPrice = String.format("%.2f", Double.parseDouble(data[5]));

                        String[] orderData = {
                            data[3], // Food Name
                            formattedPrice, // Price
                            data[4], // Order Type
                            data[6], // Order Date
                            data[7], // Vendor Status
                            data[8], //Delivery  Status
                            reviewInfo, // Review
                            data[2], // Vendor ID (not displayed)
                            data[0]  // Order ID
                        };
                        model.addRow(orderData);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading order data: " + e.getMessage());
        }
    }

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
        CancelButton = new javax.swing.JButton();
        BalanceLabel = new javax.swing.JLabel();
        UpdateReviewButton = new javax.swing.JButton();

        OrderHistoryLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        OrderHistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderHistoryLabel.setText("Order History");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrderHistoryLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        OrderHistoryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderHistoryLabel1.setText("Order History");

        OrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Price", "Order Type", "Order Time", "Vendor Status", "Delivery Status", "Review", "Vendor ID", "Order ID"
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
            OrderHistoryTable.getColumnModel().getColumn(4).setMinWidth(140);
            OrderHistoryTable.getColumnModel().getColumn(4).setMaxWidth(140);
            OrderHistoryTable.getColumnModel().getColumn(5).setMinWidth(140);
            OrderHistoryTable.getColumnModel().getColumn(5).setMaxWidth(140);
            OrderHistoryTable.getColumnModel().getColumn(6).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(6).setMaxWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setMaxWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(8).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(8).setMaxWidth(0);
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

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        BalanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BalanceLabel.setText("Balance: RM");

        UpdateReviewButton.setText("Update");
        UpdateReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateReviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderHistoryLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(390, 390, 390)
                                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CustomerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addComponent(BalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OrderHistoryLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustomerIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BalanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ReviewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ReorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SubmitReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            String foodName = (String) OrderHistoryTable.getValueAt(selectedRow, 0); // Food Name
            String priceString = (String) OrderHistoryTable.getValueAt(selectedRow, 1); // Price
            double price = Double.parseDouble(priceString);
            String orderType = (String) OrderHistoryTable.getValueAt(selectedRow, 2); // Order Type
            String customerID = CurrentUser .getLoggedInUser ().getUid(); // Get logged-in customer ID
            String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 7); // Vendor ID
            String vendorStatus = "Pending"; // Set initial vendor status
            String deliveryStatus = "Unassigned"; // Set initial delivery status
            String orderID = FileManager.getReOrderID("orders.txt"); // Generate a new order ID
            String newOrderTime = FileManager.getDateTime(); // Get current date and time

            // Initialize delivery charges
            double deliveryCharges = 0.0;

            // If the order type is delivery, set the delivery charges
            if (orderType.equalsIgnoreCase("Delivery")) {
                // Assuming you have a method to get the delivery charges
                deliveryCharges = 5.0; // Replace with actual delivery charge retrieval logic
            }

            // Total amount to deduct from the balance
            double totalAmount = price + deliveryCharges;

            // Check if the customer has enough balance
            Customer customer = (Customer) CurrentUser .getLoggedInUser ();
            if (customer.getBalance() >= totalAmount) {
                // Deduct the amount from the customer's balance
                if (FileManager.updateCustomerBalance("users.txt", customer.getUid(), totalAmount)) {
                    // Create a new order string
                    String newOrder = String.format("%s:%s:%s:%s:%s:%.2f:%s:%s:%s",
                            orderID,
                            customerID,
                            vendorID,
                            foodName,
                            orderType,
                            price,
                            newOrderTime,
                            vendorStatus,
                            deliveryStatus);

                    // Append the new order to the orders.txt file
                    FileManager.addReOrder("orders.txt", newOrder);

                    // Show a success message to the user
                    JOptionPane.showMessageDialog(null, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Update the balance label
                    // Retrieve the updated balance after the deduction
                    double updatedBalance = FileManager.loadUsers("users.txt").stream()
                            .filter(user -> user.getUid().equals(customer.getUid()))
                            .map(User::getBalance)
                            .findFirst()
                            .orElse(0.0);

                    BalanceLabel.setText("Balance: RM" + String.format("%.2f", updatedBalance));
                } else {
                    // Handle the case where the balance could not be updated
                    JOptionPane.showMessageDialog(null, "Failed to place order due to insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Show an error message if the balance is insufficient
                JOptionPane.showMessageDialog(null, "Insufficient balance to place the order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 8); // Assuming order ID is in the eighth column
        String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 7); // Assuming vendor ID is in the seventh column
        String reviewInfo = ReviewTextArea.getText(); // Get the review text
        String customerID = CurrentUser .getLoggedInUser ().getUid();

        // Check the delivery status of the selected order
        String deliveryStatus = (String) OrderHistoryTable.getValueAt(selectedRow, 5); // Assuming delivery status is in the fifth column
        if (!"Delivered".equalsIgnoreCase(deliveryStatus)) {
            JOptionPane.showMessageDialog(this, "You can only submit a review once the order has been delivered.");
            ReviewTextArea.setText(""); // Clear the text area
            return;
        }

        if (reviewInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Review cannot be empty.");
            return;
        }

        // Check if a review already exists for this order
        ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
        boolean reviewExists = false;

        for (Review review : reviews) {
            if (review.getOrderID().equals(orderID) && review.getCustomerID().equals(customerID)) {
                reviewExists = true; // Review exists
                break;
            }
        }

        if (reviewExists) {
            // Inform the user that they can only have one review per order
            JOptionPane.showMessageDialog(this, "You can only submit one review per order. Please update the existing review instead.");
        } else {
            // Create a new review and add it to the list
            Review newReview = new Review(customerID, FileManager.getReviewIDForCustomer(customerID, "review.txt"), vendorID, orderID, reviewInfo);
            reviews.add(newReview); // Add the new review to the list
            FileManager.writeReviews("review.txt", reviews); // Write updated reviews to the file
            JOptionPane.showMessageDialog(this, "Review submitted successfully.");
            ReviewTextArea.setText(""); // Clear the text area
        }

        refreshData(); // Refresh the data to reflect the new review
    }//GEN-LAST:event_SubmitReviewButtonActionPerformed

    private void DeleteReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteReviewButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to delete the review.");
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 8); // Assuming order ID is in the first column
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

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
           JOptionPane.showMessageDialog(this, "Please select an order to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 8); // Assuming orderID is in the 8th column
        double totalAmount = Double.parseDouble((String) OrderHistoryTable.getValueAt(selectedRow, 1)); // Assuming price is in the 2nd column

        // Load existing orders using loadCancelOrders method
        ArrayList<Order> orders = FileManager.loadCancelOrders("orders.txt");

        // Find the order by orderID
        Order orderToCancel = null;
        for (Order order : orders) {
            if (order.getOrderID().equals(orderID)) {
                orderToCancel = order;
                break; // Exit the loop once the order is found
            }
        }

        // Check if the order was found and if it can be canceled
        if (orderToCancel != null) {
            // Check if vendor status is "Pending"
            if (orderToCancel.getVendorStatus().equals("Pending")) {
                // Retrieve the delivery fee from the associated delivery record
                double deliveryFee = 0.0; // Initialize delivery fee
                ArrayList<Delivery> deliveries = FileManager.loadDeliveries("deliveries.txt"); // Load deliveries
                Delivery deliveryToRemove = null; // Initialize delivery to remove

                // Find the delivery associated with the order
                for (Delivery delivery : deliveries) {
                    if (delivery.getOrderID().equals(orderID)) {
                        deliveryFee = delivery.getDeliveryCharges(); // Get the delivery charges
                        deliveryToRemove = delivery; // Mark this delivery for removal
                        break; // Exit the loop once found
                    }
                }

                // Refund the amount to the customer's balance
                Customer customer = (Customer) CurrentUser .getLoggedInUser ();
                double currentBalance = customer.getBalance();
                customer.setBalance(currentBalance + totalAmount + deliveryFee); // Update the customer's balance

                // Remove the order from the list
                orders.remove(orderToCancel); // Remove the matched order

                // Update the orders file
                FileManager.writeOrders("orders.txt", orders);

                // Update the user balance in users.txt
                ArrayList<User> users = FileManager.loadUsers("users.txt");
                for (User  user : users) {
                    if (user instanceof Customer && user.getUid().equals(customer.getUid())) {
                        user.setBalance(customer.getBalance()); // Update the user's balance
                    }
                }
                FileManager.writeUsers("users.txt", users); // Update users file

                // Now remove the associated review
                ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
                reviews.removeIf(review -> review.getOrderID().equals(orderID) && review.getCustomerID().equals(customer.getUid()));
                FileManager.writeReviews("review.txt", reviews); // Write updated reviews back to the file

                // Remove the delivery record if it exists
                if (deliveryToRemove != null) {
                    deliveries.remove(deliveryToRemove); // Remove the matched delivery
                    FileManager.writeDeliveries("deliveries.txt", deliveries); // Write updated deliveries back to the file
                }

                // Clear the ReviewTextArea since the review is removed
                ReviewTextArea.setText("");

                // Show success message
                JOptionPane.showMessageDialog(this, "Order canceled successfully. Refund of RM" + String.format("%.2f", (totalAmount + deliveryFee)) + " has been processed.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Update the balance label
                BalanceLabel.setText("Balance: RM" + String.format("%.2f", customer.getBalance()));

                refreshData(); // Refresh the order history table
            } else {
                JOptionPane.showMessageDialog(this, "Order cannot be canceled as the vendor status is not 'Pending'.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Order not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void UpdateReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateReviewButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to update the review.");
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 8); // Assuming order ID is in the eighth column
        String customerID = CurrentUser .getLoggedInUser ().getUid();
        String reviewInfo = ReviewTextArea.getText(); // Get the review text

        // Check if the review info is empty
        if (reviewInfo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Review cannot be empty.");
            return;
        }

        // Load existing reviews
        ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
        boolean reviewUpdated = false;

        // Iterate through the reviews to find the one to update
        for (Review review : reviews) {
            if (review.getOrderID().equals(orderID) && review.getCustomerID().equals(customerID)) {
                // Update the existing review
                review.setReviewInfo(reviewInfo);
                reviewUpdated = true;
                break;
            }
        }

        if (reviewUpdated) {
            // Write the updated reviews back to the file
            FileManager.writeReviews("review.txt", reviews);
            JOptionPane.showMessageDialog(this, "Review updated successfully.");
            ReviewTextArea.setText(""); // Clear the text area
        } else {
            // Inform the user that no review exists for the selected order
            JOptionPane.showMessageDialog(this, "No existing review found for this order. Please submit a new review instead.");
        }

        refreshData(); // Refresh the data to reflect the updated review
    }//GEN-LAST:event_UpdateReviewButtonActionPerformed

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
    private javax.swing.JLabel BalanceLabel;
    private javax.swing.JButton CancelButton;
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
    private javax.swing.JButton UpdateReviewButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
