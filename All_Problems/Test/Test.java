package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
    System.out.println();
  }

  public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    int n1 = a.size();
    int n2 = b.size();

    int maxScore = 0;
    int score1 = 0;
    int score2 = 0;
    int sum = 0;

    for(int i=0; i<n1; i++){
      if(sum + a.get(i) <= maxSum){
        sum += a.get(i);
        score1++;

      } else {
        break;
      }
    }

    maxScore = score1;

    for(int i=0; i<n2; i++){
      sum += b.get(i);
      
      while(score1 > 0 && sum > maxSum){
        sum -= a.get(--score1);
      }
      if(sum <= maxSum){
        score2++;
        maxScore = Math.max(maxScore, score1+score2);
      } else {
        break;
      }
    }
        
    return maxScore;
  }

}
