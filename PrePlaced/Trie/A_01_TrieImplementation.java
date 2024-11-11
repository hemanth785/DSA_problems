package PrePlaced.Trie;

public class A_01_TrieImplementation {
  private static final int  ALPHABET_COUNT = 26;
  public static class TrieNode{
    TrieNode childNodes[] = new TrieNode[ALPHABET_COUNT];
    boolean isEndOfWord;

    //initialize all the child with null values, NOTE:without this also works
    // TrieNode(){
    //   for(int i=0; i<ALPHABET_COUNT; i++){
    //     childNodes[i] = null;
    //   }
    // }
  }

  private static TrieNode root;

  public static void insert(String word){
    TrieNode cur = root;
    for(int i=0; i<word.length(); i++){
      char charector = word.charAt(i);
      int index = charector - 'a';
      /* 
        here we are not actually storing the charactors, 
        we are just filling the index of charector with new node, indication this charector exists
        we can do this because at particular index (from 0-25), only one charector can exists from a-z
      */
      if(cur.childNodes[index] == null){
        cur.childNodes[index] = new TrieNode();
      }
      
      cur = cur.childNodes[index];
    }
    cur.isEndOfWord = true;
  }

  public static boolean search(String word){
    TrieNode cur = root;
    for(int i=0; i<word.length(); i++){
      int index = word.charAt(i) - 'a';
      // if any charector of string does not exists in trie, we can confirm that word does not exists
      if(cur.childNodes[index] == null){
        return false;
      }
      cur = cur.childNodes[index];
    }
    //if all chars exists, one that confirms the existance of word is flag 'endOfWord'
    return cur.isEndOfWord;
  }

  public static void main(String[] args) {
    root = new TrieNode();
    String[] keys = {"ant", "and", "cool", "batman"};

    for(String word: keys){
      insert(word);
    }

    if(search("ant")){
      System.out.println("ant exists");
    } else {
      System.out.println("ant does not exists");
    }

    if(search("bat")){
      System.out.println("bat exists");
    } else {
      System.out.println("bat does not exists");
    }

    if(search("batman")){
      System.out.println("batman exists");
    } else {
      System.out.println("batman does not exists");
    }
  }
}
