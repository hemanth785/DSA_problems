package Array_advanced;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 */
public class A05_ProductExceptSelf {
  /*
   * Appraoch: Using prefix and suffix prod arrays
   * - Create prefix prod array, which hold prod of elements upto previous element
   * - Create suffix prod array, which hold prod of elements upto next element (form right)
   * - now loop though each item and calculat product of (prefixProd[i] * suffixProd[i])
   */
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixProd = new int[n];
    int[] suffixProd = new int[n];

    int[] res = new int[n];

    Arrays.fill(prefixProd, 1);
    Arrays.fill(suffixProd, 1);

    int leftProd = 1;
    int rightProd = 1;
    for (int i = 1; i < n; i++) {
      prefixProd[i] = nums[i - 1] * leftProd;
      leftProd = prefixProd[i];
    }

    for (int i = n - 2; i >= 0; i--) {
      suffixProd[i] = nums[i + 1] * rightProd;
      rightProd = suffixProd[i];
    }

    for (int i = 0; i < n; i++) {
      res[i] = prefixProd[i] * suffixProd[i];
    }

    return res;
  }
}
