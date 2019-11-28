package datastructures.sorting.comparison;

public class QuickSort {

  public void sort(int items[], int start, int end) {
    if (start < end) {
      int partitionIndex = partition(items, start, end);
      sort(items, start, partitionIndex - 1);
      sort(items, partitionIndex + 1, end);
    }
  }

  public int partition(int items[], int start, int end) {
    int pivot = items[end];
    int i = (start - 1);

    for (int j = start; j < end; j++) {
      if (items[j] <= pivot) {
        i++;
        int swapTemp = items[i];
        items[i] = items[j];
        items[j] = swapTemp;
      }
    }

    int swapTemp = items[i + 1];
    items[i + 1] = items[end];
    items[end] = swapTemp;

    return i + 1;
  }

  private void print(int[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.print(items[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String... args) {
    int[] items = {15, 8, 7, 4, 6, 14, 18, 5};
    QuickSort sort = new QuickSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items, 0, items.length - 1);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
