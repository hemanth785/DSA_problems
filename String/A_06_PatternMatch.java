package String;

/*
 * For a given input string, return a index at which pattern string exists
 * Input: 
 * String = "abcdabdc";
 * pattern = "dab";
 * 
 * output = 3
 * 
 */
public class A_06_PatternMatch {
  public static void main(String args[]){
    String inputString = "abcdabdf";
    String pattern = "bdf";

    // int output = patternMatchUsingRabinKarp(inputString, pattern);
    int output = patternMatchUsingKMP(inputString, pattern);
    System.out.println("Pattern found at: "+output);
  }

  /*
   * Solution 1: Bruteforce
   * Using sliding window technique
   * 
   * Time: O(n*m), Space: O(1)
   * where m is the size of pattern
   */

  public static int patternMatch1(String input, String pattern){
    int n = input.length();
    int k = pattern.length();

    int l = 0;
    int r = k-1;

    while(r < n){
      if(input.charAt(l) == pattern.charAt(0)){
        int i = l+1;
        int j = 1;

        while(j<k){
          if(input.charAt(i) != pattern.charAt(j)){
            break;
          }
          i++;
          j++;
        }

        //pattern matched
        if(j>=k){
          return l;
        }
      }
      l++;
      r++;
    }

    return -1;
  }

  /*
   * Appraoch 2: Using Rabin karp algorithm (Optimized) - Which uses Rolling hash function to match the pattern
   * Link: https://www.youtube.com/watch?v=qQ8vS2btsxI
   * 
   * Time: O(n), Space: O(n)
   */
  public int strStr(String input, String pattern) {
    int n = input.length();
    int k = pattern.length();

    if (k > n) {
      return -1;
    }
    if (n == k && pattern.equals(input)) {
      return 0;
    }

    int pHash = 0, sHash = 0;

    // here we are taking prime number as 3. We can take any prime number as mod
    for (int i = 0; i < k; i++) {
      pHash += pattern.charAt(i) * Math.pow(3, i);
      sHash += input.charAt(i) * Math.pow(3, i);
    }

    int l = 0;
    int r = k;

    if (pHash == sHash) {
      if (confirmPatternMatch(input, pattern, l, r)) {
        return l;
      }
    }

    while (r < n) {
      if (pHash == sHash) {
        // if hash is matched, we need to verify by comparing charactors
        // Because hash value might not be 100% unique all the times
        if (confirmPatternMatch(input, pattern, l, k)) {
          return l;
        }
      }

      // calculate new hash removing out of window value and adding new value
      /*
       * pHash = 34, a=1, b=2, c=3, new char d = 4
       * step 1: remove left side charector ascii value
       * - 34-1 => phash = 33
       * step 2: device resulting number by prime numer used, i.e. 3 (This is required
       * because we are decrementing power 3 values by 1, for all char values. (a*3^1
       * + b*3^2) becomes (a*3^0 + b*3^1))
       * - 33/3 = 11
       * step 3: add the next charector ascii value to sHash, i.e d (4)
       * - 11 + 4*(3^2) = 45
       * 
       * new pHas = 45
       */
      if (r < n) {
        sHash = (sHash - input.charAt(l)) / 3 + (input.charAt(r) * (int) Math.pow(3, k - 1));
      }

      l++;
      r++;
    }

    if (pHash == sHash) {
      // if hash is matched, we need to verify by comparing charactors
      // Because hash value might not be 100% unique all the times
      if (confirmPatternMatch(input, pattern, l, k)) {
        return l;
      }
    }
    return -1;
  }

  public boolean confirmPatternMatch(String input, String pattern, int l, int k) {
    int i = l;
    int j = 0;

    while (j < k) {
      if (input.charAt(i) != pattern.charAt(j)) {
        break;
      }
      i++;
      j++;
    }

    if (j >= k) {
      return true;
    }
    return false;
  }

  
  /*
   * Aproach 4: Using KMP algorithm (Kruth Morris Prat)
   */

  public static int patternMatchUsingKMP(String input, String pattern){
    int kmpPattern[] = new int[pattern.length()];

    int j=0, i=1;
    kmpPattern[0] = 0;
    //build kmp pattern array
    while(i<pattern.length()){
      char iChar = pattern.charAt(i);
      char jChar = pattern.charAt(j);

      //if its matching, increment j and assign pattern value
      if(iChar == jChar){
        kmpPattern[i] = j+1;
        j++;
        i++;
      } else {
        if(j==0){
          kmpPattern[i] = 0;
          i++;
        } else {
          j = kmpPattern[j-1];
        }
      }
    }

    //search for pattern in given array
    i=0;
    j=0;
    while(i<input.length() && j<pattern.length()){
      char inputChar = input.charAt(i);
      char patternChar = pattern.charAt(j);
      if(inputChar == patternChar){
        i++;
        j++;
      } else {
        if(j== 0){
          i++;
        } else {
          j = kmpPattern[j-1];
        }
      }
    }

    if(j == pattern.length()){
      return i-pattern.length();
    }
    return -1;
  }
  
}
