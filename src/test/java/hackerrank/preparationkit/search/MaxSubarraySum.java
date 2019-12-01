package hackerrank.preparationkit.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxSubarraySum {
  // Complete the maximumSum function below.
  static class Index {
    public final int index;
    public final long value;

    public Index(int index, long value) {
      this.index = index;
      this.value = value;
    }
  }

  static long maximumSum(long[] a, long m) {
    Index[] sums = new Index[a.length];
    sums[0] = new Index(0, a[0]% m);
    for (int i = 1; i < a.length; i++) {
      sums[i] = new Index(i, (sums[i-1].value + a[i]) % m);
    }
    Arrays.sort(sums, (i1, i2) -> {
      if (i1.value == i2.value) {
        return 0;
      } else if (i1.value > i2.value) {
        return 1;
      }
      return -1;
    });
    long answer = 0;
    for (int i = 0; i <a.length; i++) {
      answer= Math.max(answer, sums[i].value);
      if (i!= 0) {
        if (sums[i].index < sums[i-1].index && sums[i].value > sums[i-1].value) {
          answer = Math.max(answer, (m + sums[i-1].value - sums[i].value));
        }
      }
    }
    return answer;
  }

  @Test
  void run() {
    long[] in = {3L, 2l, 7l, 4l};
    System.out.println("Answer: " + maximumSum(in, 7));

  }
}
