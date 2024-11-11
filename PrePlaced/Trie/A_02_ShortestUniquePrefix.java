package PrePlaced.Trie;

public class A_02_ShortestUniquePrefix {
  /*
   * Link: https://workat.tech/problem-solving/practice/shortest-unique-prefix
   * 
   */

  static int ALPHABETS = 26;
	static TrieNode root;
	static class TrieNode{
		TrieNode childNodes[] = new TrieNode[ALPHABETS];
		boolean endOfWord = false;
		int frequency = 0;
	}

	String[] getShortestUniquePrefixes(String[] words) {
		int n = words.length;
	  root = new TrieNode();
		String uniquePrefixArr[] = new String[n];
		
		for(String word : words){
			insertWord(word);
		}
		
		for(int i=0; i<n; i++){
			String uniquePrefix = findUnixPrefix(words[i]);
			uniquePrefixArr[i] = uniquePrefix;
		}
		
		return uniquePrefixArr;
	}
	
	void insertWord(String word){
		TrieNode cur = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			int index = ch - 'a';
			
			if(cur.childNodes[index] == null){
				cur.childNodes[index] = new TrieNode();
			}
			cur = cur.childNodes[index];
			cur.frequency = cur.frequency+1; //its importart to add the frequency in the next node
		}
		cur.endOfWord = true;
	}
	
	String findUnixPrefix(String word){
		TrieNode cur = root;
		String prefix = "";
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			prefix += ch;
			int index = ch - 'a';
			
			if(cur.childNodes[index] == null){
				return "";
			}
			cur = cur.childNodes[index];
			if(cur.frequency == 1){
				return prefix;
			}
		}
		return word;
	}
}
