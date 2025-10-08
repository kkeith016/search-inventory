package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static ArrayList<Product> main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();

        try (FileReader inventoryReader = new FileReader("inventory.csv");
             BufferedReader bufReader = new BufferedReader(inventoryReader)) {

            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return inventory;
    }
    }