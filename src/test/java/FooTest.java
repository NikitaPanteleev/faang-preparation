import org.junit.jupiter.api.Test;


class FooTest {

  // Complete the maxSubsetSum function below.
  static int maxSubsetSum(int[] arr) {
    int[] maxSum = new int[arr.length];
    if (arr.length == 1) {
      return arr[0];
    }
    maxSum[0] = arr[0];
    maxSum[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++) {
      maxSum[i] = Math.max(maxSum[i-1], Math.max(0, maxSum[i-2]) + arr[i]);
    }
    for (int elem: maxSum) {
      System.out.println(elem);
    }
    int max = arr[0];
    for (int j: maxSum) {
      if (j > max){
        max = j;
      }
    }
    return max;
  }

  @Test
  public void run() {
    int[] data = {3,7,4,6,5};
    System.out.println(maxSubsetSum(data));
  }



}