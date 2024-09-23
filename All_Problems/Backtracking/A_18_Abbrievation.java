package All_Problems.Backtracking;

/*
 * Link: https://www.hackerrank.com/challenges/abbr/problem
 */
public class A_18_Abbrievation {
  
  public static String abbreviation(String a, String b) {
    if(b.length() > a.length()){
      return "NO";
    }

    boolean res = matchRec(a, b, 0, 0);

    return res ? "YES": "NO";
  }

  public static boolean matchRec(String a, String b, int i, int j){
    if(j == b.length() && i == a.length()){
      return true;
    }

    if(j == b.length()){
      for(int index = i; index<a.length(); index++){
        if(a.charAt(i) < 'a' && a.charAt(i) > 'z'){
          return false;
        }
      }
      return true;
    }

    if(i >= a.length() || j >= b.length()){
      return false;
    }

    String charA = a.charAt(i)+"";
    String charB = b.charAt(j)+"";

    boolean matchCase = false;
    boolean notMatchCase = false;
    if(charA.equalsIgnoreCase(charB)){
      matchCase = matchRec(a, b, i+1, j+1);
    }
    if(a.charAt(i) >= 'a' && a.charAt(i) <= 'z'){
      notMatchCase = matchRec(a, b, i+1, j);
    }

    return matchCase || notMatchCase;
    
  }
}
