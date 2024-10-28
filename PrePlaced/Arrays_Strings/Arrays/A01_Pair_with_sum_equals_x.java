package PrePlaced.Arrays_Strings.Arrays;

/*
 * Check for pair with sum equal to x.
 * Input: [3, 1, 4, 10, 2]. target = 6
 * Output: (4,2)
 * 
 */

import java.util.HashMap;
import java.util.Arrays;

public class A01_Pair_with_sum_equals_x {

  public static void main(String[] args) {
    int arr[] = {3, 1, 4, 10, 2};
    int target = 6;

    // int[] res = solution2(arr, arr.length, target);
    int[] res = solution3(arr, arr.length, target);

    System.out.println("Couple with array: "+ Arrays.toString(res));
  }

  /*
  * Solution 1: Brute force
  * 
  * using two loops and checking, if arr[i] + arr[j] == target
  * 
  * Time O(n^2)
  * 
  */



  /*
  * Solution 2: using hashmap
  * 
  * Store (target-arr[i], arr[i]) map and check the same againt every other element
  * 
  * Time:  O(n), Space: O(n)
  * 
  */
  public static int[] solution2(int arr[], int n, int target){
    int item1= 0;
    int item2= 0;

    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    map.put(target-arr[0], arr[0]);
    for(int i=1; i<n; i++){
      if(map.get(arr[i]) != null){
        item1 = map.get(arr[i]);
        item2 = arr[i];
        break;
      }
      map.put(target-arr[i], arr[i]);
    }
    return new int[]{item1, item2};
  }


  /*
  * Solution 3: sort the array and apply 2 pointer
  * 
  * Time:  O(n log(n)), Space: O(1)
  */
  public static int[] solution3(int arr[], int n, int target){
    int item1= 0;
    int item2= 0;

    Arrays.sort(arr);

    int l=0;
    int r=n-1;
    while(l<r){
      int sum = arr[l] + arr[r];
      if(sum == target){
        item1 = arr[l];
        item2 = arr[r];
        break;
      } else if(sum > target){
        r--;
      } else {
        l++;
      }
    }
    return new int[]{item1, item2};
  }
}
