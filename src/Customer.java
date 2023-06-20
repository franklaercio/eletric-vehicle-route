import java.awt.geom.Point2D;

/**
 * This class maps the clients that must be supplied.
 *
 * @see Point2D
 *
 * @author Frank Laércio
 */
public class Customer extends Point2D.Double {

  /** ID of customer. */
  private final int id;

  /** Capacity of customer. */
  private final int demand;

  /**
   * Constructor of Customer.
   *
   * @param id       id of customer.
   * @param demand   demand of customer.
   * @param x        point x of distance.
   * @param y        point y of distance.
   */
  public Customer(int id, int demand, double x, double y) {
    this.id = id;
    this.demand = demand;
    this.x = x;
    this.y = y;
  }

  /** Methor do get distance x. */
  public double getX() {
    return x;
  }

  /** Methor do get distance y. */
  public double getY() {
    return y;
  }

  /** Methor do get capacity of customer. */
  public int getDemand() {
    return demand;
  }

  /** Methor do get id of customer. */
  public int getId() {
    return id;
  }

  /**
   * Methor to compare a customer to a customer.
   * 
   * @param o maybe a customer or not to compare.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Customer)) {
      return false;
    }
    Customer c = (Customer) o;

    return c.distance(x, c.x) == 0 && c.distance(y, c.y) == 0;
  }
}
