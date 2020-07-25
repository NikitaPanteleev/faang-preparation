package google1.interviewbit.lvl8;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CloneGraph {
  class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  }

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Stack<UndirectedGraphNode> toVisit = new Stack<>();

    toVisit.add(node);
    nodes.put(node.label, new UndirectedGraphNode(node.label));

    while (!toVisit.isEmpty()) {
      UndirectedGraphNode current = toVisit.pop();
      UndirectedGraphNode copy = nodes.get(current.label);
      visited.add(current.label);
      for (UndirectedGraphNode neighbour : current.neighbors) {
        if (!visited.contains(neighbour.label)){
          if (!nodes.containsKey(neighbour.label)) {
            nodes.put(neighbour.label, new UndirectedGraphNode(neighbour.label));
          }
          copy.neighbors.add(nodes.get(neighbour.label));
          nodes.get(neighbour.label).neighbors.add(copy);
          toVisit.add(neighbour);
        }
        if (neighbour.label == current.label && !copy.neighbors.contains(copy)) {
          copy.neighbors.add(copy);
        }
      }
    }
    return nodes.get(node.label);
  }

  @Test
  public void run() {
    System.out.println("Hello");
  }
}
