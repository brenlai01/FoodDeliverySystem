package Records;

public class Voucher {

    private String voucherID;
    private String customerID;
    private boolean isUsed;
    
    public Voucher(String voucherID, String customerID) {
        this.voucherID = voucherID;
        this.customerID = customerID;
        this.isUsed = false;
    }
    
    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public String getCustomerID() {
        return customerID;
    }
    
    public boolean getIsUsed() {
        return isUsed;
    }
    
    public void useVoucher() {
        this.isUsed = true;
    }
    
    @Override
    public String toString(){
        return voucherID + ":" + customerID + ":" + isUsed;
    }
}
