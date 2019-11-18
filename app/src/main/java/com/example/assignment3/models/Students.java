package com.example.assignment3.models;

public class Students {
    private String name, age, gender, address;
    private int img;

    public Students(String name, String age, String gender, String address, int img) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getImg() {
        return img;
    }
}
