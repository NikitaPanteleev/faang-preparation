package hackerrank.preparationkit.strings;

import org.junit.jupiter.api.Test;

public class CommonChild {
  static int commonChild(String s1, String s2) {
    int[][] memo = new int[s1.length()][s2.length()];
    for (int i = 0; i < s1.length(); i++){
      for (int j = 0; j < s2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    for (int i =0; i< s1.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          memo[i][j] = 1 + get(memo, i-1, j-1);
        } else {
          memo[i][j] = Math.max(get(memo, i-1, j), get(memo, i, j-1));
        }
      }
    }
    return memo[s1.length()-1][s2.length()-1];
  }

  static int get(int[][] memo, int i1, int i2) {
    if (i1 <0 || i2 < 0 || i1 >= memo.length || i2 >= memo[0].length) {
      return 0;
    } else {
      return memo[i1][i2];
    }
  }

  @Test
  void run() {
//    System.out.println("Answer" + commonChild("ABCDEF", "FBDAMN"));
    System.out.println("Answer: " + commonChild("SHINCHAN","NOHARAAA"));
  }
}
