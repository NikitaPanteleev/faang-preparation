package hackerrank.preparationkit.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
public class BFS {
  static class Node {
    ArrayList<Integer> neighboours = new ArrayList<>();
  }

  public static int[] bfs(Node[] nodes, int s) {
    int[] distances = new int[nodes.length];
    for (int i = 0; i < nodes.length; i++) {
      distances[i] = -1;
    }
    distances[s] = 0;
    int iteration = 1;
    ArrayList<Integer> neighbours = nodes[s].neighboours;
    ArrayList<Integer> tmp = new ArrayList<>();

    while(!neighbours.isEmpty()) {
      tmp.clear();
      for (int node: neighbours) {
        if (distances[node] == -1) {
          distances[node] = iteration * 6;
          tmp.addAll(nodes[node].neighboours);
        }
      }
      neighbours.clear();
      neighbours.addAll(tmp);
      iteration++;
    }
    return distances;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numQueries = scan.nextInt();

    for (int q = 0; q < numQueries; q++) {
      int numNodes = scan.nextInt();
      int numEdges = scan.nextInt();

      /* Create Nodes */
      Node[] nodes = new Node[numNodes + 1]; // nodes "i" will be at index "i"
      nodes[0] = null;
      for (int i = 1; i <= numNodes; i++) {
        nodes[i] = new Node();
      }

      /* Connect Nodes */
      for (int i = 0; i < numEdges; i++) {
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        nodes[n1].neighboours.add(n2);
        nodes[n2].neighboours.add(n1);
      }

      /* Create MST */
      int start = scan.nextInt();
      int[] result = bfs(nodes, start);

      /* Print results */
      for (int i = 0; i < result.length; i++) {
        if (i != start && i != 0) {
          System.out.print(result[i] + " ");
        }
      }
      System.out.println();
    }
    scan.close();
  }
}
