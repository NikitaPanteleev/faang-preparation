package google1.preparationkit.trees;

import org.junit.jupiter.api.Test;

public class IsBst {
  static class Node {
    public int data;
    public Node left;
    public Node right;
  }

  boolean checkBST(Node root) {
    return _checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean _checkBst(Node root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.data <= min || root.data >= max) {
      return false;
    }
    return _checkBst(root.left, min, root.data) && _checkBst(root.right, root.data, max);
  }

  @Test
  void run() {

  }
}
