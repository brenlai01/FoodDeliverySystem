package Records;

public class Transaction {
    private String txnID;
    private String customerID;
    private String txnType;
    private double topUpAmount;
    private String date;
    
    public Transaction (String txnid, String cid, String txnType, double amount, String date) {
        this.setTxnID(txnid);
        this.setCustomerID(cid);
        this.setTxnType(txnType);
        this.setTopUpAmount(amount);
        this.setDate(date);
        
    }
    
    public String getTxnID() {
        return txnID;
    }
    public void setTxnID(String rid) {
        this.txnID = rid;
    }
    
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String cid) {
        this.customerID = cid;
    }
    
    public String getTxnType() {
        return txnType;
    }
    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }
    
    public double getTopUpAmount() {
        return topUpAmount;
    }
    public void setTopUpAmount(double amount) {
        this.topUpAmount = amount;
    }
    
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    
    @Override
    public String toString(){
        return txnID + ":" + customerID + ":" + txnType + ":" + topUpAmount + ":" + date;
    }
    
}