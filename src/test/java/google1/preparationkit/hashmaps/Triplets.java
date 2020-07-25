package google1.preparationkit.hashmaps;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Triplets {

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> lst, long r) {
    long answer = 0;
    Long[] array = new Long[lst.size()];
    array = lst.toArray(array);
    Map<Long, Long> singles = new HashMap<>();
    Map<Long, Long> doubles = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      Long elem = array[i];

      //count triples
      if (elem % r == 0) {
        if (doubles.containsKey(elem / r)) {
          answer+=doubles.get(elem/r);
        }
      }

      //save doubles
      if (elem % r == 0) {
        if (singles.containsKey(elem / r)) {
          increment(doubles, elem , singles.get(elem/r));
        }
      }
      increment(singles, elem, 1L);

    }

    return answer;
  }

  static void increment(Map<Long, Long> map, Long elem, Long inc) {
    if (map.containsKey(elem)) {
      map.put(elem, map.get(elem)+inc);
    } else {
      map.put(elem,inc);
    }
  }

  @Test
  void run() {
    List<Long> in = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
    List<Long> in2 = Arrays.asList(1L, 2L, 1L, 2L, 4L);
    List<Long> in3 = Arrays.asList(1L, 1L, 1L, 1L, 1L);
    System.out.println(countTriplets(in3, 1));
  }
}
