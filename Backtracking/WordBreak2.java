package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Link: https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreak2 {
  List<String> sentenceList;

  public List<String> wordBreak(String str, List<String> wordDict) {
    int n = str.length();
		sentenceList = new ArrayList<>();
	  Set<String> wordsSet = new HashSet<>(wordDict);
		
		wordBreakRec(str, wordsSet, n, 0, "");
		
		return sentenceList;
  }

  void wordBreakRec(String str, Set<String> wordsSet, int n, int index, String tempRes){
		if(index >= n){
      sentenceList.add(tempRes.trim());
      return;
    }

    for(int i=index+1; i<=n; i++){
      String subStr = str.substring(index, i);
      if(wordsSet.contains(subStr)){
        wordBreakRec(str, wordsSet, n, i, tempRes+" "+subStr);
      }
    }
	}
}
