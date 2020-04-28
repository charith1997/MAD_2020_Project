package com.example.mad_2020_project;

public class Item {

    private int id,quantity;
    private String name,price,location;

    public Item(){

    }

    public Item(int id, String name, String price, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }

    public Item(String name, String price, int quantity, String location) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
