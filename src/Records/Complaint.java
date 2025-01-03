package Records;

public class Complaint {
   private String customerID;
   private String complaintID;
   private String complaintInfo; //message in text field
   
   public Complaint(String customerID, String complaintID, String complaintInfo){
       this.customerID = customerID;
       this.complaintID = complaintID;
       this.complaintInfo = complaintInfo;
   }
   
   //getter
   public String getCustomerID(){
       return customerID;
   }
   
   public String getComplaintID(){
       return complaintID;
   }
   
   public String getComplaintInfo(){
       return complaintInfo;
   }

   //change to string method
   @Override
   public String toString(){
       return customerID + ":" + complaintID + ":" + complaintInfo;
   }
}


