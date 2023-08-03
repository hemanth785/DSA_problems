package Maths;

public class Swap_two_numbers {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;
    int[] res = swap2(a, b);

    System.out.print("a"+res[0]+", b:"+res[1]);
  }

  /* By using 'temp' variable */
  public static int[] swap1(int a, int b){
    int temp = a;
    a = b;
    b = temp;

    return new int[]{a, b};
  }

  /* Without using 'temp' variable | In place swapping */
  public static int[] swap2(int a, int b){  //a=10, b=5
    a = a + b;   //a=15, b=5
    b = a - b;   //a=15, b=10
    a = a - b;   //a=5, b=10

    return new int[]{a, b};
  }
}
