package Array_advanced;
import java.util.*;

/*
 * Problem:
 * Pascal’s triangle is a triangular array of binomial coefficients. Write a function that takes an integer value n as input and prints nth line of Pascal’s triangle. 
 * for input n=6,
 * output is as follows
 * [1 5 10 10 5 1 ]
 * 
 * Note: Pascals triagle looks like this
 *       1  
 *      1 1 
 *     1 2 1 
 *    1 3 3 1 
 *   1 4 6 4 1 
 * 1 5 10 10 5 1 
 */
public class A08_Pascals_triangle {
  public static void main(String[] args) {
    int n = 7;
    List<Integer> nthPascalRow = Solution1(n);

    System.out.print(n+"th Pascals row: "+ nthPascalRow);
  }


  /*
   * Solution 1: Bruteforce
   * Start crate each row in pascals triagle,  from top to nth row
   * 
   * Time: O(n^2)
   */
  public static List<Integer> Solution1(int n) {
    List<Integer> prevRow = new ArrayList<Integer>();

    prevRow.add(1);
    if(n == 1){
      return prevRow;
    }
    
    for(int i=2; i<=n; i++){
      List<Integer> curRow = new ArrayList<Integer>();
      curRow.add(1);

      for(int j=1; j<i-1; j++){
        curRow.add(prevRow.get(j-1) + prevRow.get(j));
      }

      curRow.add(1);
      System.out.println("row: "+prevRow);
      prevRow = curRow;
      
    }

    return prevRow;
  }
}

