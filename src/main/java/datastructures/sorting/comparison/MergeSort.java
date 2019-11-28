package datastructures.sorting.comparison;

public class MergeSort {

  public void sort(int[] items) {
    int length = items.length;
    if (length < 2) {
      return;
    }
    int middle = length / 2;
    int[] left = new int[middle];
    int[] right = new int[length - middle];

    for (int i = 0; i < middle; i++) {
      left[i] = items[i];
    }
    for (int i = middle; i < length; i++) {
      right[i - middle] = items[i];
    }

    sort(left);
    sort(right);
    merge(items, left, right, middle, length - middle);
  }

  public void merge(int[] items, int[] left, int[] right, int leftLength, int rightLength) {

    int i = 0, j = 0, k = 0;
    while (i < leftLength && j < rightLength) {
      if (left[i] <= right[j]) {
        items[k++] = left[i++];
      } else {
        items[k++] = right[j++];
      }
    }
    while (i < leftLength) {
      items[k++] = left[i++];
    }
    while (j < rightLength) {
      items[k++] = right[j++];
    }
  }

  private void print(int[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.print(items[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String... args) {
    //int[] items = {2, 7, 4, 5, 8, 2, 0, 23, 45, 90, 21, 12};
    int[] items = {9, 3, 7, 5, 6, 4, 8, 2};
    MergeSort sort = new MergeSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
