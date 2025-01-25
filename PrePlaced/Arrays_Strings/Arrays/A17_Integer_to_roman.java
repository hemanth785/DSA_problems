package PrePlaced.Arrays_Strings.Arrays;

/*
 * Link: https://leetcode.com/problems/integer-to-roman/description/
 * 
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 */
public class A17_Integer_to_roman {
  public static void main(String[] args) {
    System.out.println(intToRoman(3568));
  }

  /*
   * Approach:
   * - Start by extracting larger value from given number and assigning the roman symbols
   * 
   * ex = 1568
   * - first check if this number is greater than 1000, 
   *   - if yes, add M to result list and subtract 100 from given number
   * - for 568, then check if this number is greater than 900
   * - for 568, then check if this number is greater than 500
   *    - if Yes, then add D to result list and subtract 500 from given number, 
   * 
   * - Continue the same process
   */
  public static String intToRoman(int num) {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder result = new StringBuilder();
    for(int i=0; i<values.length; i++){
      int value = values[i];
      while(num >= value){
        result.append(symbols[i]);
        num = num - value;
      }
    }

    return result.toString();
  }
}
