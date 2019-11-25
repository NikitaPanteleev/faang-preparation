package interviewbit.lvl2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

  public Integer backSearch(ArrayList<Integer> A) {
    int index = -1;
    for (int i = A.size() - 1; i > 0; i--) {
      if (A.get(i) > A.get(i - 1)) {
        return i - 1;
      }
    }
    return index;
  }

  public void reverse(ArrayList<Integer> A, int start) {
    int p1 = start;
    int p2 = A.size() - 1;
    while (p1 < p2) {
      switchElems(A, p1, p2);
      p1++;
      p2--;
    }
  }

  public void switchElems(ArrayList<Integer> A, int i, int j) {
    int tmp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, tmp);
  }

  //index is returned
  public int findNextGreaterElementToSwitch(ArrayList<Integer> A, int index) {
    for (int i = index + 1; i < A.size(); i++) {
      if (A.get(i) < A.get(index)) {
        return i-1;
      }
    }
    return A.size() - 1;
  }

  public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
    if (A.size() <= 1) {
      return A;
    }
    int elementToSwitch = backSearch(A);
    if (elementToSwitch == -1) {
      reverse(A, 0);
      return A;
    }
    int elementToSwitch2 = findNextGreaterElementToSwitch(A, elementToSwitch);
    switchElems(A, elementToSwitch, elementToSwitch2);
    reverse(A, elementToSwitch + 1);
    return A;
  }

  @Test
  public void run() {
    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(506, 59, 854, 422));
    //input:    506 59  854 422
    //mine      506 854 59  422
    //expected: 506 422 59  854

//    input = new ArrayList<>(Arrays.asList(319, 695, 52));
    //in    319, 695, 52
    //mine: 52 319 695
    //exp:  695 52 319
    System.out.println("HI " + nextPermutation(input));
  }
}
