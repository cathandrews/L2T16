package taskL2T016;

import java.util.List;

/**
 * Represents an order containing a list of meals and special instructions.
 */
public class Order {
  private final int orderNumber;
  private final List<Meal> meals;
  private final String specialInstructions;

  /**
   * Constructor to initialize an Order object.
   */
  public Order(int orderNumber, List<Meal> meals, String specialInstructions) {
    this.orderNumber = orderNumber;
    this.meals = meals;
    this.specialInstructions = specialInstructions;
  }

  // Getters for accessing private fields
  public int getOrderNumber() {
    return orderNumber;
  }

  public List<Meal> getMeals() {
    return meals;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }

  /**
   * Calculates the total amount for the order.
   */
  public double getTotalAmount() {
    return meals.stream().mapToDouble(meal -> meal.getPrice() * meal.getQuantity()).sum();
  }

  @Override
  public String toString() {
    return "Order{" + "orderNumber=" + orderNumber + ", meals=" + meals + ", specialInstructions='"
        + specialInstructions + '\'' + '}';
  }
}
