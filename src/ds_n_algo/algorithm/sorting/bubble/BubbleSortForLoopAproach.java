package ds_n_algo.algorithm.sorting.bubble;

/**
 * Created by PouRit on 29-10-2017.
 */
public class BubbleSortForLoopAproach {

    public static int[] doBubbleSorting(int[] arr) {

        OuterLoop:/*It maintains regular element (n) traversal of array*/
        for (int i = 0; i < arr.length; i++) {

            InnerLoop:/*Maintain another traversal to 1th location to unsortrd location (n-i)*/
            for (int j = 1; j < arr.length - i; j++) {

                SwapMenimum:/*chose two elements and swap lower one to left side*/
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] inPut = {5, 8, 2, 6, 9, 7, 4, 0, 1, 2, 3};
        int[] outPut = doBubbleSorting(inPut);
        for (int i = 0; i < outPut.length; i++) {
            System.out.print(outPut[i] + (i != outPut.length - 1 ? " " : ""));
        }

    }
}

/**
 * BUBBLE SORT
 ------------
 Simplest Sorting Algorithm

 Mechanism	:

 Traverse: Left -> right

 1. On each Iteration
 a. an element with it immediate right neighbor.
 b. If right neighbor is smaller then swap right and left.
 c. process repeat with remaining array items.

 2. On each iteration largest unsorted element is sorted and goes to right most side.


 Performance	:
 1. Time complexity:
 Best Case	: 	O(n)  [ very good for best case, efficient when data is small and nearly sorted]
 Avg Case 	:	O(n^2)
 worst case 	: 	O(n^2)  [ Not appropriate for large unsorted data sets]

 2. Space COmplexity:	O(n)
 Operates directly on Input array

 */
