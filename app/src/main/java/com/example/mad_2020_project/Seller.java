package com.example.mad_2020_project;


public class Seller {

    private int id,workers;
    private String username,email,mobileNo,venue,pswd,rePswd,dateFrom,dateTo;

    public Seller(){
    }

    public Seller(int id, String username, String email, String mobileNo, String venue, int workers, String dateFrom, String dateTo, String pswd, String rePswd) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.venue = venue;
        this.workers = workers;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.pswd = pswd;
        this.rePswd = rePswd;
    }

    public Seller(String username, String email, String mobileNo, String venue, int workers, String dateFrom, String dateTo, String pswd, String rePswd) {
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.venue = venue;
        this.workers = workers;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.pswd = pswd;
        this.rePswd = rePswd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getRePswd() {
        return rePswd;
    }

    public void setRePswd(String rePswd) {
        this.rePswd = rePswd;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
