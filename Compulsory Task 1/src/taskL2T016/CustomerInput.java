package taskL2T016;

import java.util.Scanner;

public class CustomerInput {
  public static Customer createCustomer(Scanner scanner) {
    System.out.print("Enter customer name: ");
    String customerName = scanner.nextLine();
    System.out.print("Enter customer contact number: ");
    String contactNumber = scanner.nextLine();
    System.out.print("Enter customer address: ");
    String address = scanner.nextLine();
    System.out.print("Enter customer location (city): ");
    String location = scanner.nextLine();
    System.out.print("Enter customer email: ");
    String email = scanner.nextLine();

    return new Customer(customerName, contactNumber, address, location, email);
  }
}
