package hackerrank.preparationkit.arrays;

public class LeftRotation {
  static int[] rotLeft(int[] a, int d) {
    int[] answer = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      answer[(a.length + i - d ) %a.length] = a[i];
    }
    return answer;
  }
}
