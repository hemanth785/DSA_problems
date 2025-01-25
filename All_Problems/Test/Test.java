package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  private static final int  INITIAL_SIZE = 1<<4; //16
  private static final int MAXIMUM_CAPACITY = 1 << 30;

  //This function used to get the next 2 power number for given capacity
  private static int tableSizeFor(int cap) {
    int n = cap - 1;
    System.out.println("n-0: "+n);
    n |= n >>> 1;
    System.out.println("n-1: "+n);
    n |= n >>> 2;
    System.out.println("n-2: "+n);
    n |= n >>> 4;
    System.out.println("n-3: "+n);
    n |= n >>> 8;
    System.out.println("n-4: "+n);
    n |= n >>> 16;
    System.out.println("n-5: "+n);

    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }

  public static void main(String[] args) {
    int size = tableSizeFor(8);
    System.out.println("tableSize: "+size);

    // int n = 14;
    // System.out.println("n: "+n);
    // System.out.println(n >>> 2);
  }

}




