/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Customer;

import FileManager.CurrentUser;
import FileManager.FileManager;
import Records.Complaint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CustomerComplaintHistory extends javax.swing.JFrame {

    /**
     * Creates new form CustomerComplaintHistory
     */
    public CustomerComplaintHistory() {
        initComponents();
        ComplaintHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComplaintHistoryTableMouseClicked(evt);
            }
        });
        // set the customer ID
        String customerID = CurrentUser .getLoggedInUser ().getUid();
        CutomerIDLabel.setText("Customer ID: " + customerID);
        // set the complaint ID
        String complaintFilePath = "complaint.txt";
        String complaintID = FileManager.getComplaintIDForCustomer(customerID, complaintFilePath);
        ComplaintIDLabel.setText("Complains ID: " + complaintID);
        refreshData();
    }

    private void ComplaintHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = ComplaintHistoryTable.getSelectedRow();
        if (selectedRow != -1) {
            ComplaintInfoText.setText((String) ComplaintHistoryTable.getValueAt(selectedRow, 1));
        }
    }

    public void refreshData() {
        try {
            DefaultTableModel model = (DefaultTableModel) ComplaintHistoryTable.getModel();
            model.setRowCount(0); //clear data

            String complaintFile = "complaint.txt";
            FileReader fr = new FileReader(complaintFile);
            BufferedReader br = new BufferedReader(fr);
            String read;

            String loggedInCustomerId = CurrentUser .getLoggedInUser ().getUid();

            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length == 4) {
                    if (data[0].equals(loggedInCustomerId)) {
                        String[] complaintData = {
                            data[2],
                            data[3]
                        };
                        model.addRow(complaintData);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading complaint data: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ReturnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComplaintHistoryTable = new javax.swing.JTable();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ComplaintInfoText = new javax.swing.JTextArea();
        DetailsLable = new javax.swing.JLabel();
        CutomerIDLabel = new javax.swing.JLabel();
        ComplaintIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Complains History Dashboard");

        ReturnButton.setText("Return");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        ComplaintHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Details"
            }
        ));
        jScrollPane1.setViewportView(ComplaintHistoryTable);
        if (ComplaintHistoryTable.getColumnModel().getColumnCount() > 0) {
            ComplaintHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ComplaintInfoText.setColumns(20);
        ComplaintInfoText.setRows(5);
        jScrollPane2.setViewportView(ComplaintInfoText);

        DetailsLable.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        DetailsLable.setText("Details:");

        CutomerIDLabel.setText("Customer ID:");

        ComplaintIDLabel.setText("Complains ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DetailsLable)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CutomerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComplaintIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CutomerIDLabel)
                    .addComponent(ComplaintIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DetailsLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
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

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        new CustomerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedRow = ComplaintHistoryTable.getSelectedRow();
        if (selectedRow != -1) {
            String uniID = (String) ComplaintHistoryTable.getValueAt(selectedRow, 0); // Get uniID
            
            // Load existing complaints
            ArrayList<Complaint> complaints = FileManager.LoadComplaints("complaint.txt");
            complaints.removeIf(complaint -> complaint.getUniID().equals(uniID)); // Remove the selected complaint
            
            // Write updated complaints back to the file
            FileManager.writeComplaints("complaint.txt", complaints);
            JOptionPane.showMessageDialog(this, "Complains deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }else{
            JOptionPane.showMessageDialog(this, "Please select a complains to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        int selectedRow = ComplaintHistoryTable.getSelectedRow();
        if (selectedRow != -1){
            String uniID = (String) ComplaintHistoryTable.getValueAt(selectedRow, 0); // Get uniID
            String updatedInfo = ComplaintInfoText.getText().trim(); // Get updated complaint info
            
            if(updatedInfo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Complaint cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            // Load existing complaints
            ArrayList<Complaint> complaints = FileManager.LoadComplaints("complaint.txt");
            for (Complaint complaint : complaints) {
                if (complaint.getUniID().equals(uniID)) {
                    complaint.setComplaintInfo(updatedInfo); // Update the complaint info
                    break;
                }
            }
            
            // Write updated complaints back to the file
            FileManager.writeComplaints("complaint.txt", complaints);
            JOptionPane.showMessageDialog(this, "Complains updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }else{
            JOptionPane.showMessageDialog(this, "Please select a complains to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerComplaintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerComplaintHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ComplaintHistoryTable;
    private javax.swing.JLabel ComplaintIDLabel;
    private javax.swing.JTextArea ComplaintInfoText;
    private javax.swing.JLabel CutomerIDLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DetailsLable;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
