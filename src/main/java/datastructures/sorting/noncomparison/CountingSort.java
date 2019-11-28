package datastructures.sorting.noncomparison;

public class CountingSort {

  public void sort(int[] items, int maxValue) {

    int[] count = new int[maxValue + 1];

    for (int i = 0; i < items.length; i++) {
      count[items[i]]++;
    }

    for (int i = 0, j = 0; i <= maxValue; i++) {
      int tmp = count[i];
      while (tmp-- > 0) {
        items[j] = i;
        j++;
      }
    }
  }

  private void print(int[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.print(items[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String... args) {
    int[] items = {2, 7, 4, 5, 8, 2, 0, 23, 45, 90, 21, 12};
    CountingSort sort = new CountingSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items, 95);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
