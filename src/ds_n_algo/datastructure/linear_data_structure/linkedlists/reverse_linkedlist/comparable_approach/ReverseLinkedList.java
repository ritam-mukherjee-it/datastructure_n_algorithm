package ds_n_algo.datastructure.linear_data_structure.linkedlists.reverse_linkedlist.comparable_approach;

/**
 * Node represents basic underlying data structure within LinkedList
 * */
class Node<X extends Comparable> {

    X item;  // also refer as data
    Node nextNode;  //pointer to keep link of Next node

    /*Constructor: make compulsory of providing data at the time of Node creation*/
    public Node(X item) {
        this.item=item;
    }

    public X getItem() {
        return item;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedList<X extends Comparable>{

    /*these two pointers keeps track of starting point and end point of List*/
    private Node first;
    private Node last;

    /*nodeCount variable responsible to keep count of size*/
    private int nodeCount;

    /*Compulsory Initialization*/
    public LinkedList() {
        first=null;
        last=null;
        nodeCount=0;
    }

    /*Utility method: to track size of List with NODECOUNT variable*/
    public int size(){
        return nodeCount;
    }


    /*Complexity    :   O(1)*/
    public void add(X item){
            /*if NODE-COUNT is zero i.e SIZE is empty
                1. The newly instantiated node is consider as FIRST node ;
                2. The FIRST node is also treated as LAST node*/
        if(nodeCount==0){
            first=new Node(item);
            last=first;
        }
        else{
           /* otherwise
                1. the newly instantiated node consider as new last node;
                2. Grab the old LAST NODE and point that to new last node;
                3. The new last node now onwards treat as LAST*/
            Node newLastNode=new Node(item);
            last.setNextNode(newLastNode);
            last=newLastNode;
        }
        nodeCount++; //increase size of List

    }

    Node reverse(Node node){

        Node prev=null;
        Node current=node;
        Node next=null;

        while (current!=null){
            next=current.getNextNode(); /*NEXT variable holding the current element's next element*/
            current.setNextNode(prev); /* Direction change */
            prev=current;  /*Movement of CURRENT pointer*/
            current=next; /*shift for while loop processing*/
        }
        node=prev; /*because prev at last holding current object reference*/
        return node;
    }

    Node reverse(){
       return reverse(this.first);
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.getItem() + "-> ");
            node = node.getNextNode();
        }
        System.out.print( "NULL");
    }

    void printList(){
        printList(this.getFirst());
    }


    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> integerList=new LinkedList<>();

        integerList.add(11);
        integerList.add(22);
        integerList.add(33);
        integerList.add(44);
        integerList.add(55);

        System.out.println("Given Linked list");
        integerList.printList();
        integerList.setFirst(integerList.reverse());
        System.out.println("");
        System.out.println("Reversed linked list ");
        integerList.printList();
    }
}
