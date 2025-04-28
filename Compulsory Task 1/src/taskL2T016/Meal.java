package taskL2T016;

/**
 * Represents a meal with its name, price, and quantity.
 */
public class Meal {
  private final String name;
  private final double price;
  private final int quantity;

  /**
   * Constructor to initialize a Meal object.
   */
  public Meal(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  // Getters for accessing private fields
  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "Meal{" + "name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + '}';
  }
}
