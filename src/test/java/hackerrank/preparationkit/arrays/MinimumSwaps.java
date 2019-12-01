package hackerrank.preparationkit.arrays;

public class MinimumSwaps {
  static int minimumSwaps(int[] arr) {
    int[] positions = new int[arr.length+1];
    for (int i = 0; i < arr.length; i++) {
      positions[arr[i]] = i;
    }
    int swap = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i]  != i + 1) {
        int toMove = arr[i];
        arr[i] = i+1;
        positions[toMove] = positions[i+1];
        arr[positions[i+1]] = toMove;
        swap++;
      }
    }
    return swap;
  }
}
