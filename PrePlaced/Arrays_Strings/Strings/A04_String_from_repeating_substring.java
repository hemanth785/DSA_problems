package Arrays_Strings.Strings;

/*
 * Link: https://www.geeksforgeeks.org/problems/string-formation-from-substring2734/1
 */

/*
 * Approach: Use KMP longest prefix algo
 * 
 * Time: O(n)
 * 
 * Space: O(n)
 */
public class A04_String_from_repeating_substring {
  int isRepeat(String str) {
    int n =str.length();
    int[] lps = getLps(str);
    
    int longestPrefLen = lps[n-1];
    if(longestPrefLen == 0){
        return 0;
    } 
    if(n% (n-longestPrefLen) == 0){
        return 1;
    } 
    return 0;
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
