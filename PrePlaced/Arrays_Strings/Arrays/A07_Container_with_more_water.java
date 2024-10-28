package PrePlaced.Arrays_Strings.Arrays;

/*
 * Link: https://leetcode.com/problems/container-with-most-water/
 */
public class A07_Container_with_more_water {
  /*
   * Approach 1: Bruteforce
   * - For each height, check the area with every other height, while comparing the maxArea
   * 
   * Time: O(n2)
   */
  public int maxArea1(int[] height) {
    int n = height.length;
    int maxArea = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int area = Math.min(height[i], height[j]) * (j - i);
        maxArea = Math.max(maxArea, area);
      }
    }

    return maxArea;
  }

  /*
   * Approach 2: Using 2 pointers (This is same as rainwater tapping, just that area calculation is diff)
   * - Set leftPointer as 0, and rightPointer as n-1
   * - Now run a while loop with condition (l<r)
   * - at each stage calculate area using min(l_Height, r_Height) * width, and also compare with maxArea
   * - move the pointer which is having less height;
   */
  public int maxArea2(int[] height) {
    int n = height.length;
    int l = 0;
    int r = n-1;

    int maxArea = 0;
    while(l<r){
      int width = r-l;
      int curArea = width * Math.min(height[l], height[r]); 
      maxArea = Math.max(maxArea, curArea);
      if(height[l] < height[r]){
        l++;
      } else {
        r--;
      }
    }

    return maxArea;
  }
}
