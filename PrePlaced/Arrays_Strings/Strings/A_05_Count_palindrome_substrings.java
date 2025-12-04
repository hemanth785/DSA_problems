package Arrays_Strings.Strings;

/*
 * Link: https://leetcode.com/problems/palindromic-substrings/
 * 
 * Given a string s, return the number of palindromic substrings in it.

 * A string is a palindrome when it reads the same backward as forward.
 */
public class A_05_Count_palindrome_substrings {
    /*
     * Approach 1: Brute force
     * 
     * Using 2 nested for loops, get all the substrings of string, 
     * while check each substring if it is palindrome
     * 
     * Time: O(n^3)
     */


     /*
     * Approach 2: Efficient
     * 
     * Check for Even and Odd length palidromes separately, 
     * 1. for Odd length strings, start with single charector, then keep adding chars on both side to check whether it is still palindrome
     * 1. for Even length strings, start with double charector, then keep adding chars on both side to check whether it is still palindrome
     * 
     * Time: O(n^2)   Space: O(1)
     * 
     * Note: This is most optimized solution, Even with DP time complexity would be O(n^2) only
     */


    public int countSubstrings(String str) {
        int n = str.length();
        int palindromeCount = 0;

        //check for substring with odd length
        for(int i=0; i<n; i++){
            palindromeCount++;
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<n){
                if(str.charAt(l) != str.charAt(r)){
                    break;
                }
                palindromeCount++;
                l--;
                r++;
            }
        }

        //check for substring with even length
        for(int i=0; i<n-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                palindromeCount++;
                int l = i-1;
                int r = i+2;

                while(l>=0 && r<n){
                    if(str.charAt(l) != str.charAt(r)){
                        break;
                    }
                    palindromeCount++;
                    l--;
                    r++;
                }
            }
        }

        return palindromeCount;
    }
}
