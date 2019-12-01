package hackerrank.preparationkit.arrays;

public class Array2D {
  static int hourglassSum(int[][] arr) {
    int answer = Integer.MIN_VALUE;
    for (int row = 0; row < arr[0].length-2; row++) {
      for (int column = 0; column < arr[0].length-2; column++) {
        int hourglass = hourglass(arr, row, column);
        if (hourglass > answer) {
          answer = hourglass;
        }
      }
    }
    return answer;
  }

  static int hourglass(int[][] arr, int row, int column) {
    return arr[row][column] + arr[row][column+1] + arr[row][column+2] +
                              arr[row+1][column+1] +
           arr[row+2][column] + arr[row+2][column+1] + arr[row+2][column+2];
  }
}
