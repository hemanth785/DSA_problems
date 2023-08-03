package Array_advanced;

/*
 * Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * Input: arr[]   = {1, 0, 3, 2, 0, 4, 2}
 * Output: 7
 */

import java.util.Arrays;
public class Rainwater_tapping {
  public static void main(String[] args) {
    int arr[] = new int[]{3, 0, 3, 2, 0, 4, 2};
    // int res = waterTrapped1(arr);
    // int res = waterTrapped2(arr);
    int res = waterTrapped3(arr);

    System.out.print("rain water unit tapped:  "+ res);
  }


  /*
   * Solution 1: Brute force
   * 
   * - define watedTapped = 0 units
   * - for each element in array
   *   - find the max element in the left array to this element (leftMax)
   *   - find max element in the right array to this element (rightMax)
   *   - find minOfMax = min(leftMax, rightMax)
   *   - add watedTapped += minOfMax - currentElement
   * 
   * Here the leftMin value and rightMin value is calculating every time when we are looping over array, No extra space is used
   * So Time complexity: O(n^2), and Space: O(1), 
   */


  /*
   * Solution 2: Using leftMax and rightMax arry
   *  
   * Improvising 1st aproach, 
   * Pre calculate leftMax and rightMax array, thus using extra space
   * 
   * ex: for given input array [1, 0, 3, 2, 0, 4, 2]
   *              leftMaxArr = [1, 1, 3, 3, 3, 4, 4]
   *             rightMaxArr = [4, 4, 4, 4, 4, 4, 2]
   * 
   * Time O(n), Space: O(n)
   * */

   public static int waterTrapped2(int arr[]){
    int n = arr.length;
    int leftMaxArr[] = new int[n];
    int rightMaxArr[] = new int[n];

    leftMaxArr[0] = arr[0];
    rightMaxArr[n-1] = arr[n-1];

    for(int i=1; i<n; i++){
      leftMaxArr[i] = Math.max(leftMaxArr[i-1], arr[i]);
      rightMaxArr[n-i-1] = Math.max(rightMaxArr[n-i], arr[n-i-1]);
    }

    // System.out.println(Arrays.toString(leftMaxArr));
    // System.out.println(Arrays.toString(rightMaxArr));

    int rainWaterTapped = 0; 
    for(int i=0; i<n; i++){
      rainWaterTapped += ( Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i]);
    }

    return rainWaterTapped;

  }

  /*
   * Solution 3: Using two pointer approach
   *  
   * Optimizing fo space
   * 
   * Time O(n), Space: O(1)
   * */

  public static int waterTrapped3(int height[]){
    int n = height.length;
    int l=0;
    int r=n-1;

    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;

    int waterTapped = 0;
    while(l<=r){
      if(height[l] < height[r]){
        if(height[l] < leftMax){
          waterTapped += leftMax - height[l];
        } else {
          leftMax = height[l]; //if current block is greater than the maxLeft block, it cannot contain any water, it can only help other right block to contain water.
        }
        l++;
      } else {
        if(height[r] < rightMax){
          waterTapped += rightMax - height[r];
        } else {
          rightMax = height[r];
        }
        r--;
      }
    }

    return waterTapped;
  }
}
