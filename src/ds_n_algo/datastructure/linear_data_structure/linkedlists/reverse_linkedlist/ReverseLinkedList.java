package ds_n_algo.datastructure.linear_data_structure.linkedlists.reverse_linkedlist;

class Node {

    /*the class having two property:
        a. data-> which represent the containing value of the element
        b. next-> reference of next element.*/
    int data;
    Node next;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public Node(int data) {
        this.data = data;
        next=null;
    }

}
class LinkedList{
    Node head;

    Node reverse(Node node){

        Node prev=null;
        Node current=node;
        Node next=null;

        while (current!=null){
            next=current.next; /*NEXT variable holding the current element's next element*/
            current.next=prev; /* Direction change */
            prev=current;  /*Movement of CURRENT pointer*/
            current=next; /*shift for while loop processing*/
        }
        node=prev; /*because prev at last holding current object reference*/
        return node;
    }
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "-> ");
            node = node.next;
        }
        System.out.print( "NULL");
    }

}
public class ReverseLinkedList {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(list.head);
        list.head = list.reverse(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.head);
    }

}
