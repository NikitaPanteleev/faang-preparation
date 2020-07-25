package google1.preparationkit.basic;

import org.junit.jupiter.api.Test;

public class JumpClouds {
  // Complete the jumpingOnClouds function below.
  static int jumpingOnClouds(int[] c) {
    int jumps = 0;
    int current = 0;
    while (current != c.length-1) {
      if (current+2 < c.length && c[current+2] != 1) {
        jumps++;
        current +=2;
      } else {
        jumps++;
        current+=1;
      }
    }
    return jumps;
  }

  @Test
  void name() {
    int[] in = {0,0, 0, 0, 1, 0};
    System.out.println("Answer: " + jumpingOnClouds(in));
  }
}
