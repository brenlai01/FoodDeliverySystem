/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.DeliveryRunner;

import FileManager.CurrentUser;
import Models.DeliveryRunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vreesa
 */
public class ChooseTasks extends javax.swing.JFrame {

    private DeliveryRunner  deliveryrunner;
    
    public ChooseTasks() {
        initComponents();
        this.deliveryrunner = (DeliveryRunner) CurrentUser.getLoggedInUser();
        getData();
    }
    public void getData(){
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tasktbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Tasktf = new javax.swing.JTextField();
        refreshbtn = new javax.swing.JButton();
        confirmbtn = new javax.swing.JButton();
        Exitbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tasktbl.setBackground(new java.awt.Color(225, 237, 243));
        Tasktbl.setFont(new java.awt.Font("Songti TC", 1, 13)); // NOI18N
        Tasktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivery ID", "OrderID", "CustomerID", "Commision(RM)", "Address", "Status", "Completion Status", "DriverID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tasktbl);
        if (Tasktbl.getColumnModel().getColumnCount() > 0) {
            Tasktbl.getColumnModel().getColumn(0).setResizable(false);
            Tasktbl.getColumnModel().getColumn(1).setPreferredWidth(10);
            Tasktbl.getColumnModel().getColumn(2).setPreferredWidth(15);
            Tasktbl.getColumnModel().getColumn(7).setPreferredWidth(0);
            Tasktbl.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Songti TC", 1, 17)); // NOI18N
        jLabel1.setText("Please enter orderID on which task you would like to accept : ");

        refreshbtn.setBackground(new java.awt.Color(225, 237, 243));
        refreshbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        refreshbtn.setText("refresh table");
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });

        confirmbtn.setBackground(new java.awt.Color(225, 237, 243));
        confirmbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        confirmbtn.setText("confirm");
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });

        Exitbtn.setBackground(new java.awt.Color(225, 237, 243));
        Exitbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Exitbtn.setText("Exit");
        Exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Exitbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tasktf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmbtn)))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tasktf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exitbtn)
                    .addComponent(refreshbtn))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        try {
            String filename = "deliveries.txt";
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel) Tasktbl.getModel();
            model.setRowCount(0); // Clear the table before adding new rows
            Object[] tableLines = br.lines().toArray();

            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(":");

                // Ensure the data row has enough columns to avoid ArrayIndexOutOfBoundsException
                if (dataRow.length >= 6) { // Assuming "Status" is the 6th column (dataRow[5])
                    String status = dataRow[5]; // Adjust the index if the column number is different

                    // Exclude rows where status is "Accepted"
                    if (!"Accepted".equalsIgnoreCase(status)) {
                        model.addRow(dataRow); // Add the filtered row to the table
                    }
                }
            }

            br.close(); // Close the buffered reader
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_refreshbtnActionPerformed

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        String orderID = Tasktf.getText(); // Retrieve the input OrderID from the text field
        if (orderID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an Order ID.");
            return;
        }

        File file = new File("deliveries.txt");
        StringBuilder updatedContent = new StringBuilder();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length > 6 && parts[1].equalsIgnoreCase(orderID)) { // to check if the 2nd column matches the OrderID
                    parts[5] = "Accepted";        // Update the status
                    parts[6] = "Ongoing";        // Update the completion status
                    parts[7] = (""+CurrentUser.getLoggedInUser().getUid()); //check!! to update driverID 
                    updated = true;
                }
                updatedContent.append(String.join(":", parts)).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(ChooseTasks.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (updated) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(updatedContent.toString());
                JOptionPane.showMessageDialog(null, "Order status and completion status updated successfully!");
            } catch (IOException ex) {
                Logger.getLogger(ChooseTasks.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Order ID not found.");
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void ExitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbtnActionPerformed
        this.dispose();
        new DRmenu().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseTasks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbtn;
    private javax.swing.JTable Tasktbl;
    private javax.swing.JTextField Tasktf;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshbtn;
    // End of variables declaration//GEN-END:variables
}
