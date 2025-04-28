package taskL2T016;

/**
 * Represents a customer with necessary details for order processing.
 */
public class Customer {
  private final String name;
  private final String contactNumber;
  private final String address;
  private final String location;
  private final String email;

  /**
   * Constructor to initialize a Customer object.
   */
  public Customer(String name, String contactNumber, String address, String location,
      String email) {
    this.name = name;
    this.contactNumber = contactNumber;
    this.address = address;
    this.location = location;
    this.email = email;
  }

  // Getters for accessing private fields
  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Customer{" + "name='" + name + '\'' + ", contactNumber='" + contactNumber + '\''
        + ", address='" + address + '\'' + ", location='" + location + '\'' + ", email='" + email
        + '\'' + '}';
  }
}
