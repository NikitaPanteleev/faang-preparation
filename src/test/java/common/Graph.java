package common;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class Graph {
  public HashMap<Integer, Node> nodes = new HashMap<>();

  public static class Node {
    private int i;
    public List<Node> adjacent = new LinkedList<>();
    public Node(Integer i) {
      this.i = i;
    }

    public String toString() {
      return i + "";
    }
  }

  public Graph() {

  }

  public void addConnection(Integer i, Integer j) {
    if (!nodes.containsKey(i)) {
      nodes.put(i, new Node(i));
    }
    if (!nodes.containsKey(j)) {
      nodes.put(j, new Node(j));
    }
    nodes.get(i).adjacent.add(nodes.get(j));
    nodes.get(j).adjacent.add(nodes.get(i));
  }

  public void print() {
    nodes.forEach((i, node) -> {
      log.info("{} -> {}", i, node.adjacent + "");
    });
  }
}
