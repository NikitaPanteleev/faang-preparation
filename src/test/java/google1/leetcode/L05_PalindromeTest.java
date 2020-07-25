package google1.leetcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L05_PalindromeTest {

  public String longestPalindrome(String s) {
    char[] array = s.toCharArray();
    if (s == null || s.length() == 1) {
      return s;
    }
    for (int len = s.length(); len >= 1; len--) {
      for (int i = 0; i <= s.length() - len; i ++) {
        if (isPalindrom(i, i +len-1, array)) {
          return s.substring(i, i + len);
        }
      }
    }
    return s;
  }

  boolean isPalindrom(int start, int end, char[] array) {
    int i = start;
    int j = end;
    while (i < j) {
      if (array[i] != array[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  @Test
  public void run() {
    log.info(longestPalindrome("absatas"));
  }

}
