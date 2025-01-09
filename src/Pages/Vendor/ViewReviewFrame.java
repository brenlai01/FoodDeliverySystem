/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Vendor;

import FileManager.CurrentUser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braxt
 */
public class ViewReviewFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewReviewFrame
     */
    public ViewReviewFrame() {
        initComponents();
        vendorIDLabel.setText("Current Logged In Vendor ID: " + CurrentUser.getLoggedInUser().getUid());
        refreshData();
        reviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewTableMouseClicked(evt);
            }
        });
    }
    
    public void refreshData() {
        DefaultTableModel model = (DefaultTableModel) reviewTable.getModel();
        model.setRowCount(0);
        String loggedInVendorId = CurrentUser.getLoggedInUser().getUid();
        boolean hasOrders = false;

        try (BufferedReader br = new BufferedReader(new FileReader("review.txt"))) {
            String read;
            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length >= 5) {
                    String[] orderData = {
                        data[1],
                        data[0],
                        data[2],
                        data[3],
                        data[4]
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
    
    private void reviewTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = reviewTable.getSelectedRow();
        if (selectedRow != -1) {
            foodIDTxt.setText((String) reviewTable.getValueAt(selectedRow, 3));;
            System.out.println("Selected order ID: " + foodIDTxt.getText());
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
        searchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vendorIDLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        foodIDTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTable = new javax.swing.JTable();
        returnBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Customer Reviews");

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        jLabel2.setText("Search:");

        vendorIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vendorIDLabel.setText("Current Logged In Vendor ID:");

        jLabel3.setText("Order ID:");

        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Review ID", "Customer ID", "Vendor ID", "Order ID", "Review"
            }
        ));
        jScrollPane1.setViewportView(reviewTable);
        if (reviewTable.getColumnModel().getColumnCount() > 0) {
            reviewTable.getColumnModel().getColumn(0).setMinWidth(67);
            reviewTable.getColumnModel().getColumn(0).setMaxWidth(67);
            reviewTable.getColumnModel().getColumn(1).setMinWidth(78);
            reviewTable.getColumnModel().getColumn(1).setMaxWidth(78);
            reviewTable.getColumnModel().getColumn(2).setMinWidth(68);
            reviewTable.getColumnModel().getColumn(2).setMaxWidth(68);
            reviewTable.getColumnModel().getColumn(3).setMinWidth(66);
            reviewTable.getColumnModel().getColumn(3).setMaxWidth(66);
        }

        returnBtn.setText("Return");
        returnBtn.setMaximumSize(new java.awt.Dimension(70, 23));
        returnBtn.setMinimumSize(new java.awt.Dimension(70, 23));
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(foodIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vendorIDLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(vendorIDLabel)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(foodIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        new VendorFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String searchText = searchTxt.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) reviewTable.getModel();
        model.setRowCount(0);

        if (searchText.isEmpty()) {
            refreshData();
            return;
        }
        
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        
        try (BufferedReader br = new BufferedReader(new FileReader("review.txt"))) { // Ensure the correct file is read
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 5) {
                    if(data[2].equals(loggedInVendorId)){
                        String reviewID = data[1].trim().toLowerCase();
                        String customerID = data[0].trim().toLowerCase();
                        String vendorID = data[2].trim().toLowerCase();
                        String orderID = data[3].trim().toLowerCase();
                        String review = data[4].trim().toLowerCase();

                        if (reviewID.contains(searchText) || customerID.contains(searchText) || 
                            vendorID.contains(searchText) || orderID.contains(searchText) ||
                            review.contains(searchText)) {
                            model.addRow(new Object[]{data[1], data[0], data[2], data[3], data[4]});
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
            java.util.logging.Logger.getLogger(ViewReviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReviewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField foodIDTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTable reviewTable;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JLabel vendorIDLabel;
    // End of variables declaration//GEN-END:variables
}
