package com.example.raymond.eventfloc;

import java.util.Date;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class Society extends User {
    private int societyID;
    private String societyName;
    private Date approvalDate;
    private String description;
    private String societyFaculty;

    public Society(int userID, String userEmail, char password, int societyID, String societyName,
                   Date approvalDate, String description, String societyFaculty) {
        super(userID, userEmail, password);

        this.societyID = societyID;
        this.societyName = societyName;
        this.approvalDate = approvalDate;
        this.description = description;
        this.societyFaculty = societyFaculty;
    }

    public String getSocietyFaculty() {
        return societyFaculty;
    }

    public void setSocietyFaculty(String societyFaculty) {
        this.societyFaculty = societyFaculty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public int getSocietyID() {
        return societyID;
    }

    public void setSocietyID(int societyID) {
        this.societyID = societyID;
    }


}
