package com.codegym.model.entities;

import java.sql.Timestamp;

public class Customer {
    private int id;
    private String name;
    private String user;
    private String password;
    private String phone;
    private String address;
    private Timestamp createdDate;

    public Customer() {
    }

    public Customer(String name, String user, String password, String phone, String address, Timestamp createdDate) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.createdDate = createdDate;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
