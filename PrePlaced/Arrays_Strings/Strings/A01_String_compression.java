package PrePlaced.Arrays_Strings.Strings;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/string-compression/
 */
public class A01_String_compression {
  public int compress(char[] chars) {
    int n = chars.length;
    List<Character> compressed = new ArrayList<>();

    int count = 1;

    for(int i=1; i<n; i++){
      if(chars[i] == chars[i-1]){
        count++;
      } else {
        compressed.add(chars[i-1]);

        if(count > 1){
          String countStr = count+"";
          for(int j=0; j<countStr.length(); j++){
            compressed.add(countStr.charAt(j));
          }
        }
        count = 1;
      }

    }

    compressed.add(chars[n-1]);
    if(count > 1){
      String countStr = count+"";
      for(int i=0; i<countStr.length(); i++){
        compressed.add(countStr.charAt(i));
      }
    }

    for(int i=0; i<compressed.size(); i++){
      chars[i] = compressed.get(i);
    }

    return compressed.size();
  }
}
