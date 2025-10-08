package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("--- Welcome to the Store Inventory System ---\n");

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
    public ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        return inventory;
    }
}
