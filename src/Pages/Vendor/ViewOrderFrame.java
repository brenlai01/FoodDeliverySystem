package Pages.Vendor;

import FileManager.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braxt
 */
public class ViewOrderFrame extends javax.swing.JFrame {

    public ViewOrderFrame() {
        initComponents();
        vendorIDLabel.setText("Current Logged In Vendor ID: " + CurrentUser.getLoggedInUser().getUid());
        refreshData();
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
    }
    
    public void refreshData() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        boolean hasOrders = false;

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String read;
            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length >= 9) {
                    String[] orderData = {
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[5],
                        data[4],
                        data[6],
                        data[7],
                        data[8]
                    };

                    if (data[2].equals(loggedInVendorId)) {
                        model.addRow(orderData);
                        hasOrders = true;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading orders data: " + e.getMessage());
        }

        if (!hasOrders) {
            JOptionPane.showMessageDialog(null, "No orders found for the current vendor.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            orderIDTxt.setText((String) orderTable.getValueAt(selectedRow, 0));;
            System.out.println("Selected order ID: " + orderIDTxt.getText());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        acceptBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        vendorIDLabel = new javax.swing.JLabel();
        assignBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        orderIDTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("View Order Dashboard");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer ID", "Vendor ID", "Item", "Total Price", "Order Type", "Ordered Time", "Vendor Status", "Delivery Status"
            }
        ));
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setMaxWidth(60);
            orderTable.getColumnModel().getColumn(1).setMaxWidth(78);
            orderTable.getColumnModel().getColumn(2).setMaxWidth(68);
            orderTable.getColumnModel().getColumn(3).setMaxWidth(200);
            orderTable.getColumnModel().getColumn(4).setMaxWidth(80);
            orderTable.getColumnModel().getColumn(5).setMaxWidth(80);
            orderTable.getColumnModel().getColumn(6).setMaxWidth(90);
            orderTable.getColumnModel().getColumn(7).setMaxWidth(90);
            orderTable.getColumnModel().getColumn(8).setMaxWidth(90);
        }

        jLabel2.setText("Search:");

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        acceptBtn.setText("Accept");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        rejectBtn.setText("Reject");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        vendorIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vendorIDLabel.setText("Current Logged In Vendor ID: ");

        assignBtn.setText("Assign");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Order ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vendorIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rejectBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(vendorIDLabel)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(rejectBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignBtn)
                    .addComponent(returnBtn))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        new VendorFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        String loggedInVendorId = CurrentUser.getLoggedInUser().getUid();
        int selectedRow = orderTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to accept.");
            return;
        }
        
        String orderID = orderIDTxt.getText().trim();
        String currentVendorID = orderTable.getValueAt(selectedRow, 2).toString();
        String vendorStatus = orderTable.getValueAt(selectedRow, 7).toString().toLowerCase();


        if (!vendorStatus.equals("pending")) {
            JOptionPane.showMessageDialog(this, "Only pending orders can be accepted.");
            return;
        }

        if (!currentVendorID.equals(loggedInVendorId)) {
            JOptionPane.showMessageDialog(this, "You have no permission to accept this order.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            StringBuilder updatedData = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 8) {
                    if (data[0].equals(orderID) && data[2].equals(currentVendorID)) {
                        data[7] = "Accepted";
                        line = String.join(":", data);
                        found = true;
                    }
                }
                updatedData.append(line).append("\n");
            }

            if (found) {
                try (FileWriter fw = new FileWriter("orders.txt")) {
                    fw.write(updatedData.toString());
                }
                JOptionPane.showMessageDialog(null, "Order has been accepted successfully!");
                refreshData();
            } else {
                JOptionPane.showMessageDialog(null, "Order ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating order status: " + e.getMessage());
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        String loggedInVendorId = CurrentUser.getLoggedInUser().getUid();
        int selectedRow = orderTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to reject.");
            return;
        }
        
        String orderID = orderIDTxt.getText().trim();
        String currentVendorID = orderTable.getValueAt(selectedRow, 2).toString();
        String vendorStatus = orderTable.getValueAt(selectedRow, 7).toString().toLowerCase();


        if (!vendorStatus.equals("pending")) {
            JOptionPane.showMessageDialog(this, "Only pending orders can be rejected.");
            return;
        }

        if (!currentVendorID.equals(loggedInVendorId)) {
            JOptionPane.showMessageDialog(this, "You have no permission to reject this order.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            StringBuilder updatedData = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 8) {
                    if (data[0].equals(orderID) && data[2].equals(currentVendorID)) {
                        data[7] = "Rejected";
                        line = String.join(":", data);
                        found = true;
                    }
                }
                updatedData.append(line).append("\n");
            }

            if (found) {
                try (FileWriter fw = new FileWriter("orders.txt")) {
                    fw.write(updatedData.toString());
                }
                JOptionPane.showMessageDialog(null, "Order has been rejected successfully!");
                refreshData();
            } else {
                JOptionPane.showMessageDialog(null, "Order ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating order status: " + e.getMessage());
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        int selectedRow = orderTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to deliver.");
            return;
        }
        
        String orderID = orderIDTxt.getText().trim();
        String currentVendorID = orderTable.getValueAt(selectedRow, 2).toString();
        String deliveryStatus = orderTable.getValueAt(selectedRow, 8).toString().toLowerCase();


        if (!deliveryStatus.equals("unassigned")) {
            JOptionPane.showMessageDialog(this, "Only unassigned orders can be deliver.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            StringBuilder updatedData = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 8) {
                    if (data[0].equals(orderID) && data[2].equals(currentVendorID) && data[7].equals("Accepted")) {
                        data[8] = "Delivering";
                        line = String.join(":", data);
                        found = true;
                    }
                }
                updatedData.append(line).append("\n");
            }

            if (found) {
                try (FileWriter fw = new FileWriter("orders.txt")) {
                    fw.write(updatedData.toString());
                }
                JOptionPane.showMessageDialog(null, "Order now is being deliver!");
                refreshData();
            } else {
                JOptionPane.showMessageDialog(null, "This order is still pending!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating order status: " + e.getMessage());
        }
    }//GEN-LAST:event_assignBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String searchText = searchTxt.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);

        if (searchText.isEmpty()) {
            refreshData();
            return;
        }
        
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        
        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) { // Ensure the correct file is read
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 9) {
                    if(data[2].equals(loggedInVendorId)){
                        String orderID = data[0].trim().toLowerCase();
                        String customerID = data[1].trim().toLowerCase();
                        String vendorID = data[2].trim().toLowerCase();
                        String item = data[3].trim().toLowerCase();
                        String totalPrice = data[4].trim().toLowerCase();
                        String orderType = data[5].trim().toLowerCase();
                        String orderTime = data[6].trim().toLowerCase();
                        String vendorStatus = data[7].trim().toLowerCase();
                        String deliveryStatus = data[8].trim().toLowerCase();

                        if (orderID.contains(searchText) || customerID.contains(searchText) || 
                            vendorID.contains(searchText) || item.contains(searchText) ||
                            totalPrice.contains(searchText) || orderType.contains(searchText) || 
                            orderTime.contains(searchText) || vendorStatus.contains(searchText) ||
                            deliveryStatus.contains(searchText)) {
                            model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]});
                        }
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }//GEN-LAST:event_searchTxtKeyReleased

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
            java.util.logging.Logger.getLogger(ViewOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton assignBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderIDTxt;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JLabel vendorIDLabel;
    // End of variables declaration//GEN-END:variables
}
