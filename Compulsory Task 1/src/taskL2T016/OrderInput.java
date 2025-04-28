package taskL2T016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInput {
  /**
   * Creates an Order object by prompting the user for input.
   */
  public static Order createOrder(Scanner scanner) {
    List<Meal> meals = new ArrayList<>();

    // Input: Number of meals
    System.out.print("Enter the number of meals: ");
    int numberOfMeals = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    // Input: Meal details
    for (int i = 0; i < numberOfMeals; i++) {
      System.out.print("Enter meal name: ");
      String mealName = scanner.nextLine();
      System.out.print("Enter meal price: R");
      double mealPrice = scanner.nextDouble();
      System.out.print("Enter meal quantity: ");
      int mealQuantity = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      meals.add(new Meal(mealName, mealPrice, mealQuantity));
    }

    // Input: Special instructions
    System.out.print("Enter special instructions: ");
    String specialInstructions = scanner.nextLine();

    // Input: Gratuity amount
    System.out.print("Enter gratuity amount: R");
    double gratuity = scanner.nextDouble();

    // Create and return an Order object
    return new Order(1234, meals, specialInstructions, gratuity);
  }
}
