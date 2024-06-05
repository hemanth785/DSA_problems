package Array_advanced;
/*
 * Given a sorted array in which all elements appear twice (one after one) and one element appears only once. 
 * Find that element in O(log n) complexity.
 * 
 * input: arr=[1 1 3 3 4 5 5 7 7 8 8], 
 * output: 4
 */
public class Element_appears_once {
  public static void main(String[] args) {
    int n = 9; 
  }

  /*
   * Solution 1: while looping through each element, compare consecutuve element
   * 
   * Time: O(n)
   */


  /*
   * Solution 2: Use Binary search
   * 
   * Approach: Suppose, If all the elements in array are repeating exactly once, 
   * then at each 'even' index, you should find 1st occurance of repeating elemnt, and
   * and at each 'odd' index, you should find 2nd occurance of the same element
   * 
   * Find the middle index, say ‘mid’.
   * If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are the same, then the required element after ‘mid’ and else before mid.
   * If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are the same, then the required element after ‘mid’ and else before mid.
   * 
   * Time: O(n)
   */
  public static int element_which_repeats_once(int[] arr) {
    int n = arr.length;
    int l = 0;
    int r = n - 1;
    int mid = 0;

    while (l <= r) {

      mid = l + (r - l) / 2;
      int midItem = arr[mid];
      System.out.println("l: " + l + ", mid: " + mid + ", r: " + r);
      if (l == r) {
        return arr[mid];
      }

      if (mid % 2 == 0) { // if mid is even
          if (midItem == arr[mid + 1]) {
            l = mid + 2;
          } else {
            r = mid;
          }
      } else {
          if (midItem == arr[mid - 1]) {
            l = mid + 1;
          } else {
            r = mid - 1;
          }
      }

    }

    return 0;
  }
}
