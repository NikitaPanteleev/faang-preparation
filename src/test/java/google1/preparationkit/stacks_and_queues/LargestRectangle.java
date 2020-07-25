package google1.preparationkit.stacks_and_queues;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LargestRectangle {
  public static class Block {
    public int i;
    public int h;

    public Block(int i, int h) {
      this.i = i;
      this.h = h;
    }
  }

  // Complete the largestRectangle function below.
  static long largestRectangle(int[] h) {
    long max = -1;
    Stack<Block> stack = new Stack<>();
    for (int i = 0; i < h.length; i++) {
      Block current = new Block(i, h[i]);
      if (stack.isEmpty() || current.h >= stack.peek().h) {
        stack.add(current);
      } else {
        int prevIndex = -1;
        while (!stack.isEmpty() && current.h <  stack.peek().h) {
          Block previousBlock = stack.pop();
          prevIndex = previousBlock.i;
          max = Math.max(max, (current.i - previousBlock.i ) * previousBlock.h);
        }
        stack.add(new Block(prevIndex, current.h));
      }
    }
    while (!stack.isEmpty()) {
      Block previousBlock = stack.pop();
      max = Math.max(max, (h.length - previousBlock.i) * previousBlock.h);
    }
    return max;
  }

  @Test
  void run() {
    int[] in1 = {1,2,3,4,5};
    int[] in2 = {11, 11,10,10,10};
    int[] in3 = {8979,4570,6436,5083,7780,3269,5400,7579,2324,2116};
    System.out.println("Answer: " + largestRectangle(in3));
    assert largestRectangle(in1) == 9;
    assert largestRectangle(in2) == 50;
  }
}
