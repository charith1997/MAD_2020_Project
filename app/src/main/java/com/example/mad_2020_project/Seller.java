package com.example.mad_2020_project;

public class Seller {

    private int id;
    private String name,email,phoneNo,location,workers,fromDate,toDate,password;

    public Seller(){

    }

    public Seller(int id, String name, String email, String phoneNo, String location, String workers, String fromDate, String toDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.location = location;
        this.workers = workers;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.password = password;
    }

    public Seller(String name, String email, String phoneNo, String location, String workers, String fromDate, String toDate, String password) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.location = location;
        this.workers = workers;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkers() {
        return workers;
    }

    public void setWorkers(String workers) {
        this.workers = workers;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
