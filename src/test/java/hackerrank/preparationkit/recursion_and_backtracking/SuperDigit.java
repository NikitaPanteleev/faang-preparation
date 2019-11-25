package hackerrank.preparationkit.recursion_and_backtracking;

import org.junit.jupiter.api.Test;


public class SuperDigit {
  static int su(int digit1, int digit2) {
    if (digit1 + digit2 < 10) {
      return digit1 + digit2;
    } else {
      return 1 + (digit1 + digit2) %10;
    }
  }

  static int superDigit(String n, int k) {
    int res = 0;
    for (Character s: n.toCharArray()) {
      res=su(res, s - '0');
    }
    int answer = 0;
    for (int i = 0; i <k; i++) {
      answer=su(res, answer);
    }
    return answer;
  }

  @Test
  void run() {
    System.out.println("Answer: " + superDigit("148", 3));
  }
}
