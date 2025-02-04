package Pages.Customer;

import FileManager.*;
import Models.*;
import Pages.*;
import Records.Notification;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CustomerFrame extends javax.swing.JFrame {
    
    private Customer customer;
    
    public CustomerFrame() {
        this.customer = (Customer) CurrentUser.getLoggedInUser();
        initComponents();
        updateBadgeButton();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CustomerDashboard = new javax.swing.JLabel();
        PlaceOrderButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CheckOrderHistoryButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CheckTransactionHistoryButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ProvideComplainsButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CustomerLogoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ViewComplainsHistory = new javax.swing.JButton();
        cmd = new Pages.Customer.BadgeButton();
        jLabel3 = new javax.swing.JLabel();
        EditInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        CustomerDashboard.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        CustomerDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CustomerDashboard.setText("Customer Dashboard");

        PlaceOrderButton.setText("Order");
        PlaceOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOrderButtonActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Place Order");

        CheckOrderHistoryButton.setText("View");
        CheckOrderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOrderHistoryButtonActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Order History");

        CheckTransactionHistoryButton.setText("View");
        CheckTransactionHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckTransactionHistoryButtonActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Transaction History");

        ProvideComplainsButton.setText("Provide");
        ProvideComplainsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvideComplainsButtonActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Complains");

        CustomerLogoutButton.setText("Logout");
        CustomerLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerLogoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Complains History");

        ViewComplainsHistory.setText("View");
        ViewComplainsHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewComplainsHistoryActionPerformed(evt);
            }
        });

        cmd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pages/Customer/icon.png"))); // NOI18N
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Edit Infomation");

        EditInfo.setText("Edit");
        EditInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlaceOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CheckTransactionHistoryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CheckOrderHistoryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(ProvideComplainsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ViewComplainsHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(EditInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(CustomerLogoutButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(CustomerDashboard)))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlaceOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(CheckOrderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckTransactionHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProvideComplainsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewComplainsHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(CustomerLogoutButton)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerLogoutButtonActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomerLogoutButtonActionPerformed

    private void ProvideComplainsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvideComplainsButtonActionPerformed
        new CustomerComplaint().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProvideComplainsButtonActionPerformed

    private void CheckTransactionHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckTransactionHistoryButtonActionPerformed
        new CustomerTransactionHistory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CheckTransactionHistoryButtonActionPerformed

    private void CheckOrderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOrderHistoryButtonActionPerformed
        new CustomerOrderHistory() .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CheckOrderHistoryButtonActionPerformed

    private void PlaceOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOrderButtonActionPerformed
        new ViewMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlaceOrderButtonActionPerformed

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        displayNotifications();
    }//GEN-LAST:event_cmdActionPerformed

    private void ViewComplainsHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewComplainsHistoryActionPerformed
        new CustomerComplaintHistory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewComplainsHistoryActionPerformed

    private void EditInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditInfoActionPerformed
        new CustomerEditInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditInfoActionPerformed

    private void displayNotifications() {
    
        String customerID = CurrentUser.getLoggedInUser().getUid();
        ArrayList<Notification> notifications = FileManager.loadNotifications("notifications.txt");
        
        notifications.sort((n1, n2) -> n2.getDateTime().compareTo(n1.getDateTime()));
        
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS)); 

        boolean hasUnread = false;
        boolean hasRead = false;
        
        JLabel newHeader = new JLabel("Notifications");
        newHeader.setFont(newHeader.getFont().deriveFont(16f).deriveFont(Font.BOLD));
        notificationPanel.add(newHeader);
        
        for (Notification notification : notifications) {
            if (notification.getUserID().equals(customerID) && notification.getStatus().equalsIgnoreCase("Unread")) {
                JLabel notificationLabel = new JLabel(
                    String.format("<html><b>%s</b><br>%s</html>", notification.getMessage(), notification.getDateTime())
                );
                notificationLabel.setForeground(Color.RED);
                notificationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
                notificationPanel.add(notificationLabel);
                notification.setStatus("Read"); 
                hasUnread = true;
            } else if (notification.getUserID().equals(customerID) && notification.getStatus().equalsIgnoreCase("Read")) {
                JLabel notificationLabel = new JLabel(
                    String.format("<html><b>%s</b><br>%s</html>", notification.getMessage(), notification.getDateTime())
                );
                notificationLabel.setForeground(Color.GRAY);
                notificationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
                notificationPanel.add(notificationLabel);
                hasRead = true;
            }
        }
        
        if (!hasUnread && !hasRead) {
            notificationPanel.add(new JLabel("No notifications."));
        }
        
        FileManager.writeNotifications("notifications.txt", notifications);
        
        JScrollPane scrollPane = new JScrollPane(notificationPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        
        JOptionPane.showMessageDialog(this, scrollPane, "Notifications", JOptionPane.INFORMATION_MESSAGE);
        updateBadgeButton();
    }
    
    private void updateBadgeButton() {
        ArrayList<Notification> notifications = FileManager.loadNotifications("notifications.txt");
        String customerID = CurrentUser.getLoggedInUser().getUid();

        int unreadCount = 0;
        for (Notification notification : notifications) {
            if (notification.getUserID().equals(customerID) && notification.getStatus().equalsIgnoreCase("Unread")) {
                unreadCount++;
            }
        }

        // Update the badge button text with unread count
        if (unreadCount > 0) {
            cmd.setText(String.valueOf(unreadCount));
        } else {
            cmd.setText(""); // Clear the badge text if no unread notifications
        }
    }



    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckOrderHistoryButton;
    private javax.swing.JButton CheckTransactionHistoryButton;
    private javax.swing.JLabel CustomerDashboard;
    private javax.swing.JButton CustomerLogoutButton;
    private javax.swing.JButton EditInfo;
    private javax.swing.JButton PlaceOrderButton;
    private javax.swing.JButton ProvideComplainsButton;
    private javax.swing.JButton ViewComplainsHistory;
    private Pages.Customer.BadgeButton cmd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
