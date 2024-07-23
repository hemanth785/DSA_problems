package Math_and_Bit_manupulation;
/*
 * Given an integer n, find each x such that, 
 * x+n == x^n
 * 
 * return the count of such numbers x, 0<=x<=n
 */
public class SumVsXor {
  public static void main(String[] args) {
    int n = 9; 
  }

  /*
   * Solution 1: Time - O(n)
   * Loop through numbers from i=0 to n-1, checking for condition x+1 == x^i
   */

  /*
   * Solution 2: Efficient
   * we know that (n+i)=(n^i)+2*(n&i)
   * So n + i = n ^ i implies n & i = 0
   * Hence our problem reduces to finding values of i such that n & i = 0. How to find count of such pairs? We can use the count of unset-bits in the binary representation of n. For n & i to be zero, i must unset all set-bits of n. If the kth bit is set at a particular in n, kth bit in i must be 0 always, else kth bit of i can be 0 or 1
   * Hence, total such combinations are 2^(count of unset bits in n)
   * For example, consider n = 12 (Binary representation : 1 1 0 0). 
   * All possible values of i that can unset all bits of n are 0 0 0/1 0/1 where 0/1 implies either 0 or 1. Number of such values of i are 2^2 = 4. 
   */
  public static int getSumXorCount(int n){
    int unsetBits = 0;
    while(n > 0){
        if((n & 1) == 0){
            unsetBits++;
        }
        n=n>>1;
    }

    /* 
    * Return 2 ^ unset_bits
    * that can be done in 2 ways
    * 1.   1 >> unsetBits
    * 2.   Math.pow(2, unsetBits)
    */ 
    return 1<<unsetBits;
    
  }
}
