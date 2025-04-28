package taskL2T016;

/**
 * Represents a restaurant with necessary details for order processing.
 */
public class Restaurant {
  private final String name;
  private final String location;
  private final String contactNumber;

  /**
   * Constructor to initialize a Restaurant object.
   */
  public Restaurant(String name, String location, String contactNumber) {
    this.name = name;
    this.location = location;
    this.contactNumber = contactNumber;
  }

  // Getters for accessing private fields
  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  @Override
  public String toString() {
    return "Restaurant{" + "name='" + name + '\'' + ", location='" + location + '\''
        + ", contactNumber='" + contactNumber + '\'' + '}';
  }
}
