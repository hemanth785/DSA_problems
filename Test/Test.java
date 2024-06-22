package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    int index = 6;
    int parentIndex = index == 1 ? 0 : (index-1)/2;
    System.out.println(parentIndex);
  }
}
