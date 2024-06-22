import java.util.ArrayList;
import java.util.List;

public class FindContacts {
  /*
   * Link: https://www.hackerrank.com/contests/mock-interview-test-1713867398/challenges/contacts
   */

   /*
    * Note: Here the fequency/count will be stored in all the nodes other than root node
    */

   static int ALPHABETS = 26;

  static class TrieNode {
    TrieNode childNodes[] = new TrieNode[ALPHABETS];
    boolean endOfWord = false;
    int frequency = 0;
  }

  public static List<Integer> contacts(List<List<String>> queries) {
    TrieNode root = new TrieNode();

    List<Integer> countList = new ArrayList<>();
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String queryType = query.get(0);
      String word = query.get(1);

      if (queryType.equals("add")) {
        insertWord(root, word);
      } else {
        int numOfWords = findWord(root, word);
        countList.add(numOfWords);
      }
    }

    return countList;
  }

  public static void insertWord(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';

      if (cur.childNodes[index] == null) {
        cur.childNodes[index] = new TrieNode();
      }
      cur = cur.childNodes[index];
      cur.frequency = cur.frequency + 1; //we are adding frequency to child node pointing from current node, because while fetching fetch it from child node only
    }
    cur.endOfWord = true;
  }

  public static int findWord(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';

      if (cur.childNodes[index] == null) {
        return 0;
      }
      cur = cur.childNodes[index];
    }
    return cur.frequency;
  }
}
