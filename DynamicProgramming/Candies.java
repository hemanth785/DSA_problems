package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/candies
 * 
 * solution link: https://www.youtube.com/watch?v=gib-yC5NmuM
 */
public class Candies {
  public static void main(String args[]){
    Integer arr[] = new Integer[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
    List<Integer> list = Arrays.asList(arr);

    long candyCount = candies(list.size(), list);
    System.out.println("Min candies required: "+ candyCount);
  }
  
  public static long candies(int n, List<Integer> arr) {
    int candies[] = new int[n];
    
    //initially assume everyone gets one candy
    Arrays.fill(candies, 1);
    
    //move from left to right, checking for higher score condition
    for(int i=1; i<n; i++){
        if(arr.get(i) > arr.get(i-1)){
            candies[i] = candies[i-1] + 1;
        }
    }
    
    //move from right to left, checking for higher score condition
    for(int i=n-2; i>=0; i--){
        System.out.println("i: "+i+", candies:"+candies[i]);
        if(arr.get(i) > arr.get(i+1) && candies[i] <= candies[i+1]){
            candies[i] = candies[i+1] + 1;
        }
    }
    
    //count the candies
    long candyCount = 0;
    for(int i=0; i<n; i++){
        candyCount += candies[i];
    }
    
    return candyCount;
  }
}


