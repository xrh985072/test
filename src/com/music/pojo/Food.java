package com.music.pojo;

public class Food {
    private int id;
    private String name;
    private int inventory;
    private Double price;
    private int salenumber;
    private String t_type;



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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSalenumber() {
        return salenumber;
    }

    public void setSalenumber(int salenumber) {
        this.salenumber = salenumber;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public Food(int id, String name, int inventory, Double price, String t_type) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.t_type = t_type;
    }

    public Food(String name, int inventory, Double price) {
        this.name = name;
        this.inventory = inventory;
        this.price = price;
    }

    public Food(String name, int inventory, Double price, String t_type) {
        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.t_type = t_type;
    }

    public Food(String name, Double price, int salenumber, String t_type) {
        this.name = name;
        this.price = price;
        this.salenumber = salenumber;
        this.t_type = t_type;
    }

    public Food(int id, String name, int inventory, Double price, int salenumber, String t_type) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.salenumber = salenumber;
        this.t_type = t_type;
    }

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                ", price=" + price +
                ", salenumber=" + salenumber +
                ", t_type='" + t_type + '\'' +
                '}';
    }
}
