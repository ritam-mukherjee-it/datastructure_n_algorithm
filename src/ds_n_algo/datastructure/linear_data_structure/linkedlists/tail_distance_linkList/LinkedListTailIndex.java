package ds_n_algo.datastructure.linear_data_structure.linkedlists.tail_distance_linkList;

import java.util.Scanner;

/**
 *
 * Source       :   HackerRank
 * Link         :   https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 *
 * The problem also can resolve by reversing the linked list and through backward traverse.
 */
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
    public Node getTailPointer(int distance){

        Node tail=head;
        while(distance>=0){
            tail=tail.next;
            distance--;
        }
        return tail;
    }

    public Node getElement(Node head_pointer, Node tail_pointer){

        while(tail_pointer!=null){
            head_pointer=head_pointer.next;
            tail_pointer=tail_pointer.next;
        }

        return head_pointer;
    }

}
public class LinkedListTailIndex {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        Scanner scanner=new Scanner(System.in);

        Node tail_pointer=list.getTailPointer(scanner.nextInt());

        Node element=list.getElement(list.head,tail_pointer);
        System.out.println(element.data);
    }
}
