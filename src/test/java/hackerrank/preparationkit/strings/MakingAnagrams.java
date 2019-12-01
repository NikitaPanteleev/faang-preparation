package hackerrank.preparationkit.strings;

import org.junit.jupiter.api.Test;

public class MakingAnagrams {
  static int makeAnagram(String a, String b) {
    int[] letters = new int['z'-'a'+1];
    for (char ch: a.toCharArray()) {
      letters[ch - 'a']++;
    }
    for (char ch: b.toCharArray()) {
      letters[ch - 'a']--;
    }
    int answer = 0;
    for (int counter: letters) {
      answer+=Math.abs(counter);
    }
    return answer;
  }

  @Test
  void run() {
    System.out.println("Answer: " + makeAnagram("cde", "abe"));
  }
}
