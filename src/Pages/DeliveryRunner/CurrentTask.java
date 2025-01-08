/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.DeliveryRunner;

import FileManager.CurrentUser;
import Models.DeliveryRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vreesa
 */
public class CurrentTask extends javax.swing.JFrame {
    private DeliveryRunner  deliveryrunner;

    /**
     * Creates new form CurrentTask
     */
    public CurrentTask() {
        initComponents();
        this.deliveryrunner = (DeliveryRunner) CurrentUser.getLoggedInUser();

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
        jLabel1 = new javax.swing.JLabel();
        Refreshbtn = new javax.swing.JButton();
        Exitbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tasktbl.setBackground(new java.awt.Color(225, 237, 243));
        Tasktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivery No.", "OrderID", "Customer ID", "Commision(RM)", "Address", "Vendor Status", "Status", "Completion Status", "DriverID", "Delivery Time"
            }
        ));
        jScrollPane2.setViewportView(Tasktbl);
        if (Tasktbl.getColumnModel().getColumnCount() > 0) {
            Tasktbl.getColumnModel().getColumn(0).setPreferredWidth(10);
            Tasktbl.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("STIX Two Text", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(42, 49, 129));
        jLabel1.setText("Current Task :");

        Refreshbtn.setBackground(new java.awt.Color(225, 237, 243));
        Refreshbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Refreshbtn.setForeground(new java.awt.Color(42, 49, 129));
        Refreshbtn.setText("refresh");
        Refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshbtnActionPerformed(evt);
            }
        });

        Exitbtn.setBackground(new java.awt.Color(225, 237, 243));
        Exitbtn.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        Exitbtn.setForeground(new java.awt.Color(42, 49, 129));
        Exitbtn.setText("exit");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Exitbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refreshbtn))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Refreshbtn)
                    .addComponent(Exitbtn))
                .addContainerGap(23, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(CurrentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbtn;
    private javax.swing.JButton Refreshbtn;
    private javax.swing.JTable Tasktbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
