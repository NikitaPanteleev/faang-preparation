package google1.preparationkit.search;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Pairs {
  static int pairs(int k, int[] arr) {
    HashMap<Integer, Integer> sup = new HashMap<>();
    int pairs = 0;
    for (int i: arr) {
      pairs+= sup.getOrDefault(k, 0);
      sup.put(i+k, sup.getOrDefault(i +k, 0)+1);
      sup.put(i-k, sup.getOrDefault(i - k, 0)+1);
    }
    return pairs;
  }

  @Test
  void run() {
    int[]in = {1,5,3,4,2};
    System.out.println("answer: " + pairs(2, in));
  }
}
