package interviewbit.lvl8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class CommutableIslands {

  public static class Graph {
    public Node[] nodes;

    public static class Node {
      public final int i;
      public List<Edge> edges = new LinkedList<>();

      public Node(Integer i) {
        this.i = i;
      }
    }

    public static class Edge {
      public final int out;
      public final int cost;

      public Edge(int out, int cost) {
        this.out = out;
        this.cost = cost;
      }

      public String toString() {
        return "->" + out + " : " + cost;
      }
    }

    public Graph(int A, int[][] B) {
      this.nodes = new Node[A + 1];
      for (int i = 1; i < A + 1; i++) {
        this.nodes[i] = new Node(i);
      }
      for (int[] edgeData : B) {
        this.addConnection(edgeData[0], edgeData[1], edgeData[2]);
      }
    }

    public void addConnection(Integer i, Integer j, Integer cost) {
      nodes[i].edges.add(new Edge(j, cost));
      nodes[j].edges.add(new Edge(i, cost));
    }
  }

  public int solve(int A, int[][] B) {
    Graph graph = new Graph(A, B);
    int[] minimumWeights = new int[A + 1];
    for (int i = 1; i < A + 1; i++) {
      minimumWeights[i] = -1;
    }
    Queue<Graph.Edge> toVisit = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

    toVisit.addAll(graph.nodes[1].edges);
    minimumWeights[1] = 0;

    while (!toVisit.isEmpty()) {
      Graph.Edge edge = toVisit.poll();
      if (minimumWeights[edge.out] == -1) {
        minimumWeights[edge.out] = edge.cost;
        for (Graph.Edge adj : graph.nodes[edge.out].edges) {
          if (minimumWeights[adj.out] == -1) {
            toVisit.add(adj);
          }
        }
      }
    }

    int totalCost = 0;
    for (int cost : minimumWeights) {
      totalCost += cost;
    }
    return totalCost;
  }

  @Test
  public void run() {
    int[][] input1 = {
        {1, 2, 1},
        {2, 3, 4},
        {1, 4, 3},
        {4, 3, 2},
        {1, 3, 10}
    };

    System.out.println(solve(4, input1));
  }
}
