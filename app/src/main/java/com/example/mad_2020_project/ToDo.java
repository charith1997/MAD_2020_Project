package com.example.mad_2020_project;

public class ToDo {
    private int id;
    private String name, price;
    private String started;
    private String finished;

    public ToDo(String name, String price,String started, String finished){

    }

    public ToDo(int id, String name, String price, String started, String finished) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.started=started;
        this.finished=finished;
    }

    public ToDo() {
        this.name=name;
        this.price=price;
        this.started=started;
        this.finished=finished;
    }

    public ToDo(String name, String price, long started, int finished) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price=price;
    }

    public long getStarted() {
        return Long.parseLong(started);
    }

    public void setStarted(long started) {
        this.started=String.valueOf(started);
    }

    public long getFinished() {
        return Long.parseLong(finished);
    }

    public void setFinished(long finished) {
        this.finished=String.valueOf(finished);
    }
}
