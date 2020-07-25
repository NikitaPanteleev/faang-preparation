package google1.preparationkit.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

public class LibrariesAndRoads {
  static class Node {
    ArrayList<Integer> neighbours = new ArrayList<>();
  }

  static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
    if (c_lib <= c_road) {
      return n * c_lib;
    }
    boolean[] visited = new boolean[n];
    Node[] nodes = new Node[n];
    for (int i =0; i < n; i++) {
      nodes[i] = new Node();
    }

    for (int[] city: cities) {
      nodes[city[0]-1].neighbours.add(city[1]-1);
      nodes[city[1]-1].neighbours.add(city[0]-1);
    }
    long answer = 0l;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        answer+= buildComponent(visited, nodes, i, c_lib, c_road);
      }
    }

    return answer;
  }

  static long buildComponent(boolean[] visited, Node[] nodes, int i, long c_lib, long c_road) {
    long counter = c_lib;
    Stack<Integer> neigbours = new Stack<>();
    neigbours.add(i);
    visited[i] = true;

    while (!neigbours.isEmpty()) {
      int current = neigbours.pop();
      for (int j: nodes[current].neighbours) {
        if (!visited[j]) {
          visited[j] = true;
          counter+=c_road;
          neigbours.add(j);
        }
      }
    }
    return counter;
  }

  @Test
  void run() {

  }
}
