package google1.preparationkit.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Triplets {
  static long triplets(int[] a, int[] b, int[] c) {
    Set<Integer> aSet= new HashSet<Integer>();
    Set<Integer> bSet= new HashSet<Integer>();
    Set<Integer> cSet= new HashSet<Integer>();
    for (int elem: a) {
      aSet.add(elem);
    }
    for (int elem: b) {
      bSet.add(elem);
    }
    for (int elem: c) {
      cSet.add(elem);
    }
    ArrayList<Integer> aList = new ArrayList<>();
    ArrayList<Integer> bList = new ArrayList<>();
    ArrayList<Integer> cList = new ArrayList<>();
    aList.addAll(aSet);
    bList.addAll(bSet);
    cList.addAll(cSet);
    Collections.sort(aList);
    Collections.sort(bList);
    Collections.sort(cList);

    int elemsInA = aList.size();
    int elemsInC = cList.size();
    long answer = 0L;
    for (int i = bList.size()-1; i >=0; i--) {
      while(elemsInA > 0 && bList.get(i) < aList.get(elemsInA-1)) {
        elemsInA--;
      }
      while(elemsInC > 0 && bList.get(i) < cList.get(elemsInC-1)) {
        elemsInC--;
      }
      answer+= (long) elemsInA * (long)elemsInC;
    }
    return answer;
  }

}
