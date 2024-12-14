package Pages.Vendor;
import Records.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CreateItemFrame extends javax.swing.JFrame {

    /**
     * Creates new form CreateItemFrame
     */
    public CreateItemFrame() {
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

        CrtItmPnl = new javax.swing.JPanel();
        CrtItmLbl = new javax.swing.JLabel();
        BtnPnl = new javax.swing.JPanel();
        ReturnBtn = new javax.swing.JButton();
        CreateBtn = new javax.swing.JButton();
        FoodIDPnl = new javax.swing.JPanel();
        FoodIDLbl = new javax.swing.JLabel();
        FoodIDTxt = new javax.swing.JTextField();
        VendorIDPnl = new javax.swing.JPanel();
        VendorIDLbl = new javax.swing.JLabel();
        VendorIDTxt = new javax.swing.JTextField();
        FoodNamePnl = new javax.swing.JPanel();
        FoodNameLbl = new javax.swing.JLabel();
        FoodNameTxt = new javax.swing.JTextField();
        PricePnl = new javax.swing.JPanel();
        PriceLbl = new javax.swing.JLabel();
        PriceTxt = new javax.swing.JTextField();
        DescripPnl = new javax.swing.JPanel();
        DescriptionLbl = new javax.swing.JLabel();
        DiscrpScrollPnl = new javax.swing.JScrollPane();
        DescriptionTxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CrtItmLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CrtItmLbl.setText("Create Item Dashboard");

        javax.swing.GroupLayout CrtItmPnlLayout = new javax.swing.GroupLayout(CrtItmPnl);
        CrtItmPnl.setLayout(CrtItmPnlLayout);
        CrtItmPnlLayout.setHorizontalGroup(
            CrtItmPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrtItmPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CrtItmLbl)
                .addGap(158, 158, 158))
        );
        CrtItmPnlLayout.setVerticalGroup(
            CrtItmPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrtItmPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CrtItmLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ReturnBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReturnBtn.setText("Return");
        ReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBtnActionPerformed(evt);
            }
        });

        CreateBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreateBtn.setText("Create");
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BtnPnlLayout = new javax.swing.GroupLayout(BtnPnl);
        BtnPnl.setLayout(BtnPnlLayout);
        BtnPnlLayout.setHorizontalGroup(
            BtnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(CreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BtnPnlLayout.setVerticalGroup(
            BtnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturnBtn)
                    .addComponent(CreateBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FoodIDLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FoodIDLbl.setText("Food ID");

        javax.swing.GroupLayout FoodIDPnlLayout = new javax.swing.GroupLayout(FoodIDPnl);
        FoodIDPnl.setLayout(FoodIDPnlLayout);
        FoodIDPnlLayout.setHorizontalGroup(
            FoodIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodIDPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FoodIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FoodIDTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addGroup(FoodIDPnlLayout.createSequentialGroup()
                        .addComponent(FoodIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FoodIDPnlLayout.setVerticalGroup(
            FoodIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodIDPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FoodIDLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FoodIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        VendorIDLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VendorIDLbl.setText("Vendor ID");

        javax.swing.GroupLayout VendorIDPnlLayout = new javax.swing.GroupLayout(VendorIDPnl);
        VendorIDPnl.setLayout(VendorIDPnlLayout);
        VendorIDPnlLayout.setHorizontalGroup(
            VendorIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VendorIDPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VendorIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VendorIDPnlLayout.createSequentialGroup()
                        .addComponent(VendorIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(VendorIDTxt))
                .addContainerGap())
        );
        VendorIDPnlLayout.setVerticalGroup(
            VendorIDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VendorIDPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VendorIDLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VendorIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FoodNameLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FoodNameLbl.setText("Food Name");

        javax.swing.GroupLayout FoodNamePnlLayout = new javax.swing.GroupLayout(FoodNamePnl);
        FoodNamePnl.setLayout(FoodNamePnlLayout);
        FoodNamePnlLayout.setHorizontalGroup(
            FoodNamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodNamePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FoodNamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FoodNameTxt)
                    .addComponent(FoodNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        FoodNamePnlLayout.setVerticalGroup(
            FoodNamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FoodNamePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FoodNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FoodNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PriceLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PriceLbl.setText("Price");

        PriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PricePnlLayout = new javax.swing.GroupLayout(PricePnl);
        PricePnl.setLayout(PricePnlLayout);
        PricePnlLayout.setHorizontalGroup(
            PricePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PricePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PricePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PricePnlLayout.createSequentialGroup()
                        .addComponent(PriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PriceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        PricePnlLayout.setVerticalGroup(
            PricePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PricePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PriceLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DescriptionLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DescriptionLbl.setText("Description");

        DescriptionTxt.setColumns(20);
        DescriptionTxt.setRows(5);
        DiscrpScrollPnl.setViewportView(DescriptionTxt);

        javax.swing.GroupLayout DescripPnlLayout = new javax.swing.GroupLayout(DescripPnl);
        DescripPnl.setLayout(DescripPnlLayout);
        DescripPnlLayout.setHorizontalGroup(
            DescripPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DescripPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DescriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiscrpScrollPnl)
                .addContainerGap())
        );
        DescripPnlLayout.setVerticalGroup(
            DescripPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DescripPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DescripPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescriptionLbl)
                    .addComponent(DiscrpScrollPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CrtItmPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DescripPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FoodIDPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VendorIDPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FoodNamePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PricePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CrtItmPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PricePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodIDPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VendorIDPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodNamePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DescripPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBtnActionPerformed
        new ManageItemFrame().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ReturnBtnActionPerformed

    private void PriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTxtActionPerformed

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        
        String foodID = FoodIDTxt.getText().trim();
        String vendorID = VendorIDTxt.getText().trim();
        String foodName = FoodNameTxt.getText().trim();
        String price = PriceTxt.getText().trim();
        String description = DescriptionTxt.getText().trim();
        
        ArrayList<Food> foods = Food.loadFoods("fooditems.txt");
        
        if (foodID.equals("") || vendorID.equals("") || foodName.equals("") || price.equals("") || description.equals("")) {
            JOptionPane.showMessageDialog(null, "Please provide some info.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_CreateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CreateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnPnl;
    private javax.swing.JButton CreateBtn;
    private javax.swing.JLabel CrtItmLbl;
    private javax.swing.JPanel CrtItmPnl;
    private javax.swing.JPanel DescripPnl;
    private javax.swing.JLabel DescriptionLbl;
    private javax.swing.JTextArea DescriptionTxt;
    private javax.swing.JScrollPane DiscrpScrollPnl;
    private javax.swing.JLabel FoodIDLbl;
    private javax.swing.JPanel FoodIDPnl;
    private javax.swing.JTextField FoodIDTxt;
    private javax.swing.JLabel FoodNameLbl;
    private javax.swing.JPanel FoodNamePnl;
    private javax.swing.JTextField FoodNameTxt;
    private javax.swing.JLabel PriceLbl;
    private javax.swing.JPanel PricePnl;
    private javax.swing.JTextField PriceTxt;
    private javax.swing.JButton ReturnBtn;
    private javax.swing.JLabel VendorIDLbl;
    private javax.swing.JPanel VendorIDPnl;
    private javax.swing.JTextField VendorIDTxt;
    // End of variables declaration//GEN-END:variables
}
