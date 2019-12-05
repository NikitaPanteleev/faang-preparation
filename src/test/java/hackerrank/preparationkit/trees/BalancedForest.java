package hackerrank.preparationkit.trees;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BalancedForest {
  static class Node {
    long weight;
    ArrayList<Long> parentSums = new ArrayList<>();
    long currentSum;
    ArrayList<Integer> neighbours = new ArrayList<>();

    public Node(int weight) {
      this.weight = weight;
    }
  }

  static long balancedForest(int[] c, int[][] edges) {
    Node[] nodes = new Node[c.length];
    long sum = 0;
    for (int i = 0; i < c.length; i++) {
      nodes[i] = new Node(c[i]);
      sum += c[i];
    }
    for (int[] edge : edges) {
      nodes[edge[0] - 1].neighbours.add(edge[1] - 1);
      nodes[edge[1] - 1].neighbours.add(edge[0] - 1);
    }
    //sum of subtree, how many times found
    Map<Long, ArrayList<Integer>> partialSums = new HashMap<>();

    int root = 0;
    for (int child : nodes[root].neighbours) {
      dfs(root, child, nodes, partialSums);
    }
    for (int child : nodes[root].neighbours) {
      propagateParentWeights(root, child, nodes);
    }

    long minCut = -1;
    for (Map.Entry<Long, ArrayList<Integer>> partialSum : partialSums.entrySet()) {
      long currentSum = partialSum.getKey();
      if (partialSum.getValue().size() == 2) {
        long remaining = sum - 2 * currentSum;
        long toAdd = (currentSum - remaining);
        minCut = updateMinCut(minCut, toAdd);
      }

      if ((currentSum + sum) % 2 == 0 && partialSums.containsKey((currentSum + sum) / 2)) {
        //find the node and verify that parent sum contain (currentNode.currentSum + sum) / 2
        for (int nodeIndex: partialSum.getValue()) {
          if (nodes[nodeIndex].parentSums.contains((currentSum + sum) / 2)) {
            long toAdd = (sum - 3 * currentSum)/2;
            minCut = updateMinCut(minCut, toAdd);
          }
        }

      }
      if ((sum - currentSum) % 2 == 0) {
        long sumNotInParent =(sum - currentSum) / 2;
        if (partialSums.containsKey(sumNotInParent)) {
          for (int nodeIndex: partialSum.getValue()) {
            if (!nodes[nodeIndex].parentSums.contains(sumNotInParent)) {
              //verify that sumNotInParent not in parent for currentSum
              long toAdd = (sum - 3 * currentSum) /2;
              minCut = updateMinCut(minCut, toAdd);
            }
          }

        }
      }
      if (partialSums.containsKey(sum - currentSum)) {
        //verify that parentSums contains sum - currentSum
        for (int nodeIndex: partialSum.getValue()) {
          if (nodes[nodeIndex].parentSums.contains(sum - currentSum)) {
            long toAdd = 3 * currentSum - sum;
            minCut = updateMinCut(minCut, toAdd);
          }
        }
      }
    }

    if (sum % 2 == 0 && partialSums.containsKey(sum/2)) {
      return updateMinCut(minCut, sum/2);
    }

    return minCut;
  }

  static long updateMinCut(long minCut, long toAdd) {
    if (minCut == -1 && toAdd > 0) {
      return toAdd;
    } else if (toAdd > 0) {
      return Math.min(minCut, toAdd);
    }
    return minCut;
  }

  public static long dfs(int root, int current, Node[] nodes, Map<Long, ArrayList<Integer>> partialSums) {
    if (nodes[current].neighbours.size() == 1) {
      nodes[current].currentSum = nodes[current].weight;
      ArrayList<Integer> array = partialSums.getOrDefault(nodes[current].weight, new ArrayList<>());
      array.add(current);
      partialSums.put(nodes[current].weight, array);
      return nodes[current].weight;
    } else {
      long answer = nodes[current].weight;
      for (int child : nodes[current].neighbours) {
        if (child != root) {
          answer += dfs(current, child, nodes, partialSums);
        }
      }
      nodes[current].currentSum = answer;
      ArrayList<Integer> array = partialSums.getOrDefault(answer, new ArrayList<>());
      array.add(current);
      partialSums.put(answer,array );
      return answer;
    }
  }

  public static void propagateParentWeights(int root, int current, Node[] nodes) {
    for (int child : nodes[current].neighbours) {
      if (child != root) {
        nodes[child].parentSums.addAll(nodes[current].parentSums);
        nodes[child].parentSums.add(nodes[current].currentSum);
        propagateParentWeights(current, child, nodes);
      }
    }
  }

  @Test
  void run() {
    int[] w1 = {15, 12, 8, 14, 13};
    int[][] e1 = {
        {1, 2},
        {1, 3},
        {1, 4},
        {4, 5}
    };

    int[] w2 = {1, 2, 2, 1, 1};
    int[][] e2 = {
        {1, 2},
        {1, 3},
        {3, 5},
        {1, 4}
    };
    int[] w3 = {7, 7, 4, 1, 1, 1};
    int[][] e3 = {{1, 2},
        {3, 1},
        {2, 4},
        {2, 5},
        {2, 6}
    };
    int[] w4 = {1, 1, 1, 18, 10, 11, 5, 6};
    int[][] e4 = {
        {1, 2},
        {1, 4},
        {2, 3},
        {1, 8},
        {8, 7},
        {7, 6},
        {5, 7}
    };

    int[] w5 = {10,4,1,5,6,4,5,5};
    int[][] e5 = {
        {1,2},
        {2,3},
        {1,4},
        {5,4},
        {5,6},
        {7,8},
        {7,5}
    };
    int[] w6 = {100,100,99,99,98,98};
    int[][] e6 = {
        {1,3},
        {3 ,5},
        {1 ,2},
        {2 ,4},
        {4 ,6}
    };

    int[] w7 = {12,7,11, 17, 20, 10};
    int[][]e7 = {
        {1, 2},
        {2 ,3},
        {4 ,5},
        {6 ,5},
        {1,4}
    };
    System.out.println("Answer: " + balancedForest(w3, e3));
    assert balancedForest(w1, e1) == 19;
    assert balancedForest(w3, e3) == -1;
    assert balancedForest(w4, e4) == 10;
    assert balancedForest(w5, e5) == 5;
    assert balancedForest(w6, e6) == 297;
    assert  balancedForest(w7, e7) == 13;
  }


  @Test
  public void main() throws IOException {
    final Scanner scanner = new Scanner(new File(this.getClass().getClassLoader().getResource("case6.txt").getPath()));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] c = new int[n];

      String[] cItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int cItem = Integer.parseInt(cItems[i]);
        c[i] = cItem;
      }

      int[][] edges = new int[n - 1][2];

      for (int i = 0; i < n - 1; i++) {
        String[] edgesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int edgesItem = Integer.parseInt(edgesRowItems[j]);
          edges[i][j] = edgesItem;
        }
      }

      long result = balancedForest(c, edges);
      System.out.println(String.valueOf(result));
    }
    scanner.close();
  }
  /**
   * 1714
   * 5016
   * 759000000000
   * -1
   * 6
   */
}
