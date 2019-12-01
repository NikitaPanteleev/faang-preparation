package hackerrank.preparationkit.linkedlists;

public class InsertNode {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
  }

  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    _insertNodeAtPosition(head.next, data, position-1);
    return head;
  }

  static void  _insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    if (position == 0) {
      SinglyLinkedListNode newNode = new SinglyLinkedListNode();
      newNode.data = data;
      newNode.next = head.next;
      head.next = newNode;
    } else {
      _insertNodeAtPosition(head.next, data, position-1);
    }
  }
}
