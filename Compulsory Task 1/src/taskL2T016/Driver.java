package taskL2T016;

/**
 * Represents a driver with details about their location and current load.
 */
public class Driver {
  private final String name;
  private final String location;
  private final int currentLoad;

  /**
   * Constructor to initialize a Driver object.
   */
  public Driver(String name, String location, int currentLoad) {
    this.name = name;
    this.location = location;
    this.currentLoad = currentLoad;
  }

  // Getters for accessing private fields
  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public int getCurrentLoad() {
    return currentLoad;
  }

  @Override
  public String toString() {
    return "Driver{" + "name='" + name + '\'' + ", location='" + location + '\'' + ", currentLoad="
        + currentLoad + '}';
  }
}
