package taskL2T016;

import java.util.Scanner;

public class RestaurantInput {
  public static Restaurant createRestaurant(Scanner scanner) {
    System.out.print("Enter restaurant name: ");
    String restaurantName = scanner.nextLine();
    System.out.print("Enter restaurant location (city): ");
    String restaurantLocation = scanner.nextLine();
    System.out.print("Enter restaurant contact number: ");
    String restaurantContactNumber = scanner.nextLine();

    return new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);
  }
}
