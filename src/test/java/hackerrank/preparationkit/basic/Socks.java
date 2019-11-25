package hackerrank.preparationkit.basic;

import org.junit.jupiter.api.Test;

public class Socks {
  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    int[] pairs = new int[101];
    for (int elem: ar) {
      pairs[elem]++;
    }
    int answer = 0;
    for (int pair: pairs) {
      answer+=pair/2;
    }
    return answer;
  }

  @Test
  void run() {
    int[] in = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    System.out.println("Answer: " + sockMerchant(in.length, in));
  }
}
