import java.util.ArrayList;
import java.util.List;

/**
 * This is the heuristic scan of Clarke and Wrights to calculate the routing of skilled vehicles.
 * <br>
 *
 * <ul>
 * <li>First the route to and from the warehouse to the customers is calculated.
 * <li>Then the list of nodes are sorted by the MergeSort algorithm.
 * <li>The calculation is made to group routes respecting the capacity of each
 * vehicle.
 * </ul>
 *
 * @author Frank Laércio
 * @see ClarkeWrightAlgorithm
 * @see MergeSort
 */
public class Main {

  public static void main(String[] args) {
    List<Customer> customers = FileUtil.readCustomersFromCSV("data/test2.csv");

    ClarkeWrightAlgorithm clarkeWrightAlgorithm = new ClarkeWrightAlgorithm();

    int load = 2; // 2 is the load of each vehicle in tons
    int batteryCapacity = 100; // 100 is the battery capacity in kWh
    int vehicleCapacity =  batteryCapacity / load;

    List<Route> routes = clarkeWrightAlgorithm.solve(customers, vehicleCapacity);

    for (int i = 0; i < routes.size(); i++) {
      System.out.println("Route " + i + ":");
      for (Customer client : routes.get(i).getCustomers()) {
        System.out.println(client.getId() + " (" + client.getX() + ", " + client.getY() + ")");
      }

      System.out.println("Total distance: " + routes.get(i).getTotalDistance());
      System.out.println("Total demand: " + routes.get(i).getDemand());
      System.out.println();
    }
  }
}