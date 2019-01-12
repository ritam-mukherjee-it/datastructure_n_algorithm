package ds_n_algo.algorithm.sorting.sorting_problems;

public class ReverseOrderSorting {
    public static int[] doReverseSorting(int[] arr) {


        OuterLoop:/*It maintains regular element (n) traversal of array*/
        for (int i = 0; i < arr.length; i++) {

            InnerLoop:/*Maintain another traversal to 1th location to unsortrd location (n-i)*/
            for (int j = 1; j < arr.length - i; j++) {

                SwapMenimum:/*chose two elements and swap lower one to left side*/
                if (arr[j - 1] < arr[j]) {
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
        int[] outPut = doReverseSorting(inPut);
        for (int i = 0; i < outPut.length; i++) {
            System.out.print(outPut[i] + (i != outPut.length - 1 ? " " : ""));
        }
    }

}
