package com.example.mad_2020_project;

public class Student {

    private int studentId;
    private String  studentName,email,mobileNo,password,confirmPassword;

    public Student(){

    }

    public Student(int studentId, String  studentName, String email, String mobileNo, String password, String confirmPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Student(String studentName, String email, String mobileNo, String password, String confirmPassword) {
        this.studentName = studentName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
