package hackerrank.preparationkit.stacks_and_queues;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Castle {

  static class Node {
    public int row;
    public int column;
    //boarders inclusive
    public int[][] neighbours;

    public Node(int row, int column, int[][] neighbours) {
      this.row = row;
      this.column = column;
      this.neighbours = neighbours;
    }
  }

  static int minimumMoves(String[] input, int startX, int startY, int goalX, int goalY) {
    boolean[][] grid = new boolean[input.length][input[0].length()];
    for (int row = 0; row < input.length; row++) {
      for (int column = 0; column < input[row].length(); column++) {
        char[] chars = input[row].toCharArray();
        grid[row][column] = chars[column] == '.';
      }
    }
    Node[][] nodes = new Node[input.length][input[0].length()];
    fillTheNodes(nodes, grid);
    return bfs(nodes, startX, startY, goalX, goalY);
  }

  static int bfs(Node[][] nodes, int startX, int startY, int goalX, int goalY) {
    if (startX == goalX && startY == goalY) {
      return 0;
    }
    boolean[][] visited = new boolean[nodes.length][nodes[0].length];
    int level = 1;
    visited[startX][startY] = true;
    ArrayList<int[]> nodesOnCurrentLevel = new ArrayList<>();
    for (int[] node: nodes[startX][startY].neighbours){
      nodesOnCurrentLevel.add(node);
    }
    ArrayList<int[]> tmp = new ArrayList<>();
    while (!nodesOnCurrentLevel.isEmpty()) {
      tmp.clear();
      for (int[] index: nodesOnCurrentLevel) {
        visited[index[0]][index[1]] = true;
        for (int[] child: nodes[index[0]][index[1]].neighbours) {
          if (child[0] == goalX && child[1] == goalY) {
            return level+1;
          }
          if (!visited[child[0]][child[1]]) {
            tmp.add(child);
          }
        }
      }
      nodesOnCurrentLevel.clear();
      nodesOnCurrentLevel.addAll(tmp);
      level++;
    }
    return level;
  }


  static void fillTheNodes(Node[][] nodes, boolean[][] grid) {
    int r,l,up,down, pointer;
    for (int row = 0; row < nodes.length; row++) {
      for (int column = 0; column < nodes[row].length; column++) {
        if (!grid[row][column]) {
          continue;
        }
       //check to the right
        r = column+1;
        while (r < nodes[row].length && grid[row][r]) {
          r++;
        }
        //check the left
        l = column-1;
        while (l >= 0 && grid[row][l]) {
          l--;
        }
        //check up
        up = row-1;
        while (up >= 0 && grid[up][column]) {
          up--;
        }
        //check down
        down = row+1;
        while (down < nodes.length && grid[down][column]) {
          down++;
        }
        int[][] neighbours = new int[r-l + down - up-4][2];
        pointer = 0;
        for (int i =l+1; i <= r-1; i++) {
          if (i != column) {
            int[] tmp = {row, i};
            neighbours[pointer] = tmp;
            pointer++;
          }
        }
        for (int i = up+1; i <= down-1; i++) {
          if (i != row) {
            int[] tmp = {i, column};
            neighbours[pointer] = tmp;
            pointer++;
          }
        }
        nodes[row][column] = new Node(row, column, neighbours);
      }
    }
  }

  @Test
  void run() {
    String[] in1= {
        ".X.",
        ".X.",
        "..."
    };
    System.out.println("Answer: " +minimumMoves(in1, 0,0,0,2));
  }


  @Test
  public void main() throws IOException {
    final Scanner
        scanner = new Scanner(new File(this.getClass().getClassLoader().getResource("case_castle.txt").getPath()));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] grid = new String[n];

    for (int i = 0; i < n; i++) {
      String gridItem = scanner.nextLine();
      grid[i] = gridItem;
    }

    String[] startXStartY = scanner.nextLine().split(" ");

    int startX = Integer.parseInt(startXStartY[0]);

    int startY = Integer.parseInt(startXStartY[1]);

    int goalX = Integer.parseInt(startXStartY[2]);

    int goalY = Integer.parseInt(startXStartY[3]);

    int result = minimumMoves(grid, startX, startY, goalX, goalY);

    System.out.println(String.valueOf(result));

    scanner.close();
  }
}
