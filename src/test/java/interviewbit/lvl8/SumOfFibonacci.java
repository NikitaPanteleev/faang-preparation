package interviewbit.lvl8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOfFibonacci {
  public int fibsum(int A) {
    if (A <= 3) {
      return 1;
    }
    LinkedList<Integer> fibs = new LinkedList<>();
    fibs.add(1);
    fibs.add(1);
    int f1 = 1;
    int f2 = 1;
    while (f2 <= A) {
      int tmp = f1+f2;
      fibs.addFirst(tmp);
      f1 = f2;
      f2 = tmp;
    }
    int tmp = A;
    int counter = 0;
    for (int fib: fibs) {
      if (tmp == 0) {
        return counter;
      }
      if (fib <= tmp) {
        tmp-=fib;
        counter++;
      }
    }
    return -1;
  }
  @Test
  public void run() {
    System.out.println(fibsum(35));
  }
}
