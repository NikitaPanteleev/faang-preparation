package hackerrank.preparationkit.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class TwoStacks {
  public static class MyQueue<T> {
    Stack<T> queue = new Stack<T>();
    Stack<T> dequeue  = new Stack<T>();

    public void enqueue(T elem) {
      queue.add(elem);
    }

    public T dequeue() {
      if (!dequeue.isEmpty()) {
        return dequeue.pop();
      } else {
        while (!queue.isEmpty()) {
          dequeue.add(queue.pop());
        }
        return dequeue.pop();
      }
    }

    public T peek() {
      if (!dequeue.isEmpty()) {
        return dequeue.peek();
      } else {
        while (!queue.isEmpty()) {
          dequeue.add(queue.pop());
        }
        return dequeue.peek();
      }
    }
  }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
