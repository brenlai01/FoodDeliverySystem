/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.DeliveryRunner;

import FileManager.*;
import Records.Notification;
import Records.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vreesa
 */
public class UpdateStatus extends javax.swing.JFrame {

    public UpdateStatus() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Exitbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tasktbl = new javax.swing.JTable();
        Exitbtn1 = new javax.swing.JButton();
        Refreshbtn = new javax.swing.JButton();
        UpdateStatusbtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("STIX Two Text", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(42, 49, 129));
        jLabel1.setText("Current Task :");

        Exitbtn.setBackground(new java.awt.Color(225, 237, 243));
        Exitbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Exitbtn.setForeground(new java.awt.Color(42, 49, 129));
        Exitbtn.setText("exit");
        Exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("STIX Two Text", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Current Task :");

        Tasktbl.setBackground(new java.awt.Color(227, 244, 227));
        Tasktbl.setFont(new java.awt.Font("STIX Two Text", 0, 13)); // NOI18N
        Tasktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DeliveryID", "OrderID", "CustomerID", "Commision(RM)", "Address", "VendorStatus", "Status", "Completion Status", "DriverID", "Delivery Time"
            }
        ));
        jScrollPane2.setViewportView(Tasktbl);

        Exitbtn1.setBackground(new java.awt.Color(51, 35, 0));
        Exitbtn1.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Exitbtn1.setForeground(new java.awt.Color(255, 255, 255));
        Exitbtn1.setText("Exit");
        Exitbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exitbtn1ActionPerformed(evt);
            }
        });

        Refreshbtn.setBackground(new java.awt.Color(0, 51, 51));
        Refreshbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Refreshbtn.setForeground(new java.awt.Color(227, 244, 227));
        Refreshbtn.setText("Refresh");
        Refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshbtnActionPerformed(evt);
            }
        });

        UpdateStatusbtn.setBackground(new java.awt.Color(0, 51, 51));
        UpdateStatusbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        UpdateStatusbtn.setForeground(new java.awt.Color(227, 244, 227));
        UpdateStatusbtn.setText("Update Status");
        UpdateStatusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStatusbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(654, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(UpdateStatusbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Exitbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refreshbtn)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(UpdateStatusbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exitbtn1)
                    .addComponent(Refreshbtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbtnActionPerformed
        this.dispose();
        new DRmenu().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitbtnActionPerformed

    private void RefreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshbtnActionPerformed
        try {
        String filename = "deliveries.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        DefaultTableModel model = (DefaultTableModel) Tasktbl.getModel();
        model.setRowCount(0); // Clear the table before adding new rows

        // Get the logged-in Driver ID
        String loggedInDriverID = CurrentUser.getLoggedInUser().getUid();
        Object[] tableLines = br.lines().toArray();

        for (Object tableLine : tableLines) {
            String line = tableLine.toString().trim();
            String[] dataRow = line.split(":");

            // Ensure the data row has enough columns to avoid ArrayIndexOutOfBoundsException
            if (dataRow.length >= 8) { 
                String status = dataRow[6];           // Assuming "Status" is the 6th column (dataRow[5])
                String completionStatus = dataRow[7]; // Assuming "Completion Status" is the 7th column (dataRow[6])
                String driverID = dataRow[8];        // Assuming "DriverID" is the 8th column (dataRow[7])

                // Add rows where status is "Accepted", completion status is "Ongoing", and DriverID matches
                if ("Accepted".equalsIgnoreCase(status) 
                        && "Ongoing".equalsIgnoreCase(completionStatus) 
                        && loggedInDriverID.equals(driverID)) {
                    model.addRow(dataRow); // Add the filtered row to the table
                }
            }
        }

        br.close(); // Close the buffered reader
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }     // TODO add your handling code here:
    }//GEN-LAST:event_RefreshbtnActionPerformed

    private void UpdateStatusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStatusbtnActionPerformed
        if (Tasktbl.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "No task available to update.");
        return;
        }

        // Get the OrderID from the only row in the table
        String orderID = Tasktbl.getValueAt(0, 1).toString(); // 1 refers to the second column, OrderID
        File deliveriesFile = new File("deliveries.txt");
        File ordersFile = new File("orders.txt");
        File usersFile = new File("users.txt");

        StringBuilder updatedDeliveriesContent = new StringBuilder();
        StringBuilder updatedUsersContent = new StringBuilder();
        boolean updated = false;

        String vendorID = null;
        double driverRevenue = 0.0;
        double totalRevenue = 0.0;

        try {
            // Read the orders.txt file to find the vendorID and totalRevenue
            try (BufferedReader ordersReader = new BufferedReader(new FileReader(ordersFile))) {
                String line;
                while ((line = ordersReader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length > 5 && parts[0].equalsIgnoreCase(orderID)) { // Check if OrderID matches
                        vendorID = parts[2]; // VendorID is at index 1
                        totalRevenue = Double.parseDouble(parts[5]); // Total Revenue is at index 5
                        break;
                    }
                }
            }

            if (vendorID == null) {
                JOptionPane.showMessageDialog(null, "No matching OrderID found in orders.txt.");
                return;
            }

            // Read and update deliveries.txt
            try (BufferedReader deliveriesReader = new BufferedReader(new FileReader(deliveriesFile))) {
                String line;
                while ((line = deliveriesReader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length > 6 && parts[1].equalsIgnoreCase(orderID)) { // Check if OrderID matches
                        if (!"Delivered".equalsIgnoreCase(parts[6])) { // Ensure the status isn't already "Delivered"
                            parts[7] = "Delivered"; // Update the completion status                      
                            parts[8] = CurrentUser.getLoggedInUser().getUid();

                            //get the drivers revenue ammount
                            driverRevenue = Double.parseDouble(parts[3]);
                   
                            // Get the current time
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
                            parts[9] = now.format(formatter);

                            updated = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "The task is already marked as 'Delivered'.");
                            return;
                        }
                    }
                    updatedDeliveriesContent.append(String.join(":", parts)).append(System.lineSeparator());
                }
            }

            if (!updated) {
                JOptionPane.showMessageDialog(null, "No matching task found to update in deliveries.txt.");
                return;
            }

            // Read and update users.txt
            try (BufferedReader usersReader = new BufferedReader(new FileReader(usersFile))) {
                String line;
                while ((line = usersReader.readLine()) != null) {
                    String[] parts = line.split(":");

                    // Update revenue for vendorID
                    if (parts.length > 4 && parts[1].equalsIgnoreCase(vendorID)) { // VendorID is at index 0
                        double currentRevenue = Double.parseDouble(parts[4]); // Revenue field is at index 4
                        parts[4] = String.valueOf(currentRevenue + totalRevenue);
                    }

                    // Update revenue for driverID
                    if (parts.length > 4 && parts[1].equalsIgnoreCase(CurrentUser.getLoggedInUser().getUid())) { // DriverID
                        double currentRevenue = Double.parseDouble(parts[4]); // Revenue field is at index 4
                        parts[4] = String.valueOf(currentRevenue + driverRevenue);
                    }

                    updatedUsersContent.append(String.join(":", parts)).append(System.lineSeparator());
                }
            }

            // Write updates back to deliveries.txt
            try (FileWriter deliveriesWriter = new FileWriter(deliveriesFile)) {
                deliveriesWriter.write(updatedDeliveriesContent.toString());
            }

            // Write updates back to users.txt
            try (FileWriter usersWriter = new FileWriter(usersFile)) {
                usersWriter.write(updatedUsersContent.toString());
            }
            
            ArrayList<Order> orders = FileManager.loadOrders("orders.txt");
            ArrayList<Notification> notifications = FileManager.loadNotifications("notifications.txt");
            
            for(Order order: orders){
                if(order.getOrderID().equalsIgnoreCase(orderID)){
                    order.setDeliveryStatus("Delivered");
                    String nid = FileManager.getNotificationID(notifications);
                    String msg = "Your order has been delivered! OrderID = " + order.getOrderID();
                    Notification notification = new Notification(nid, order.getCustomerID(), msg, FileManager.getDateTime(), "Unread");
                    notifications.add(notification);
                }
            }
            FileManager.writeOrders("orders.txt", orders);
            FileManager.writeNotifications("notifications.txt", notifications);

            JOptionPane.showMessageDialog(null, "Task updated to 'Delivered' successfully!");
            RefreshbtnActionPerformed(evt); // Refresh the table to reflect changes

        } catch (IOException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }    
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateStatusbtnActionPerformed

    private void Exitbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exitbtn1ActionPerformed
        this.dispose();
        new DRmenu().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Exitbtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbtn;
    private javax.swing.JButton Exitbtn1;
    private javax.swing.JButton Refreshbtn;
    private javax.swing.JTable Tasktbl;
    private javax.swing.JButton UpdateStatusbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
