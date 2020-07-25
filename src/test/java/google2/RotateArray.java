package google2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      rotateOnce(nums);
    }
  }

  public void rotateOnce(int[] nums) {
    int last = nums[nums.length - 1];
    for (int i = nums.length-1; i >=1; i--) {
      nums[i] = nums[i-1];
    }
    nums[0] = last;
  }

  @Test
  public void run() {
    int[] in = {1,2,3,4,5,6,7};
    rotate(in, 3);
    System.out.println(Arrays.toString(in));
  }
}
