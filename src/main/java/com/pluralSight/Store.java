package com.pluralSight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store {

    private static final String FILE_NAME = "Products.csv";
    private static final ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {

        loadInventory(FILE_NAME);

        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Display menu and get user choice until they choose to exit
        while (running) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();

            // Call the appropriate method based on user choice
            switch (choice) {
                case "1":
                    displayProducts(inventory, cart, scanner);
                    break;
                case "2":
                    displayCart(cart, scanner, totalAmount);
                    break;
                case "3":
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        scanner.close();

    }

    private static void loadInventory(String fileName) {
        try {

            // read from product file
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while((line = bufferedReader.readLine()) != null){

                String[] parts = line.split("\\|");

                // extract internal attributes from each line
                if (parts.length == 3){

                    String id = parts[0];
                    String productName = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    Product product = new Product(id, productName, price);

                    inventory.add(product); // add all products to the inventory list

                }

            }

            bufferedReader.close();


        } catch (FileNotFoundException e) {

            System.out.println("File not found! Please enter the correct file name " + e.getMessage());

        } catch (IOException e){

            System.out.println("Error reading from product file" + e.getMessage());

        }

    }


    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        // This method should display a list of products from the inventory,
        // and prompt the user to add items to their cart. The method should
        // prompt the user to enter the ID of the product they want to add to
        // their cart. The method should
        // add the selected product to the cart ArrayList.
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        // This method should display the items in the cart ArrayList, along
        // with the total cost of all items in the cart. The method should
        // prompt the user to remove items from their cart by entering the ID
        // of the product they want to remove. The method should update the cart ArrayList and totalAmount
        // variable accordingly.
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        // This method should calculate the total cost of all items in the cart,
        // and display a summary of the purchase to the user. The method should
        // prompt the user to confirm the purchase, and deduct the total cost
        // from their account if they confirm.
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // This method should search the inventory ArrayList for a product with
        // the specified ID, and return the corresponding Product object. If
        // no product with the specified ID is found, the method should return
        // null.
    }


}
