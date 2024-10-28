package PrePlaced.Arrays_Strings.Arrays;

/*
 * Link: https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839
 */
public class A15_Merge_2_sorted_array_without_extra_space {
  /*
   * Approach 1: (Bruteforce) store merged result in extra space and add it to original array later
   * 
   * Time: O(n+n)  Space: O(n+m)
   */

  /*
   * Approach 2: Swap and sort - (We can use inbuild sort method while writing code for this)
   * - left pointer will point to last item of first array
   * - Right pointer will point to beginning of 2nd array
   * - If leftPointer element is greater than rightPointer element, 
   *      - Swap both element
   * - decrement leftPointer and increment rightPointer
   * - exit iteration, once any of the pointer overflow
   * - Now we have all the smaller items in left array & all the bigger elements in right array
   * - Now start there left and right subarray individually
   * 
   * Time: O(n*log(n) + m*log(m))     Space: O(1)
   */

  /*
   * Approach 3: Gap method, which uses shell short
   * - find a gap, gap = Math.ceil( (n+m)/2 )
   * - define 2 variables l= 0, and r= l+gap
   * - iterate over array, will right pointer reaches end
   *    - if item[l] > item[r], then swap
   * 
   * - Once iteration is over, halve the gap value and finding ceil of it
   * - Continue comparision of elements again
   * 
   * - Repeat this unit, gap reaches value 1
   * 
   * Time: O( (n+m) * log(n+m))     Space: O(1)
   * 
   * Link: https://www.youtube.com/watch?v=n7uwj04E0I4
   */

  public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
    int n = a.length;
    int m = b.length;
    int len = n+m;

    int gap = (int)Math.ceil((len)/2.0f) ;

    while(gap >= 1){
      int l = 0;
      int r = l+gap;
      
      while(r < len){
        //arr1 and arr2
        if(l<n && r>=n){
          swapIfGreater(a, b, l, r-n);
        } else if(l>=n) { //arr2 and arr2
          swapIfGreater(b, b, l-n, r-n);
        } else { //arr1 and arr1
          swapIfGreater(a, a, l, r);
        }
        l++;
        r++;
      }

      if(gap == 1){
        break;
      }

      gap = (int)Math.ceil((gap)/2.0f) ;
    }
  }

  static void swapIfGreater(long[] arr1, long[] arr2, int id1, int id2){
    if(arr1[id1] > arr2[id2]){
      long temp = arr1[id1];
      arr1[id1] = arr2[id2];
      arr2[id2] = temp;
    }
  }
}
