package Arrays_Strings.Strings;
/*
 * link: https://www.geeksforgeeks.org/find-and-replace-all-occurrence-of-a-substring-in-the-given-string/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Approach 1: Using simplet pattern search 
 * - replace substring whenever we find string
 * 
 * Time: O(n*m)
 */

/*
 * Appraoch 2: Usign KMP algo to find pattern
 * 
 * Time: O(n+m) , where m is the pattern length
 */
public class A05_Replace_substring_of_string {
  public static void main(String[] args) {
    String S = "abababa";
    String S1 = "aba";
    String S2 = "a";

    String res = modifyString(S, S1, S2);
    System.out.println("modified string: "+ res);
  }

  public static String modifyString(String S, String S1, String S2){
    int n = S.length();
    int m = S1.length(); //Pattern length

    //Get LPS/KMP search pattern array
    int[] kmpPattern = getLps(S);

    //Search for pattern S1 in S
    StringBuilder sb = new StringBuilder();
    Set<Integer> foundIndex = new HashSet<>();
    int pi = 0;
    int si = 0;
    while(si < n-m){
      
      while(pi < m){
        if(S.charAt(si) == S1.charAt(pi)){
          si++;
          pi++;
        } else {
          if(kmpPattern[pi] == 0){
            kmpPattern[si] = 0;
            si++;
          } else {
            pi = kmpPattern[pi-1];
          }
        }
      }
      //if pattern found, add it to set
      if(pi >= m){
        foundIndex.add(si-m);
      }
      pi=0; //reset pattern index
    }

    for(int i=0; i<n; i++){
      if(foundIndex.contains(i)){
        sb.append(S2);
        i = i+m-1;
      } else {
        sb.append(S.charAt(i));
      }
    }

    return sb.toString();
  }

  public static int[] getLps(String str){ //longest prefix string
    int[] lps = new int[str.length()];

    int l=0;
    int r=1;

    while(r<str.length()){
      if(str.charAt(l) == str.charAt(r)){
        lps[r] = l+1;

        l++;
        r++;

      } else {
        if(l==0){
          lps[r] = 0;
          r++;
        } else {
          l = lps[l-1];
        }
      }
    }

    return lps;
  }


}
