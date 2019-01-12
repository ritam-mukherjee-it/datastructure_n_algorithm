package ds_n_algo.datastructure.non_linear_data_structure.heaps.array_implementation.min_heap;

import java.util.Arrays;
import java.util.function.Consumer;



public class MinHeap {

    private int capacity=10;//initial capacity of heap is 10
    private int size=0;

    int[] items=new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private int getParentIndex(int chilldIndex){
        return (chilldIndex-1)/2;
    }


    private  boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    private  boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }


    private  int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private  int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int parent(int index){
        return items[getParentIndex(index)];
    }


    private void swap(int index1, int index2){
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            items= Arrays.copyOf(items,capacity*2);
            capacity*=2;
        }
    }


    public int peek(){
        if(size==0) throw new IllegalStateException();

        return items[0];
    }

    public int pool(){
        if(size==0) throw new IllegalStateException();
        int item=items[0];

        items[0]=items[size-1];// put the last element of array at root location
        size--;//shrinking the array

        heapifyDown();
        return item;
    }


    public void add(int item){
        ensureExtraCapacity();
        items[size]=item;// put the new element at last size
        size++;
        heapifyUp();

    }

    public void heapifyUp(){
        int index=size-1;//start with very last element has been added;

        /*until it has parent and parent item is bigger than current item*/
        while(hasParent(index) && parent(index)>items[index]){

            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index=0;

        while(hasLeftChild(index)){

            /*consider that item's left child is holding smaller element'*/
            int smallerChildIndex=getLeftChildIndex(index);

            /*if it has rightChild and right child's element is smaller than left child,
            right child's element will consider as smaller element*/
            if(hasRightChild(index) && rightChild(index)<leftChild(index))
                smallerChildIndex=getRightChildIndex(index);

            if(items[index]<items[smallerChildIndex])
                break;
            else
                swap(index,smallerChildIndex);


            index=smallerChildIndex;
        }
    }

    public static void main(String[] args) {
        Consumer<int[]> arrayConsumer= ints -> Arrays.stream(ints).forEach(value -> System.out.print(value+","));

        MinHeap heap=new MinHeap();
        heap.add(4);
        heap.add(6);
        heap.add(8);

        arrayConsumer.accept(heap.items);
        heap.add(1);
        System.out.println("\nAfter Add------------");
        arrayConsumer.accept(heap.items);

        heap.add(3);
        System.out.println("\nAfter Add------------");
        arrayConsumer.accept(heap.items);

        heap.pool();
        System.out.println("\nAfter Pool------------");
        arrayConsumer.accept(heap.items);
    }
}
