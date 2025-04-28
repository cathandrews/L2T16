package taskL2T016;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DriverManager {
  /**
   * Reads driver information from a file and returns a list of Driver objects.
   */
  public static List<Driver> readDriversFromFile(String filePath) {
    List<Driver> drivers = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
          String name = parts[0].trim();
          String location = parts[1].trim().toLowerCase(); // Convert to lowercase
          int currentLoad = Integer.parseInt(parts[2].trim());
          drivers.add(new Driver(name, location, currentLoad));
        } else {
          System.out.println("Incorrect format in file: " + line);
        }
      }
    } catch (IOException e) {
      System.out.println("File not found: " + filePath);
      e.printStackTrace();
    }
    return drivers;
  }

  /**
   * Finds the nearest driver based on location and least number of deliveries.
   */
  public static Driver findNearestDriver(List<Driver> drivers, String restaurantLocation) {
    Driver nearestDriver = null;
    String restaurantLocationLower = restaurantLocation.trim().toLowerCase(); // Convert to
                                                                              // lowercase
    for (Driver driver : drivers) {
      if (driver.getLocation().equals(restaurantLocationLower)) {
        if (nearestDriver == null || driver.getCurrentLoad() < nearestDriver.getCurrentLoad()) {
          nearestDriver = driver;
        }
      }
    }
    if (nearestDriver == null) {
      // If no driver in the same city, select the one with the least deliveries
      nearestDriver = drivers.get(0);
      for (Driver driver : drivers) {
        if (driver.getCurrentLoad() < nearestDriver.getCurrentLoad()) {
          nearestDriver = driver;
        }
      }
    }
    return nearestDriver;
  }
}
