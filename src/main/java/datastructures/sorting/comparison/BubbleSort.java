package datastructures.sorting.comparison;

public class BubbleSort {

  public void sort(int[] items) {
    if (items == null || items.length < 1) {
      return;
    }
    for (int i = items.length; i >= 0; i--) {
      boolean swapped = false;
      for (int j = 0; j < items.length - 1; j++) {
        if (items[j] > items[j + 1]) {
          int temp = items[j];
          items[j] = items[j + 1];
          items[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
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
    BubbleSort bubbleSort = new BubbleSort();
    System.out.println("Before sorting......");
    bubbleSort.print(items);

    bubbleSort.sort(items);

    System.out.println("After sorting......");
    bubbleSort.print(items);
  }
}
