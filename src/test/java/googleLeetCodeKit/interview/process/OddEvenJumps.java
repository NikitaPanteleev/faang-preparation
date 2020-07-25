package googleLeetCodeKit.interview.process;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
  public int oddEvenJumps(int[] A) {
    if (A.length == 1) {
      return 1;
    }
    boolean[] oddIndices = new boolean[A.length];
    boolean[] evenIndices = new boolean[A.length];
    oddIndices[oddIndices.length-1] = true;
    evenIndices[evenIndices.length-1] = true;
    TreeMap<Integer, Integer> data = new TreeMap<>();
    data.put(A[A.length-1], A.length-1);
    for(int i = oddIndices.length-2; i>=0; i--) {
      if (data.containsKey(A[i])) {
        oddIndices[i] = evenIndices[data.get(A[i])];
        evenIndices[i] = oddIndices[data.get(A[i])];
        data.put(A[i], i);
      } else {
        data.put(A[i], i);
        Map.Entry<Integer, Integer> minEntry = data.lowerEntry(A[i]);
        if (minEntry != null) {
          evenIndices[i] = oddIndices[minEntry.getValue()];
        }
        Map.Entry<Integer, Integer> maxEntry = data.higherEntry(A[i]);
        if (maxEntry != null) {
          oddIndices[i] = evenIndices[maxEntry.getValue()];
        }
      }
    }
    int counter = 0;
    for(boolean isStart: oddIndices) {
      if (isStart) {
        counter++;
      }
    }
    System.out.println("Odd: " + Arrays.toString(oddIndices));
    System.out.println("Even: " + Arrays.toString(evenIndices));
    return counter;
  }

  @Test
  public void run() {
    int[] in = {2,3,1,1,4};
    System.out.println("Answer: " + oddEvenJumps(in));
  }
}
