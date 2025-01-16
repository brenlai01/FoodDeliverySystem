/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.DeliveryRunner;

import FileManager.CurrentUser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vreesa
 */
public class TaskHistory extends javax.swing.JFrame {

    /**
     * Creates new form TaskHistory
     */
    public TaskHistory() {
        initComponents();
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
        Tasktbl = new javax.swing.JTable();
        Exitbtn1 = new javax.swing.JButton();
        Refreshbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RevenuetxtF = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tasktbl.setBackground(new java.awt.Color(227, 244, 227));
        Tasktbl.setFont(new java.awt.Font("STIX Two Text", 0, 13)); // NOI18N
        Tasktbl.setForeground(new java.awt.Color(0, 0, 102));
        Tasktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DeliveryID", "OrderID", "CustomerID", "Commision(RM)", "Address", "Vendor Status", "Runner Status", "Delivery Status", "DriverID", "Delivery Time"
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

        jLabel1.setFont(new java.awt.Font("STIX Two Text", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Task History :");

        jScrollPane3.setViewportView(RevenuetxtF);

        jLabel2.setFont(new java.awt.Font("Songti TC", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Total Revenue(RM) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(732, 732, 732)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Exitbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refreshbtn))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exitbtn1)
                    .addComponent(Refreshbtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Exitbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exitbtn1ActionPerformed
        this.dispose();
        new DRmenu().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Exitbtn1ActionPerformed

    private void RefreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshbtnActionPerformed
        try {
            String filename = "deliveries.txt";
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel) Tasktbl.getModel();
            model.setRowCount(0); // Clear the table before adding new rows

            double totalCommission = 0.0; // Variable to hold the total commission

            // Get the logged-in user's DriverID
            String loggedInDriverID = CurrentUser.getLoggedInUser().getUid();

            Object[] tableLines = br.lines().toArray();
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(":");

                // Ensure the data row has enough columns to avoid ArrayIndexOutOfBoundsException
                if (dataRow.length >= 8) {
                    String completionStatus = dataRow[7]; // Assuming the 7th column is "Completion Status"
                    String driverID = dataRow[8];        // Assuming the 8th column is "DriverID"

                    // Filter rows with "Delivered" status and matching DriverID
                    if ("Delivered".equalsIgnoreCase(completionStatus) && loggedInDriverID.equals(driverID)) {
                        model.addRow(dataRow); // Add the row to the table

                        // Attempt to parse and sum the commission value
                        try {
                            double commission = Double.parseDouble(dataRow[3]); // Assuming the 4th column is commission
                            totalCommission += commission;
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing commission: " + e.getMessage());
                        }
                    }
                }
            }

            // Display the total commission in the text field
            RevenuetxtF.setText(String.format("%.2f", totalCommission));

            br.close(); // Close the buffered reader
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_RefreshbtnActionPerformed

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
            java.util.logging.Logger.getLogger(TaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbtn1;
    private javax.swing.JButton Refreshbtn;
    private javax.swing.JTextPane RevenuetxtF;
    private javax.swing.JTable Tasktbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
