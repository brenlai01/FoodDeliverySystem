package Records;

public class Complaint {
    private String customerID;
    private String complaintID;
    private String uniID;
    private String complaintInfo; 
    private String managerReply;
    private String complaintStatus; // unresolved -> resolved

    public Complaint(String customerID, String complaintID, String uniID, String complaintInfo, String managerReply, String complaintStatus){
        this.customerID = customerID;
        this.complaintID = complaintID;
        this.uniID = uniID;
        this.complaintInfo = complaintInfo;
        this.managerReply = managerReply;
        this.complaintStatus = complaintStatus;
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

    public void setManagerReply(String managerReply) {
        this.managerReply = managerReply;
    }

    public String getComplaintStatus(){
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    //change to string method
    @Override
    public String toString(){
        return customerID + ":" + complaintID + ":" + uniID + ":" + complaintInfo + ":" + managerReply + ":" + complaintStatus;
    }
}


