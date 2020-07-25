package google1.preparationkit.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
  static class Node {
    int data;
    Node next;
  }

  boolean hasCycle(Node head) {
    if (head == null || head.next == null) {
      return false;
    }
    Set<Node> visited = new HashSet<>();
    return _hasCycle(head, visited);
  }

  boolean _hasCycle(Node head, Set<Node> visited) {
    if (visited.contains(head)) {
      return true;
    } else if (head.next == null) {
      return false;
    } else {
      visited.add(head);
      return _hasCycle(head.next, visited);
    }
  }
}
