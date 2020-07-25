package google1.preparationkit.arrays;

import org.junit.jupiter.api.Test;

public class ArrayManipulation {
  static long arrayManipulation(int n, int[][] queries) {
    long[] arr = new long[n+1];
    for (int[] query: queries) {
      int start = query[0];
      int end = query[1];
      int value = query[2];
      arr[start]+=value;
      if (end < n) {
        arr[end+1]-=value;
      }
    }
    long max = 0l;
    long tmp = 0l;
    for (int i = 0; i < arr.length; i++) {
      tmp+=arr[i];
      if (tmp > max) {
        max=tmp;
      }
    }
    return max;
  }

  @Test
  void run() {
    int[][] in = {
        {1, 5, 3},
        {4, 8, 7},
        {6, 9, 1}
    };
    System.out.println("answer: " + arrayManipulation(10, in));
  }
}
