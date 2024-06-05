/*
 * Find the max difference in an array so that larger element has higher index than smaller index
 *   (A[j] - A[i] = max); j>i
 *   Input: [3,1,4,7,5,100,10] 
 * 
 *   Output: 99
 * 
 */


public class Max_diff_in_array {
  public static void main(String[] args) {
    int arr[] = {3,1,4,7,5,100,10};
    
    int res = Solution2(arr, arr.length);

    System.out.print("Max diff element: "+res);
  }


  /* 
    Solution 1: Brute force aproach
    - Use nested for loops, 1st for loop runs from i=0 to n-1 and 2nd one from j=i+1 to n
    - get the diff a[j]-a[i], while checking for max diff in each iteration

    Time: O(n^2), Space: O(1)
  */ 



  /*
   * Solution 2: Using the left min value
   * - make leftMin as 1st element
   * - Use single loop, i=1 to n, 
   * - for each element, check the diff: a[i] - leftMin, and then store diff in maxDiff
   * - if (a[i] < leftMin), then make leftMin = a[i] 
   * - after the complete loop, maxDiff will have correct value
   */
  public static int Solution2(int arr[], int n){
    int leftMin = arr[0];
    int maxDiff = 0;

    for(int i=1; i<n; i++){
      int diff = arr[i] - leftMin;
      if(diff > maxDiff){
        maxDiff = diff;
      }
      if(arr[i] < leftMin){
        leftMin = arr[i];
      }
    }
    return maxDiff;
  }
}
