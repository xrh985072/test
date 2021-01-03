package com.music.pojo;

public class Order {
    int orderid;
    String id;
    String username;
    int number;
    double price;
    String phone;
    String address;
    String ordertime;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Order(int orderid, String id, String username, int number, double price, String phone, String address, String ordertime) {
        this.orderid = orderid;
        this.id = id;
        this.username = username;
        this.number = number;
        this.price = price;
        this.phone = phone;
        this.address = address;
        this.ordertime = ordertime;
    }

    public Order(String id, String username, String phone, String address) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", ordertime='" + ordertime + '\'' +
                '}';
    }
}
