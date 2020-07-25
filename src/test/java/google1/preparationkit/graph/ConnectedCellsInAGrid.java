package google1.preparationkit.graph;

import org.junit.jupiter.api.Test;

public class ConnectedCellsInAGrid {

  @Test
  void run() {
    int[][] in = {
        {1,1,0,0},
        {0,1,1,0},
        {0,0,1,0},
        {1,0,0,0}
    };
    System.out.println("Answer: " + maxRegion(in));
  }

  // Complete the maxRegion function below.
  static int maxRegion(int[][] grid) {
    int max = 0;
    for(int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] != 0) {
          max = Math.max(max, getMaxRegion(grid, row, col));
        }
      }
    }
    return max;
  }

  static int getMaxRegion(int[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
      return 0;
    }
    if (grid[row][col] == 0) {
      return 0;
    }
    grid[row][col] = 0;

    return 1 +
        getMaxRegion(grid, row-1, col - 1) +
        getMaxRegion(grid, row-1, col ) +
        getMaxRegion(grid, row-1, col + 1) +
        getMaxRegion(grid, row, col - 1) +
        getMaxRegion(grid, row, col + 1) +
        getMaxRegion(grid, row + 1, col -1) +
        getMaxRegion(grid, row + 1, col) +
        getMaxRegion(grid, row + 1, col +1);
  }


}
