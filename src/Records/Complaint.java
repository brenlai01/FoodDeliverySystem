package Records;

public class Complaint {
   private String customerID;
   private String complaintID;
   private String uniID;
   private String complaintInfo; 
   private String managerReply;
   private String complaintStatus; // unresolved -> resolved
   
   public Complaint(String customerID, String complaintID, String uniID, String complaintInfo, String reply, String status){
       this.customerID = customerID;
       this.complaintID = complaintID;
       this.uniID = uniID;
       this.complaintInfo = complaintInfo;
       this.managerReply = reply;
       this.complaintStatus = status;
   }
   
   //getter & setter
   public String getCustomerID(){
       return customerID;
   }
   
   public String getComplaintID(){
       return complaintID;
   }
   
   public String getUniID(){
       return uniID;
   }
   
   public String getComplaintInfo(){
       return complaintInfo;
   }
   
   public void setComplaintInfo(String complaintInfo){
       this.complaintInfo = complaintInfo;
   }
   
   public String getManagerReply() {
       return managerReply;
   }
   
   public void setManagerReply(String reply) {
       this.managerReply = reply;
   }
   public String getComplaintStatus(){
       return complaintStatus;
   }
   
   public void setComplaintStatus(String status) {
       this.complaintStatus = status;
   }
   
   //change to string method
   @Override
   public String toString(){
       return customerID + ":" + complaintID + ":" + uniID + ":" + complaintInfo;
   }
}


