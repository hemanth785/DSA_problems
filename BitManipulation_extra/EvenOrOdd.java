package BitManipulation_extra;

public class EvenOrOdd {
  public static void main(String[] args) {
    int n = 11;
    String evenorodd = (n&1) == 0 ? "even" : "odd";
    System.out.println(evenorodd);
    /*
     * we can find even or odd by applying bitwise & between number and 1
     * if result is zero, its odd. or its even
    */
  }
}
