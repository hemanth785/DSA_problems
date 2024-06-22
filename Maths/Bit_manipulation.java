package Maths;

public class Bit_manipulation {
  public static void main(String[] args) {
    //----get i'th bit
    // int number = 6;  //6 -> 110
    // int i = 1;   //from right side of number
    // int res = getIthBit(number, i);
    // System.out.print("i'th bit value:  "+ res);

    //----set i'th bit
    // int number = 5 ;  //4 -> 101
    // int i = 2;   //from right side of number
    // int res = setIthBit(number, i);
    // System.out.print("value after setting i'th bit:  "+ res);

    //---clear i'th bit
    int number = 13 ;  //6 -> 111
    int i = 3;   //from right side of number
    int res = clearIthBit(number, i);
    System.out.print("value after clearing i'th bit:  "+ res);

    //----check if number is power of 2
    // isNumberPower2(3);


    //----count setBits for number n
    // int n = 7;
    // int res = countAllSetBits(n);
    // System.out.print("Set bits count: "+ res);

    //----count setBits for number from 1 to n
    // int n = 4;
    // // int res = countSetBitsFrom1toN_1(n);
    // int res = countSetBitsFrom1toN_2(n);
    // System.out.print("Set bits count: "+ res);
  }

  /*
   * trick to get the ith bit without converting number to binary form
   * 
   * Problem: lets say number 5 in binary form is 101 & neet get i=3 bit
   * Solution: 
   * - Take number '1', in binary '001' (it can be 01 or 1  also)
   * - left shift 001 by ith bit (i=3), 001 << 3 = 100
   * - compute bitwise and (&) of two numbers
   * -      & 101
   * -        100
   * -we get: 100
   * - if the result we get is >0, then we can conclude that ith bit is 1, or its a 0
   */
  public static int getIthBit(int number, int i){
    int helpNumber = 1;

    helpNumber = helpNumber<<(i-1);

    System.out.println("helpNumber: "+helpNumber);

    int result = number & helpNumber; //bitwise AND operator
    System.out.println("after AND: "+result);
    if(result == 0){
      return 0;
    } else {
      return 1;
    }
  }

  /*
   * set i'th bit ==> make ith bit as '1', irrespctive of whether its 0 or 1 currently
   * - here to set the i'th bit, we need to make use of OR operator
   */
  public static int setIthBit(int number, int i){
    int helpNumber = 1;  //001 or ...0001
    helpNumber = helpNumber<<i-1;

    System.out.println("helpNumber: "+helpNumber);

    int result = number | helpNumber; //bitwise OR operator
    return result;
  }

  /*
   * clear i'th bit ==> make ith bit as '0', irrespctive of whether its 0 or 1 currently
   * - here to clear the i'th bit, we need to make use of OR operator
   */
  public static int clearIthBit(int number, int i){
    int helpNumber = 1;  //001 or ...0001
    helpNumber = helpNumber<<i-1;

    System.out.println("helpNumber: "+ ~helpNumber);

    int result = number | ~helpNumber; //bitwise OR operator
    return result;
  }

  /*
   * Logic:
   * let n=8 => 1000;
   *    n-1=7 => 0111;
   * 
   * If we apply logical AND on these 2 numbers we'll get 0 (For only numbers which are power of 2. i.e. 2,4,8,16,.....)
   * 
   */
  public static void isNumberPower2(int n){
    if(n < 2){
      System.out.println("No");
    }
    if((n & n-1) == 0){
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  /*
   * Problem: get the count of bits having value 1 in a number n
   * 
   * Time: O(n)
   */
  public static int countAllSetBits(int n){
    int count = 0;
    while(n>0){
      if((n&1) == 1){
        count++;
      }
      n = n>>1;
    }
    return count;
  }

  /*
   * Problem: get the count of bits for numbers from 1 to n
   * 
   * Time: O(n * log(n))
   */
  public static int countSetBitsFrom1toN_1(int n){
    int count = 0;
    if(n == 0){
      return count;
    }

    for(int i=1; i<=n; i++){
      count+=countAllSetBits(i);
    }

    return count;
  }

  /* 1<<0 ==> 1
   * 1<<1 ==> 10
   * 1<<2 ==> 100
   * 1<<1 ==> 1000
   * 1<<1 ==> 10000
   */
  public static int largestPowerOf2(int n){
    int x=0;

    while((1<<x) <= n){  
      x++;
    }

    return x;
  }
  /*
   * Problem: get the count of bits for numbers from 1 to n
   * 
   * Solution 2: using formula: (2^x-1 * x) + (n-(2^x)+1) + func(n-2^x)
   * where x- largest power of 2 number, which is less than n
   * 
   * Time: less than O(log(n))
   */

   
  public static int countSetBitsFrom1toN_2(int n){
    System.out.println("n: "+n);
    if(n <= 0){
      return 0;
    }
    int x = largestPowerOf2(n);

    System.out.println("x: "+x);
    int i=0;
    if(i>5){
      return 0;
    }
    i++;

    // return 0;
    return (int)((Math.pow(2, x-1) * x) + (n-Math.pow(2,x)+1) + (countSetBitsFrom1toN_2(n - (int)Math.pow(2,x))));
  }


}


