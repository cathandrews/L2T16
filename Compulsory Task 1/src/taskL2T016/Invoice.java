package taskL2T016;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Generates an invoice for a customer's order.
 */
public class Invoice {

  /**
   * Generates an invoice and writes it to a file named "invoice.txt".
   */
  public static void generateInvoice(Customer customer, Restaurant restaurant, Order order,
      Driver driver, boolean isValidLocation) {
    try (FileWriter writer = new FileWriter("invoice.txt")) {
      if (!isValidLocation) {
        writer.write(
            "Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
      } else {
        writeInvoiceDetails(writer, customer, restaurant, order, driver);
      }
    } catch (IOException e) {
      System.err.println("Error writing to invoice file: " + e.getMessage());
    }
  }

  private static void writeInvoiceDetails(FileWriter writer, Customer customer,
      Restaurant restaurant, Order order, Driver driver) throws IOException {
    writer.write("Order number " + order.getOrderNumber() + "\n");
    writer.write("Customer: " + customer.getName() + "\n");
    writer.write("Email: " + customer.getEmail() + "\n");
    writer.write("Phone number: " + customer.getContactNumber() + "\n");
    writer.write("Location: " + customer.getLocation() + "\n\n");
    writer.write("You have ordered the following from " + restaurant.getName() + " in "
        + restaurant.getLocation() + ":\n\n");

    for (Meal meal : order.getMeals()) {
      writer.write(meal.getQuantity() + " x " + meal.getName() + " (R" + meal.getPrice() + ")\n");
    }

    writer.write("\nSpecial instructions: " + order.getSpecialInstructions() + "\n\n");
    writer.write("Total: R" + order.getTotalAmount() + "\n\n");
    writer.write(driver.getName()
        + " is nearest to the restaurant and so he will be delivering your order to you at:\n");
    writer.write(customer.getAddress() + "\n\n");
    writer.write("If you need to contact the restaurant, their number is "
        + restaurant.getContactNumber() + ".\n");
  }
}
