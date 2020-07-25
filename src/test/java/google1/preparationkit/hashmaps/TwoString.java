package google1.preparationkit.hashmaps;

public class TwoString {
  static String twoStrings(String s1, String s2) {
    boolean[] s1Chars = new boolean[('z' - 'a') + 1];
    boolean[] s2Chars = new boolean[('z' - 'a') + 1];
    for (char ch: s1.toCharArray()) {
      s1Chars[ch - 'a'] = true;
    }
    for (char ch: s2.toCharArray()) {
      s2Chars[ch - 'a'] = true;
    }
    for (int i = 0; i < ('z' - 'a') + 1; i++) {
      if (s1Chars[i] == s2Chars[i] && s1Chars[i]) {
        return "YES";
      }
    }
    return "NO";
  }
}
