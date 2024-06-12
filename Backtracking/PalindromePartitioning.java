package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * link: https://workat.tech/problem-solving/practice/palindromic-partitioning
 */

public class PalindromePartitioning {
  /*
   * Approach: 
   * - Start from the 0th index, and check for each substring till size of n whether its a palindrome, 
   *  - if this string (0 to i) is palindrome, call recursive funtion to check plindrome for string (i+1 to n)
   *  - if function call index reaches n, that means we have found all the partitions which are palindromes. 
   *        push the temp palidrome list to resultList
   */
  List<List<String>> resList;
	List<String> tempList;
	
	List<List<String>> getPartitions(String s) {
	    resList = new ArrayList<>();
		tempList = new ArrayList<>();
		
		int n = s.length();
		getPalindromes(s, n, 0);
		
		return resList;
	}
	
	void getPalindromes(String s, int n, int index){
		if(index >= s.length()){
			resList.add(new ArrayList(tempList));
      return;
		}
		
		for(int i=index; i<n; i++){
			String subStr = s.substring(index, i+1);
			if(isPalindrome(subStr)){
				tempList.add(subStr);
				getPalindromes(s, n, i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	boolean isPalindrome(String s){
		if(s.length() == 1){
			return true;
		}
		int n = s.length();
		for(int i=0; i<s.length()/2; i++){
			char left = s.charAt(i);
			char right = s.charAt(n-i-1);
			if(left!=right){
				return false;
			}
		}
		
		return true;
	}
}
