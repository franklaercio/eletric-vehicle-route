import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class to read all customers from CSV.
 * 
 * @see List
 * @see Customer
 *
 * @author Frank Laércio
 */
public class FileUtil {

  /**
   * Method to read all customers from CSV
   * 
   * @param fileName name of the CSV file.
   */
  public static List<Customer> readCustomersFromCSV(String fileName) {
    List<Customer> customers = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);

    try (BufferedReader br = Files.newBufferedReader(pathToFile,
        StandardCharsets.US_ASCII)) {

      String line = br.readLine();

      while (line != null) {
        String[] attributes = line.split(",");

        Customer customer = createCustomer(attributes);
        customers.add(customer);

        line = br.readLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return customers;
  }

  /**
   * Method to create a customer.
   * 
   * @param data arrays of strings values.
   */
  private static Customer createCustomer(String[] data) {
    int id = Integer.parseInt(data[0]);
    int demand = Integer.parseInt(data[1]);
    double x = Double.parseDouble(data[2]);
    double y = Double.parseDouble(data[3]);
    return new Customer(id, demand, x, y);
  }

}
