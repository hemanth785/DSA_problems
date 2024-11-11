

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A02_DistinctNumbersInWindow {
  public static void main(String[] args) {
    int arr[] = {1, 1, 2, 1, 4, 6, 5};
    int k = 3;
    int res[] = distintNumbersInWindow(arr, k);
    System.out.println(Arrays.toString(res));
  }

  /*
   * Approach 1: Using nested arrays
   * 
   * Time: O(n*k), Space: O(1)
   */

  /*
   * Approach 2: Using hashmap and sliding window
   * 
   * Time: O(n), Space: O(k)
   */
  public static int[] distintNumbersInWindow(int[] A, int k) {
		int n = A.length;
	  Map<Integer, Integer> map = new HashMap<>();
		
		int res[] = new int[n-(k-1)];
		int count = 0;
		
		for(int i=0; i<k; i++){
			int item = A[i];
			if(!map.containsKey(item)){
				count++;
        map.put(item, 1);
			} else {
        map.put(item, map.get(item)+1);
			}
		}
		
		res[0] = count;
		
		int l=0;
		int r=k;
		int i=1;
		while(r<n){
			//removing left item from windows
			if(map.get(A[l]) == 1){
				map.remove(A[l]);
				count--;
			} else {
				map.put(A[l], map.get(A[l])-1);
			}
      l++;
			
			//add item on the right side of window
			if(!map.containsKey(A[r])){
				count++;
        map.put(A[r], 1);
			} else {
				map.put(A[r], map.get(A[r])+1);
			}
      r++;
			
			//add the count to array
			res[i++] = count;
		}
		
		return res;
	}
}
