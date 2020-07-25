package google1.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class L48 {
  public void rotate(int[][] m) {
    int n = m.length-1;
    int tmp;
    int rBorder = m.length/2;
    int cBorder = m.length % 2 == 0 ? m.length/2-1 : m.length/2;
    for (int r = 0; r < rBorder; r++) {
      for (int c=0; c<= cBorder; c++) {
        tmp =  m[r][c];
        m[r][c] = m[n-c][r];
        m[n-c][r] =  m[n - r][n-c ];
        m[n - r][n-c ] = m[c][n - r];
        m[c][n - r] = tmp;
      }
    }

  }

  @Test
  void run() {
    int[][] in = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    rotate(in);
    for (int[] r : in) {
      System.out.println(Arrays.toString(r));
    }
  }
}
