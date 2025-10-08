package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

    ArrayList<Product> inventory = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice;

    // --- Load inventory from CSV directly ---
        try (FileReader inventoryReader = new FileReader("src/main/resources/inventory.csv");
    BufferedReader inventoryScanner = new BufferedReader(inventoryReader)) {

        String line;
        while ((line = inventoryScanner.readLine()) != null) {
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
        //Menu and formating.
        System.out.println("--- Welcome to the Store Inventory System ---\n");

        do {
        System.out.println("What do you want to do?");
        System.out.println("1 - List all products");
        System.out.println("2 - Lookup a product by its id");
        System.out.println("3 - Find all products within a price range");
        System.out.println("4 - Add a new product");
        System.out.println("5 - Quit the application");
        System.out.print("Enter command: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number 1-5: ");
            scanner.next();
        }

        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                listProducts(inventory);
                break;
            case 2:
                lookupProductById(inventory, scanner);
                break;
            case 3:
                findProductsByPriceRange(inventory, scanner);
                break;
            case 4:
                addNewProduct(inventory, scanner);
                break;
            case 5:
                System.out.println("Exiting program...");
            default:
                System.out.println("Invalid choice. Try again.");
        }

    } while (choice != 5);

        scanner.close();
}

// --- List all products ---
public static void listProducts(ArrayList<Product> inventory) {
    System.out.println("\n--- Store Inventory ---");
    for (Product item : inventory) {
        System.out.println(item);
    }
    System.out.println();
}

// --- Lookup product by ID ---
public static void lookupProductById(ArrayList<Product> inventory, Scanner scanner) {
    System.out.print("Enter product ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    boolean found = false;
    for (Product item : inventory) {
        if (item.getId() == id) {
            System.out.println("Found: " + item);
            found = true;
            break;
        }
    }
    if (!found) System.out.println("Product not found.\n");
}

// --- Find products by price range ---
public static void findProductsByPriceRange(ArrayList<Product> inventory, Scanner scanner) {
    System.out.print("Enter minimum price: ");
    double min = scanner.nextDouble();
    System.out.print("Enter maximum price: ");
    double max = scanner.nextDouble();
    scanner.nextLine();

    System.out.println("\nProducts in price range:");
    boolean found = false;
    for (Product item : inventory) {
        if (item.getPrice() >= min && item.getPrice() <= max) {
            System.out.println(item);
            found = true;
        }
    }
    if (!found) System.out.println("No products in that range.\n");
}

// --- Add new product ---
public static void addNewProduct(ArrayList<Product> inventory, Scanner scanner) {
    System.out.print("Enter new product ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter product name: ");
    String name = scanner.nextLine();
    System.out.print("Enter product price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();

    inventory.add(new Product(id, name, price));
    System.out.println("Product added successfully!\n");
}
}