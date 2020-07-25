package google1.preparationkit.trees;

import java.util.ArrayList;

public class HeightOfTree {
  class Node {
    public int data;
    public Node left;
    public Node right;
  }

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int height = 0;
    ArrayList<Node> children = new ArrayList<>();
    ArrayList<Node> tmp = new ArrayList<>();
    children.add(root);
    while(!children.isEmpty()) {
      tmp.clear();
      for (Node child: children) {
        if (child.left != null) {
          tmp.add(child.left);
        }
        if (child.right != null) {
          tmp.add(child.right);
        }
      }
      children.clear();
      children.addAll(tmp);
      height++;
    }
    return height-1;
  }

}
