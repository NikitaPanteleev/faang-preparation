package hackerrank.preparationkit.graph;

import java.util.ArrayList;

public class HuffmanDecoding {
  class Node {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
  }

  void decode(String s, Node root) {
    ArrayList<Character> chars = new ArrayList<>();
    char[] string = s.toCharArray();
    int i = 0;
    Node current = root;
    while (i < s.length()) {
      if (string[i] == '0' && current.left.left == null && current.left.right == null) {
        chars.add(current.left.data);
        current = root;
      } else if (string[i] == '1' && current.right.left == null && current.right.right == null) {
        chars.add(current.right.data);
        current = root;
      } else if (string[i] == '0') {
        current = current.left;
      } else if (string[i] == '1') {
        current = current.right;
      }
      i++;
    }
    StringBuilder sb = new StringBuilder();
    for (char letter : chars) {
      sb.append(letter);
    }
    System.out.println( sb.toString());
  }

}
