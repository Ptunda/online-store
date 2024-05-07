package com.pluralSight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {

    private static final String FILE_NAME = "Products.csv";
    private static final ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {

        loadInventory(FILE_NAME);

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
    
}
