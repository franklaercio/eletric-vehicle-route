import java.util.ArrayList;
import java.util.List;

/**
 * This is the heuristic scan of Clarke and Wrights to calculate the routing of skilled vehicles.
 *
 * @author Frank Laércio
 * @see ArrayList
 * @see List
 * @see Node
 * @see Route
 */
public class ClarkeWrightAlgorithm {

  /**
   * Method to create an initial routes in Clarke and Wrights algorithm. <br>
   * For this it is calculated by: Sij=C(0, i) +C(0, j) − C(i, j).
   *
   * @param customers list of customers loaded.
   * @param vehicleCapacity capacity of each vehicle.
   * @return list of nodes.
   */
  public List<Route> solve(List<Customer> customers, int vehicleCapacity) {
    List<Node> savings = calculateSavings(customers);
    MergeSort.sort(savings);
    List<Route> routes = constructInitialRoutes(customers);

    for (Node saving : savings) {
      Customer customerA = saving.getFrom();
      Customer customerB = saving.getTo();
      Route routeA = findRouteContainingCustomer(routes, customerA);
      Route routeB = findRouteContainingCustomer(routes, customerB);

      if (routeA != null && routeB != null && routeA != routeB
          && (routeA.getDemand() + routeB.getDemand() <= vehicleCapacity)) {
          Route mergedRoute = mergeRoutes(routeA, routeB);
          routes.remove(routeA);
          routes.remove(routeB);
          routes.add(mergedRoute);
      }
    }

    for (Route route : routes) {
      route.getCustomers().removeIf(customer -> customer.x == 0 && customer.y == 0);
    }

    for (Route route : routes) {
      route.getCustomers().add(0, customers.get(0));
      route.getCustomers().add(customers.get(0));
    }

    return routes;
  }

  /**
   * Calculate the savings of each pair of customers.
   *
   * @param customers list of customers
   * @return list of savings
   */
  private List<Node> calculateSavings(List<Customer> customers) {
    List<Node> savings = new ArrayList<>();
    int depotIndex = 0;
    for (int i = 0; i < customers.size(); i++) {
      for (int j = i + 1; j < customers.size(); j++) {
        Customer customerA = customers.get(i);
        Customer customerB = customers.get(j);
        double saving = (customerA.distance(customers.get(depotIndex)))
            + (customerB.distance(customers.get(depotIndex)))
            - (customerA.distance(customerB));
        savings.add(new Node(customerA, customerB, saving));
      }
    }
    return savings;
  }

  /**
   * Construct initial routes for each customer.
   * @param customers list of customers
   * @return list of routes with one customer each one of them and the depot as well
   */
  private List<Route> constructInitialRoutes(List<Customer> customers) {
    List<Route> routes = new ArrayList<>();
    for (int i = 1; i < customers.size(); i++) {
      Customer customer = customers.get(i);
      Route route = new Route();
      route.addCustomer(customers.get(0));
      route.addCustomer(customer);
      routes.add(route);
    }
    return routes;
  }

  /**
   * Find the route that contains the customer. If the customer is not in any route, return null.
   * @param routes list of routes
   * @param customer customer to be found
   * @return route that contains the customer
   */
  private Route findRouteContainingCustomer(List<Route> routes, Customer customer) {
    for (Route route : routes) {
      if (route.containsCustomer(customer)) {
        return route;
      }
    }
    return null;
  }

  /**
   * Merge two routes into one.
   * @param routeA route A
   * @param routeB route B
   * @return merged route
   */
  private Route mergeRoutes(Route routeA, Route routeB) {
    Route mergedRoute = new Route();
    mergedRoute.addCustomers(routeA.getCustomers());
    mergedRoute.addCustomers(routeB.getCustomers());
    return mergedRoute;
  }
}
