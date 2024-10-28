package PrePlaced.Arrays_Strings.Arrays;

/*
 * Link: https://leetcode.com/problems/integer-to-roman/description/
 */
public class A17_Integer_to_roman {
  public String intToRoman(int num) {
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
