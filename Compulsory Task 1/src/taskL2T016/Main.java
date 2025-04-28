package taskL2T016;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Accept customer details from user
      Customer customer = CustomerInput.createCustomer(scanner);

      // Accept restaurant details from user
      Restaurant restaurant = RestaurantInput.createRestaurant(scanner);

      // Accept order details from user
      Order order = OrderInput.createOrder(scanner);

      // Read drivers from file
      List<Driver> drivers = DriverManager.readDriversFromFile("src/driver-info.txt");

      // Check if drivers list is not empty
      if (drivers.isEmpty()) {
        System.out.println("No drivers available.");
        return;
      }

      // Find the nearest driver based on location and least number of deliveries
      Driver nearestDriver = DriverManager.findNearestDriver(drivers, restaurant.getLocation());

      // Check if the customer's location matches any driver's location
      boolean isValidLocation =
          customer.getLocation().trim().toLowerCase().equals(nearestDriver.getLocation());

      if (!isValidLocation) {
        System.out.println(
            "\nSorry! Our drivers are too far away from you to be able to deliver to your location.");
      }

      // Generate and print invoice to console
      Invoice.generateInvoice(customer, restaurant, order, nearestDriver, isValidLocation);
      if (isValidLocation) {
        InvoicePrinter.printInvoiceToConsole(customer, restaurant, order, nearestDriver);
      }
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}

