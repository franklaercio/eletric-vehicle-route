import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class maps customers with the client list and capacity of that route.
 *
 * @author Frank Laércio
 * @see ArrayList
 */
public class Route {

  /**
   * List of customers with each customer
   */
  private final List<Customer> customers;

  /**
   * Constructor of Route
   */
  public Route() {
    customers = new LinkedList<>();
  }

  public void addCustomer(Customer client) {
    customers.add(client);
  }

  public void addCustomers(List<Customer> customers) {
    this.customers.addAll(customers);
  }

  public void removeCustomer(Customer client) {
    customers.remove(client);
  }

  public boolean containsCustomer(Customer client) {
    return customers.contains(client);
  }

  /**
   * Method responsible for returning all customer in this route.
   */
  public List<Customer> getCustomers() {
    return customers;
  }

  /**
   * Method responsible for returning this capacity of route.
   */
  public int getDemand() {
    int demand = 0;
    for (Customer client : customers) {
      demand += client.getDemand();
    }
    return demand;
  }

  /**
   * Method responsible for returning this capacity of route.
   * @return capacity of route in double type.
   */
  public double getTotalDistance() {
    double totalDistance = 0;
    for (int i = 1; i < customers.size(); i++) {
      totalDistance += customers.get(i - 1).distance(customers.get(i));
    }
    return totalDistance;
  }
}