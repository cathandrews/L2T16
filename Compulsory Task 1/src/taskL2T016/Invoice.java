package taskL2T016;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Invoice {

  /**
   * Generates an invoice and writes it to a file.
   */
  public static void generateInvoice(Customer customer, Restaurant restaurant, Order order,
      Driver driver, boolean isValidLocation) {
    try (FileWriter writer = new FileWriter("invoice.txt")) {
      if (!isValidLocation) {
        writer.write(
            "Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
      } else {
        writeInvoiceDetails(writer, customer, restaurant, order, driver);
        updateDriverGratuity(driver, order.getGratuity());
      }
    } catch (IOException e) {
      System.err.println("Error writing to invoice file: " + e.getMessage());
    }
  }

  /**
   * Writes the invoice details to the file.
   */
  private static void writeInvoiceDetails(FileWriter writer, Customer customer,
      Restaurant restaurant, Order order, Driver driver) throws IOException {
    DecimalFormat df = new DecimalFormat("0.00");

    // Write order and customer details
    writer.write("Order number " + order.getOrderNumber() + "\n");
    writer.write("Customer: " + customer.getName() + "\n");
    writer.write("Email: " + customer.getEmail() + "\n");
    writer.write("Phone number: " + customer.getContactNumber() + "\n");
    writer.write("Location: " + customer.getLocation() + "\n\n");
    writer.write("You have ordered the following from " + restaurant.getName() + " in "
        + restaurant.getLocation() + ":\n\n");

    // Write meal details
    for (Meal meal : order.getMeals()) {
      writer.write(
          meal.getQuantity() + " x " + meal.getName() + " (R" + df.format(meal.getPrice()) + ")\n");
    }

    // Write special instructions, gratuity, and total amount
    writer.write("\nSpecial instructions: " + order.getSpecialInstructions() + "\n");
    writer.write("Gratuity: R" + df.format(order.getGratuity()) + "\n");
    writer.write("Total: R" + df.format(order.getTotalAmount()) + "\n\n");
    writer.write(driver.getName()
        + " is nearest to the restaurant and so he will be delivering your order to you at:\n");
    writer.write(customer.getAddress() + "\n\n");
    writer.write("If you need to contact the restaurant, their number is "
        + restaurant.getContactNumber() + ".\n");
  }

  /**
   * Updates the driver's gratuity record.
   */
  private static void updateDriverGratuity(Driver driver, double gratuity) {
    try (FileWriter writer = new FileWriter("driver_gratuities.txt", true)) {
      DecimalFormat df = new DecimalFormat("0.00");
      writer.write(driver.getName() + ": R" + df.format(gratuity) + "\n");
    } catch (IOException e) {
      System.err.println("Error writing to driver gratuities file: " + e.getMessage());
    }
  }
}
