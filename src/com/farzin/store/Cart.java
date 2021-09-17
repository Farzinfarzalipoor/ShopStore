package com.farzin.store;

public class Cart {
    private int overallPrice;
    private final int productCount = 5;
    Product[] products = new Product[productCount];
    private int index = 0;

    public void addProduct(Product product) {
        if (products[5] != null) {
            System.out.println("Your cart is full. you cannot add more than:" + productCount);
            return;
        }
        products[index] = product;
        index++;

        overallPrice += product.getPrice();
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public boolean isEmpty() {
        for (Product p : products) {
            if (p != null) {
                return true;
            }
        }
        return false;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(int overallPrice) {
        this.overallPrice = overallPrice;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
