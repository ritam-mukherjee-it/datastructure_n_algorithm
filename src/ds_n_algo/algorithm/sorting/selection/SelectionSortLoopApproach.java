package ds_n_algo.algorithm.sorting.selection;

/**
 * SELECTION SORT
 ---------------------------
 Sort the data by finding  or SELECT shortest element and swapping it into  the ARRAY in the first unsorted location.

 [Bubble find largest element and moves into its position, SE do opposite, find smallest and move into it's location]

 Traverse :	Left -> right
 1. Identify the sorted element.
 2.	Put it into the unsorted  position .
 3. Traverse to unsorted position and compare with elements either any item is smaller, if so swap is done.

 Algorithm:
 1. One for loop traverse from 0th location to n location pinting i;
 2. Another for loop traversing i+1 location to n ocation pointing j,considering 'i'th location's element is shortest.
 3. If during traversal find any j location's element smaller than 'i't h location's element do swapping.

 1. Time complexity:
 Best Case	:O(n^2)
 Avg Case	: O(n^2
 Worst Case O(n^2)

 2. Space Complexity:	O(n^2) [ Not applicable for large unsorted data set ]
 < Worked directly with input array, efficient when space crunch is there >.


 Note:
 Hybrid of BUBBLE & INSERTION
 On performance standard better than "Bubble Sort" but worse than "Insertion Sort".
 */
public class SelectionSortLoopApproach {

    public static int[] doSelectionSorting(int[] arr) {

        OutterLoop:/*It maintains regular element (n) traversal of array*/
        for (int i = 0; i < arr.length; i++) {
            /* 'min_index' is a location which hold minimum element of unsorted arraay
            *  It's starts assuming ith loction's element is minimum
            * */
            int min_index=i;

            InnerLoop:/*It maintains Unsorted Array Traversal*/
            for (int j = i+1; j < arr.length; j++) {

               SelectMinimumElement:/*try to find minimum element of 'unsorted' array and put min_index location*/
                if (arr[j] < arr[min_index]) {
                    int temp_minimum=arr[j];
                    arr[j]=arr[min_index];
                    arr[min_index]=temp_minimum;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] inPut = {5, 8, 2, 6, 9, 7, 4, 0, 1, 2, 3};
        int[] outPut = doSelectionSorting(inPut);
        for (int i : outPut) {
            System.out.print(i + ",");
        }
    }
}
