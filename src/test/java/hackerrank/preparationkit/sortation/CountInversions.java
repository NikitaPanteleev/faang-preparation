package hackerrank.preparationkit.sortation;

import org.junit.jupiter.api.Test;

public class CountInversions {
  static long countInversions(int[] arr) {
    int[] tmp = new int[arr.length];

    return mergeSort(arr, tmp, 0, arr.length-1, 0);
  }

  static long mergeSort(int[] arr, int[] tmp, int start, int end, long counter) {
    if (start >= end) {
      return counter;
    }
    int middle = (start + end) / 2;
    long c1= mergeSort(arr, tmp, start, middle, counter);
    long c2= mergeSort(arr, tmp, middle+1, end, counter);
    long c3= merge(arr, tmp, start, middle, end);
    return c1+c2+c3;
  }

  static long merge(int[] arr, int[] tmp, int start, int middle, int end) {
    int leftPointer = start;
    int rightPointer=middle+1;
    int index = start;
    long counter = 0;
    while (leftPointer <= middle && rightPointer <= end) {
      if (arr[leftPointer] <= arr[rightPointer]) {
        tmp[index] = arr[leftPointer];
        leftPointer++;
      } else {
        tmp[index] = arr[rightPointer];
        counter+=middle-leftPointer+1;
        rightPointer++;
      }
      index++;
    }
    System.arraycopy(arr, leftPointer, tmp, index,middle - leftPointer+1);
    System.arraycopy(arr, rightPointer, tmp, index, end - rightPointer+1);
    System.arraycopy(tmp, start, arr, start, end-start+1);
    return counter;
  }

  @Test
  void run() {
    int[] input = { 2, 4, 1}; //2
    int[] input2 = {1,1,1,2,2}; //0
    int[] input3 = {2,1,3,1,2}; //4
    System.out.println("Answer: " + countInversions(input));
    System.out.println("Answer: " + countInversions(input2));
    System.out.println("Answer: " + countInversions(input3));
  }
}
