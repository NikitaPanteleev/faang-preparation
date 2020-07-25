package google1.preparationkit.hashmaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Queries {
  // Complete the freqQuery function below.
  static List<Integer> freqQuery(List<int[]> queries) {
    HashMap<Integer, Integer> data = new HashMap<>();
    int[] counters = new int[queries.size()+1];
    ArrayList<Integer> answer = new ArrayList<>();
    for (int[] cmd : queries) {
      Integer cmdType = cmd[0];
      Integer cmdValue = cmd[1];

      switch (cmdType) {
        case 1:
          int previousCount = data.getOrDefault(cmdValue, 0);
          data.put(cmdValue, data.getOrDefault(cmdValue, 0) + 1);
          counters[data.get(cmdValue)]+=1;
          counters[previousCount]-=1;
          break;
        case 2:
          if (data.containsKey(cmdValue) && data.get(cmdValue) != 0) {
            int currentCounter = data.get(cmdValue);
            data.put(cmdValue, currentCounter - 1);
            counters[currentCounter]-=1;
            counters[currentCounter-1]+=1;
          }
          break;
        case 3:
          if (cmdValue < queries.size() && counters[cmdValue] > 0) {
            answer.add(1);
          } else {
            answer.add(0);
          }
          break;
      }
    }
    return answer;
  }

  @Test
  void run() {
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Long.MAX_VALUE);
  }
}
