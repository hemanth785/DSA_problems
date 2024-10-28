package PrePlaced.Arrays_Strings.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/roman-to-integer
 */
public class A18_Roman_to_Integer {
  public Map<Character, Integer> getRomanMap(){
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		return romanMap;
	}

  public int romanToInt(String s) {
    int ans = 0;
    int prev = 0;
    Map<Character, Integer> romanMap = getRomanMap();
    
    for(char ch: s.toCharArray()){
      int number = romanMap.get(ch);

      if(number > prev){
        ans = ans + number - (prev*2);
      } else {
        ans = ans + number;
      }
      prev = number;
    }
  
  return ans;
  }
}
