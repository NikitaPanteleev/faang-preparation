package interviewbit.lvl8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class Multiple01 {
  public String multiple(int A) {
    if (A == 1) {
      return "1";
    }
    //list of residuals
    Queue<Integer> numbers = new ArrayDeque<>();
    //list of added digits
    boolean[] digits = new boolean[A + 1];
    //list of parents
    int[] parents = new int[A + 1];

    numbers.add(1);
    digits[1] = true;
    parents[1] = 1;

    while (!numbers.isEmpty()) {
      int residual = numbers.poll();
      if (residual % A == 0) {
        int parent = residual;
        StringBuilder sb = new StringBuilder();
        while (parent != 1) {
          sb.append(digits[parent] ? "1" : "0");
          parent = parents[parent];
        }
        sb.append("1");
        return sb.reverse().toString();
      }

      int next = residual * 10 % A;
      int afterNext = (residual * 10 + 1) % A;
      if (next != 1 && parents[next] == 0) {
        numbers.add(next);
        parents[next] = residual;
        digits[next] = false;
      }

      if( afterNext !=1 && parents[afterNext] == 0){
        numbers.add(afterNext);
        parents[afterNext] = residual;
        digits[afterNext] = true;
      }
    }
    return "-1";
  }

  @Test
  public void run() {
    log.info("Answer: " + multiple(35));
    log.info("Answer: " + multiple(25));
    log.info("Answer: " + multiple(6));
  }
}
