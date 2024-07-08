package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */

public class A_15_LetterCombinationOfPhoneNumber {
  static void fillAlphsForNumbers(Map<Character, String> numAlphaMap){
		numAlphaMap.put('2', "abc");
		numAlphaMap.put('3', "def");
		numAlphaMap.put('4', "ghi");
		numAlphaMap.put('5', "jkl");
		numAlphaMap.put('6', "mno");
		numAlphaMap.put('7', "pqrs");
		numAlphaMap.put('8', "tuv");
		numAlphaMap.put('9', "wxyz");
	}
	
	static List<String> resList;

  public static void main(String[] args) {
    List<String> result = letterCombinations("12");
  }

	static List<String> letterCombinations(String digits) {
		int n = digits.length();
		
		Map<Character, String> numAlphaMap = new HashMap<>();
		fillAlphsForNumbers(numAlphaMap);
		
		List<String> alphaList = new ArrayList<>();

	  for(int i=0; i<n; i++){
			char ch = digits.charAt(i);
			alphaList.add(numAlphaMap.get(ch));
		}
		
		resList = new ArrayList<>();
		formLetterCombinationRec(alphaList, n, 0, "");
		
		return resList;
	}
	
	static void formLetterCombinationRec(List<String> alphaList, int n, int index, String resString){
		if(index == n){
			resList.add(resString);
			return;
		}
    //get string related to number at index
		String alphaStr = alphaList.get(index);
    //loop through all the chars for that string and keep forming new string using next digit string
		for(int i=0; i<alphaStr.length(); i++){
			formLetterCombinationRec(alphaList, n, index+1, resString+alphaStr.charAt(i));
		}
	}
}
