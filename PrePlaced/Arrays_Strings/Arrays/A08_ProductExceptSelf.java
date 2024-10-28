package PrePlaced.Arrays_Strings.Arrays;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 */
public class A08_ProductExceptSelf {
  /*
   * Appraoch: Using prefix and suffix prod arrays
   * - Create prefix prod array, which hold prod of elements upto previous element
   * - Create suffix prod array, which hold prod of elements upto next element (form right)
   * - now loop though each item and calculat product of (prefixProd[i] * suffixProd[i])
   * 
   * Time: O(n),   Space: O(n)
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


  /*
   * Appraoch: (Space-Efficient than above) Storing prefix and suffix prod in input and output arrays (Approach is same as above)
   * - Since output array is not considered for extra space, we can use that to store prefix and suffix prod
   * - Iterate through start of array once to store prefix prod in output array
   * - Iterate through end of array while calaculating and storign result in output array, while storing postfix prod in input array
   * 
   * Time: O(n),   Space: O(1)
   */
  public int[] productExceptSelfEfficient(int[] nums) {
    int n = nums.length;
    int output[] = new int[n];
    Arrays.fill(output, 1);

    //Store the prefix product in output array
    for(int i=1; i<n; i++){
      output[i] = nums[i-1] * output[i-1];
    }

    //Store the postfix product in input array and store final ans in output array
    for(int i=n-2; i>=0; i--){
      output[i] = output[i] * nums[i+1];
      nums[i] = nums[i] * nums[i+1];
    }

    return output;
  }
}
