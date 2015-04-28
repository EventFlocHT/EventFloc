package com.example.raymond.eventfloc;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class Student extends User {
    private int studentID;
    private String firstName;
    private String lastName;


    public Student(int userID, String userEmail, char password, int studentID, String firstName, String lastName) {
        super(userID, userEmail, password);
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
