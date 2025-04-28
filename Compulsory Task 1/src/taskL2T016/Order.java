package taskL2T016;

import java.util.List;

public class Order {
  private final int orderNumber;
  private final List<Meal> meals;
  private final String specialInstructions;
  private final double gratuity;

  public Order(int orderNumber, List<Meal> meals, String specialInstructions, double gratuity) {
    this.orderNumber = orderNumber;
    this.meals = meals;
    this.specialInstructions = specialInstructions;
    this.gratuity = gratuity;
  }

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

  public double getTotalAmount() {
    double mealTotal =
        meals.stream().mapToDouble(meal -> meal.getPrice() * meal.getQuantity()).sum();
    return mealTotal + gratuity;
  }

  @Override
  public String toString() {
    return "Order{" + "orderNumber=" + orderNumber + ", meals=" + meals + ", specialInstructions='"
        + specialInstructions + '\'' + ", gratuity=" + gratuity + '}';
  }
}
