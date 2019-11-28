package datastructures.sorting.comparison;

public class BinaryInsertionSort {

  public int binarySearch(int items[], int item, int low, int high) {
    if (high <= low) {
      return (item > items[low]) ? (low + 1) : low;
    }

    int mid = (low + high) / 2;

    if (item == items[mid])
      return mid + 1;
    if (item > items[mid])
      return binarySearch(items, item, mid + 1, high);
    return binarySearch(items, item, low, mid - 1);
  }

  public void insertionSort(int items[]) {
    for (int i = 1; i < items.length; ++i) {
      int start = i - 1;
      int selected = items[i];
      int index = binarySearch(items, selected, 0, start);

      while (start >= index) {
        items[start + 1] = items[start];
        start--;
      }
      items[start + 1] = selected;
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
    BinaryInsertionSort sort = new BinaryInsertionSort();
    System.out.println("Before sorting......");
    sort.print(items);
    sort.insertionSort(items);
    System.out.println("After sorting......");
    sort.print(items);
  }
}
