package PrePlaced.Recursion;

/*
 * Link: https://www.geeksforgeeks.org/problems/rank-the-permutations2229/1
 */
public class A08_Lexographical_rank_of_string {
  /*
   * Approach 1: 
   * If we take the word “rank”, 
   *  Total number of letters in the string - 4 
      For the first character , ‘r’ , there are 3 chars smaller than ‘r’ , in the alphabetical order. So, for r - 3*3! 
      Now , for 'a' - every word is greater than ‘a’ , so it will be 0*0! 
      For n , - 1*2! 
      For k , - 0*0! 
      Adding them all - 3*3! + 0 + 1*2! + 0 = 20

   * So, now implementation - For each character, we need to know the number of characters smaller than that on the right, 
   * and the number of characters left in the string to be processed. 
   * For every character, - (no. of character smaller than that) * (no.of character left in the string)!   
   * 
   * Time: O(n^2)
   */

  static long factorial(int num){
    if(num <= 1){
      return num;
    }
    return num * factorial(num-1);
  }

  static int getCountOfSmallerCharsOnRight(String str, int index){
    char ch = str.charAt(index);
    int count = 0;
    for(int i=index+1; i<str.length(); i++){
      if(str.charAt(i) < ch){
        count++;
      }
    }
    return count;
  }

  public long findRank(String str)
  {
    int n = str.length();
    long nFactorial = factorial(n);
    long rank = 1;
    
    for(int i=0; i<n; i++){
      int smallCharCount = getCountOfSmallerCharsOnRight(str, i);
      nFactorial = nFactorial/(n-i);
      
      rank += smallCharCount * nFactorial;
    }
    
    return rank;
  }


  /*
   * Optimiziong for time--
   * We can also have an O(n) solution by using some space. 
   * In this, we will take an auxiliary array or frequency array of 256 characters, 
   * and use that array to store the smaller elements on the right. 
   * 
   * Time: O(n)
   */

  static void populateInitialCount(int[] count, String str){
    for(char ch: str.toCharArray()){
      count[ch] = 1;
    }
    for(int i=1; i<256; i++){
      count[i] = count[i] + count[i-1];
    }
  }

  static void updateCount(int[] count, char ch){
    for(int i=ch; i<256; i++){
      count[i] = count[i]-1;
    }
  }

  public long findRank2(String str)
  {
    int n = str.length();
    long nFactorial = factorial(n);
    long rank = 1;
    
    int count[] = new int[256];
    populateInitialCount(count, str);
    
    for(int i=0; i<n; i++){
      nFactorial = nFactorial/(n-i);
      int smallCharCount = count[str.charAt(i)-1];
      
      rank += smallCharCount * nFactorial;
      updateCount(count, str.charAt(i));
    }
    
    return rank;
  }
}
