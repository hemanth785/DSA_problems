package Math_and_Bit_manupulation;
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


  /*
   * Approach 4: Checking count of set bits in number
   * Perfect square will have only one set bit
   */

   boolean isPerfectSquare2(int n) {
    int cnt = 0;
    while (n > 0) {
      if ((n & 1) == 1) {
        cnt++; // if n&1 == 1 keep incrementing cnt
        // variable
      }
      n = n >> 1; // keep dividing n by 2 using right
                  // shift operator
    }
    return cnt == 1;
      
  }

  /* The optimal is to observe that if a number n is a power of 2, 
     then its bitwise & with (n - 1) will be 0. 
     The special case to check is if n = 0 separately 

     if n=8, then 
     check for n & n-1 =>  8 & 7
     =>  1000
         0111
         0000 (its a perfect square)
  */

  boolean isPowerOfTwo(int n) {
    if(n == 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }

}
