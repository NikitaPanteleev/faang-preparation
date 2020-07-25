package google1.preparationkit.hashmaps;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {
  static HashMap<Character, Integer> primes = new HashMap<Character, Integer>(){{
    put('a', 2);
    put('b', 3);
    put('c', 5);
    put('d', 7);
    put('e', 11);
    put('f', 13);
    put('g', 17);
    put('h', 19);
    put('i', 23);
    put('j', 29);
    put('k', 31);
    put('l', 37);
    put('m', 41);
    put('n', 43);
    put('o', 47);
    put('p', 53);
    put('q', 59);
    put('r', 61);
    put('s', 67);
    put('t', 71);
    put('u', 73);
    put('v', 79);
    put('w', 83);
    put('x', 89);
    put('y', 97);
    put('z', 101);
  }};

  static int sherlockAndAnagrams(String s) {
    Map<Long, Integer> occurences = new HashMap<>(s.length());
    int result = 0;
    for (int l = 1; l < s.length(); l++) {
      occurences.clear();
      for (int i = 0; i <= s.length() - l; i++) {
        long hash = special(s.substring(i, i + l));
        if (occurences.containsKey(hash)) {
          occurences.put(hash, occurences.get(hash) + 1);
        } else {
          occurences.put(hash, 1);
        }
      }
      for (int count : occurences.values()) {
        if (count >= 2) {
          result += count * (count - 1) / 2;
        }
      }
    }
    return result;
  }

  static long special(String s) {
    long i = 1;
    for (char ch: s.toCharArray()) {
      i = i *  primes.get(ch) %1000000007L;
    }
    return i;
  }

  @Test
  void run() {
    System.out.println("Answer " + sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
  }
}
