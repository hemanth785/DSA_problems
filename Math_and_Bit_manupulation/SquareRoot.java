package Math_and_Bit_manupulation;
public class SquareRoot {

  /*
   * Approach 2: Using binary search
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
    if(square > num){
      return mid-1;
    }
    return mid;
  }
}
