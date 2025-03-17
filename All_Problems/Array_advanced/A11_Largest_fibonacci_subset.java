package Array_advanced;

import java.util.ArrayList;

/*
 * Link: https://www.geeksforgeeks.org/problems/largest-fibonacci-subsequence2206/1
 */
public class A11_Largest_fibonacci_subset {
  /*
   * Solution 1: Using hashset
   * A simple solution is to use a Hash Set. Firstly traverse the array to find the max element in the array,
   *  Then generate all the Fibonacci numbers smaller than max element and store them in Hash Set.
   *  Now traverse the array and check if that element is there in the Hash set or not. 
   *  If Yes, put it in the result array.
   */

   /*
    * Solution 2: Using Mathematical Formulae – O(n log m) Time
    * A number n is a Fibonacci number if and only if one or both of the following conditions hold true:

    *      5 × (num^2) + 4 is a perfect square, or
    *      5 × (num^2) − 4 is a perfect square.
    *
    *     This property is derived from the fact that Fibonacci numbers have a specific relationship with certain quadratic forms. 
    *     It is based on number theory and is a very efficient way to check if a number belongs to the Fibonacci sequence 
    *     without having to generate the Fibonacci numbers.
    */

    // Function to check if a number is Fibonacci
    static boolean isFibonacci(int num) {
      
      // Using the property that a number is Fibonacci if and only if 
      // one of (5 * n^2 + 4) or (5 * n^2 - 4) is a perfect square.
      int fact1 = 5 * num * num + 4;
      int fact2 = 5 * num * num - 4;
      int sqrtFact1 = (int) Math.sqrt(fact1);
      int sqrtFact2 = (int) Math.sqrt(fact2);

      return (sqrtFact1 * sqrtFact1 == fact1 || sqrtFact2 * sqrtFact2 == fact2);
    }

    // Function to find the largest Fibonacci subset
    static public ArrayList<Integer> findFibSubset(int arr[]) {
      ArrayList<Integer> res = new ArrayList<>();

      // Iterate through all elements of the array
      for (int num : arr) {
          if (isFibonacci(num)) {
              res.add(num);
          }
      }
      return res;
    }
}
