package ds_n_algo.datastructure.linear_data_structure.queues.list_implementation;

public class Queue_List {

    /*The Queue class should have a static node field*/
    private static class Node{
        /*The node should have one data field and reference of another node field*/
        private int data;
        private Node next;
            /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
        public Node(int data) {
            this.data = data;
        }
    }

   /* All que should having one producer_consumer Node called "Head" and one ending node called "Tail"*/
    private Node head; //value should be remove from head
    private Node tail; //value should be added at tail


    /*Method 1 #  isEmpty() ->If head is null return true else return false*/
    public boolean isEmpty(){
        if(head==null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    /*Method 2# peek() -> If que is not empty return head data*/
    public Integer peek(){
        if(isEmpty())
            return null;
        else
            return head.data;
    }

    /*Method 3 # add(data)    -> this will add element at the end of the Queue*/
    public void add(int data){

        /*create a node with provided data*/
        Node node=new Node(data);

        /*if tail not null then tail will point new Node and new Node will consider as "tail"*/
        if(tail!=null){
            tail.next=node;
        }
        tail=node;


        /*If in special scenario where head is null, then new node will also consider as head node
        * This is the situation when queue have only one element*/
        if(head==null)
            head=node;

    }

    /*Method 4 # remove() -> elemenete data from head node*/
    public int remove(){

        /*remove will happen from head so head element's data should select,
        * and head elements's reference node will consider as new "head" element*/
        int data=head.data;
        head=head.next;

        /*if new head element is null then same node will also consider as tail element*/
        if(head==null)
            tail=null;

        return data;
    }

    public void display(){
        while (tail!=null){
            System.out.print("| "+head.data+" |->");
            remove();
        }

    }

    public static void main(String[] args) {
        Queue_List queue=new Queue_List();
        queue.add(11);
        queue.add(22);
        queue.add(33);
        queue.add(44);
        queue.add(55);

        queue.display();
    }
}
