package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Link: https://workat.tech/problem-solving/practice/word-ladder
 * 
 * solution ref: https://www.youtube.com/watch?v=2odLxQWYDi0
 * 
 * Solution:
 * 1. Start by pushing beginWord to queue
 * 2. Pop the top entry(beginWord) from queue, do the folloing
 *    - Change the each charactor of curWord, from a-z and form a newWord
 *    - First check if this new word matches endWord, if yes, return length+1 (length here descripts number of times queue become empty)
 *    - else check if newWord is present in the WordList given, if yes - push it to 'Queue' and remove it from 'Set' (wordList)
 * 3. If nothing found, return 0;
 */

public class A_16_WordLadder {
  int shortestLadderLength(String beginWord, String endWord, String[] wordList) {
    int wordLen = beginWord.length();
    int n = wordList.length;

    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(wordList[i]);
    }

    // edge case check
    if (!set.contains(endWord)) {
      return 0;
    }

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    int length = 0;

    while (!queue.isEmpty()) {
      int qSize = queue.size();
      length++;

      //loop through each word currently present in queue
      for (int i = 0; i < qSize; i++) {
        String curWord = queue.remove();

        // loop through each charector of currentWord
        for (int j = 0; j < wordLen; j++) {
          char temp[] = curWord.toCharArray();

          // change the each charector from a to z, and check if it matches with any word in word list
          for (char ch = 'a'; ch <= 'z'; ch++) {
            temp[j] = ch;
            String newWord = new String(temp);

            // check if it matches endWord
            if (newWord.equals(endWord)) {
              return length + 1;
            }

            if (set.contains(newWord)) {
              queue.add(newWord);
              set.remove(newWord);
            }
          }
        }
      }
    }

    return 0;
  }
}
