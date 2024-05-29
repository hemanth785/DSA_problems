package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Link: https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreak2 {
  List<String> resList;

  public List<String> wordBreak(String str, List<String> wordDict) {
    int n = str.length();
    resList = new ArrayList<>();
    Set<String> wordsSet = new HashSet<>(wordDict);

    wordBreakMemo(str, wordsSet, n, 0, 0, "");

    return resList;
  }

  void wordBreakMemo(String str, Set<String> wordsSet, int n, int l, int r, String tempRes) {
    if (r >= n - 1) {
      String subStr = str.substring(l, r + 1);
      if (wordsSet.contains(subStr)) {
        tempRes = tempRes + " " + subStr;
        resList.add(tempRes.trim());
      }
      return;
    }

    String subStr = str.substring(l, r + 1);
    if (wordsSet.contains(subStr)) {
      wordBreakMemo(str, wordsSet, n, r + 1, r + 1, tempRes + " " + subStr);
    }
    wordBreakMemo(str, wordsSet, n, l, r + 1, tempRes);

    return;
  }
}
