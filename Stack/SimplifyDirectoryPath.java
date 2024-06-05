package Stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * Link: https://workat.tech/problem-solving/practice/simplify-directory-path
 * Given a string 'path' representing the absolute path of a file in a Unix-like file system, simplify it.
 */
public class SimplifyDirectoryPath {

  /*
   * Approach: Using stack: link: https://www.youtube.com/watch?v=kVylYewnQ_k
   */

  public static void main(String[] args) {
    String path = "/.../a/../b//c/../d/./";
    String canonicalResult = simplifyPath(path);
    System.out.println("canonical path: "+canonicalResult);
  }

  static String simplifyPath(String path) {
    String result = "";
    Stack<String> stack = new Stack<>();

    String[] tokens = path.split("/+");

    System.out.println(Arrays.toString(tokens));

    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i].trim();
      if (token.equals(".") || token.equals("")) {
        continue;
      }
      if (!token.equals("..")) { //if not '..', push it to stack
        stack.push(token);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }

    while (!stack.isEmpty()) {
      String slash = (result == "") ? "" : "/";
      result = stack.pop() + slash + result;
    }
    result = "/" + result;
    return result;
  }
}
