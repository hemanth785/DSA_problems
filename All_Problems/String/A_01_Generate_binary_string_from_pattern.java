/*
 * Link: https://www.geeksforgeeks.org/problems/generate-binary-string3642/1
 */

import java.util.LinkedList;
import java.util.Queue;

class A_01_Generate_binary_string_from_pattern {
  /*
   * Approach 1: Using Recursion
   * 
   */

  /*
   * Approach 2: Using queue
   * 
   */
  static void print(String str)
  {
    Queue<String> q = new LinkedList<>();
    q.add(str);

    while (!q.isEmpty())
    {
      str = q.remove();

      // find position of first occurrence of wildcard
      int index = str.indexOf('?');

      // If no matches were found,
      // find returns string::npos
      if(index != -1)
      {
        // replace '?' by '0' and add string into queue
        str = str.substring(0,index) + '0' + str.substring(index+1);
        q.add(str);

        // replace '?' by '1' and add string into queue
        str = str.substring(0,index) + '1' + str.substring(index+1);
        q.add(str);
      }

      else {
        // If no wildcard characters are left,
        // print the string.
        System.out.println(str);
      }

    }
  }
}