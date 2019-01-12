package ds_n_algo.algorithm.sorting.selection;

import java.util.function.Consumer;

/**
 * Created by PouRit on 01-11-2017.
 */
interface iSelectionSort {
    public  int[] doSelectionSorting(int[] arr);
}
public class SelectionSortForLoopApproachLambda {
    public static void main(String[] args) {
        iSelectionSort selectionSort = arr -> {

            OutterLoop:/*It maintains regular element (n) traversal of array*/
            for (int i = 0; i < arr.length; i++) {
            /* 'min_index' is alocation which hold minim element of unsorted arraay
            *  It's starts assuming ith loction's element is minimum
            * */
                int min_index=i;

                InnerLoop:/*It maintains Unsorted Array Traversal*/
                for (int j = i+1; j < arr.length; j++) {

                    swapMinimumElement:/*try to find minimum element of 'unsorted' array and put min_index location*/
                    if (arr[j] < arr[min_index]) {
                        int temp_minimum=arr[j];
                        arr[j]=arr[min_index];
                        arr[min_index]=temp_minimum;
                    }
                }
            }

            return arr;
        };


        Consumer<int[]> arrayConsumer=ints ->  {
            for (int i: ints){
                System.out.print(i+",");
            }
        };
        int[] inPut={5,8,2,6,9, 7, 4, 0,1,2,3};
        selectionSort.doSelectionSorting(inPut);



    }
}
