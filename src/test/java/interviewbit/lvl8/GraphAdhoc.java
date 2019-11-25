package interviewbit.lvl8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 **/

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class GraphAdhoc {
  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  public TreeNode sortedListToBST(ListNode a) {
    ArrayList<Integer> labels = new ArrayList<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();
    labels.add(a.val);
    nodes.put(a.val, new TreeNode(a.val));
    ListNode next = a;

    while (next.next != null) {
      labels.add(next.next.val);
      nodes.put(next.next.val, new TreeNode(next.next.val));
      next = next.next;
    }

    return _sortedListToBST(labels, 0, labels.size()-1);
  }

  public TreeNode _sortedListToBST(ArrayList<Integer> nodes, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode root = new TreeNode(nodes.get((start + end) / 2));
    root.left = _sortedListToBST(nodes, start, (start + end)/2 -1);
    root.right = _sortedListToBST(nodes, (start + end)/ 2 + 1, end);
    return root;
  }

  @Test
  public void run() {
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(20);
    ListNode a3 = new ListNode(30);
    ListNode a4 = new ListNode(40);
    ListNode a5 = new ListNode(50);
//    ListNode a6 = new ListNode(60);

    a1.next = a2;
    a2.next = a3;
    a3.next = a4;
    a4.next = a5;
//    a5.next = a6;
    TreeNode res = sortedListToBST(a1);
    System.out.println("Hello");
  }
}
