package google1.preparationkit.basic;

import org.junit.jupiter.api.Test;

public class CountingValleys {
  static int countingValleys(int n, String s) {
    int valleys = 0;
    int level = 0;
    for (Character step: s.toCharArray()) {
      if (level == 0 && step == 'D') {
        valleys+=1;
      }
      if (step == 'D') {
        level-=1;
      } else {
        level+=1;
      }
    }
    return valleys;
  }

  @Test
  void run() {
    System.out.println("Answer: " + countingValleys(8, "UDDDUDUU"));
  }
}
