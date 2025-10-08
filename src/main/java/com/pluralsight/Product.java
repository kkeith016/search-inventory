package com.pluralsight;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // toString for easy display
    public String toString() {
        return String.format("id: %d | %s | $%.2f", id, name, price);
    }
    }
