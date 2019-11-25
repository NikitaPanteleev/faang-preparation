package hackerrank.preparationkit.recursion_and_backtracking;


import org.junit.jupiter.api.Test;

public class Staircase {
  // Complete the stepPerms function below.
  static int stepPerms(int n) {
    int[] memo = new int[n+3];
    memo[0] = 1;
    memo[1] = 1;
    memo[2] = 2;
    memo[3] = 4;
    if (n <=3) {
      return memo[n];
    } else {
      return _stepPerms(n, memo);
    }
  }

  static int _stepPerms(int n, int[] memo) {
    if (memo[n] !=0) {
      return memo[n];
    } else {
      long result = (_stepPerms(n-3, memo) + _stepPerms(n-2, memo) + _stepPerms(n-1, memo)) % 10000000007L;
      memo[n] = (int)result;
      return (int)result;
    }
  }

  @Test
  void run() {
    System.out.println("Answer: " + stepPerms(7) );
  }
}
