package google1.preparationkit.linkedlists;

//https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
public class PointOfMerge {

  static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
  }

  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode A = head1;
    SinglyLinkedListNode B = head2;
    while (A != B) {
      if (A.next == null) {
        A = head2;
      } else {
        A = A.next;
      }

      if (B.next == null) {
        B = head1;
      } else {
        B = B.next;
      }
    }
    return A.data;
  }

  static int _findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
     if (head1.next == null) {
      return head1.data;
    } else if (head2.next == null) {
      return head2.data;
    } else if (head1.data == head2.data) {
      return head1.data;
    } else if (head1.data > head2.data) {
      return _findMergeNode(head1, head2.next);
    } else {
      return _findMergeNode(head1.next, head2);
    }
  }
}
