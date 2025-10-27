package com.example.hf3;

public class Product {
    private String code;
    private String name;
    private double price;

    public Product(String code, double price, String name) {
        this.code = code;
        this.price = price;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cod->"+code +", Megnevezes->"+ name +", Ar->"+ price;
    }
}
