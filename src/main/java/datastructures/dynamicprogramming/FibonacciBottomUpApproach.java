package datastructures.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciBottomUpApproach {

  private Map<Integer, Integer> map = new HashMap<>();

  public int fibonacci(int number) {
    map.put(0, 0);
    map.put(1, 1);

    for(int i = 2; i <= number; i++) {
      map.put(i, map.get(i - 1) + map.get(i - 2));
    }
    return map.get(number);
  }

  public static void main(String... args) {
    FibonacciBottomUpApproach obj = new FibonacciBottomUpApproach();
    System.out.println(obj.fibonacci(8));
  }
}
