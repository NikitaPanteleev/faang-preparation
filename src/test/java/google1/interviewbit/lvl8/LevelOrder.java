package google1.interviewbit.lvl8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LevelOrder {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
    ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    ArrayList<TreeNode> current = new ArrayList<>();
    ArrayList<TreeNode> next = new ArrayList<>();
    ArrayList<Integer> tmp = new ArrayList<>();
    current.add(A);
    while (!current.isEmpty()){
      tmp.clear();
      next.clear();
      for (TreeNode node: current) {
        tmp.add(node.val);
        if (node.left != null) {
          next.add(node.left);
        }
        if (node.right != null) {
          next.add(node.right);
        }
      }
      levels.add(new ArrayList<>(tmp));
      current.clear();
      current.addAll(next);
    }
    return levels;
  }

  @Test
  public void run(){
    TreeNode a1 = new TreeNode(1);
    TreeNode a2 = new TreeNode(2);
    TreeNode a3 = new TreeNode(3);
    TreeNode a4 = new TreeNode(4);
    a1.left = a2;
    a1.right= a3;
    a3.right = a4;
    ArrayList<ArrayList<Integer>> res = levelOrder(a1);
    System.out.println(res);
  }
}
