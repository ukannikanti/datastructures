package datastructures.recursion;

import java.time.LocalDateTime;

public class Fibonacci {

  public int fibonacci(int number) {
    // Base case
    if (number == 0 || number == 1) {
      return number;
    }

    return fibonacci(number - 2) + fibonacci(number - 1);
  }

  public static void main(String... args) {
    Fibonacci fibonacci = new Fibonacci();
    int result = fibonacci.fibonacci(45);
    System.out.println(LocalDateTime.now());
    System.out.println(result);
    System.out.println(LocalDateTime.now());
  }
}
