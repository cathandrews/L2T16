package taskL2T016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInput {
  public static Order createOrder(Scanner scanner) {
    List<Meal> meals = new ArrayList<>();
    System.out.print("Enter the number of meals: ");
    int numberOfMeals = scanner.nextInt();
    scanner.nextLine(); // Consume newline

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

    System.out.print("Enter special instructions: ");
    String specialInstructions = scanner.nextLine();

    return new Order(1234, meals, specialInstructions);
  }
}
