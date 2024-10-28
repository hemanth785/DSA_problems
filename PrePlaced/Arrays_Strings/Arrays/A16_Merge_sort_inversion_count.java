package PrePlaced.Arrays_Strings.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
public class A16_Merge_sort_inversion_count {
  /*
   * Approach 1: bruteforce
   * - Use 2 nested loops
   * - Check for each element, count how many elements on right side which are lesser
   * - return the final count
   * 
   * Time: O(n^2)
   */

  /*
   * Approach 2: Using Merge sort  
   * - we know that, while sorting using merge sort we devide array into two halves at every iteration
   * - So while merging to sorted array, 
   *      we can calcuate the number of inversions for each eleemnt on left subarray, by comparing against right subarray elemnt
   * 
   * Logic: For any element on left, if we found one element which is lesser. (it forms inversion pair with current element)
   *    we can conlude that it also forms pair with rest of the elements on left subarray.
   *    so if 3 more elements on left array after current element, we can increment inversion count by 4
   * 
   * TIme: O(n * log(n)), Space: O(n)
   * approach link: https://www.youtube.com/watch?v=AseUmwVNaoY
   */
  static int totalInversions;
  static int inversionCount(int arr[]) {
      totalInversions = 0;
      mergeSortWithInversionCount(arr, 0, arr.length-1);
      
      return totalInversions;
  }
    
  static void mergeSortWithInversionCount(int arr[], int low, int high){
    if(low >= high){
      return;
    }

    int mid = (low+high)/2;
    mergeSortWithInversionCount(arr, low, mid);
    mergeSortWithInversionCount(arr, mid+1, high);

    sortWhileMerging(arr, low, mid, high);
  }

  static void sortWhileMerging(int arr[], int low, int mid, int high){
    //temp array
    List<Integer> temp = new ArrayList<>();

    int left = low;
    int right = mid+1;
    
    
    //calculate number of inversion between left and right subarray
    int inversions = 0;
    while(left <= mid && right <= high){
      if(arr[left] > arr[right]){
        inversions += mid-left+1;
        right++;
      } else {
        left++;
      }
    }
    totalInversions += inversions;
    

    //merge 2 sorted array
    left = low;
    right = mid+1;
    while(left <= mid && right <= high){
      if(arr[left] <= arr[right]){
        temp.add(arr[left++]);
      } else {
        temp.add(arr[right++]);
      }
    }

    while(left <= mid){
      temp.add(arr[left++]);
    }

    while(right <= high){
      temp.add(arr[right++]);
    }

    for(int i=low; i<=high; i++){
      arr[i] = temp.get(i-low);
    }
  }

}
