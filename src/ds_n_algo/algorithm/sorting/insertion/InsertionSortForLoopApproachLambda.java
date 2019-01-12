package ds_n_algo.algorithm.sorting.insertion;

import java.util.function.Consumer;

/**
 * INSERTION SORT
 ----------------
 Sorts each item of the array as they encountered.

 Traverse : left to right.
         1. Use single pass.
         2. each item's left side is sorted and right side is unsorted.
         3. After completion of each traversal The current item is "inserted" into currect place of sorted section.

 Algorithm:
     1. One loop pointing 1st element , traverse from 0 th location to nth location.
     2. another loop pointing j, passing from (i-1) to 0 th locaton[Sorted Area] and swap shortest one;

 Advantage	: 	No additional space is needed, when memory space is sort
 Disadvantage:	Not appropriate for large unsorted data

 Performance	:
 1. Time complexity:
         Best Case	: 	O(n)  [ very good for best case, efficient when data is small and nearly sorted]
         Avg Case 	:	O(n^2)
         Worst Case 	: 	O(n^2)

 2. Space COmplexity:	O(n)
        It also operates directly from input array.
 */

interface iInsertionSort {
    public int[] doInsertionSorting(int[] arr);
}

public class InsertionSortForLoopApproachLambda {
    public static void main(String[] args) {
        iInsertionSort insertionSort = arr -> {

            OutterLoop:/*It maintains regular element (n) traversal of array*/
            for (int i = 1; i <= arr.length; i++) {

                InnerLoop:/*its maintain backward traversal*/
                for (int j = i - 1; j > 0; j--) {

                    SwapMenimum:/*chose two elements and swap lower one to left side*/
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            return arr;
        };

        Consumer<int[]> arrayConsumer = ints -> {
            for (int i : ints) {
                System.out.print(i + ",");
            }
        };
        int[] inPut = {5, 8, 2, 6, 9, 7, 4, 0, 1, 2, 3};
        insertionSort.doInsertionSorting(inPut);
    }

}
