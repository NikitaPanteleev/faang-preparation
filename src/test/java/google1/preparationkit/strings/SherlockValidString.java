package google1.preparationkit.strings;

import org.junit.jupiter.api.Test;

import java.util.*;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class SherlockValidString {
  static String isValid(String s) {
    int[] letters = new int['z' - 'a' + 1];
    for (char ch : s.toCharArray()) {
      letters[ch - 'a']++;
    }
    Map<Integer, Integer> occurences = new HashMap<>();
    for (int i : letters) {
      if (i != 0) {
        occurences.put(i, occurences.getOrDefault(i, 0) + 1);
      }
    }
    if (occurences.keySet().size() == 1) {
      return "YES";
    } else if (occurences.keySet().size() > 2) {
      return "NO";
    }
    //only 2 types of occurences (1 and 2)
    int k1 = 0;
    int k2 = 0;
    for (int k : occurences.keySet()) {
      if (k1 == 0) {
        k1 = k;
      } else {
        if (k > k1) {
          k2 = k;
        } else {
          int tmp = k1;
          k1 = k;
          k2 = tmp;
        }
      }
    }
    if (k1 == 1 && occurences.get(1) == 1) {
      return "YES";
    }
    if (Math.abs(k1-k2) != 1) {
      return "NO";
    }

    return (occurences.get(k2) == 1 || occurences.get(k1) == 1)  ? "YES": "NO";
  }

  @Test
  void run() {
    System.out.println("Answer: " + isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
  }
}
