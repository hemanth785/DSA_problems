

import java.util.HashSet;
import java.util.Set;

/*
 * Link: https://www.geeksforgeeks.org/count-k-length-substrings-with-no-repeated-characters/
 */
public class A17_FindKLengthSubtringWithDistinctCharactors {
  public static void main(String[] args) {
    int result = findKLengthDistinctSubtrings("geeksforgeeks", 5);
    System.out.println("result: "+result);
  }

  static int findKLengthDistinctSubtrings(String str, int k){
    int n = str.length();
    int count = 0;
    if(k>n){
      return count;
    }

    Set<Character> set = new HashSet<>();
    int l=0;
    int r=0;

    while(r<n){
      char rChar = str.charAt(r);
      
      if(!set.contains(rChar)){
        set.add(rChar);
        r++;

        if(r-l == k){
          count++;
          
          char lChar = str.charAt(l);
          set.remove(lChar);
          l++;
        }
      } else {
        while(l<r){
          char lChar = str.charAt(l);
          set.remove(lChar);
          l++;
        }
      }
    }

    return count;
  }
}
