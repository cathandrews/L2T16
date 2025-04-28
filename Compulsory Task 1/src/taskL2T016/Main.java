package taskL2T016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Accept customer details from user
      Customer customer = CustomerInput.createCustomer(scanner);

      // Check if the customer is in the Cape Town area
      boolean isCapeTownClient = customer.getLocation().trim().toLowerCase().equals("cape town");

      // List to store multiple orders and restaurants if the client is in Cape Town
      List<Order> orders = new ArrayList<>();
      List<Restaurant> restaurants = new ArrayList<>();

      // Offer to order from multiple restaurants if the client is in Cape Town
      if (isCapeTownClient) {
        System.out.println(
            "\nWelcome to our new trial! Would you like to place an order at more than one restaurant? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();

        int numRestaurants = response.equals("yes") ? 2 : 1; // Order from 2 restaurants if "yes",
                                                             // otherwise 1

        for (int i = 0; i < numRestaurants; i++) {
          System.out.println("\nEnter details for restaurant " + (i + 1) + ":");
          Restaurant restaurant = RestaurantInput.createRestaurant(scanner);
          restaurants.add(restaurant);

          System.out.println("\nEnter order details for " + restaurant.getName() + ":");
          Order order = OrderInput.createOrderWithoutGratuity(scanner);
          orders.add(order);
        }
      } else {
        // Accept restaurant details and order from the single restaurant
        Restaurant restaurant = RestaurantInput.createRestaurant(scanner);
        restaurants.add(restaurant);

        Order order = OrderInput.createOrderWithoutGratuity(scanner);
        orders.add(order);
      }

      // Calculate and display total for all orders
      double totalAmount = 0;
      for (int i = 0; i < orders.size(); i++) {
        double orderTotal = orders.get(i).getTotalAmountWithoutGratuity();
        totalAmount += orderTotal;
        System.out.printf("\nOrder total for %s: R%.2f\n", restaurants.get(i).getName(),
            orderTotal);
      }
      System.out.printf("\nCombined order total: R%.2f\n", totalAmount);

      // Input gratuity amount after displaying all order totals
      System.out.print("\nEnter gratuity amount: R");
      double gratuity = scanner.nextDouble();
      scanner.nextLine(); // Consume newline left-over

      // Update each order with the gratuity amount
      for (Order order : orders) {
        order.setGratuity(gratuity);
      }

      // Read drivers from file
      List<Driver> drivers = DriverManager.readDriversFromFile("src/driver-info.txt");

      // Check if drivers list is not empty
      if (drivers.isEmpty()) {
        System.out.println("No drivers available.");
        return;
      }

      // Find the nearest driver based on the first restaurant's location
      Driver nearestDriver =
          DriverManager.findNearestDriver(drivers, restaurants.get(0).getLocation());

      // Check if the customer's location matches any driver's location
      boolean isValidLocation =
          customer.getLocation().trim().toLowerCase().equals(nearestDriver.getLocation());

      if (!isValidLocation) {
        System.out.println(
            "\nSorry! Our drivers are too far away from you to be able to deliver to your location.");
      }

      // Generate and print invoice to console
      for (int i = 0; i < restaurants.size(); i++) {
        Invoice.generateInvoice(customer, restaurants.get(i), orders.get(i), nearestDriver,
            isValidLocation);
        if (isValidLocation) {
          InvoicePrinter.printInvoiceToConsole(customer, restaurants.get(i), orders.get(i),
              nearestDriver);
        }
      }

    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
