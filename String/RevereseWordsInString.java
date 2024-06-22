package String;

import java.util.Stack;

/*
 * Reverese a order of words in string
 * Input: "this is a DSA course";
 * Output: "course DSA a is this";
 */
public class RevereseWordsInString {
  public static void main(String args[]){
    String input = "this is a DSA course";
    // String output = reverseUsingStack(input);
    String output = reverseWithoutStack(input);
    System.out.println("Reversed string is: "+output);
  }

  /*
   * Solution 1: using stack
   */
  public static String reverseUsingStack(String input){
    Stack<String> stack = new Stack<>();

    String word = "";
    for(int i=0; i<input.length(); i++){
      char charector = input.charAt(i);
      if(charector == ' '){
        stack.push(word);
        word = "";
      } else {
        word = word + charector; 
      }
    }
    stack.push(word);

    String output = "";
    while(!stack.isEmpty()){
      if(stack.size() > 1){
        output = output + stack.pop() +" ";
      } else {
        output = output + stack.pop();
      }
    }

    return output;
  }


  /*
   * Solution 2: Without stack
   */
  public static String reverseWithoutStack(String input){
    String output = "";
    String word = "";
    for(int i=0; i<input.length(); i++){
      char charector = input.charAt(i);
      if(charector == ' '){
        output = word + " " + output;
        word = "";
      } else {
        word = word + charector; 
      }
    }
    output = word + " " + output;
    return output;
  }
}
