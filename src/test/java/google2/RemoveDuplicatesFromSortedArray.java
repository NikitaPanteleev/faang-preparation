package google2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


@Slf4j
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int sortedIndex = 0;
    for(int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[sortedIndex]) {
        //doing nothing
      } else {
        nums[sortedIndex+1] = nums[i];
        sortedIndex++;
      }
    }
    return sortedIndex+1;
  }

  @Test
  public void run() {
    int[] input = {0,0,1,1,1,2,2,3,3,4};
    log.info(removeDuplicates(input) + "");
    log.info(Arrays.toString(input));
  }
}
