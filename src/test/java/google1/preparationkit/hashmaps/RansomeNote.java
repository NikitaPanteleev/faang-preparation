package google1.preparationkit.hashmaps;

import java.util.HashMap;

public class RansomeNote {
  static void checkMagazine(String[] magazine, String[] note) {
    HashMap<String, Integer> bigger = new HashMap<>(magazine.length);
    HashMap<String, Integer> smaller = new HashMap<>(note.length);

    for (String s: magazine) {
      if (bigger.containsKey(s)) {
        bigger.put(s, bigger.get(s) + 1);
      } else {
        bigger.put(s, 1);
      }
    }
    for (String s: note) {
      if (smaller.containsKey(s)) {
        smaller.put(s, bigger.get(s) + 1);
      } else {
        smaller.put(s, 1);
      }
    }
    for (String s: smaller.keySet()) {
      if (!bigger.containsKey(s) || bigger.get(s) < smaller.get(s)) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

}
