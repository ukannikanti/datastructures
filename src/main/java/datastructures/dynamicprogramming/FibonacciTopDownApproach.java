package datastructures.dynamicprogramming;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FibonacciTopDownApproach {

  private Map<Integer, Integer> map = new HashMap<>();

  public int fibonacci(int number) {
    if (number == 0 || number == 1) {
      map.put(0, 0);
      map.put(1, 1);
      return number;
    }

    Integer value = map.get(number);

    if (value != null) {
      return value;
    }

    return fibonacci(number - 2) + fibonacci(number - 1);
  }

  public static void main(String... args) {
    FibonacciTopDownApproach obj = new FibonacciTopDownApproach();
    System.out.println(LocalDateTime.now());
    System.out.println(obj.fibonacci(45));
    System.out.println(LocalDateTime.now());
  }
}
