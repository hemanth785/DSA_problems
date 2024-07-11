package String;

public class A_03_StringToInteger {
  public static void main(String args[]){
    String str = "+-25";
    int res = stringToInt(str);
    System.out.println(res);
  }

  public static int stringToInt(String s){
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    int i = 0;
    // remove leading whitespaces
    while (i < n && s.charAt(i) == ' ') {
      i++;
    }

    boolean neg = false;
    if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      if (s.charAt(i) == '-')
        neg = true;
      i++;
    }

    int baseAns = 0;
    while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
      int val = s.charAt(i) - '0';
      if ((baseAns > Integer.MAX_VALUE / 10) || (baseAns == Integer.MAX_VALUE / 10 && val > 7)) {
        if (neg)
          return Integer.MIN_VALUE;
        return Integer.MAX_VALUE;
      }
      baseAns = 10 * baseAns + val;
      i++;
    }
    if (neg)
      return -baseAns;
    return baseAns;
  }
}
