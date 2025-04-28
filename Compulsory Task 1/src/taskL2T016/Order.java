package taskL2T016;

import java.util.List;

/**
 * Represents an order containing a list of meals and special instructions.
 */
public class Order {
  private final int orderNumber;
  private final List<Meal> meals;
  private final String specialInstructions;
  private double gratuity;

  /**
   * Constructor to initialize an Order object.
   */
  public Order(int orderNumber, List<Meal> meals, String specialInstructions, double gratuity) {
    this.orderNumber = orderNumber;
    this.meals = meals;
    this.specialInstructions = specialInstructions;
    this.gratuity = gratuity;
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

  public double getGratuity() {
    return gratuity;
  }

  /**
   * Sets the gratuity amount for the order.
   */
  public void setGratuity(double gratuity) {
    this.gratuity = gratuity;
  }

  /**
   * Calculates the total amount for the order including gratuity.
   */
  public double getTotalAmount() {
    double mealTotal =
        meals.stream().mapToDouble(meal -> meal.getPrice() * meal.getQuantity()).sum();
    return mealTotal + gratuity;
  }

  /**
   * Calculates the total amount for the order without gratuity.
   */
  public double getTotalAmountWithoutGratuity() {
    return meals.stream().mapToDouble(meal -> meal.getPrice() * meal.getQuantity()).sum();
  }

  @Override
  public String toString() {
    return "Order{" + "orderNumber=" + orderNumber + ", meals=" + meals + ", specialInstructions='"
        + specialInstructions + '\'' + ", gratuity=" + gratuity + '}';
  }
}
