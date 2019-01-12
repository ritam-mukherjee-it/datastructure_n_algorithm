package ds_n_algo.algorithm.sorting.quick;

import java.util.Arrays;
import java.util.function.Consumer;

public class QuickSortImplementation {
    public static  void quickSort(int[] arr){
    quickSort(arr,0,arr.length-1);
    }

    public static  void quickSort(int[] arr, int left, int right){
        if(left>=right)
            return;

        /*PIVOT: A special element based on which other elements re-arrange their position quickly*/
        int pivot=arr[(left+right)/2];

       /* INDEX: based on which ARRAY is divided into LEFT and RIGHT part.*/
        int index=partition(arr,left,right,pivot);

        quickSort(arr,left,index-1);
        quickSort(arr,index,right);
    }

    public static int partition(int[] array,int left, int right,int pivot){

            traverse_till_left_meet_right:
             while (left<=right)   {

                 find_left_bigger_than_pivot: //left->right
                 while(array[left]<pivot) {
                     left++;
                 }

                 find_right_smaller_than_pivot://right->left move
                 while(array[right]>pivot) {
                     right--;
                 }
                 left_right_swap:/*If left location is more than right we can swap element's of left and right location*/
                 if(left<=right){
                     int temp=array[left];
                     array[left]=array[right];
                     array[right]=temp;
                     left++;
                     right--;
                 }

             }

        return left; //left element as INDEX
    }

    public static void main(String[] args) {
        Consumer<int[]> arrayConsumer=ints -> Arrays.stream(ints).forEach(value -> System.out.print(value+","));

        int[] arr={4,2,3,5,9,7,1,8};
        arrayConsumer.accept(arr);
        System.out.println("\n sorting");

        quickSort(arr);
        arrayConsumer.accept(arr);


    }
}

/**

 QUICK SORT
 -----------
 Mechanism:
 1. Principal	:	Divide and Conquers of sorting
 2. It selects a pivot value from array either  a fixed rule or statistics.
 ( nor right or wrong choice to choose, only better choice).
 3. Put all value less than pivot position's value to left and more to right.
 4. Based on pivot partitioning happen and its self partitioning further.
 5. The process Repeat until sorted.

 Algorithm:
 1. This algorithm always consider two special elements:
 A.PIVOT: A special element based on which other elements re-arrange their position quickly;
 B.INDEX: based on which ARRAY is divided into LEFT and RIGHT part.
 2.Mainly two methods involve to do sorting:
 A. quickSort() : one recursive sort method ,responsible to quickly re arrange
 elements comparing PIVOT position's elements value.
 B. partition() : this method is responsible to find out proper position of INDEX.
 3.  quickSort();
 A. Identify middle element; [MIDDLE= LEFT +RIGHT /2]
 B. call partition() method to find out location of INDEX.
 C. call quickSort() method passing producer_consumer element as LEFT and INDEX element as right;
 [ quickSort(ARRAY,LEFT,INDEX) ]
 D. call quickSort() method as next to INDEX element as LEFT, & nth  element as RIGHT.
 [ quickSort(ARRAY,INDEX+1,RIGHT) ]

 4. partition()
 A. stat traversal LEFT-> RIGHT considering 0th element as LEFT and nth element as RIGHT.
 B. Continue traversal till it reach LEFT<=RIGHT.  [WHILE(LEFT<=RIGHT)]
 C. while LEFT element is less than PIVOT just shift 1 place forward.
 WHILE[LEFT<PIVOT] { [LEFT++]};
 D. While RIGHT element is more than PIVOT elemet shift right element 1 place backward.
 WHILE (RIGHT>PIVOT>{ [RIGHT--] };
 E. encounter two sides when LEFT element is bigger than PIVOT and RIGHT is smaller than PIVOT.
 F. Do swapping among LEFT  and RIGHT and continue progression.
 If[LEFT>PIVOT]{ [SWAP; LEFT++, RIGHT--]  }
 J. while LEFT and RIGHT elemnts meet consider that position and return that location as INDEX;
 Return{[LEFT];

 Performance:
 1. Time complexity:
 best case	:   O(nlog n)
 avg case 	:	O(nlogn)
 worst Case	:   O(n^2)

 2. space complexity O(n)
 As recursive algorithm so stack space must be considered.
 */