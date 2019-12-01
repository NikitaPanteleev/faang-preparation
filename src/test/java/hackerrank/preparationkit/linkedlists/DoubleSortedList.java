package hackerrank.preparationkit.linkedlists;

//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
public class DoubleSortedList {
  public static class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
      this.data = data;
    }
  }

  static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    if (head == null) {
      return new DoublyLinkedListNode(data);
    } else if (head.data >= data) {
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
      newNode.next = head;
      head.prev = newNode;
      return newNode;
    }
    _sortedInsert(head, data);
    return head;
  }
  //data always >= head.data
  static void _sortedInsert(DoublyLinkedListNode head, int data) {
    if (head.next == null) {
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
      newNode.prev = head;
      head.next = newNode;
      return;
    } else if (head.next.data >= data) {
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
      newNode.prev = head;
      newNode.next = head.next;
      head.next = newNode;
    } else {
      _sortedInsert(head.next, data);
    }
  }
}
