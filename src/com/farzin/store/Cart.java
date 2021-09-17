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
