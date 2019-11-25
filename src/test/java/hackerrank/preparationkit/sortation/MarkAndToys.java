package hackerrank.preparationkit.sortation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MarkAndToys {
  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int sum = 0;
    for (int i = 0; i < prices.length; i++) {
      if (sum + prices[i] <= k) {
        sum += prices[i];
      } else {
        return i;
      }
    }
    return prices.length;
  }

  @Test
  void run() {
    int[] in = {1, 12, 5, 111, 200, 1000, 10};
    System.out.println("Answer: " + maximumToys(in, 50));
  }
}
