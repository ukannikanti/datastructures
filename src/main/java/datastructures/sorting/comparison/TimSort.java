package datastructures.sorting.comparison;

public class TimSort {
  private int stackSize = 0;  // Number of pending runs on stack
  private int[] runBase;
  private int[] runLen;

  public void sort(Object[] a) {
    int stackLen = (a.length < 120 ? 5 : a.length < 1542 ? 10 : a.length < 119151 ? 24 : 49);
    runBase = new int[stackLen];
    runLen = new int[stackLen];
    int hi = a.length;
    int lo = 0;
    int nRemaining = hi - lo;
    int minRun = 32;

    do {
      int runLen = countRunAndMakeAscending(a, lo, hi);

      // If run is short, extend to min(minRun, nRemaining)
      if (runLen < minRun) {
        int force = nRemaining <= minRun ? nRemaining : minRun;
        binarySort(a, lo, lo + force, lo + runLen);
        runLen = force;
      }

      // Push run onto pending-run stack, and maybe merge
      pushRun(lo, runLen);
      mergeCollapse();

      // Advance to find next run
      lo += runLen;

      nRemaining -= runLen;

    } while (nRemaining != 0);

  }

  public void pushRun(int runBase, int runLen) {
    this.runBase[stackSize] = runBase;
    this.runLen[stackSize] = runLen;
    stackSize++;
  }

  public void binarySort(Object[] a, int lo, int hi, int start) {
    assert lo <= start && start <= hi;

    if (start == lo)
      start++;

    for (; start < hi; start++) {
      Comparable pivot = (Comparable) a[start];

      // Set left (and right) to the index where a[start] (pivot) belongs
      int left = lo;
      int right = start;
      assert left <= right;
      /*
       * Invariants:
       *   pivot >= all in [lo, left).
       *   pivot <  all in [right, start).
       */
      while (left < right) {
        int mid = (left + right) >>> 1;
        if (pivot.compareTo(a[mid]) < 0)
          right = mid;
        else
          left = mid + 1;
      }
      assert left == right;

      /*
       * The invariants still hold: pivot >= all in [lo, left) and
       * pivot < all in [left, start), so pivot belongs at left.  Note
       * that if there are elements equal to pivot, left points to the
       * first slot after them -- that's why this sort is stable.
       * Slide elements over to make room for pivot.
       */
      int n = start - left;  // The number of elements to move
      // Switch is just an optimization for arraycopy in default case
      switch (n) {
        case 2:
          a[left + 2] = a[left + 1];
        case 1:
          a[left + 1] = a[left];
          break;
        default:
          System.arraycopy(a, left, a, left + 1, n);
      }
      a[left] = pivot;
    }
  }

  private void mergeCollapse() {
    while (stackSize > 1) {
      int n = stackSize - 2;
      if (n > 0 && runLen[n - 1] <= runLen[n] + runLen[n + 1]) {
        if (runLen[n - 1] < runLen[n + 1])
          n--;
        mergeAt(n);
      } else if (runLen[n] <= runLen[n + 1]) {
        mergeAt(n);
      } else {
        break; // Invariant is established
      }
    }
  }

  private void mergeAt(int i) {
    int base1 = runBase[i];
    int len1 = runLen[i];
    int base2 = runBase[i + 1];
    int len2 = runLen[i + 1];

    runLen[i] = len1 + len2;
    if (i == stackSize - 3) {
      runBase[i + 1] = runBase[i + 2];
      runLen[i + 1] = runLen[i + 2];
    }
    stackSize--;



  }

  public int countRunAndMakeAscending(Object[] a, int lo, int hi) {
    assert lo < hi;
    int runHi = lo + 1;
    if (runHi == hi)
      return 1;

    // Find end of run, and reverse range if descending
    if (((Comparable) a[runHi++]).compareTo(a[lo]) < 0) { // Descending
      while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) < 0)
        runHi++;
      reverseRange(a, lo, runHi);
    } else {                              // Ascending
      while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) >= 0)
        runHi++;
    }

    return runHi - lo;
  }

  private static void reverseRange(Object[] a, int lo, int hi) {
    hi--;
    while (lo < hi) {
      Object t = a[lo];
      a[lo++] = a[hi];
      a[hi--] = t;
    }
  }

  private int minRunLength(int n) {
    int r = 0;      // Becomes 1 if any 1 bits are shifted off
    while (n >= 32) {
      r |= (n & 1);
      n >>= 1;
    }
    return n + r;
  }

  public static void main(String... args) {
    TimSort sort = new TimSort();
    String text =
        "Peters designed Timsort to use already-ordered elements that exist in most real-world data sets. It calls these already-ordered elements “natural runs”. It iterates over the data collecting the elements into runs and simultaneously merging those runs together into one An insertion sort is a simple sort which is most effective on small lists. It is quite slow at larger lists, but very fast with small lists. The idea of an insertion sort is as follows";
    String[] str = text.split(" ");
    sort.sort(str);

    //    Arrays.asList(str).stream().forEach(v -> System.out.println(v));
  }
}

