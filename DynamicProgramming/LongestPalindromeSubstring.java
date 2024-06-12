package DynamicProgramming;

public class LongestPalindromeSubstring {
  String longestPalindromeString = "";

  public String longestPalindrome(String s) {
    int n = s.length();
    int dp[][] = new int[n + 1][n + 1];

    longestPalindromeMemo(s, 0, 0, dp);
    return longestPalindromeString;
  }

  public void longestPalindromeMemo(String s, int l, int r, int[][] dp) {
    if(r >= s.length()) {
      return;
    }
    //here we are just marking for any l and r combination we checked for palindrome
    if(dp[l][r] == 1) {
      return;
    }
    if (isPalindrome(s, l, r)) {
      if (r - l + 1 > longestPalindromeString.length()) {
        longestPalindromeString = s.substring(l, r + 1);
      }
    }
    // include exclude principle
    longestPalindromeMemo(s, l, r + 1, dp);
    longestPalindromeMemo(s, l + 1, r + 1, dp);
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
