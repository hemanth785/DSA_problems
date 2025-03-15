/*
 * This problem is also referred as dutch national flag
 * i.e. sort the array having number 0,1 and 2
 * 
 * link: https://leetcode.com/problems/sort-colors/
 */

public class A02_Separate_0_1_and_2 {

  /*
   * Aproach 1: Using count of items
   *  - we can solve it easily by finding the count of 0's 1's and 2's
   *  - Override the given array with 0's 1's and 2's based on the count
   */

  /*
   * Approach 2: 3 pointers
   * 1. Maintain three pointers, low=0, mid=0 and high=n-1
   * 2. run a while loop with condition (mid <= high)
   * 3. Check for 3 conditions inside loop
   *   a. if(arr[mid] == 0), swap mid with low item and increement both low and mid
   *   b. if(arr[mid] == 1), just increment mid
   *   c. if(arr[mid] == 2), swap mid with high item and decrement count of high
   *
   *   (NOTE: In 'c.' -> here we are not increment mid because, whatever the value swapped with high,
   *          we are not sure whether it is 0 or 1, so we need to check it in next iteration before moving it.)
   * 
   *  Time: O(n), Space: O(1)
   */

  void sortTheArray(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      //Case 1: swap with low item and increment both low and mid
      if (nums[mid] == 0) {
        swap(nums, low, mid);
        low++;
        mid++;
      }
      //Case 2: just increment mid
      else if (nums[mid] == 1) {
        mid++;
      }
      //Case 3: if midItem == 2, then swap with high item and just decrement high.
      else {
        swap(nums, mid, high);
        high--;
      }
    }
  }

  public void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
