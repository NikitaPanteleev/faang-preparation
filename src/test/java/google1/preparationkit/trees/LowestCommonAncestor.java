package google1.preparationkit.trees;

public class LowestCommonAncestor {
  class Node {
    public int data;
    public Node left;
    public Node right;
  }


  public static Node lca(Node root, int v1, int v2) {
    if (root.data < v1 && root.data < v2) {
      return lca(root.right, v1, v2);
    } else if (root.data > v2 && root.data > v1){
      return lca(root.left, v1, v2);
    } else {
      return root;
    }
  }
}
