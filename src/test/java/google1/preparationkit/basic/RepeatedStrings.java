package google1.preparationkit.basic;

import org.junit.jupiter.api.Test;

public class RepeatedStrings {
  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {
      long fullStrings = n / s.length();
      long occurences = 0;
      for (char letter: s.toCharArray()) {
        if (letter == 'a') {
          occurences++;
        }
      }
     long answer = occurences * fullStrings;
      if (n % s.length() != 0) {
        String rem = s.substring(0, (int) (n % s.length()));
        for (char letter: rem.toCharArray()) {
          if (letter == 'a') {
            answer++;
          }
        }
      }
      return answer;
  }

  @Test
  void run() {
    System.out.println("Answer: " + repeatedString("aab", 3));
  }
}
