package hackerrank.preparationkit.sortation;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Fraudulent {
  // Complete the activityNotifications function below.
  static int activityNotifications(int[] expenditure, int d) {

    int counter = 0;
    PriorityQueue<Integer> left = new PriorityQueue<>(d / 2 + 1, (a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>(d / 2 + 1);
    for (int i = 0; i < d; i++) {
      left.add(expenditure[i]);
    }
    for (int i = 0; i < d/2; i++) {
      right.add(left.poll());
    }
    for (int i = d; i < expenditure.length; i++) {
      if (expenditure[i] >= peekMiddleDoubled(left, right)) {
        counter++;
      }
      addElement(left, right, expenditure[i], expenditure[i-d]);
    }
    return counter;
  }

  static void addElement(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int elem, int toRemove) {
    if (left.remove(toRemove)) {
      if (elem < right.peek()) {
        left.add(elem);
      } else {
        left.add(right.poll());
        right.add(elem);
      }
    } else {
      right.remove(toRemove);
      if (elem > left.peek()) {
        right.add(elem);
      } else {
        right.add(left.poll());
        left.add(elem);
      }
    }
  }

  static int peekMiddleDoubled(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    if (left.size() == right.size()) {
      return left.peek() + right.peek();
    } else if (left.size() > right.size()) {
      return 2 * left.peek();
    } else {
      return 2 * right.peek();
    }
  }


  @Test
  void run() {
    int[] in = {1, 2, 3, 4, 4};
    int[] in2 = {10,20,30,40,50};
     System.out.println("Answer: " + activityNotifications(in, 4));
  }
}
