package google1.interviewbit;

import common.Graph;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

@Slf4j
public class BfsTest {


  @Test
  public void run(){
    val graph = new Graph();
    graph.addConnection(1, 2);
    graph.addConnection(1, 3);
    graph.print();
  }
}
