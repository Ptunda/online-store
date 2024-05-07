package com.pluralSight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {

    public static void main(String[] args) {

        try {
            String fileName = "product.csv";

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while((line = bufferedReader.readLine()) != null){

                String[] parts = line.split("\\|");

                if (parts.length == 3){

                    String id = parts[0];
                    String productName = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    Product product = new Product(id, productName, price);

                    Product[] products = new Product[8];

                    for (int i = 0; i < products.length; i++) {

                        products[i] = product;

                    }

                }

            }



        } catch (FileNotFoundException e) {

            System.out.println("FileNotFoundException occurred! " + e.getMessage());

        } catch (IOException e){

            System.out.println("IOException occurred! " + e.getMessage());

        }

    }
}
