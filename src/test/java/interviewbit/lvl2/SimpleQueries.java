package interviewbit.lvl2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SimpleQueries {
  public static final int M = 1000000007;

  public static class Data {
    public final int product;
    public final int position;

    public Data(int product, int position) {
      this.product = product;
      this.position = position;
    }

    public long occurences(int N) {
      if (this.position == 0) {
        return 1;
      } else if (this.position == N-1) {
        return (int) Math.pow(2, N-1) - 1;
      } else {
        return (int) Math.pow(2, this.position);
      }
    }
  }

  // function to product the factors
  static int multiplyFactors(int n) {
    int prod = 1;
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {

        // If factors are equal,
        // multiply only once
        if (n / i == i) { prod = (prod * i) % M; }

        // Otherwise multiply both
        else {
          prod = (prod * i) % M;
          prod = (prod * n / i) % M;
        }
      }
    }
    return prod;
  }

  public int base( Data[] products, int n) {
    int rem = n;
    for (Data data: products) {
      if (rem <= data.occurences(products.length)) {
        return data.product;
      } else {
        rem-=data.occurences(products.length);
      }
    }
    return 0;
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    Integer[] numbers = A.toArray(new Integer[A.size()]);
    Arrays.sort(numbers);
    Data[] products = new Data[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      products[i] = new Data(multiplyFactors(numbers[i]), i);
    }
    Arrays.sort(products, (Data o1, Data o2) -> {
      long result = o1.product - o2.product;
      if (result == 0) {
        return 0;
      } else if (result > 0) {
        return -1;
      } else {
        return 1;
      }
    });
    ArrayList<Integer> result = new ArrayList<>();
    for (int position: B) {
      result.add(base(products, position));
    }
    return result;
  }

  @Test
  public void run() {
    System.out.println("Hello: " + solve(
        new ArrayList(Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45)),
        new ArrayList(Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838))));
  }
}
