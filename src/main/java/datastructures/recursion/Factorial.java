package datastructures.recursion;

public class Factorial {

  public int factorial(int n) {
    // Check for base case
    if (n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  public static void main(String... args){
    Factorial factorial = new Factorial();
    int result = factorial.factorial(4);
    System.out.println(result);
  }
}

