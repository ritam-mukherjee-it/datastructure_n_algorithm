package ds_n_algo.datastructure.linear_data_structure.linkedlists.single_linkedlist.quick_approach;

/**
 * @author      :Ritam Mukherjee on 01-11-2017.
 * @version     :HackerRank
 * @see         : https://www.youtube.com/watch?v=njTh_OwMljA
 */

/*The "Node" class represent each element of a LinkedList*/
class Node {

    /*the class having two property:
        a. data-> which represent the containing value of the element
        b. next-> reference of next element.*/
    int data;
    Node next;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public Node(int data) {
        this.data = data;
    }

}

public class LinkedList {

    /* All LinkedList should having one producer_consumer Node called "Head" "*/
    private Node head; //each time traversal should start from head

    /*Utility Method  1# getLength() -> print size of the List*/
    /**Point to HEAD node, traverse each node and increment counter till encounter a "null" reference*/
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
        while (current != null) {
            System.out.print("|   " + current.data + "    |--->");
            current = current.next; //current node now pointing last element
        }
        System.out.print("[NULL]");
        System.out.print("\t\t  [SIZE :"+getLength()+"]");
        System.out.println("\n---------------------------------------------------------------------------------------");
        //  System.out.print("|   " + current.data + "    |\n");
    }


    /*Method 1 # append(data)    -> add element to the end of the List*/

    /**
     * Insert At End
     --------------
     1. Mainly one Pointer is used:
     A. CURRENT -> the node which is presently processing
     2. List is Empty?
                [ HEAD ==NULL] then HEAD= CURRENT;
     3. Elements are present?
     Start from HEAD node reach till the particular node which pointing to NULL node	[ while CURRNT.NEXT=NULL ]
     4.got last element?
                If it got element then CURRENT.NEXT will point to new NODE;
     */
    public void append(int data) {

        /* Situation 1: when List is empty, i.e. head is null*/
        if (head == null) {
            head = new Node(data);
            return;  //this'return' statement is very important to stop the flow
        }

        /*Situation 2: when List is not empty*/
        Node current = head;   /*The current node is a pointer which start pointing "head" node*/

                /*Now the current node traverse all elements of Linked list until comes end of the list,
                  i.e. until pointing to a null element*/
        while (current.next != null) {
            current = current.next; //current node now pointing last element
        }

        current.next = new Node(data);//current node now holding new "Node" object

    }

    /*Method 2 # prepend(data)    -> add element to the producer_consumer of the List*/
    public void prepend(int data) {
        /*New head element will be created*/
        Node newHead = new Node(data);
        /*newHead element is now point to head element*/
        newHead.next = head;
        /*Now the 'newHead' element should consider as head*/
        head = newHead;
    }

    public void deleteWithValue(int data) {
        /* Situation 1: when List is empty, i.e. head is null*/
        if (head == null)
            return;

        /* Situation 2: when List having data at head node*/
        if (head.data == data) {
            head = head.next; //head element is now pointing to next element
            return;
        }

        /* Situation 3: when List having data at any other location*/
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next; //current node now pointing last element
        }
    }

/**

 Insert At Particular Position
------------------------------
        1. Three pointers mainly used
            A. 	ELEMENT  -> The node which is going to insert
            B. 	PREVIOUS -> The location where is going to insert
            C 	CURRENT -> the node which is presently processing,
        2. List is Empty?
                    [ HEAD ==NULL] then HEAD= CURRENT;
        3. Invalid Position?
            POSITION >= '0' && POSITION<= length -1   => "Invalid Position"
        4. Valid Position?
            A. Is Inserttion and the First Location?
                POSITION == 1? - YES
                ELEMENT.NEXT=HEAD;
                HEAD=ELEMENT;
            B. Is position more than 1?
                 I. 	PREVIOUS point to 'HEAD' location & count start from'1' position.
                II.     traverse : HEAD --> 'Position -1'  < while (count < position - 1)>
                III.    reach destination?
                        CURRENT <- PREVIOUS.NEXT;  	 --assigning
                        PREVIOUS.NEXT= ELEMENT;		 --cutting
                        ELEMENT.NEXT=CURRENT; 		 --joining

*/

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
            element.next = head;
            head = element;
        } else {
         /* "previous" represt where the element should inserted
            "current" at present which node is exist that location   */

            Node previous = head;//start considering first location
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;//<CUTTING>
            element.next = current;  /*new "element" pointing current node*/
            previous.next = element; /*previous now pointing "element"*/

        }

    }
/**
Delete At Particular Postion
------------------------------
        1. Mainly two pointers needed:
            PREVIOUS -> The location where is going to insert
            CURRENT -> the node which is presently processing,
        2. Is th list Empty?
            [LIST==NULL] --'underflow'
        3. Invalid Position?
            POSITION >= '0' && POSITION<= length -1   => "Invalid Position"
        4. Valid Position?
            A. Is Inserttion and the First Location?
                    POSITION == 1? - YES
                    HEAD=HEAD.NEXT
            B. Is position more than 1?
                    I. 	PREVIOUS point to 'HEAD' location & count start from'1' position.
                    II. Traverse : HEAD --> 'Position -1'  < while (count < position - 1)>
                    III. Assignment	: PREVIOUS.NEXT= PREVIOUS.NEXT.NEXT
    */

    public void deleteAtPosition(int position) {

        empty_list:
        if (head == null) {
            System.out.println("underflow");
        }

        invalid_position:
        if (position > getLength() + 1 || position < 1)
            System.out.println("invalid position");

        valid_position:
        /*Scenario 1: when element will deleted from first*/
        if (position == 1) {
            head = head.next;
        } else {

         /* "previous" represent where the element should inserted
            "current" at present which node is exist that location   */

            Node previous = head;//start considering first location
            int count = 1;
            while (previous != null) {
                if (count == position - 1) {
                    previous.next = previous.next.next;
              /*      Node current=previous.next;
                    previous.next=current.next;*/
                }
                previous = previous.next;
                count++;
            }

        }

    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();


        linkedList.insertAtPosition(44, 1);
        linkedList.display();
        linkedList.append(11);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.display();

        linkedList.prepend(00);
        linkedList.display();

        linkedList.deleteWithValue(22);
        linkedList.display();

        linkedList.insertAtPosition(99, 3);
        linkedList.display();

        linkedList.deleteAtPosition(2);
        linkedList.display();

    }
}
