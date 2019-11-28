package datastructures.sorting.comparison;

public class InsertionSort {

  public void sort(int[] items) {
    int temp;
    for (int i = 1; i < items.length; i++) {
      for (int j = i; j > 0 && items[j - 1] > items[j]; j--) {
        if (items[j] < items[j - 1]) {
          temp = items[j];
          items[j] = items[j - 1];
          items[j - 1] = temp;
        }
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
    int[] items = {6, 5, 4, 3, 2, 1};
    InsertionSort sort = new InsertionSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
