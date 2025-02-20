package Pages.Vendor;

import FileManager.*;
import Records.FoodImage;
import Records.Voucher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;

public class ManageItemFrame extends javax.swing.JFrame {
    /**
     * Creates new form Manage_Item
     */
    
    public ManageItemFrame() {
        initComponents();
        foodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodTableMouseClicked(evt);
            }
        });
        vendorIDLabel.setText("Current Logged In Vendor ID: " + CurrentUser.getLoggedInUser().getUid());
        refreshData();
    }
    
    private void foodTableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int selectedRow = foodTable.getSelectedRow();
        if (selectedRow != -1) {
            foodIDTxt.setText((String) foodTable.getValueAt(selectedRow, 1));
            foodNameTxt.setText((String) foodTable.getValueAt(selectedRow, 2));
            priceTxt.setText((String) foodTable.getValueAt(selectedRow, 3));
            descriptionTxt.setText((String) foodTable.getValueAt(selectedRow, 4));
            System.out.println("Selected Food ID: " + foodIDTxt.getText());
        }
    }
    
    public void refreshData() {
        try{
            DefaultTableModel model = (DefaultTableModel) foodTable.getModel();
            model.setRowCount(0);
            String foodFile = "foodItems.txt";
            FileReader fr = new FileReader(foodFile);
            BufferedReader br = new BufferedReader(fr);
            String read;
            String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
            while ((read = br.readLine()) != null) {
                String[] data = read.split(":");
                if (data.length == 5){
                    String[] foodData = {
                        data[1],
                        data[0],
                        data[2],
                        data[4],
                        data[3]
                    };
                    if(data[1].equals(loggedInVendorId)){
                        model.addRow(foodData);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading food items data: " + e.getMessage());
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

        MngeItmPanel = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        foodIDTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        foodNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        createBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        vendorIDLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        MngeItmLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        jLabel6.setText("Search");

        javax.swing.GroupLayout MngeItmPanelLayout = new javax.swing.GroupLayout(MngeItmPanel);
        MngeItmPanel.setLayout(MngeItmPanelLayout);
        MngeItmPanelLayout.setHorizontalGroup(
            MngeItmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MngeItmPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        MngeItmPanelLayout.setVerticalGroup(
            MngeItmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MngeItmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MngeItmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jLabel1.setText("Food ID:");

        foodIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodIDTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Food Name:");

        jLabel4.setText("Price:");

        jLabel5.setText("Description:");

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        jScrollPane1.setViewportView(descriptionTxt);

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        vendorIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vendorIDLabel.setText("vendorID:      V001");

        jLabel7.setText("Picture:");

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vendorIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(foodIDTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(foodNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(uploadButton, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vendorIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(foodIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(foodNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadButton)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn)
                    .addComponent(returnBtn)))
        );

        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vendor ID", "Food ID", "Food Name", "Price", "Description"
            }
        ));
        foodTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(foodTable);
        if (foodTable.getColumnModel().getColumnCount() > 0) {
            foodTable.getColumnModel().getColumn(0).setMinWidth(67);
            foodTable.getColumnModel().getColumn(0).setMaxWidth(67);
            foodTable.getColumnModel().getColumn(1).setMinWidth(60);
            foodTable.getColumnModel().getColumn(1).setMaxWidth(60);
            foodTable.getColumnModel().getColumn(2).setMinWidth(100);
            foodTable.getColumnModel().getColumn(2).setMaxWidth(100);
            foodTable.getColumnModel().getColumn(3).setMinWidth(50);
            foodTable.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        MngeItmLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MngeItmLbl.setText("Manage Item Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(MngeItmLbl)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MngeItmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MngeItmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MngeItmLbl)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        if (foodNameTxt.getText().trim().isEmpty() ||
            priceTxt.getText().trim().isEmpty() ||
            descriptionTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Plaese fill in all fields!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String foodID = generateNewFoodID();
        String vendorID = CurrentUser.getLoggedInUser().getUid();
        String foodName = foodNameTxt.getText().trim();
        String description = descriptionTxt.getText().trim();
        double price;
        try {
            price = Double.parseDouble(priceTxt.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price format! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            String foodFile = "foodItems.txt";
            FileWriter fw = new FileWriter(foodFile,true);
            fw.write(
                foodID +":"
                + vendorID + ":"
                + foodName+ ":"
                + description + ":"
                + price + "\n"
            );
            fw.close();
            JOptionPane.showMessageDialog(null, "Successfully food informations!");
            refreshData();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_createBtnActionPerformed
    private String generateNewFoodID() {
        String lastFoodID = "F000";
        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 5) {
                    lastFoodID = data[0]; // Get the last food ID
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }

        String numericPart = lastFoodID.substring(1);
        int newIdNumber = Integer.parseInt(numericPart) + 1;
        return "F" + String.format("%03d", newIdNumber);
    }
    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String searchText = searchTxt.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) foodTable.getModel();
        model.setRowCount(0);

        if (searchText.isEmpty()) {
            refreshData();
            return;
        }
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();
        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length >= 5) {
                    if(data[1].equals(loggedInVendorId)){
                        String vendorID = data[1].trim().toLowerCase();
                        String foodID = data[0].trim().toLowerCase();
                        String foodName = data[2].trim().toLowerCase();
                        String description = data[3].trim().toLowerCase();
                        String price = data[4].trim().toLowerCase();

                        if (vendorID.contains(searchText) || foodID.contains(searchText) || 
                            foodName.contains(searchText) || description.contains(searchText) || 
                            price.contains(searchText)) {
                            model.addRow(new Object[]{data[1], data[0], data[2], data[4], data[3]});
                        }
                    }

                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String loggedInVendorId = CurrentUser .getLoggedInUser ().getUid();

        if (foodIDTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a food item to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String foodID = foodIDTxt.getText().trim();
        //System.out.println("Attempting to delete Food ID: " + foodID);

        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
            StringBuilder updatedData = new StringBuilder();
            String line;
            boolean found = false;
            boolean isOwner = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length == 5) {
                    //System.out.println("Checking line: " + line);
                    if (data[0].equals(foodID)) {
                        found = true;
                        if (data[1].equals(loggedInVendorId)) {
                            isOwner = true;
                            //System.out.println("Food item found and marked for deletion.");
                        } else {
                            updatedData.append(line).append("\n");
                        }
                    } else {
                        updatedData.append(line).append("\n");
                    }
                }
            }

            if (found) {
                if (isOwner) {
                    try (FileWriter fw = new FileWriter("foodItems.txt")) {
                        fw.write(updatedData.toString());
                    }
                    JOptionPane.showMessageDialog(null, "Food item deleted successfully!");
                    refreshData();
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have permission to delete this food item!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Food ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error deleting food item: " + e.getMessage());
        }        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String loggedInVendorId = CurrentUser.getLoggedInUser().getUid();

        if (foodIDTxt.getText().trim().isEmpty() || 
            foodNameTxt.getText().trim().isEmpty() ||
            priceTxt.getText().trim().isEmpty() ||
            descriptionTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String foodID = foodIDTxt.getText().trim();
        String foodName = foodNameTxt.getText().trim();
        double price;
        try {
            price = Double.parseDouble(priceTxt.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price format! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String description = descriptionTxt.getText().trim();

        try (BufferedReader br = new BufferedReader(new FileReader("foodItems.txt"))) {
            StringBuilder updatedData = new StringBuilder();
            String line;
            boolean found = false;
            boolean isOwner = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");
                if (data.length == 5) {
                    if (data[0].equals(foodID)) {
                        if (data[1].equals(loggedInVendorId)) {
                            updatedData.append(foodID).append(":")
                                        .append(loggedInVendorId).append(":")
                                        .append(foodName).append(":")
                                        .append(description).append(":")
                                        .append(price).append("\n");
                            isOwner = true;
                        } else {
                            updatedData.append(line).append("\n");
                        }
                        found = true;
                    } else {
                        updatedData.append(line).append("\n");
                    }
                }
            }

            if (found) {
                if (isOwner) {
                    try (FileWriter fw = new FileWriter("foodItems.txt")) {
                        fw.write(updatedData.toString());
                    }
                    JOptionPane.showMessageDialog(null, "Food information updated successfully!");
                    refreshData();
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have permission to update this food item!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Food ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating food information: " + e.getMessage());
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        foodIDTxt.setText("");
        foodNameTxt.setText("");
        priceTxt.setText("");
        descriptionTxt.setText("");
        searchTxt.setText("");
        refreshData();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        new VendorFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void foodIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodIDTxtActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
                                                  // Get Food ID from the text field
        String foodID = foodIDTxt.getText().trim();

        // Validate Food ID
        if (foodID == null || foodID.isEmpty()) {
            System.out.println("No Food ID entered. Upload canceled.");
            return;
        }

        // Set up the file chooser
        JnaFileChooser ch = new JnaFileChooser();
        ch.setTitle("Select Food Image");
        ch.addFilter("Image Files", "jpg", "jpeg", "png");
        boolean action = ch.showOpenDialog(this);

        // If the user selects a file
        if (action) {
            File selectedFile = ch.getSelectedFile(); // Selected image file

            // Create "images" folder if it doesn't exist
            File projectFolder = new File("images");
            if (!projectFolder.exists()) {
                projectFolder.mkdir();
            }

            // Create destination file with a unique name
            File destinationFile = new File(projectFolder, foodID + "_" + selectedFile.getName());

            try {
                // Copy the selected image to the "images" folder
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Create FoodImage object with relative path
                String relativePath = "images/" + destinationFile.getName();
                FoodImage foodImage = new FoodImage(foodID, relativePath);

                // Save the FoodImage details to food_images.txt
                saveFoodImageToFile(foodImage);

                System.out.println("Image uploaded and saved successfully!");

            } catch (IOException e) {
                System.out.println("Error uploading image: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_uploadButtonActionPerformed
    
    private void saveFoodImageToFile(FoodImage foodImage) {
        File file = new File("food_images.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Append FoodID and image path to the file
            writer.write(foodImage.getFoodID() + "," + foodImage.getImageFile());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving food image: " + e.getMessage());
        }
    }


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
            java.util.logging.Logger.getLogger(ManageItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MngeItmLbl;
    private javax.swing.JPanel MngeItmPanel;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JTextField foodIDTxt;
    private javax.swing.JTextField foodNameTxt;
    private javax.swing.JTable foodTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel vendorIDLabel;
    // End of variables declaration//GEN-END:variables
}
