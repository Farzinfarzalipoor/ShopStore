package com.farzin.store;

import java.util.Scanner;

public class Store {
    static User[] user;
    static int index = 0;
    private static Product[] product = new Product[6];
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
                    printAdd();
                    break;
                case 6:
                    printPrice();
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
        user = new User[n];

        user[index] = new User();
        System.out.println("Enter user-name:");
        user[index].setUsername(sc.next());
        System.out.println("Enter password:");
        user[index].setPassword(sc.nextInt());
        System.out.println("Enter first name:");
        user[index].setFirstName(sc.next());
        System.out.println("Enter last name:");
        user[index].setLastName(sc.next());
        System.out.println("Enter phone number:");
        user[index].setPhoneNum(sc.next());
        System.out.println("Enter e-mail:");
        user[index].setEmail(sc.next());
        System.out.println("Enter address(Province-City-Avenue:");
        user[index].setAddress(sc.nextLine());
        sc.nextLine();
        System.out.println("Enter postal code: ");
        user[index].setPostalCode(sc.next());
        index++;


    }

    private static void showAll() {
        print();
    }

    private static void addProduct() {
    }

    private static void delProduct() {
    }

    private static void printAdd() {
    }

    private static void printPrice() {
    }

    private static void confirm() {
    }


    private static void insertProduct() {
        int index = 0;
        Product p1 = new Product();
        p1.setName("Radio");
        p1.setStock(10);
        p1.setPrice(100000);
        p1.setType(Product.Type.ELECTRICAL);
        product[index++] = p1;

        Product p2 = new Product();
        p2.setName("TV");
        p2.setStock(10);
        p2.setPrice(500000);
        p2.setType(Product.Type.ELECTRICAL);
        product[index++] = p2;

        Product p3 = new Product();
        p3.setName("Sport");
        p3.setStock(10);
        p3.setPrice(300000);
        p3.setType(Product.Type.SHOE);
        product[index++] = p3;

        Product p4 = new Product();
        p4.setName("Official");
        p4.setStock(10);
        p4.setPrice(400000);
        p4.setType(Product.Type.SHOE);
        product[index++] = p4;

        Product p5 = new Product();
        p5.setName("Book");
        p5.setStock(10);
        p5.setPrice(60000);
        p5.setType(Product.Type.READABLE);
        product[index++] = p5;


        Product p6 = new Product();
        p6.setName("Magazine");
        p6.setStock(10);
        p6.setPrice(10000);
        p6.setType(Product.Type.READABLE);
        product[index] = p6;
    }

    private static void print(){
        for (Product p: product){
            System.out.println("products: " + p.toString());
        }
    }
}

