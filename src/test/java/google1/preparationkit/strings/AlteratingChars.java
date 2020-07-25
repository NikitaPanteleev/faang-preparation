package google1.preparationkit.strings;

import org.junit.jupiter.api.Test;

public class AlteratingChars {
  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s) {
    if (s.equals("")) {
      return 0;
    }
    char current = s.charAt(0);
    int counter = 0;
    for (char ch: s.substring(1).toCharArray()) {
      if (ch == current) {
        counter++;
      } else {
        current = ch;
      }
    }
    return counter;
  }

  @Test
  void run() {
    System.out.println("Answer: " + alternatingCharacters("ABAABB"));
  }
}
