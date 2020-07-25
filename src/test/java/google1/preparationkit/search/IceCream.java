package google1.preparationkit.search;

import java.util.HashMap;

//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
public class IceCream {
  // Complete the whatFlavors function below.
  static void whatFlavors(int[] cost, int money) {
    HashMap<Integer, Integer> remaining = new HashMap<>();
    for (int i =0; i< cost.length; i++) {
      if (remaining.containsKey(cost[i])) {
        System.out.println((remaining.get(cost[i])+1) + " " + (i+1));
        return;
      } else {
        remaining.put(money-cost[i], i);
      }
    }
  }
}
