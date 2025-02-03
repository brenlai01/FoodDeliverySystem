package Pages.Customer;

import Enum.TransactionType;
import FileManager.*;
import Models.Customer;
import Models.User;
import Records.*;
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

            String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 0);
            
            selectedOrderID.setText(orderID);
            selectedOrderID.setEditable(false);
            
        }
    }
    
    public void refreshData() {
        try {
            DefaultTableModel model = (DefaultTableModel) OrderHistoryTable.getModel();
            model.setRowCount(0); // Clear existing data

            String orderFile = "orders.txt";
            FileReader fr = new FileReader(orderFile);
            BufferedReader br = new BufferedReader(fr);
            String read;

            String loggedInCustomerId = CurrentUser .getLoggedInUser ().getUid(); // Get the logged-in customer ID

            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length == 9) { // Ensure it matches the expected number of fields in orders.txt
                    if (data[1].equals(loggedInCustomerId)) { // Check if the order belongs to the logged-in customer
                        String orderID = data[0]; // Assuming orderID is the first field

                        
                        String formattedPrice = String.format("%.2f", Double.parseDouble(data[5]));

                        String[] orderData = {
                            data[0],  // Order ID
                            data[3], // Food Name
                            formattedPrice, // Price
                            data[4], // Order Type
                            data[6], // Order Date
                            data[7], // Vendor Status
                            data[8], // Delivery  Status
                            data[2] // Vendor ID (not displayed)
                            
                        };
                        model.addRow(orderData);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading order data: " + e.getMessage());
        }
        
                // For order rating
        orderRatingStar.addEventStarRating(new EventStarRating() {
            @Override
            public void selected(int star) {
                System.out.println(star);
            }
        });
        // For delivery rating
        deliveryRatingStar.addEventStarRating(new EventStarRating() {
            @Override
            public void selected(int star) {
                System.out.println(star);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ReorderButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        BalanceLabel = new javax.swing.JLabel();
        OrderHistoryLabel1 = new javax.swing.JLabel();
        ReturnButton = new javax.swing.JButton();
        CustomerIDLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderHistoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        selectedOrderID = new javax.swing.JFormattedTextField();
        orderRatingStar = new Pages.Customer.StarRating();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderReviewText = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        deliveryReviewText = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        deliveryRatingStar = new Pages.Customer.StarRating();
        jLabel8 = new javax.swing.JLabel();
        submitReview = new javax.swing.JButton();
        clearReview = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 800));

        ReorderButton.setText("Reorder");
        ReorderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReorderButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        BalanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BalanceLabel.setText("Balance: RM");

        OrderHistoryLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        OrderHistoryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderHistoryLabel1.setText("Order History");

        ReturnButton.setText("Return");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        CustomerIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CustomerIDLabel.setText("Customer ID:");

        OrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Food Name", "Price", "Order Type", "Order Time", "Vendor Status", "Delivery Status", "Vendor ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrderHistoryTable);
        if (OrderHistoryTable.getColumnModel().getColumnCount() > 0) {
            OrderHistoryTable.getColumnModel().getColumn(0).setMinWidth(60);
            OrderHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            OrderHistoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(2).setMinWidth(60);
            OrderHistoryTable.getColumnModel().getColumn(2).setMaxWidth(60);
            OrderHistoryTable.getColumnModel().getColumn(3).setMinWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(3).setMaxWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(4).setMinWidth(130);
            OrderHistoryTable.getColumnModel().getColumn(4).setMaxWidth(130);
            OrderHistoryTable.getColumnModel().getColumn(5).setMinWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(5).setMaxWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(6).setMinWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(6).setMaxWidth(120);
            OrderHistoryTable.getColumnModel().getColumn(7).setMinWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            OrderHistoryTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Selected OrderID");

        selectedOrderID.setPreferredSize(new java.awt.Dimension(70, 22));
        selectedOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedOrderIDActionPerformed(evt);
            }
        });

        jLabel2.setText("How would you rate this order?");

        jLabel3.setText("Provide your feedback.");

        orderReviewText.setColumns(20);
        orderReviewText.setRows(5);
        jScrollPane2.setViewportView(orderReviewText);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Order Review");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Delivery Runner Review");

        deliveryReviewText.setColumns(20);
        deliveryReviewText.setRows(5);
        jScrollPane3.setViewportView(deliveryReviewText);

        jLabel7.setText("Provide your feedback.");

        jLabel8.setText("How would you rate the delivery of this order?");

        submitReview.setText("Submit");
        submitReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReviewActionPerformed(evt);
            }
        });

        clearReview.setText("Clear");
        clearReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearReviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(ReorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 420, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrderHistoryLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(227, 227, 227)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(orderRatingStar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submitReview, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(deliveryRatingStar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearReview))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(OrderHistoryLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CustomerIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BalanceLabel))
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderRatingStar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deliveryRatingStar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearReview)
                    .addComponent(submitReview))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        new CustomerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 0); // Assuming orderID is in the 8th column
        double totalAmount = Double.parseDouble((String) OrderHistoryTable.getValueAt(selectedRow, 2)); // Assuming price is in the 2nd column

        // Load existing orders using loadCancelOrders method
        ArrayList<Order> orders = FileManager.loadOrders("orders.txt");
        System.out.println(orders);
        // Find the order by orderID
        Order orderToCancel = null;
        for (Order order : orders) {
            if (order.getOrderID().equals(orderID)) {
                orderToCancel = order;
                break; // Exit the loop once the order is found
            }
        }
        System.out.println(orderToCancel);
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

                for (Order order : orders) {
                    if (order.getOrderID().equals(orderToCancel.getOrderID())){
                        order.setVendorStatus("Cancelled");
                        break; // Exit the loop once the order is found
                    }
                }
                System.out.println(orders);
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

                // Remove the delivery record if it exists
                if (deliveryToRemove != null) {
                    deliveries.remove(deliveryToRemove); // Remove the matched delivery
                    FileManager.writeDeliveries("deliveries.txt", deliveries); // Write updated deliveries back to the file
                }

                // Create a refund transaction record
                ArrayList<Transaction> txns = FileManager.loadTxns("transactions.txt");

                String customerID = CurrentUser .getLoggedInUser ().getUid();
                String date = FileManager.getDateTime();
                String txnID = FileManager.getTxnID(txns);
                Transaction txn = new Transaction(txnID, customerID, TransactionType.REFUND, totalAmount, date);
                txns.add(txn);
                FileManager.writeTxns("transactions.txt", txns);

                // Create order cancel notification for vendor
                ArrayList<Notification> notifications = FileManager.loadNotifications("notifications.txt");
                String nid = FileManager.getNotificationID(notifications);
                String msg = "A customer has cancel an order. Items " + orderToCancel.getItems().toString();
                Notification notification = new Notification(nid, orderToCancel.getVendorID(), msg, date, "Unread");
                notifications.add(notification);
                FileManager.writeNotifications("notifications.txt", notifications);

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

    private void ReorderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReorderButtonActionPerformed
        int selectedRow = OrderHistoryTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Retrieve order details from the selected row
            String foodName = (String) OrderHistoryTable.getValueAt(selectedRow, 1); // Food Name
            String priceString = (String) OrderHistoryTable.getValueAt(selectedRow, 2); // Price
            double price = Double.parseDouble(priceString);
            String orderType = (String) OrderHistoryTable.getValueAt(selectedRow, 3); // Order Type
            String customerID = CurrentUser .getLoggedInUser ().getUid(); // Get logged-in customer ID
            String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 7); // Vendor ID
            String vendorStatus = "Pending"; // Set initial vendor status
            String deliveryStatus = "Unassigned"; // Set initial delivery status
            String orderID = FileManager.generateOrderID("orders.txt"); // Generate a new order ID
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

                    if(orderType.equalsIgnoreCase("delivery")){

                        String deliveryAddress = JOptionPane.showInputDialog(null, "Please enter delivery address:", "Delivery Address", JOptionPane.QUESTION_MESSAGE);

                        if (deliveryAddress == null || deliveryAddress.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Delivery Address is required.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        ArrayList<Delivery> deliveries = FileManager.loadDeliveries("deliveries.txt");

                        String deliveryID = FileManager.generateDeliveryID();

                        Delivery delivery = new Delivery(deliveryID, orderID, customerID, deliveryCharges, deliveryAddress, "pending", "unassigned", "pending", "N/A", "N/A");
                        FileManager.appendDeliveries("deliveries.txt", delivery);
                    }
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

    private void selectedOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedOrderIDActionPerformed
        
    }//GEN-LAST:event_selectedOrderIDActionPerformed

    private void submitReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReviewActionPerformed

        int selectedRow = OrderHistoryTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to review.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String orderID = (String) OrderHistoryTable.getValueAt(selectedRow, 0); 
        String vendorID = (String) OrderHistoryTable.getValueAt(selectedRow, 7); 
        String orderType = (String) OrderHistoryTable.getValueAt(selectedRow, 3);
        String vendorStatus = (String) OrderHistoryTable.getValueAt(selectedRow, 5);
        String deliveryID = null;
        String deliveryRunnerID = null;
        
        if (vendorStatus.equalsIgnoreCase("Pending") || vendorStatus.equalsIgnoreCase("Cancelled")) {
            JOptionPane.showMessageDialog(this, "You cannot submit a review for orders with 'Pending' or 'Cancelled' status.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<Review> reviews = FileManager.loadReviews("review.txt");
        
        for(Review review : reviews) {
            if(orderID.equals(review.getOrderID())) {
                JOptionPane.showMessageDialog(this, "You have already submitted a review for this order.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        if(orderType.equalsIgnoreCase("delivery")) {
            ArrayList<Delivery> deliveries = FileManager.loadDeliveries("deliveries.txt");
            
            for (Delivery delivery: deliveries) {
                if(orderID.equals(delivery.getOrderID())) {
                    deliveryID = delivery.getDeliveryID();
                    deliveryRunnerID = delivery.getDeliveryRunnerID();
                    break;
                }
            }
        }
        
        String orderReview = orderReviewText.getText().trim(); 
        int orderRating = orderRatingStar.getStar(); // Get rating from the number of stars selected

        if (orderReview.isEmpty() || orderRating == 0) {
            JOptionPane.showMessageDialog(this, "Please provide both a review and a rating for the order.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Get delivery review and rating if applicable
        String deliveryReview = null;
        int deliveryRating = 0;
        
        if (orderType.equalsIgnoreCase("Delivery")) {
            
            deliveryReview = deliveryReviewText.getText().trim();
            deliveryRating = deliveryRatingStar.getStar();

            if (deliveryReview.isEmpty() || deliveryRating == 0) {
                JOptionPane.showMessageDialog(this, "Please provide both a review and a rating for the delivery.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Generate a new review ID
        String reviewID = "R" + (reviews.size() + 1); 

        Review review = new Review(
            CurrentUser.getLoggedInUser().getUid(),
            reviewID,
            vendorID,
            orderID,
            orderReview,
            orderRating,
            deliveryRunnerID,
            deliveryID,
            deliveryReview,
            deliveryRating
        );

        reviews.add(review);
        
        FileManager.writeReviews("review.txt", reviews);

        JOptionPane.showMessageDialog(this, "Review submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Reset the review form
        orderReviewText.setText("");
        orderRatingStar.setStar(0); 
        
        if (deliveryID != null && !deliveryID.isEmpty()) {
            deliveryReviewText.setText("");
            deliveryRatingStar.setStar(0); 
        }

        refreshData();
    }//GEN-LAST:event_submitReviewActionPerformed

    private void clearReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearReviewActionPerformed
        selectedOrderID.setText("");
        orderReviewText.setText("");
        orderRatingStar.setStar(0); 
        deliveryReviewText.setText("");
        deliveryRatingStar.setStar(0); 
    }//GEN-LAST:event_clearReviewActionPerformed

    public static void main(String args[]) {

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
    private javax.swing.JLabel OrderHistoryLabel1;
    private javax.swing.JTable OrderHistoryTable;
    private javax.swing.JButton ReorderButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton clearReview;
    private Pages.Customer.StarRating deliveryRatingStar;
    private javax.swing.JTextArea deliveryReviewText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private Pages.Customer.StarRating orderRatingStar;
    private javax.swing.JTextArea orderReviewText;
    private javax.swing.JFormattedTextField selectedOrderID;
    private javax.swing.JButton submitReview;
    // End of variables declaration//GEN-END:variables
}
