package Stack;

import java.util.Stack;

/*
 * Link: https://workat.tech/problem-solving/practice/simplify-directory-path
 * Given a string 'path' representing the absolute path of a file in a Unix-like file system, simplify it.
 */
public class SimplifyDirectoryPath {

  /*
   * Approach: Using stack: link: https://www.youtube.com/watch?v=kVylYewnQ_k
   */

  String simplifyPath(String path) {
    String canonical = "";
    Stack<String> stack = new Stack<>();

    String[] tokens = path.split("/+");

    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i].trim();
      if (token.equals(".") || token.equals("")) {
        continue;
      }
      if (!token.equals("..")) {
        stack.push(token);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }

    while (!stack.isEmpty()) {
      String slash = canonical == "" ? "" : "/";
      canonical = stack.pop() + slash + canonical;
    }
    canonical = "/" + canonical;
    return canonical;
  }
}
