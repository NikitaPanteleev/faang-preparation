package hackerrank.preparationkit.stacks_and_queues;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PoisonousPlants {
  // Complete the poisonousPlants function below.
  static int poisonousPlants(int[] p) {
    ArrayList<Deque<Integer>> chains = new ArrayList<>();
    for (int i: p) {
      if (chains.isEmpty() || i > chains.get(chains.size()-1).getLast()) {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        tmp.add(i);
        chains.add(tmp);
      } else {
        chains.get(chains.size()-1).add(i);
      }
    }
    int day = 0;
    while (chains.size() > 1) {
      //remove heads
      for (int i =0; i < chains.size(); i++) {
        if (i!=0) {
          chains.get(i).removeFirst();
        }
      }
      Deque<Integer> current = chains.get(0);
      for (Deque<Integer> stack: chains.subList(1, chains.size())) {
        if (!stack.isEmpty()) {
          if (stack.getFirst() <= current.getLast()) {
            current.addAll(stack);
            stack.clear();
          } else {
            current = stack;
          }
        }
      }
      chains.removeIf(s -> s.isEmpty());
      day++;
    }

    return day;
  }


  @Test
  void run() {
    int[] in = {6,5,8,4,7,10,9};
    int[] in2 = {4, 3, 7, 5, 6, 4, 2};
    int[] in3 = {20,5,6,15,2,2,17,2,11,5,14,5,10,9,19,12,5};
    System.out.println("Answer: " + poisonousPlants(in3));
  }
}
