package Pages.Admin;
import Enum.TransactionType;
import FileManager.*;
import Models.*;
import Records.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TopUpFrame extends javax.swing.JFrame {
    
    private Admin admin;
    
    public TopUpFrame() {
        this.admin = (Admin) CurrentUser.getLoggedInUser();
        initComponents();
        addCustomerSelectionListener();
        addSearchFieldListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Admin = new javax.swing.JLabel();
        UserPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        selectedUserField = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        currentBalancetxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        topUpAmounttxt = new javax.swing.JTextField();
        TopUpButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 400));

        MainPanel.setPreferredSize(new java.awt.Dimension(470, 300));
        MainPanel.setRequestFocusEnabled(false);
        MainPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(470, 35));

        Admin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Admin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Admin.setText("Admin Dashboard");
        Admin.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Admin.setPreferredSize(new java.awt.Dimension(400, 25));
        Admin.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        MainPanel.add(jPanel2, java.awt.BorderLayout.NORTH);

        UserPanel.setPreferredSize(new java.awt.Dimension(470, 215));

        jLabel6.setText("Search");

        searchField.setPreferredSize(new java.awt.Dimension(100, 25));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Customers");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(180, 200));

        jScrollPane1.setViewportView(customerList);

        jLabel2.setText("Selected Customer");

        selectedUserField.setPreferredSize(new java.awt.Dimension(160, 25));
        selectedUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedUserFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Current Balance");

        currentBalancetxt.setPreferredSize(new java.awt.Dimension(160, 25));
        currentBalancetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentBalancetxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Top-up Amount ");

        topUpAmounttxt.setPreferredSize(new java.awt.Dimension(120, 25));

        TopUpButton.setText("Top-Up");
        TopUpButton.setPreferredSize(new java.awt.Dimension(70, 25));
        TopUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopUpButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Return");
        ReturnButton.setPreferredSize(new java.awt.Dimension(76, 25));
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addComponent(TopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(currentBalancetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(topUpAmounttxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(selectedUserField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectedUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addComponent(currentBalancetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topUpAmounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.add(UserPanel, java.awt.BorderLayout.LINE_START);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }//GEN-LAST:event_searchFieldActionPerformed

    private void selectedUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedUserFieldActionPerformed

    private void currentBalancetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentBalancetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentBalancetxtActionPerformed

    private void TopUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUpButtonActionPerformed
        
        String selectedValue = customerList.getSelectedValue();
        
        if (selectedValue == null) {
            JOptionPane.showMessageDialog(this, "Please select a customer to top-up.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Splitting of customer Id from the id-username string (e.g. C001 - customer1)
        String cid = selectedValue.split(" - ")[0];
        double topUpAmount;
        
        // make sure customer enters a double
        try {
            topUpAmount = Double.parseDouble(topUpAmounttxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid balance value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<User> users = FileManager.loadUsers("users.txt");
        ArrayList<Transaction> txns = FileManager.loadTxns("transactions.txt");
        ArrayList<Notification> notifications = FileManager.loadNotifications("notifications.txt");
        
        boolean topUpSucess = admin.topUpCredit(users, cid, topUpAmount);
        
        if (topUpSucess) {
            
            String txnID = FileManager.getTxnID(txns); // Getting txn details & createing new txn
            String dateTime = FileManager.getDateTime();
            Transaction txn = new Transaction(txnID, cid, TransactionType.TOP_UP, topUpAmount, dateTime);
            txns.add(txn);
            
            String nid = FileManager.getNotificationID(notifications);
            String msg = "Your balance has been topped up by RM" + topUpAmount;
            Notification notification = new Notification(nid, cid, msg, dateTime, "Unread");
            notifications.add(notification);
            
            FileManager.writeUsers("users.txt", users);
            FileManager.writeTxns("transactions.txt", txns);
            FileManager.writeNotifications("notifications.txt", notifications);
            
            JOptionPane.showMessageDialog(null, "Top-up successful!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            selectedUserField.setText("");
            currentBalancetxt.setText("");
            topUpAmounttxt.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_TopUpButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        new AdminFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    // Display all users at the start of program
    public void updateCustomerList(String query) {
        
        ArrayList<User> users = FileManager.loadUsers("users.txt");
        ArrayList<String> displayUsers = new ArrayList<>();
        
        for (User user : users) {
            if (user instanceof Customer) {
                String userDisplay = user.getUid() + " - " + user.getUsername();

                if (query.isEmpty() || userDisplay.toLowerCase().contains(query.toLowerCase())) {
                    displayUsers.add(userDisplay);
                }
            }
        }
        customerList.setListData(displayUsers.toArray(new String[0]));
    }
    
    private void addCustomerSelectionListener() {
        
        customerList.addListSelectionListener(listener -> {
            if (!listener.getValueIsAdjusting() && customerList.getSelectedValue() != null) {
                String selectedUser = customerList.getSelectedValue();
                String selectedUID = selectedUser.split(" - ")[0];
                
                ArrayList<User> users = FileManager.loadUsers("users.txt");
                for (User user : users) {
                    if (user.getUid().equals(selectedUID)) {
                        selectedUserField.setText(selectedUser);
                        selectedUserField.setEditable(false);
                        currentBalancetxt.setText(String.valueOf(user.getBalance()));
                        currentBalancetxt.setEditable(false);
                        break;
                    }
                }
            }
        });
    }
    
    private void addSearchFieldListener() {                                         
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e){
                updateCustomerList(searchField.getText().trim());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCustomerList(searchField.getText().trim());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCustomerList(searchField.getText().trim());
            }
        });  
    }
   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TopUpFrame frame = new TopUpFrame();
                frame.setVisible(true);
                frame.updateCustomerList("");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton TopUpButton;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JTextField currentBalancetxt;
    private javax.swing.JList<String> customerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    private javax.swing.JFormattedTextField selectedUserField;
    private javax.swing.JTextField topUpAmounttxt;
    // End of variables declaration//GEN-END:variables
}
