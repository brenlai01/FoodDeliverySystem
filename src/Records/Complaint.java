package Records;

public class Complaint {
   private String complaintID;
   private String customerID;
   private String complaintInfo; //message in text field
   
   public Complaint(String complaintID, String customerID, String complaintInfo){
       
       this.setComplaintID(complaintID);
       this.setCustomerID(customerID);
       this.setComplaintInfo(complaintInfo);
   }
   
   //getter
   public String getComplaintID(){
       return complaintID;
   }
   
   public String getCustomerID(){
       return customerID;
   }
   
   public String getComplaintInfo(){
       return complaintInfo;
   }
   
   //setter
   public void setComplaintID(String complaintID){
       this.complaintID = complaintID;
   }
   
   public void setCustomerID(String customerID){
       this.customerID = customerID;
   }
   
   public void setComplaintInfo(String complaintInfo){
       this.complaintInfo = complaintInfo;
   }
   
   //change to string method
   @Override
   public String toString(){
       return "Complaint ID: " + complaintID + "\n" +
               "Customer ID: " + customerID + "\n" +
               "Complaint information: " + complaintInfo;
   }
}


