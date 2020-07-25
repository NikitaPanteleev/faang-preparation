package google1.preparationkit.strings;

import org.junit.jupiter.api.Test;

public class SpecialString {
  // Complete the substrCount function below.
  static long substrCount(int n, String s) {
    int answer = 0;
    for (int i = 0; i< s.length(); i++) {
      int maxSequence= 1;
      for (int j = i+1; j < s.length(); j++) {
        if (s.charAt(j) == s.charAt(i)) {
          maxSequence++;
        } else {
          break;
        }
      }
      if (isSpecial(s, i, maxSequence)) {
        answer++;
      }
      answer+=maxSequence;
    }
    return answer;
  }

  static boolean isSpecial(String s, int i, int maxSeq) {
    if (i + 2 * maxSeq  < s.length()) {
      for (int j = i; j < i + 2 * maxSeq + 1; j++) {
        if (j != i + maxSeq) {
          if (s.charAt(i) != s.charAt(j)) {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }

  @Test
  void run() {
    System.out.println("Answer: " + substrCount(0, "abcbaba"));
  }
}
