public class IsPerfectSquare {
  public static void main(String[] args) {
    int num = 808201;
    System.out.println(isPerfectSquare(num));
  }

  /*
   * Approach 1: Using the Math.sqrt method
   */

  /*
   * Approach 2: Withouth Using the Math.sqrt method
   * Starting from 1, find the sqaure of each number until n/2, 
   * 
   * Time: O(n)
   */

  /*
   * Appraoch 3: Optimal - using binary search
   */
  static boolean isPerfectSquare (int num) {
		if(num <= 1){
			return true;
		}
		
		int l = 1;
		int r = num;
		
		while(l<=r){
			int mid = l + (r-l)/2;
			long square = (long)mid * (long)mid;
			if(square == num){
				return true;
			} else if(square < num){
        l = mid+1;
			} else {
				r = mid-1; 
			}
		}
		return false;
	}
}
