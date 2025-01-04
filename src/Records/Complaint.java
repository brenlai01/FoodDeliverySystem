package Records;

public class Complaint {
   private String customerID;
   private String complaintID;
   private String uniID;
   private String complaintInfo; 
   
   public Complaint(String customerID, String complaintID, String uniID, String complaintInfo){
       this.customerID = customerID;
       this.complaintID = complaintID;
       this.uniID = uniID;
       this.complaintInfo = complaintInfo;
   }
   
   //getter
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
   
   //change to string method
   @Override
   public String toString(){
       return customerID + ":" + complaintID + ":" + uniID + ":" + complaintInfo;
   }
}


