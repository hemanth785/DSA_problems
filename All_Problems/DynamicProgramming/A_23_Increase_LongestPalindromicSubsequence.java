/*
 * Link: https://www.hackerrank.com/challenges/longest-palindromic-subsequence/problem
 */

public class A_23_Increase_LongestPalindromicSubsequence {

  /*
   * Approach:
   * 1. calculate the Longest commen subsequence between original and reversed string (Using tabulation)
   * 2. calculate the Longest palindromic subsequence of original array (Using tabulation)
   * 3. Now run a loop to insert and check new char at every position (i) between chars. there will be max of n+1 position where this new char can be placed 
   *    i.e. for a string of 'ab', the new char can be inserted in the following positions denoted by * => '*a*b*'
   * 4. Inside the first loop, run a 2nd loop, which identifies, which existing char (j) in the string (for each possible position) on the other side of palindrome
   *    Note: Here we need to check for total of (n+1)*n possibilities
   * 5. At each stage, check if new char inserted, will increase the palindrome subsequnce length by atleast (lps+k) times
   */
  public static int longestPalindromicSubsequenceIncrease(String s, int k) {
    int n = s.length();
    if(k == 0){
        return 26*(n+1);
    }
    if(n == 1){
        return 2;
    }
    
    char arr[] = s.toCharArray();
    int[][] lps = calcLPS(arr);
    int[][] lcs = lcs(arr,reverse(arr));
    return calcWays(lps,lcs,arr,k);
  }
    

  //lsc[i][j] = length of longest common subsequence between S[0,i] and rev(S)[0,j] i.e. S[n-1-j]
  private static int[][] lcs(char[] str1, char[] str2){
    int n = str1.length;
    int m = str2.length;

    int dp[][] = new int[n+1][m+1];

    for(int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        if(str1[i-1] == str2[j-1]){
          dp[i][j] = 1+dp[i-1][j-1];  //1+left top diaganal value
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); //max of left and top value
        }
      }
    }
    
    return dp;
  }
    
  //lps[i][j] = maximum length of any palindrome in S[i][j]
  private static int[][] calcLPS(char[] arr){
    int[][] lps = new int[arr.length][arr.length];
    int i,j,k;
    for(i=0;i<arr.length;i++){
      lps[i][i] = 1;
    }
    //k denotes the length of substring
    //all 1 length are have already been covered
    for(k=2;k<=arr.length;k++){
      for(i=0;i<=arr.length-k;i++){
        j = i+k-1;
        if(j==i+1){
          //i.e. only two characters
          if(arr[i]==arr[j]){
            lps[i][j] = 2;
          }
          else{
            lps[i][j] = 1;
          }
        }
        else{
          if(arr[i] == arr[j]){
            lps[i][j] = 2+lps[i+1][j-1];
          }
          else{
            lps[i][j] = Math.max(lps[i+1][j],lps[i][j-1]);
          }
        }
      }
    }
    return lps;
  }
   
  private static int calcWays(int[][] lps,int[][] lcs,char[] arr,int lp){
    int n = arr.length;
    int i,j,k;
    int ans = 0;
    //there are n+1 positions to insert a new character
    //also length of palindrome cannot be increased more than 2
    //we will try to put character at each of these positions and try to 
    //get the length of palindrome, if it increases then we add this to final answer
    int[] table = new int[26];

    //i denotes the position of new character will be added (it runs till the array length, because we can add char after the end of string also)
    for(i=0;i<=arr.length;i++){

      //CASE 1: consider i as a center if palindromis subsequence, then new palindrome will always be of odd length
      int x = Math.max(2*lcs[i][n-i] +1, lps[0][n-1]);

      //this denotes inserting 26 characters
      for(k=0;k<=25;k++){
        table[k] = x;
      }
      
      //CASE 2: consider the case when i is not the center of palindromic subsequence
      //Here j represents the each character in original string
      for(j=0;j<arr.length;j++){
        if(j<i){
          x = 2*lcs[j][n-i] + (j+1<n ? lps[j+1][i-1] : 0);
        }
        else if (j>i){
          x = 2*lcs[i][n-j-1] + lps[i][j-1]; 
        }
        else {
          x = 2*lcs[i][n-j-1];
        }

        table[arr[j]-'a'] = Math.max(table[arr[j]-'a'], (x+2));
      }
      for(j=0;j<=25;j++){
        if(table[j] >= lps[0][n-1]+lp){
          ans++;
        }
      }
    }
    return ans;
  }

  private static char[] reverse(char[] arr){
    char[] rev = new char[arr.length];
    int i,n= arr.length-1;
    for(i=0;i<=n;i++){
      rev[i] = arr[n-i];
    }
    return rev;
  }
}

/*
* Note: for finding x (at line 67), we are trying to insert one charactor at each index starting from 0 and n, 
* and check if this is the middle character of palindromic subsequence, what'll be the maximum palindromic lenght
*  
* Lets consider string of "abbcd", and we are about to insert this new char at index 2 (i.e. after 1st 'b')
* Then it'll device the string like this [charsMatchingToRightPart(ab) + x + charsMatchingToLeftPart(bcd)], where 'x' is new char
* when we compare left and right side, we got only b matching, 
* so to calculate length, that will be 2*1(length of b)+1(length of x) = 3 => bxb
*
*  for Other scenarios 
*  where i - represents where we insert new char
*        j - represents which char does this new char gonna match on other side of palindrome   
*  
*  Case 1: For (j>i), lets say we are inserting new char at ith index, and matching char index(j) on right side of i
*      - 1st part gives palindromic subtring length which comes before ith index and after jth index
*      - 2nd part gives palindromic subtrnig length which comes in between ith and jth index
*
*      Note: Here we are using (n-j-1) instead of j, while finding commen chars between original string and reversed string
*           - jth position on the origin string means, (n-j-1)th position in the reversed string
*  
*  Case 2: For (j==i), we are inserting new char left or right beside the jth char
       - So here only 1st part exists, because there will not be any substring between ith and jth char (i==j+1 or j-1)
*
*  Case 3: for (j<i), we are inserting new char to the right, and matching char index(j) on left side of i
*      - 
*/