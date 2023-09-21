package String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public static void main(String[] args) {
    String s = "paper";
    String t = "title";
    System.out.println(isIsomorphic(s, t));
  }
  public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int n=s.length();

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(map.get(a) != null && map.get(a) != b){
                return false;
            }
            if((map.get(a) != null && reverseMap.get(b) == null) || 
            (reverseMap.get(b) != null && reverseMap.get(b) != a))
            {
                return false;
            }
            map.put(a, b);
            reverseMap.put(b, a);
            
        }
        return true;
    }
}
