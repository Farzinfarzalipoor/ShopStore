package com.farzin.store;

import java.util.Objects;
import java.util.Scanner;

public class Store {
    static User user;
    private static Product[] products = new Product[6];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        insertProduct();

        int input = 0;
        do {
            System.out.println("Choose your option: \n1)Add user \n2)Show all products \n3)Add product to cart \n4)Delete product from cart \n5)Print all added-products to cart with number \n6)Print price of all item in cart \n7)is it confirmed?(yes/no) \n8)Exit");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    addUser();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    delProduct();
                    break;
                case 5:
                    user.getCart().print();
                    break;
                case 6:
                    System.out.println("The overall price of the Cart is : " + user.getCart().getOverallPrice());
                    break;
                case 7:
                    confirm();
                    break;
                case 8:
                    System.out.println("Exit");
            }

        } while (input != 8);
    }

    private static void addUser() {
        System.out.println("Enter number of users you want to add");
        int n = sc.nextInt();
        user = new User();

        System.out.println("Enter user-name:");
        user.setUsername(sc.next());
        System.out.println("Enter password:");
        user.setPassword(sc.nextInt());
        System.out.println("Enter first name:");
        user.setFirstName(sc.next());
        System.out.println("Enter last name:");
        user.setLastName(sc.next());
        System.out.println("Enter phone number:");
        user.setPhoneNum(sc.next());
        System.out.println("Enter e-mail:");
        user.setEmail(sc.next());
        System.out.println("Enter address(Province-City-Avenue:");
        user.setAddress(sc.nextLine());
        sc.nextLine();
        System.out.println("Enter postal code: ");
        user.setPostalCode(sc.next());


    }

    private static void showAll() {
        System.out.println("products list: ");
        for (Product p : products) {
            System.out.println("\t" + p.toString());
        }
    }

    private static void addProduct() {
        System.out.println("Enter product id: ");
        String id = sc.next();
        System.out.println("Enter number of products you want to buy: ");
        int stock = sc.nextInt();
        boolean found = false;
        Product buyProduct = new Product();
        for (Product p : products) {
            if (Objects.equals(id, p.getId())) {
                if (p.getStock() > stock) {
                    buyProduct.setStock(stock);
                    buyProduct.setId(id);
                    buyProduct.setName(p.getName());
                    buyProduct.setPrice(p.getPrice());
                    buyProduct.setType(p.getType());

                    user.getCart().addProduct(buyProduct);
                    System.out.println("Product is added successfully");
                } else {
                    System.out.println("Stock is not enough!!!");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no product with entered id");
        }
    }

    private static void delProduct() {
        System.out.println("Enter product id: ");
        boolean found = false;
        Product[] newProducts = new Product[products.length];
        String id = sc.next();
        int j = 0;
        for (Product product : products) {
            if (!Objects.equals(id, product.getId())) {
                newProducts[j] = product;
                found = true;
                j++;
            }
        }
        products = newProducts;
        if (!found) {
            System.out.println("There is no product with entered id");
        }
    }

    private static void confirm() {
        for (Product p : user.getCart().products) {
            reduceStock(p.getId(), p.getStock());
        }
        System.out.println("This is your cart stock:");
        user.getCart().print();
        user.setCart(new Cart());
    }

    public static void reduceStock(String id, int stock) {
        for (Product p : products) {
            if (Objects.equals(p.getId(), id)) {
                p.setStock(p.getStock() - stock);
            }
        }
    }

    private static void insertProduct() {
        int index = 0;
        Product p1 = new Product();
        p1.setId("1");
        p1.setName("Radio");
        p1.setStock(10);
        p1.setPrice(100000);
        p1.setType(Product.Type.ELECTRICAL);
        products[index++] = p1;

        Product p2 = new Product();
        p2.setId("2");
        p2.setName("TV");
        p2.setStock(10);
        p2.setPrice(500000);
        p2.setType(Product.Type.ELECTRICAL);
        products[index++] = p2;

        Product p3 = new Product();
        p3.setId("3");
        p3.setName("Sport");
        p3.setStock(10);
        p3.setPrice(300000);
        p3.setType(Product.Type.SHOE);
        products[index++] = p3;

        Product p4 = new Product();
        p4.setId("4");
        p4.setName("Official");
        p4.setStock(10);
        p4.setPrice(400000);
        p4.setType(Product.Type.SHOE);
        products[index++] = p4;

        Product p5 = new Product();
        p5.setId("5");
        p5.setName("Book");
        p5.setStock(10);
        p5.setPrice(60000);
        p5.setType(Product.Type.READABLE);
        products[index++] = p5;


        Product p6 = new Product();
        p6.setId("6");
        p6.setName("Magazine");
        p6.setStock(10);
        p6.setPrice(10000);
        p6.setType(Product.Type.READABLE);
        products[index] = p6;
    }
}

