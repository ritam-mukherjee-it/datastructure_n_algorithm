package ds_n_algo.algorithm.searching.binary_search;

public class BinarySearch {

    public static boolean binarySearchRecursive(int[] arr, int x, int left, int right) {
        if (left > right) {
            return Boolean.FALSE;
        }

        int mid = (left + right) / 2;
        /*
        This way also we can get middle element to overcome integer overflow issue
        int middle=left + (right-left/2);*/

        value_equal_middle:
        /*scenario 1: value is same as middle element*/
        if (arr[mid] == x)
            return Boolean.TRUE;

        value_less_middle:
        /*scenario 2: value is less than middle element*/
        if (x < arr[mid])
            return binarySearchRecursive(arr, x, left, mid - 1);

        value_more_element:
        /*scenario 1: value is more than middle element*/
        if (x > arr[mid])
            return binarySearchRecursive(arr, x, mid, right);

        else
            return Boolean.FALSE;

    }


    public static boolean binarySearchIterative(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return Boolean.TRUE;
            if (x < arr[mid])
                right = mid - 1;
            if (x > arr[mid])
                left = mid + 1;

        }
        return Boolean.FALSE;

    }
    public static boolean binarySearch(int[] arr, int x){
       return binarySearchRecursive(arr,x,0,4);
    }

    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        System.out.println(binarySearch(arr,30));
    }
}
