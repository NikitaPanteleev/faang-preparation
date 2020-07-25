package google1.interviewbit.greedy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Candies {
  public long candy(ArrayList<Integer> A) {
    int n=A.size();
    int[] candies=new int[n];
    Arrays.fill(candies,1);
    for(int i=0;i<n-1;i++){
      if(A.get(i+1)>A.get(i))
        candies[i+1]=candies[i]+1;
    }
    for(int i=n-1;i>0;i--){
      if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
        candies[i-1]=candies[i]+1;
    }
    int sum=0;
    for(int i=0;i<n;i++){
      sum+=candies[i];
    }
    return sum;
  }


  @Test
  public void run(){
    List<Integer> input = Arrays.asList(2, 4, 2, 6, 1, 7, 8, 9, 2, 1);
    System.out.println("Answer: " + candy(new ArrayList<>(input)));

  }
}
