package com.newusershoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> availableItems = createAvailableItems();
        List<String> cart = new ArrayList<>();
        List<Double> prices = createPrices();

        
        while (true) {
            System.out.println("\nShopping Cart Options:");
            System.out.println("1. View available items");
            System.out.println("2. Add item to cart");
            System.out.println("3. View cart items");
            System.out.println("4. Calculate total");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Available items:");
                    for (int i = 0; i < availableItems.size(); i++) {
                        System.out.println((i + 1) + ". " + availableItems.get(i) + " - Rs " + prices.get(i));
                    }
                    break;
                    
                    
                case 2:
                    System.out.print("Enter the number of the item to add: ");
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    if (itemNumber > 0 && itemNumber <= availableItems.size()) {
                        cart.add(availableItems.get(itemNumber - 1));
                        System.out.println("Item added to cart.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("Items in cart:");
                    for (String item : cart) {
                        System.out.println(item);
                    }
                    break;
                    
                    
                case 4:
                    double total = 0.0;
                    for (String item : cart) {
                        int index = availableItems.indexOf(item);
                        total += prices.get(index);
                    }
                    System.out.println("Total amount: -" + total);
                    break;
                    
                    
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static List<String> createAvailableItems() {
        List<String> items = new ArrayList<>();
        items.add("Shirt");
        items.add("T-Shirt");
        items.add("Jacket");
        return items;
    }

    
    private static List<Double> createPrices() {
        List<Double> prices = new ArrayList<>();
        prices.add(200.0);
        prices.add(300.0);
        prices.add(400.0);
        return prices;
    }
}
