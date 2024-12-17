package Records;
import Enum.TransactionType;

public class Transaction {
    private String txnID;
    private String customerID;
    private TransactionType txnType;
    private double topUpAmount;
    private String dateTime;
    
    public Transaction (String txnid, String cid, TransactionType txnType, double amount, String dateTime) {
        this.setTxnID(txnid);
        this.setCustomerID(cid);
        this.setTxnType(txnType);
        this.setTopUpAmount(amount);
        this.setDateTime(dateTime);
        
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
    
    public TransactionType getTxnType() {
        return txnType;
    }
    public void setTxnType(TransactionType txnType) {
        this.txnType = txnType;
    }
    
    public double getTopUpAmount() {
        return topUpAmount;
    }
    public void setTopUpAmount(double amount) {
        this.topUpAmount = amount;
    }
    
    public String getDate(){
        return dateTime;
    }
    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }
    
    @Override
    public String toString(){
        return txnID + ":" + customerID + ":" + txnType + ":" + topUpAmount + ":" + dateTime;
    }
    
}