package ds_n_algo.algorithm.sorting.merge;

import java.util.Arrays;
import java.util.function.Consumer;

public class MergeSortRecursionApproach {


    public static void mergeSort(int[] arr) {

        mergeSort(arr, new int[arr.length], 0, arr.length - 1);

    }

    public static void mergeSort(int arr[], int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        /*  int mid=leftStart+((rightEnd-leftStart)/2);*/
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, mid);
        mergeSort(arr, temp, mid + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);

    }

    public static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        /*find our span of left part*/
        /*int leftEnd=leftStart+((rightEnd-leftStart)/2);*/
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        simultanious_left_right_traversal:
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {

                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        only_left_trversal:
        while (left <= leftEnd) {
            temp[index] = arr[left];
            left++;
            index++;
        }

        only_right_trversal:
        while (right <= rightEnd) {
            temp[index] = arr[right];
            right++;
            index++;
        }

 /*       System.arraycopy(arr,left,temp,index,leftEnd-left+1);
        System.arraycopy(arr,right,temp,index,rightEnd-right+1);*/

        System.arraycopy(temp, leftStart, arr, leftStart, size);


    }

    public static void main(String[] args) {
        Consumer<int[]> arrayConsumer = ints -> Arrays.stream(ints).forEach(value -> System.out.print(value + ","));
        int[] arr = {2, 8, 5, 6, 9, 7, 1, 4};
        arrayConsumer.accept(arr);

        System.out.println("-------------------sorting------------------");
        mergeSort(arr);
        arrayConsumer.accept(arr);


    }
}




/**
 *
 MERGE SORT
 ----------
 Mechanism:
 1. Principal	:	Divide and Conquer
 2. The array is recursively split into two halves.
 3. When array is in group of 1, it is reconstructed in sort order.
 4. Each reconstructed array is merged with other halvs.


 Algorithm:
 1. Mainly two methods involve to do sorting:
 A. mergeSort() : one recursive sort method ,responsible to split the array
 into two halves, consider as LEFT_ARRAY and RIGHT_ARRAY, and do shopping;
 B. mergeHalves() : one merge method call before each recursive call to merge sorted halves;
 2. mergeSort() method :
 A. Identify middle element;
 B. call mergeSort() method passing producer_consumer element as LEFT and middle element as RIGHT,
 C. call mergeSort() method as next to middle element as LEFT, & nth  element as RIGHT.
 D. call mergeHalves() method;
 3. mergeHalves():
 A. It got two arrays and consider both are sorted;
 B. Find out Middle element;
 C. consider LEFT element as producer_consumer fo LEFT_START and middle as LEFT_END,
 D. Consider MIDDLE as RIGHT_START and last nth element as RIGHT_END;
 E. producer_consumer point of TEMP array is LEFT_START element of LEFT_ARRAY.
 F. traverse both simultaneously and compare same location's element in both array;
 G. Whichever sorted put that into TEMP array. increase the INDEX.
 H. There may be a situation comes when either LEFT_ARRAY or RIGHT_ARRAY traversal complete.
 I. traverse individually LEFT_ARRAY and RIGHT_ARRAY and put elements in TEMP.
 J. Along with Combind LEFT_ARRAY and RIGHT_ARRAY traversal, only LEFT_ARRAY or RIGHT_ARRAY
 traversal possible but not both simultaneously.


 Property	:
 1. Appropriate for Large data set.
 2. Data spitting that means algorithm can be made parallal.
 3. Performance is good but fixed.

 1. Time complexity:
 worst case/best case/ Worst Case:	O(nlogn)
 2. Space Complexity	->	O(n)


 Advantage:
 Predictable and dependable algorithm.

 Disadvantage:
 A. Merge can be done but it is often not performed "in-place", One additional array is needed.
 B. The extra allocation increase the memory footprint required to sort data

 */