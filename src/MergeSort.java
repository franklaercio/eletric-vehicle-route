import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class sort a list of nodes with the MergeSort algorithm.
 *
 * @author Frank Laércio
 * @see java.util.ArrayList
 * @see List
 * @see Node
 */
public class MergeSort {

  public static List<Node> sort(List<Node> list) {
    if (list.size() <= 1) {
      return list;
    }

    int mid = list.size() / 2;
    List<Node> left = new ArrayList<>(list.subList(0, mid));
    List<Node> right = new ArrayList<>(list.subList(mid, list.size()));

    left = sort(left);
    right = sort(right);

    return merge(left, right);
  }

  private static List<Node> merge(List<Node> left, List<Node> right) {
    List<Node> merged = new ArrayList<>();
    int i = 0, j = 0;

    while (i < left.size() && j < right.size()) {
      if (left.get(i).getSavings() >= right.get(j).getSavings()) {
        merged.add(left.get(i));
        i++;
      } else {
        merged.add(right.get(j));
        j++;
      }
    }

    while (i < left.size()) {
      merged.add(left.get(i));
      i++;
    }

    while (j < right.size()) {
      merged.add(right.get(j));
      j++;
    }

    return merged;
  }
}
