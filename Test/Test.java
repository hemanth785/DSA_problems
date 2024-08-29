package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
    System.out.println(numDistinct("babgbag", "bag"));
  }

  public static int numDistinct(String s, String t) {
      return numDistinctMemo(s, t, 0, 0);
  }

  public static int numDistinctMemo(String s, String t, int i, int j) {
    if(i == s.length() && j == t.length()){
        return 1;
    } 
    if(j >= t.length()){
        return 1;
    }
    if(i >= s.length()){
        return 0;
    }

      int sChar = s.charAt(i);
      int tChar = t.charAt(j);

      int include = 0;
      if (sChar == tChar) {
          include = numDistinctMemo(s, t, i + 1, j + 1);
      }

      int exclude = numDistinctMemo(s, t, i + 1, j);

      return include + exclude;
  }

}
