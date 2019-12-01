package hackerrank.preparationkit.arrays;

import org.junit.jupiter.api.Test;

public class NewYearChaos {
  static void minimumBribes(int[] q) {
    int ans= 0;
    for (int i = q.length-1; i >= 0; i--) {
      if (q[i] - i - 1 > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, q[i]-2); j <i; j++) {
        if (q[j] > q[i]) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }


  @Test
  void run() {
    int[] i0 = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] in = {1, 2, 5, 3, 7, 8, 6, 4};
    minimumBribes(in);
  }
}
