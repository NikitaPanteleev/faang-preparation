package hackerrank.preparationkit.sortation;

import org.junit.jupiter.api.Test;

public class BubleSort {
  // Complete the countSwaps function below.
  static void countSwaps(int[] a) {
    int n = a.length;
    int swaps = 0;
    int tmp;
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          tmp = a[j];
          a[j] = a[j+1];
          a[j+1] = tmp;
          swaps++;
        }
      }
    }
    System.out.println("Array is sorted in " + swaps + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n-1]);
  }

  @Test
  void run() {
    int[] arr = {1,2,3,0};
    countSwaps(arr);

  }
}
