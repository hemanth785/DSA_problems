package DynamicProgramming;
/*
 * Link: https://workat.tech/problem-solving/practice/max-product-subarray/
 * 
 * solution link: https://www.youtube.com/watch?v=hnswaLJvr6g
 */
public class A_18_MaxProductSubarray {
  /*
   * Naive/Bruteforce approach - O(n^2)
   * 
   * - Use 2 nested loops to find out the product of each possible subarray.
   */

  /*
   * Optimal approach - O(n)
   * 
   * OBSERVATION---
   * The optimal approach is based on the below observation
   * - If all elements in array in positive, then result will be product of whole array
   * - If array contains even number of elements, then also result will be product of whole array
   * - If array contains One negative element, the result will be product of prefix or suffix array to that negative element
   * - if array contains odd number of negative elements, 
   *      then result will be product of suffix or prefix array of the, negative element on either side/end of array
   * - If array contains '0', the result will be product of prefix or suffix array to that 0 (basically wherever that 0 exists, it just devides the array)
   * 
   * APPROACH---
   * Based on above observation, we can find the max prod subarray using the below approach
   * - First find the maximum individual element in the array, and initalize it as result
   * - then iterate given array from left side (prefix Product) while calculating product and comparing it with result at each step
   *     - If we found '0' in the middle, re-initialize prefixProduct to 'zero'.
   * - then iterate given array from right side (suffix Product) while calculating product and comparing it with result at each step
   *     - If we found '0' in the middle, re-initialize prefixProduct to 'zero'.
   * - Now after 3 step, we'll have the result
   */
  public int maxProduct(int[] A) {
    int n = A.length;

    int result = Integer.MIN_VALUE;
    //1. initialize result with max individual element in array
    for (int i = 0; i < n; i++) {
      result = Math.max(result, A[i]);
    }
    int prefixProd = 1;
    int suffixProd = 1;

    // 2. check for max product from left side of array
    for (int i = 0; i < n; i++) {
      int cur = A[i];

      //ignore 0 and initialize prod 1, wherever 0 found
      if (cur == 0) {
        prefixProd = 1;
        continue;
      }

      prefixProd = prefixProd * cur;
      result = Math.max(result, prefixProd);
    }

    // 3. check for max product from right side of array
    for (int i = n - 1; i >= 0; i--) {
      int cur = A[i];

      //ignore 0 and initialize prod 1, wherever 0 found
      if (cur == 0) {
        suffixProd = 1;
        continue;
      }

      suffixProd = suffixProd * cur;
      result = Math.max(result, suffixProd);
    }

    return result;
  }
}
