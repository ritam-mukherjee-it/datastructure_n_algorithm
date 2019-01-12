package ds_n_algo.algorithm.sorting.sorting_problems;

public class RemoveDuplicateElements {

    public static int[] removeDuplicates(int[] arr){
        int end=arr.length;
        for (int i = 0; i <end ; i++) {
            for (int j = i+1; j < end; j++) {
                if(arr[i]==arr[j]){
                    arr[j]=arr[end-1];
                    j--;
                    end--;
                }
            }
        }

        int[] whitelist=new int[end];
        System.arraycopy(arr,0,whitelist,0,end);
        return whitelist;
    }

    public static void main(String[] args) {
        int[] inPut = {5, 8, 2, 6, 9, 7, 4, 0, 1, 2, 3,5,7,8,5,4,3,6};
        int[] outPut = removeDuplicates(inPut);
        for (int i = 0; i < outPut.length; i++) {
            System.out.print(outPut[i] + (i != outPut.length - 1 ? " " : ""));
        }
    }
}
