package google1.preparationkit.linkedlists;

public class ReverseList {
  public static class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
      this.data = data;
    }
  }

  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    if (head == null) {
      return null;
    } else if (head.next == null) {
      head.next = head.prev;
      head.prev = null;
      return head;
    } else {
      DoublyLinkedListNode tmp = head.next;
      head.next = head.prev;
      head.prev = tmp;
      return reverse(tmp);
    }
  }



}
