package google1.preparationkit.dynamic_programming;

import org.junit.jupiter.api.Test;

public class Candies {
  // Complete the candies function below.
  static long candies(int n, int[] arr) {
    if (n == 0 || n == 1) {
      return n;
    }
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = 1;
    }
    boolean correct = false;
    while (!correct) {
      correct = true;
      for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1] && answer[i] > answer[i + 1] ||
            arr[i] < arr[i + 1] && answer[i] < answer[i + 1] ||
            arr[i] == arr[i+1]
        ) {
          //everything is fine, in all other cases correct = false
        } else {
          correct = false;
          if (arr[i] < arr[i+1]) {
            answer[i+1] += answer[i]-answer[i+1] + 1;
          } else if(arr[i] > arr[i+1]) {
            answer[i]+= answer[i+1] - answer[i] + 1;
          }
        }
      }
    }
    long sum = 0;
    for (int i = 0; i< n; i++) {
      sum+=answer[i];
    }
    return sum;
  }


  @Test
  public void run() {
//    int[] in3 = {1,2,2};
//    assert candies(in3.length, in3) == 4;
//
//    int[] in = {4, 6, 4, 5, 6, 2};
//    assert candies(in.length, in) == 10;

    int[] in2 = {2 ,4 ,2 ,6 ,1 ,7 ,8 ,9, 2 ,1};
    System.out.println("Answer " + candies(in2.length, in2));
    assert candies(in2.length, in2) == 19;

  }
}
