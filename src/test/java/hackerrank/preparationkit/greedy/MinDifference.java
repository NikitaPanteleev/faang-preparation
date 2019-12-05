package hackerrank.preparationkit.greedy;

import java.util.Arrays;

public class MinDifference {
  static int minimumAbsoluteDifference(int[] arr) {
    Arrays.sort(arr);
    int answer = Math.abs(arr[0] - arr[1]);
    for (int i =0; i < arr.length - 1; i++) {
      if (Math.abs(arr[i] - arr[i + 1]) < answer) {
        answer = Math.abs(arr[i] - arr[i + 1]);
      }
    }
    return answer;

  }
}
