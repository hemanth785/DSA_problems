package DynamicProgramming;

public class A_21_LongestPalindromeSubstring {
  String longestPalindromeString = "";

  public String longestPalindrome(String s) {
    int n = s.length();
    int dp[][] = new int[n + 1][n + 1];

    longestPalindromeMemo(s, 0, 0, dp);
    return longestPalindromeString;
  }

  public void longestPalindromeMemo(String str, int l, int r, int[][] dp) {
    if(r >= str.length()) {
      return;
    }
    //here we are just marking for any l and r combination we checked for palindrome
    if(dp[l][r] == 1) {
      return;
    }
    //check for palindrome
    if (isPalindrome(str, l, r)) {
      if (r - l + 1 > longestPalindromeString.length()) {
        longestPalindromeString = str.substring(l, r + 1);
      }
    }

    // include exclude principle
    longestPalindromeMemo(str, l, r+1, dp);
    longestPalindromeMemo(str, l+1, r+1, dp);
    dp[l][r] = 1;
  }


  //function to check palindrome
  public boolean isPalindrome(String s, int l, int r) {
    if (l == r) {
      return true;
    }
    int mid = l + ((r - l) / 2);
    for (int i = l; i <= mid; i++) {
      if (s.charAt(i) != s.charAt(r - (i - l))) {
        return false;
      }
    }
    return true;
  }
}
