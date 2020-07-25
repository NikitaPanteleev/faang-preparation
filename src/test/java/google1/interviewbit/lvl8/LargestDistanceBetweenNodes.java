package google1.interviewbit.lvl8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;


@Slf4j
public class LargestDistanceBetweenNodes {
  public static class Graph {
    Node[] nodes;

    public static class Node {
      public Set<Integer> neighours = new HashSet<>();
    }

    public Graph(int[] input) {
      this.nodes = new Node[input.length];
      for (int i = 0; i < input.length; i++) {
        nodes[i] = new Node();
      }
      for (int i = 0; i < input.length; i++) {
        if (input[i] != -1) {
          nodes[i].neighours.add(input[i]);
          nodes[input[i]].neighours.add(i);
        }
      }
    }
  }

  public int solve(int[] A) {
    if (A.length <= 1) {
      return 0;
    }
    Graph graph = new Graph(A);
    int[] firstResult = longestPath(graph, 0);
    int[] secondResult = longestPath(graph, firstResult[0]);
    return secondResult[1];
  }

  //returns j node and len
  public int[] longestPath(Graph graph, int node) {
    boolean[] visited = new boolean[graph.nodes.length];
    int max = 1;
    Set<Integer> toVisit = new HashSet<>(graph.nodes[node].neighours);
    visited[node] = true;
    Set<Integer> tmp = new HashSet<>();
    while (true){
      tmp.clear();
      for (Integer elem: toVisit){
        visited[elem] = true;
        for (Integer neighbour: graph.nodes[elem].neighours){
          if (!visited[neighbour]){
            tmp.add(neighbour);
          }
        }
      }
      if (tmp.isEmpty()) {
        int[] result = {toVisit.iterator().next(), max};
        return result;
      } else {
        max+=1;
        toVisit.clear();
        toVisit.addAll(tmp);
        tmp.clear();
      }
    }
  }

  @Test
  public void run() {
    int[] input = {-1, 0, 0, 1, 2, 1, 5};
    System.out.println(solve(input));
  }
}
