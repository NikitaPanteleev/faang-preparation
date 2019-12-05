package hackerrank.preparationkit.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Matrix {
  public static class Edge {
    public final int from;
    public final int to;
    public final int len;

    public Edge(int i, int j, int len) {
      this.from = i;
      this.to = j;
      this.len = len;
    }

    @Override
    public String toString() {
      return "->" + to + "(" + len + ')';
    }
  }

  static int minTime(int[][] roads, int[] machinesIndices) {
    Edge[] edges = new Edge[roads.length];
    HashMap<Integer, Integer> unionFind = new HashMap<>();
    for (int i = 0; i < roads.length; i++) {
      unionFind.put(roads[i][0], roads[i][0]);
      unionFind.put(roads[i][1],roads[i][1]);
      edges[i] = new Edge(roads[i][0], roads[i][1], roads[i][2]);
    }
    Arrays.sort(edges, (e1, e2) -> Integer.compare(e2.len, e1.len));
    Set<Integer> machines = new HashSet<>();
    for (int i : machinesIndices) {
      machines.add(i);
    }
    for (Edge city : edges) {
      unionFind.put(city.from, city.from);
      unionFind.put(city.to, city.to);
    }
    for (int machine: machinesIndices) {
      unionFind.put(machine, machine);
    }
    int removedEdges = 0;
    for (Edge edge : edges) {
      int root1 = find(unionFind, edge.from);
      int root2 = find(unionFind, edge.to);
      if (root1 == root2) {
        return -1;
      } else {
        if (machines.contains(root1) && machines.contains(root2)) {
          removedEdges += edge.len;
        } else {
          union(unionFind, machines, root1, root2);
        }
      }
    }
    return removedEdges;
  }

  static void union(HashMap<Integer, Integer> unionFind, Set<Integer> machines, int i, int j) {
    if (machines.contains(i)) {
      unionFind.put(j, i);
    } else {
      unionFind.put(i, j);
    }
  }

  static int find(HashMap<Integer, Integer> unionFind, int i) {
    int root = i;
    while (root != unionFind.get(root)) {
      root = unionFind.get(root);
    }

    int tmp = i;
    while (root != unionFind.get(tmp)) {
      int oldRoot = unionFind.get(tmp);
      unionFind.put(tmp, root);
      tmp = oldRoot;
    }
    return root;
  }

  @Test
  void run() {
    int[][] in = {
        {2, 1, 8},
        {1, 0, 5},
        {2, 4, 5},
        {1, 3, 4}
    };
    int[] machines = {2, 4, 0};

    int[][] in2 = {
        {4, 6, 4},
        {6, 5, 4},
        {6, 1, 9},
        {5, 2, 5},
        {6, 7, 4},
        {1, 8, 3},
        {6, 0, 9},
        {8, 9, 10},
        {5, 3, 7}
    };
    int[] machines2 = {1, 2, 4, 9, 0, 7, 5, 3, 6, 8};
    //answer 55

    int[][] in3 ={
      {0, 3, 3},
      {1, 4, 4},
      {1, 3, 4},
      {0, 2, 5},
    } ;
    int[] machines3 = {1,3,4};
    System.out.println("Answer:  " + minTime(in4, machines4));
    //in4 -> 610
  }

  public static int[] machines4 = {
      1,
      95,
      90,
      11,
      48,
      49,
      23,
      6,
      0,
      76,
      3,
      83,
      85,
      31,
      44,
      54,
      87,
      38,
      16,
      61,
      22,
      21,
      29
  };

  public static int[][] in4 = {
      {9,78,35},
      {9,54,45},
      {78,69,27},
      {9,55,9},
      {9,1,78},
      {1,92,7},
      {55,42,57},
      {1,84,4},
      {1,5,38},
      {92,8,75},
      {55,30,99},
      {69,7,9},
      {1,81,45},
      {8,31,4},
      {42,23,100},
      {78,95,3},
      {54,14,14},
      {84,53,80},
      {92,32,8},
      {42,86,40},
      {1,64,93},
      {78,60,65},
      {64,76,24},
      {42,89,86},
      {7,28,48},
      {69,62,26},
      {1,40,23},
      {78,38,29},
      {8,44,39},
      {78,3,37},
      {54,26,17},
      {62,50,24},
      {76,66,37},
      {30,51,75},
      {86,43,91},
      {5,77,32},
      {64,91,11},
      {14,10,36},
      {26,20,19},
      {9,52,50},
      {77,94,32},
      {44,67,63},
      {64,15,61},
      {92,0,73},
      {10,37,23},
      {89,2,37},
      {92,18,51},
      {26,47,25},
      {30,87,15},
      {47,36,35},
      {92,72,16},
      {28,75,93},
      {78,73,66},
      {20,19,64},
      {73,57,1},
      {91,6,50},
      {54,33,41},
      {78,11,38},
      {37,71,55},
      {5,63,52},
      {10,46,22},
      {94,82,19},
      {95,83,51},
      {57,90,10},
      {63,58,94},
      {43,45,23},
      {72,68,62},
      {82,85,88},
      {58,4,94},
      {82,41,62},
      {3,22,68},
      {54,70,78},
      {31,74,27},
      {36,29,61},
      {33,24,76},
      {40,35,61},
      {83,79,51},
      {8,59,20},
      {45,34,26},
      {38,12,18},
      {70,99,25},
      {40,80,81},
      {31,97,58},
      {69,21,16},
      {83,13,22},
      {80,48,49},
      {97,65,44},
      {74,17,1},
      {68,16,92},
      {50,98,54},
      {94,27,76},
      {81,61,67},
      {85,49,96},
      {81,93,31},
      {22,25,67},
      {57,96,93},
      {82,88,92},
      {86,56,80},
      {25,39,44}
  };
}
