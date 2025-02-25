/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.Manager;

import FileManager.CurrentUser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chew WB
 */
public class RiderPerformanceFrame extends javax.swing.JFrame {

    /**
     * Creates new form RiderPerformanceFrame
     */
    public RiderPerformanceFrame() {
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

        jPanel2 = new javax.swing.JPanel();
        RiderPerformanceDashHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RunnerPerformanceTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        currentSelectedDriverID = new javax.swing.JLabel();
        RiderAvgRatings = new javax.swing.JLabel();
        RiderTotalCommision = new javax.swing.JLabel();
        RunnerDetailsLabel = new javax.swing.JLabel();
        RunnerName = new javax.swing.JLabel();
        RunnerPerformance = new javax.swing.JLabel();
        VRDashboardReturnButton = new javax.swing.JButton();
        SearchRunnerLabel = new javax.swing.JLabel();
        selectRider = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        RiderPerformanceDashHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        RiderPerformanceDashHeader.setText("Runner Performance Dashboard");

        RunnerPerformanceTable.setFont(new java.awt.Font("Songti TC", 1, 13)); // NOI18N
        RunnerPerformanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RunnerID", "DeliveryID", "OrderID", "CustomerID", "Commision(RM)", "Address", "Status", "Completion Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(RunnerPerformanceTable);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        currentSelectedDriverID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        currentSelectedDriverID.setText("Current Runner Selected:");

        RiderAvgRatings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RiderAvgRatings.setText("Runner Average Ratings (Stars): ");

        RiderTotalCommision.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RiderTotalCommision.setText("Total Commision (RM): ");

        RunnerDetailsLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        RunnerDetailsLabel.setText("Delivery Runner Details ");

        RunnerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RunnerName.setText("Runner Name: ");

        RunnerPerformance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RunnerPerformance.setText("Runner Performance: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RunnerDetailsLabel)
                    .addComponent(RiderAvgRatings, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(RunnerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentSelectedDriverID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RiderTotalCommision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RunnerPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(RunnerDetailsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RunnerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentSelectedDriverID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RiderAvgRatings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RiderTotalCommision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RunnerPerformance)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        VRDashboardReturnButton.setBackground(new java.awt.Color(225, 237, 243));
        VRDashboardReturnButton.setFont(new java.awt.Font("Songti TC", 1, 14)); // NOI18N
        VRDashboardReturnButton.setText("Return");
        VRDashboardReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VRDashboardReturnButtonActionPerformed(evt);
            }
        });

        SearchRunnerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SearchRunnerLabel.setText("Select RunnerID (exp D001):");

        selectRider.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D001", "D002", "D003", "All" }));
        selectRider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RiderPerformanceDashHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchRunnerLabel)
                        .addGap(18, 18, 18)
                        .addComponent(selectRider, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VRDashboardReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RiderPerformanceDashHeader)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchRunnerLabel)
                        .addComponent(selectRider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VRDashboardReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void loadDeliveriesForSelectedRunner(String selectedRunner) {
    DefaultTableModel model = (DefaultTableModel) RunnerPerformanceTable.getModel();
    model.setRowCount(0); 
    

    try (BufferedReader br = new BufferedReader(new FileReader("deliveries.txt"))) {
        String line;
        boolean found = false; 
        while ((line = br.readLine()) != null) {
            String[] data = line.split(":"); 
            if (data.length >= 10) {
                String runnerID = data[8]; //  Runner ID
                String completionStatus = data[7]; // Completion Status

                // Check if the selected runner is "All" or matches the runner ID
                if ("All".equals(selectedRunner) || runnerID.equals(selectedRunner)) {
                    model.addRow(new Object[]{
                        runnerID,
                        data[0], // DeliveryID
                        data[1], // OrderID
                        data[2], // CustomerID
                        data[3], // Rating
                        data[4], // Address
                        data[5], // Status
                        completionStatus, // Completion Status
                        data[8]  // Delivery Time
                    });
                    found = true; 
                }
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No deliveries found for the selected runner.");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading deliveries: " + e.getMessage());
    }
}

    private boolean loadRunnerDetails(String selectedRunner) {
        if (selectedRunner.equals("All")) {
            RunnerName.setText("Runner Name: "); 
            RiderTotalCommision.setText("Total Commission (RM): "); 
            return true; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean found = false; 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":"); 
                if (data.length >= 5 && data[1].equalsIgnoreCase(selectedRunner) && data[0].equals("deliveryrunner")) {
                    RunnerName.setText("Runner Name: " + data[2]); // Set the runner's name
                    RiderTotalCommision.setText("Total Commission (RM): " + data[4]); 
                    found = true; 
                    break; 
                }
            }
            if (!found) {
                return false; 
            }
            return found; 
            
        } catch (IOException e) {
            return false; 
        }
    }
         
    private void calculateAverageRating(String selectedRunner) {
        double totalRating = 0.0;
        double totalCommission = 0.0;
        int ratingCount = 0;
        int deliveryCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("review.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                
                if (data.length >= 10 && data[6] != null && data[6].equals(selectedRunner)) { //matches runner and selected runner
                    try {
                        
                        totalRating += Double.parseDouble(data[9]);
                        ratingCount++;
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing rating: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error calculating average rating: " + e.getMessage());
        }
        
        // Calculate total commission from deliveries
        try (BufferedReader br = new BufferedReader(new FileReader("deliveries.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 10 && data[8].equals(selectedRunner)) {
                    try {
                        totalCommission += Double.parseDouble(data[3]);
                        deliveryCount++;
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing commission: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error calculating total commission: " + e.getMessage());
        }
        // Calculate and display the average rating
        if (ratingCount > 0) {
            double averageRating = totalRating / ratingCount;
            RiderAvgRatings.setText("Runner Average Ratings (Stars): " + String.format("%.2f", averageRating));
        } else {
            RiderAvgRatings.setText("Runner Average Ratings (Stars): No ratings found.");
        }
    
    
        // Update the RunnerPerformance label
        if (deliveryCount > 0) {
            double performance = totalCommission / deliveryCount;
            RunnerPerformance.setText( "Peformance: "+String.format("%.2f", performance));
        } else {
            RunnerPerformance.setText("Peformance: No information found.");
        }
    }
     
    private void updateRiderInfo(String selectedRunner) {
    currentSelectedDriverID.setText("Current Rider Selected: " + selectedRunner); // Modify loadRunnerDetails to return a boolean
        if (loadRunnerDetails(selectedRunner)) {
            calculateAverageRating(selectedRunner); // Calculate average rating only if the runner is found
        }
    }
    
    private void VRDashboardReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VRDashboardReturnButtonActionPerformed
        this.dispose();
        new ManagerFrame().setVisible(true);        
    }//GEN-LAST:event_VRDashboardReturnButtonActionPerformed

    private void selectRiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRiderActionPerformed
        String selectedRunner = (String) selectRider.getSelectedItem();
        updateRiderInfo(selectedRunner);
        loadDeliveriesForSelectedRunner(selectedRunner);
    }//GEN-LAST:event_selectRiderActionPerformed

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
            java.util.logging.Logger.getLogger(RiderPerformanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RiderPerformanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RiderPerformanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RiderPerformanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RiderPerformanceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RiderAvgRatings;
    private javax.swing.JLabel RiderPerformanceDashHeader;
    private javax.swing.JLabel RiderTotalCommision;
    private javax.swing.JLabel RunnerDetailsLabel;
    private javax.swing.JLabel RunnerName;
    private javax.swing.JLabel RunnerPerformance;
    private javax.swing.JTable RunnerPerformanceTable;
    private javax.swing.JLabel SearchRunnerLabel;
    private javax.swing.JButton VRDashboardReturnButton;
    private javax.swing.JLabel currentSelectedDriverID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectRider;
    // End of variables declaration//GEN-END:variables
}
