/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Vendor;

import FileManager.CurrentUser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braxt
 */
public class ViewRevenueFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewRevenue
     */
    public ViewRevenueFrame() {
        initComponents();
        vendorIDLabel.setText("Current Logged In Vendor ID: " + CurrentUser.getLoggedInUser().getUid());
        vendorBalLabel.setText("Vendor Balance: RM " + CurrentUser.getLoggedInUser().getBalance());
        refreshData();
    }
    
    public void refreshData() {
        DefaultTableModel model = (DefaultTableModel) revenuesTable.getModel();
        model.setRowCount(0);
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        boolean hasOrders = false;

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String read;
            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length >= 9) {
                    String deliveryStatus = data[8];
                    String[] orderData = {
                        data[0],
                        data[2],
                        data[3],
                        data[5],
                        data[6]
                    };

                    if ((data[2].equals(loggedInVendorId) && data[7].equals("Accepted")) && (data[8].equals("Delivered")||
                        data[4].equals("Dine-in") || data[4].equals("Takeaway"))) {
                        model.addRow(orderData);
                        hasOrders = true;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading revenues data: " + e.getMessage());
        }

        if (!hasOrders) {
            JOptionPane.showMessageDialog(null, "No revenues found for the current vendor.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
   
    private void calculateAndDisplayRevenue() {
        String selectedPeriod = (String) periodCBox.getSelectedItem();
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        double totalRevenue = 0;

        DefaultTableModel model = (DefaultTableModel) revenuesTable.getModel();
        model.setRowCount(0); // Clear existing rows

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"); // Adjust as needed

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            LocalDate today = LocalDate.now();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 9) {
                    if ((data[2].equals(loggedInVendorId) && data[7].equals("Accepted")) && 
                        (data[8].equals("Delivered")|| data[4].equals("Dine-in") || 
                         data[4].equals("Takeaway"))){
                        // Parse the order date from the 7th field (index 6)
                        LocalDate orderDate = LocalDate.parse(data[6].trim(), dateFormatter);
                        double totalPrice = Double.parseDouble(data[5].trim());

                        // Check the selected period
                        boolean isInPeriod = false;
                        switch (selectedPeriod.toLowerCase()) {
                            case "daily":
                                isInPeriod = orderDate.isEqual(today);
                                break;
                            case "monthly":
                                isInPeriod = orderDate.getYear() == today.getYear() && orderDate.getMonth() == today.getMonth();
                                break;
                            case "quarterly":
                                isInPeriod = orderDate.getYear() == today.getYear() && (orderDate.getMonthValue() - 1) / 3 == (today.getMonthValue() - 1) / 3;
                                break;
                            case "yearly":
                                isInPeriod = orderDate.getYear() == today.getYear();
                                break;
                        }

                        if (isInPeriod) {
                            totalRevenue += totalPrice;
                            model.addRow(new Object[]{data[0], data[2], data[3], data[5], data[6]}); // Add relevant data to the table

                        }
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }

        revenueTxt.setText("Total Revenue for " + selectedPeriod + ": RM " + totalRevenue);
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
        vendorIDLabel = new javax.swing.JLabel();
        revenueTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        revenuesTable = new javax.swing.JTable();
        returnBtn = new javax.swing.JButton();
        vendorBalLabel = new javax.swing.JLabel();
        periodCBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Vendor Revenue Dashboard");

        vendorIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vendorIDLabel.setText("Current Logged In Vendor ID:");

        revenueTxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        revenueTxt.setText("Total Revenue:");

        revenuesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Vendor ID", "Ordered Items", "Total Price", "Ordered Time"
            }
        ));
        jScrollPane1.setViewportView(revenuesTable);
        if (revenuesTable.getColumnModel().getColumnCount() > 0) {
            revenuesTable.getColumnModel().getColumn(0).setMinWidth(69);
            revenuesTable.getColumnModel().getColumn(0).setMaxWidth(69);
            revenuesTable.getColumnModel().getColumn(1).setMinWidth(75);
            revenuesTable.getColumnModel().getColumn(1).setMaxWidth(75);
            revenuesTable.getColumnModel().getColumn(3).setMinWidth(75);
            revenuesTable.getColumnModel().getColumn(3).setMaxWidth(75);
            revenuesTable.getColumnModel().getColumn(4).setMinWidth(120);
            revenuesTable.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        vendorBalLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vendorBalLabel.setText("Vendor Balance: RM 100.0");

        periodCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Monthly", "Quarterly", "Yearly" }));
        periodCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodCBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Select period:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vendorIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(vendorBalLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(periodCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6))
                            .addComponent(revenueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(periodCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorIDLabel)
                    .addComponent(vendorBalLabel))
                .addGap(17, 17, 17)
                .addComponent(revenueTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(returnBtn)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        new VendorFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void periodCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodCBoxActionPerformed
        calculateAndDisplayRevenue();
    }//GEN-LAST:event_periodCBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRevenueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRevenueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRevenueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRevenueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRevenueFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> periodCBox;
    private javax.swing.JButton returnBtn;
    private javax.swing.JLabel revenueTxt;
    private javax.swing.JTable revenuesTable;
    private javax.swing.JLabel vendorBalLabel;
    private javax.swing.JLabel vendorIDLabel;
    // End of variables declaration//GEN-END:variables
}
