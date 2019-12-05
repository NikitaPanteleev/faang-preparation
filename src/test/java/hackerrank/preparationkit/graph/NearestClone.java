package hackerrank.preparationkit.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class NearestClone {
  // Complete the findShortest function below.
  static class Node {
    public int fromNode = -1;
    public int len = 0;
    public int label;
    ArrayList<Integer> edges = new ArrayList<>();

    public Node(int label) {
      this.label = label;
    }
  }

  static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
    Node[] nodes = new Node[graphNodes];
    for (int i = 0; i < graphNodes; i++) {
      nodes[i] = new Node(i);
    }
    for (int i = 0; i < graphFrom.length; i++) {
      nodes[graphFrom[i]-1].edges.add(graphTo[i]-1);
      nodes[graphTo[i]-1].edges.add(graphFrom[i]-1);
    }
    ArrayList<Integer> neighbours = new ArrayList<>();
    ArrayList<Integer> tmp = new ArrayList<>();
    for (int i = 0; i < ids.length; i++) {
      if (ids[i] == val) {
        neighbours.add(i);
        nodes[i].fromNode=i;
      }
    }

    while (!neighbours.isEmpty()){
      tmp.clear();
      for (int i: neighbours) {
        for (int neighbour: nodes[i].edges) {
          if (nodes[neighbour].fromNode != -1 && nodes[neighbour].fromNode != nodes[i].fromNode) {
            return nodes[i].len + nodes[neighbour].len + 1;
          } else if (nodes[neighbour].fromNode == nodes[i].fromNode) {
            //skip this node
          } else {
            nodes[neighbour].fromNode = nodes[i].fromNode;
            nodes[neighbour].len = nodes[i].len + 1;
            tmp.add(neighbour);
          }
        }
      }
      neighbours.clear();
      neighbours.addAll(tmp);
    }
    return -1;
  }

  @Test
  void run() {
    System.out.println("Answer: " + findShortest(In.ids.length, In.graphFrom, In.graphTo, In.ids, 1));
  }

  static class In {
    public static int[] graphFrom = {1,1,4};
    public static int[] graphTo = {2,3,2};
    public static long[] ids ={1,2,1,1};
  }
}
