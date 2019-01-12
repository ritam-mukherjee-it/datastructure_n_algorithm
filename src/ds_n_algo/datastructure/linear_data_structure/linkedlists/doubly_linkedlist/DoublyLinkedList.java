package ds_n_algo.datastructure.linear_data_structure.linkedlists.doubly_linkedlist;


/*The "Node" class represent each element of a LinkedList*/
class Node {

    /*the class having two property:
        a. data-> which represent the containing value of the element
        b. next-> reference of next element.*/
    int data;
    Node next;
    Node previous;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public Node(int data) {
        this.data = data;
    }

}
public class DoublyLinkedList {
    /* All queue should having one producer_consumer Node called "Head" "*/
    private Node head; //each time traversal should start from head

    /*Utility Method  1# getLength() -> print size of the List*/
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /*Utility Method  2# display() -> print all elements of the list*/
    public void display() {
        Node current = head;
        System.out.print("[NULL]<-->");
        while (current != null) {
            System.out.print("|   " + current.data + "    |<-->");
            current = current.next; //current node now pointing last element
        }
        System.out.print("[NULL]");
        System.out.print("\t [SIZE :"+getLength()+"]");
        System.out.println("\n---------------------------------------------------------------------------------------");
        //  System.out.print("|   " + current.data + "    |\n");
    }

    /*Utility Method  2# display() -> print all elements of the list*/
    public void display_previous() {
        Node current = head;
        System.out.print("[NULL]<-->");
        while (current.next != null) {
            current = current.next; //current node now pointing last element
        }

        while(current!=null){
            System.out.print("|   " + current.data + "    |<-->");
            current = current.previous;
        }

        System.out.print("[NULL]");
        System.out.print("\t [SIZE :"+getLength()+"]");
        System.out.println("\n---------------------------------------------------------------------------------------");
        //  System.out.print("|   " + current.data + "    |\n");
    }


    public void insertAtPosition(int data, int position) {
        Node element = new Node(data);
        empty_list:
        if (head == null) {
            head = element;
            return;
        }

        invalid_position:
        if (position > getLength() + 1 || position < 1)
            System.out.println("invalid position");

        valid_position:
        /*Scenario 1: when element will insert at first*/
        if (position == 1) {
            element.next = head; /*new element point to head node*/
            head.previous=element; /* 'need' node previos point to new element node*/
            head = element; /* 'element' node will consider as new head*/
        } else {
         /* "previous" represt where the element should inserted
            "current" at present which node is exist that location   */

            Node previous = head;//start considering first location
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            element.next = current;  /*new "element" pointing current node*/
            if(current!=null)
                current.previous=element;  /*"current"  node previous pointing to 'element' node*/

            previous.next = element; /*previous now next pointing "element"*/
            element.previous=previous; /*"element"  node previous pointing to 'previous' node*/

        }

    }


    public void deleteAtPosition(int position) {

        empty_list:
        if (head == null) {
            System.out.println("underflow");
        }

        invalid_position:
        if (position > getLength() + 1 || position < 1)
            System.out.println("invalid position");

        valid_position:
        /*Scenario 1: when element will insert at first*/
        if (position == 1) {
            head = head.next;
            head.previous=null;
        } else {

           /* "before" represent where the element should inserted
            * "current" at present which node is exist that location
            * "later" where current is now pointing
            */

            Node before = head;//start considering first location
            int count = 1;
            while (before != null) {
                if (count == position - 1) {
                    Node current=before.next;
                    Node later=current.next;

                    before.next=current.next;
                    later.previous=current.previous;
              /*      Node current=previous.next;
                    previous.next=current.next;*/
                }
                before = before.next;
                count++;
            }

        }

    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtPosition(11,1);
        doublyLinkedList.display();
        doublyLinkedList.insertAtPosition(22,2);
        doublyLinkedList.display();

        doublyLinkedList.insertAtPosition(33,3);
        doublyLinkedList.display();

/*        doublyLinkedList.deleteAtPosition(1);
        doublyLinkedList.display();*/

        doublyLinkedList.insertAtPosition(33,3);
        doublyLinkedList.display();

        doublyLinkedList.insertAtPosition(44,4);
        doublyLinkedList.display();

        doublyLinkedList.deleteAtPosition(2);
        doublyLinkedList.display();

        doublyLinkedList.display_previous();
    }
}
