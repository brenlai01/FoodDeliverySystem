/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Manager;

import FileManager.CurrentUser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chew WB
 */
public class VendorItemsFrame extends javax.swing.JFrame {

    /**
     * Creates new form VendorItemsFrame
     */
    public VendorItemsFrame() {
        initComponents();
        refreshData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        deleteItemButton = new javax.swing.JButton();
        VendorItemManagementReturnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Food ID", "Vendor ID", "Food Name", "Price", "Description"
            }
        ));
        foodTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(foodTable);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("Vendor Item Management Dashboard");

        deleteItemButton.setText("Delete");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        VendorItemManagementReturnButton.setText("Return");
        VendorItemManagementReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendorItemManagementReturnButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Options For Item Selected:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(deleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                        .addComponent(VendorItemManagementReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VendorItemManagementReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(deleteItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshData() {
        DefaultTableModel model = (DefaultTableModel) foodTable.getModel();
        model.setRowCount(0); // Clear existing data

        // Load food items from the file
        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":"); // Assuming data is separated by colons
                if (data.length == 5) { // Ensure there are enough fields
                    model.addRow(new Object[]{data[0], data[1], data[2], data[4], data[3]}); // Vendor ID, Food ID, Food Name, Price, Description
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading food items: " + e.getMessage());
        }
    }
    
    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        
        // Get the selected row from the table
        int selectedRow = foodTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a food item to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get the food ID from the selected row
        String foodID = foodTable.getValueAt(selectedRow, 0).toString(); // Assuming Food ID is in the second column
        

        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
        StringBuilder updatedData = new StringBuilder();
        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(":");
            if (data.length == 5) {
                if (!data[0].equals(foodID)) { // Keep the line if it's not the selected food item
                    updatedData.append(line).append("\n");
                } else {
                    found = true; // Mark as found if this is the food item to delete
                }
            }
        }


            if (found) {
                // Write the updated data back to the file
                try (FileWriter fw = new FileWriter("foodItems.txt")) {
                    fw.write(updatedData.toString());
                }
                JOptionPane.showMessageDialog(null, "Food item deleted successfully!");
                refreshData(); // Refresh the table to show updated items
            } else {
                JOptionPane.showMessageDialog(null, "Food ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error deleting food item: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteItemButtonActionPerformed

    private void VendorItemManagementReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendorItemManagementReturnButtonActionPerformed
        new ManagerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VendorItemManagementReturnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VendorItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorItemsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VendorItemManagementReturnButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JTable foodTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
