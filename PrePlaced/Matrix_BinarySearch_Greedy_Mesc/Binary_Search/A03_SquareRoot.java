public class A03_SquareRoot {

  /*
   * Approach 2: Using binary search
   * - we know that, square root of number lies between 1 and the number itself.
   * - So initialize two varibles l=1 & r = number
   * - find the mid valud of l and r
   * - find the square of this mid, and compare it against given number,
   * - If it matches, this is the squre root,
   * - otherwise move the l or r pointer based on condition
   * 
   * Time: Log(n)
   */
  public int findSqrt(int num){
    if(num <= 1){
      return num;
    }
  
    int l = 1;
    int r = num;
  
    int mid = 0;
    long square = 0;
    while(l<=r){
      mid = l + (r-l)/2;
      square = (long)mid * (long)mid;
      if(square == num){
        return mid;
      } else if(square < num){
        l = mid+1;
      } else {
        r = mid-1; 
      }
    }

    //if perfect square does not exists
    if(square > num){
      return mid-1;
    }
    return mid;
  }
}
