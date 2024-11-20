package Arrays_Strings.Strings;

/*
 * Link: https://leetcode.com/problems/count-and-say/solutions/5981943
 */
public class A02_Count_and_say {
  public String countAndSay(int n) {
    String reString = "1";

    for (int i = 2; i <= n; i++) {
      reString = countAndSayHelper(reString);
    }

    return reString;
  }

  public String countAndSayHelper(String str) {
    StringBuilder sb = new StringBuilder();
    char prev = str.charAt(0);
    int cnt = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == prev) 
        cnt++;
      else {
        sb.append(cnt);
        sb.append(prev);
        prev = str.charAt(i);
        cnt = 1;
      }
    }

    sb.append(cnt);
    sb.append(prev);
    
    return sb.toString();
  }
}
