package PrePlaced.Trie;

/*
 * Link: https://leetcode.com/problems/longest-common-prefix/
 */
class A_07_LongestStringWithPrefix{
  /*
   * Approach:
   * - Add all word to trie with words count in each node
   * - The for each word, search for prefix in trie, which is present in all the given words (where n is total number of words given)
   * - then compare that prefix with max length prefix
   */
  static class TrieNode{
		TrieNode childNodes[];
		boolean endOfWord = false;
		int wordCount = 0;

		TrieNode(){
			childNodes = new TrieNode[26];
		}
	}


	static TrieNode root;

	public static String longestCommonPrefix(String[] arr, int n) {
		root = new TrieNode();

		for(int i=0; i<n; i++){
			insertWord(arr[i], root);
		}

		//check longest common prefix
		String resPrefix = "";

		for(int i=0; i<n; i++){
			String longPrefix = longestPrefix(arr[i], root, n);
			if(longPrefix.length() > resPrefix.length()){
				resPrefix = longPrefix;
			}
		}

		return resPrefix;

	}

	static String longestPrefix(String word, TrieNode root, int n){
		String commonPrefix = "";
		for(char ch: word.toCharArray()){
			int index = ch-'a';

			if(root.childNodes[index].wordCount < n){
				return commonPrefix;
			}

			commonPrefix += ch;
			root = root.childNodes[index];
		}

		return commonPrefix;
	}

	static void insertWord(String word, TrieNode root){
		for(char ch: word.toCharArray()){
			int index = ch-'a';

			if(root.childNodes[index] == null){
				root.childNodes[index] = new TrieNode();
			}

			root = root.childNodes[index];
			root.wordCount += 1;
		}

		root.endOfWord = true;
	}
}