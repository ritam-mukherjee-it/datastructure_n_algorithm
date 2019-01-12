package ds_n_algo.datastructure.linear_data_structure.linkedlists.print_reverse_linkedlist;
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

 void printReverseList(Node head){
     if(head==null)
         return;
     printReverseList(head.next);

     System.out.print(head.data+" ");

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
public class LinkedListReverseOrder {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(list.head);
        System.out.println("");
        System.out.println("Reversed Order linked list ");
        list.printReverseList(list.head);

    }
}
