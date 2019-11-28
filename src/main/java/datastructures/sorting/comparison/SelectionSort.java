package datastructures.sorting.comparison;

public class SelectionSort {

  public void sort(int[] items) {
    for (int i = 0; i < items.length; i++) {
      int minIndex = i;

      for (int j = i; j < items.length; j++) {
        if (items[j] < items[minIndex]) {
          minIndex = j;
        }
      }

      int smallerNumber = items[minIndex];
      items[minIndex] = items[i];
      items[i] = smallerNumber;
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
    SelectionSort sort = new SelectionSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
