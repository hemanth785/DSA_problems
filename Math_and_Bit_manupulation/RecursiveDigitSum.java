package Maths;

/*
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {
  public static void main(String args[]){
    int result = superDigit("8756", 4);
    System.out.println("recursive digit sum"+ result);
  }

  /*
   * Solution1: Bruteforce 
   * 
   * Loop through each digit and find the sum of digits iteratively, until digit sum bacomes single digit or <9
   * 
   */
  public static int superDigit(String n, int k) {
    String p = n;
    int digitSum = 0;
    for(int i=0; i<p.length(); i++){
        char charNum = p.charAt(i);
        digitSum += Character.getNumericValue(charNum);
    }
    digitSum = digitSum * k;
    p = ""+digitSum;
    
    System.out.println("p:"+p);
    while(p.length() > 1){
        digitSum = 0;
        for(int i=0; i<p.length(); i++){
            char charNum = p.charAt(i);
            digitSum += Character.getNumericValue(charNum);
        }
        p = ""+digitSum;
        System.out.println("p:"+p);
    }
    return Integer.parseInt(p);
  }

  /*Solution 2: using knowledge of modulus 
   * if any number is divisible by 9, then the last single digit will be 9
   * ex: 81 divisble by 9, last digit is 8+1 => 9
   * if any number is not divisible by 9, then the last single digit will be num%9
   * ex: 82 not divisble by 9, last digit is 8+2 = 10 ==> 1+0 = 1    i.e  82%9 = 1
   * 
   * Note: This solution will work for smaller number, and if k is not provided
  */

  public static int superDigit(int n, int k) {
    int sum = k * digSum(n);
    return digSum(sum);
  }

  public static int digSum(int n)
  {
      if (n == 0)
        return 0;
      return (n % 9 == 0) ? 9 : (n % 9);
  }


  /*
   * Solution 3: Most optimized, when very big number is given in string datatype, and it has to be repeated k times before finding the super digit
   * 
   * for num = 123, k=3
   * Step 1: find superDigit for 123, i.e '6'
   * Step 2: repeat the superdigit of 123 k times, instead of 123 itself, then it becomes '666'
   * Step 3: find superDigit for '666', until it becomes single digit. i.e. 9
   */
  public static int superDigit3(String num, int k) {
    String p = getDigitSum(num).repeat(k);
    
    return Integer.parseInt(getDigitSum(p));
  }

  public static String getDigitSum(String num)
  {
    int total = 0;
    for(int i=0; i<num.length(); i++){
      total += Character.getNumericValue(num.charAt(i));
    }
    String totalString = ""+total;
    if(totalString.length() == 1){
        return totalString;
    } else {
        return getDigitSum(totalString);
    }
  }

}
