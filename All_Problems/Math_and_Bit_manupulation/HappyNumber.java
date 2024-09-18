package Math_and_Bit_manupulation;

import java.util.HashSet;

public class HappyNumber {
  public static void main(String[] args) {
    System.out.print(isHappy(2));
  }

  public static boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    set.add(n);

    while (n > 1) {
      // System.out.println("n: "+n);
      int digitSquareSum = 0;
      while (n > 0) {
        digitSquareSum += n > 9 ? (n % 10) * (n % 10) : n * n;
        n = n / 10;
      }
      System.out.println("digitSquareSum: "+digitSquareSum);
      if (set.contains(digitSquareSum)) {
        return false;
      }
      set.add(digitSquareSum);
      n = digitSquareSum;
    }

    return true;
  }
}
