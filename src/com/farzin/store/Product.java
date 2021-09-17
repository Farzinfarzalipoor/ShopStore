package com.farzin.store;

public class Product {
    private String name;
    private int stock;
    private int price;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    enum Type {
        ELECTRICAL,
        SHOE,
        READABLE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
