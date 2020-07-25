package google1.interviewbit.lvl2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXSPPROD {
  int MOD = 1000000007;

  public int[] nextGreaterElement(ArrayList<Integer> A) {
    int[] result = new int[A.size()];
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i< A.size(); i++) {
      while(!stack.isEmpty() && A.get(i) > A.get(stack.peek())) {
        result[stack.pop()] = i;
      }
      stack.push(i);
    }
    return result;
  }

  public int[] previousGreaterElement(ArrayList<Integer> A) {
    int[] result = new int[A.size()];
    Stack<Integer> stack = new Stack<>();
    for(int i = A.size()-1; i>=0; i--) {
      while(!stack.isEmpty() && A.get(i) > A.get(stack.peek())) {
        result[stack.pop()] = i;
      }
      stack.push(i);
    }
    return result;
  }

  public int maxSpecialProduct(ArrayList<Integer> A) {
    int[] greaters = nextGreaterElement(A);
    int[] minions = previousGreaterElement(A);
    long max = 0, current = 0;
    for (int i = 0; i < A.size(); i++){
      current = (long) greaters[i] * (long) minions[i];
      if ( current> max) {
        max = current;
      }
    }
    return (int)(max%1000000007);
  }

  @Test
  public void run(){
    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(506, 59, 854, 422, 4, 6, 800));
    System.out.println("Hi "  + maxSpecialProduct(input));
  }
}
