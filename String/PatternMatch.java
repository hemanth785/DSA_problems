package String.java;

/*
 * For a given input string, return a index at which pattern strin exists
 * Input: 
 * String = "abcdabdc";
 * pattern = "dab";
 * 
 * output = 3
 * 
 */
public class PatternMatch {
  public static void main(String args[]){
    String inputString = "abcdabdf";
    String pattern = "cdab";

    int output = patternMatchUsingRabinKarp(inputString, pattern);
    System.out.println("Pattern found at: "+output);
  }

  /*
   * Solution 1: Bruteforce
   * Using sliding window technique
   * 
   * time: O(n*m), Space: O(1)
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
   * Appraoch 2: Using Rabin karp algorith (Optimized) - we can use it for other pattern matching problems
   * 
   * Time: O(n), Space: O(n)
   */
  public static int patternMatchUsingRabinKarp(String input, String pattern){
    //first calculate the hash value for pattern and initial substtrin of pattern lenghth
    int n = input.length();
    int k = pattern.length();

    int pHash=0, sHash=0;

    // here we are taking prime number as 3. We can take any prime number as mod
    for(int i=0; i<k; i++){
      pHash += pattern.charAt(i) * Math.pow(3, i);
      sHash += input.charAt(i) * Math.pow(3, i);
    }

    int l = 0;
    int r = k-1;
    while(r < n){
      System.out.println("pHash: "+pHash+", sHash: "+sHash);
      if(pHash == sHash){
        //if hash is matched, we need to verify by comparing charectors
        //Hash value might not be 100% unique all the times
        int i = l;
        int j = 0;

        while(j<k){
          if(input.charAt(i) != pattern.charAt(j)){
            break;
          }
          i++;
          j++;
        }
        if(j>=k){
          return l;
        }
      }

      //calculate new hash removing  out of window value and adding new value
      /* pHash = 34, a=1, b=2, c=3, new char d = 4
       * step 1: remove left side charector ascii value
       *  - 34-1 =>  phash = 33
       * step 2: device resulting number by prime numer used, i.e. 3
       *  - 33/3 = 11
       * step 3: add the next charector ascii value to pHash, i.e d (4)
       *  - 11 + 4*(3^2) = 45
       * 
       * new pHas = 45
       */
      if(r < n){
        sHash = (sHash - input.charAt(l))/3 + (input.charAt(r+1) * (int)Math.pow(3, k-1)) ;
      }

      l++;
      r++;
    }
    return -1;
  }
}
