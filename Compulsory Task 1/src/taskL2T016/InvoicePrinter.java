package taskL2T016;

import java.text.DecimalFormat;

public class InvoicePrinter {
  /**
   * Prints the invoice details to the console.
   */
  public static void printInvoiceToConsole(Customer customer, Restaurant restaurant, Order order,
      Driver driver) {
    DecimalFormat df = new DecimalFormat("0.00");

    // Print order and customer details
    System.out.println();
    System.out.println("Order number " + order.getOrderNumber());
    System.out.println("Customer: " + customer.getName());
    System.out.println("Email: " + customer.getEmail());
    System.out.println("Phone number: " + customer.getContactNumber());
    System.out.println("Location: " + customer.getLocation() + "\n");
    System.out.println("You have ordered the following from " + restaurant.getName() + " in "
        + restaurant.getLocation() + ":\n");

    // Print meal details
    for (Meal meal : order.getMeals()) {
      System.out.println(
          meal.getQuantity() + " x " + meal.getName() + " (R" + df.format(meal.getPrice()) + ")");
    }

    // Print special instructions, gratuity, and total amount
    System.out.println("\nSpecial instructions: " + order.getSpecialInstructions());
    System.out.println("Gratuity: R" + df.format(order.getGratuity()));
    System.out.println("Total: R" + df.format(order.getTotalAmount()) + "\n");
    System.out.println(driver.getName()
        + " is nearest to the restaurant and so he will be delivering your order to you at:");
    System.out.println(customer.getAddress() + "\n");
    System.out.println("If you need to contact the restaurant, their number is "
        + restaurant.getContactNumber() + ".");
  }
}
