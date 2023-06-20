/**
 * This class mapping the nodes and the distance between them.
 *
 * <ul>
 *   <li>The node is the client that must be supplied.</li>
 *   <li>Get a savings of costs to this node</li>
 * </ul>
 *
 * @author Frank Laércio
 * @see Customer
 */
public class Node {

  /** Client from where the node departs. */
  private final Customer from;

  /** Client where the node goes. */
  private final Customer to;

  /** Total cost of the node. */
  private final double savings;

  /**
   * Constructor of the Node
   * 
   * @param from      customer from node
   * @param to      customer to node
   * @param savings the cost of the node
   */
  public Node(Customer from, Customer to, double savings) {
    this.from = from;
    this.to = to;
    this.savings = savings;
  }

  /** Method to get a customer from. */
  public Customer getFrom() {
    return from;
  }

  /** Method to get a customer to. */
  public Customer getTo() {
    return to;
  }

  /** Method to get a cost of node. */
  public double getSavings() {
    return savings;
  }
}
