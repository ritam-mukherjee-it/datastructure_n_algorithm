package ds_n_algo.datastructure.linear_data_structure.linkedlists.circular_linkedlist;


/*The "Node" class represent each element of a LinkedList*/
class Node {

    /*the class having two property:
        a. data-> wheich represent the containing value of the element
        b. next-> reference of next element.*/
    int data;
    Node next;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public Node(int data) {
        this.data = data;
    }

}


public class CircularLinkedList {
    /* All queue should having one producer_consumer Node called "Head" "*/
    private Node head; //each time traversal should start from head

    /*Utility Method  1# getLength() -> print size of the List*/
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
            if(current==head)
                break; /*most importatnt is break to preven infinity loop*/
        }
        return length;
    }


     /*Utility Method  2# display() -> print all elements of the list*/
     public void display() {
         Node current = head;
         while (current != null) {
             System.out.print("|   " + current.data + "    |--->");
             current = current.next; //current node now pointing last element
             if(current==head)
                 break; /*most importatnt is break to preven infinity loop*/
         }
         System.out.print("O");
         System.out.print("\t\t  [SIZE :"+getLength()+"]");
         System.out.println("\n---------------------------------------------------------------------------------------");
         //  System.out.print("|   " + current.data + "    |\n");
     }


    /*Method a # append(data)    -> add element to the end of the List*/
    public void append(int data) {

        /*New node is created called "element"*/
        Node element=new Node(data);
        element.next=element; /* <SELF POINTING> for circular list self pointing initialization is mandatory*/

        /* Situation 1: when List is empty, i.e. head is null*/
        if (head == null) {
            head = element;
            return;  //this'return' statement is very important to stop the flow
        }else{

            Node current = head;   /*The current node is a pointer which start pointing "head" node*/

                /**Now the current node traverse all elements of Linked list until comes to head,
                  i.e. until pointing to a head element
                    In case of circular LinkedList it always traverse till head element.
                  */
            while (current.next != head) {
                current = current.next; //current node now pointing last element
            }
            /*Insertion Happens at current location*/
            element.next=head;  /*'element' node now pointing to 'head' node <CUTTING>*/
            current.next=element; /* 'current' node now pointing to element node*/

        }

    }


    public void prepend(int data) {

        /*New node is created called "element"*/
        Node element=new Node(data);
        element.next=element; /*for circular list self pointing initialization is mandatory*/

        /* Situation 1: when List is empty, i.e. head is null*/
        if (head == null) {
            head = element;
            return;  //this'return' statement is very important to stop the flow
        }else{
            /* Situation 2: when List is not empty i.e. head is not null*/
            Node current = head;   /*The current node is a pointer which start pointing "head" node*/

            /**Now the current node traverse all elements of Linked list until comes to head,
             i.e. until pointing to a head element
             In case of circular LinkedList it always traverse till head element.
             */
            while (current.next != head) {
                current = current.next; //current node now pointing last element
            }
            /*Insertion Happens at current location*/
            element.next=head;  /* <CUTTING> 'element' node now pointing to 'head' node */
            current.next=element; /* <JOINING> 'current' node now pointing to element node*/
            head=element;//<ASSIGNING-HEAD>just setting new 'element' as head is added functionality
        }

    }

    public void delete_last(){

      /*  Two pointer needed:
            'before'   -> which node is holding to be deleted node
            'curent'   -> which element should be deleted*/

        Node before=head;
        Node current=head;

        /* Situation 1: when List is empty, i.e. head is null*/
        under_flow:
        if(head==null){
            System.out.println("underflow");
            return;
        }

        /* Situation 2: when List having only one 'head node' which is self pointing*/
        single_element_list:
        if(head.next==head){
            System.out.println("cleaning");
            head=null;
            return;
        }

        /* Situation 2: when List having only one 'head node' which is self pointing*/
        other_scenerio:
        while(current.next!=head){
            before=current;
            current=current.next;
        }
        before.next=current.next;
        current=null;
    }

    public void delete_first(){

        Node current=head;

        /* Situation 1: when List is empty, i.e. head is null*/
        under_flow:
        if(head==null){
            System.out.println("underflow");
            return;
        }

        /* Situation 2: when List having only one 'head node' which is self pointing*/
        single_element_list:
        if(head.next==head){
            System.out.println("cleaning");
            head=null;
            return;
        }

        other_scenerio:
        while(current.next!=head){
            current=current.next;
        }
        current.next=head.next;
        head=head.next;
    }

   public boolean  hasCycle() {
        boolean flag = false;
        if (head == null)
            return false;

        Node fast = head.next.next;
        Node slow = head.next;
        while_loop:
        while (fast != null && slow != null && fast.next != null) {
            if (fast == slow)
                flag = true;

            if(fast ==head  && slow==head)
                break while_loop;
            fast=fast.next.next;
            slow=slow.next;
        }
        return flag;
    }


    public static void main(String[] args) {
        CircularLinkedList circularLinkedList=new CircularLinkedList();

        circularLinkedList.append(11);
        circularLinkedList.append(22);
        circularLinkedList.append(33);
        circularLinkedList.display();

        circularLinkedList.append(44);
        circularLinkedList.display();

        circularLinkedList.delete_last();
        circularLinkedList.display();

        circularLinkedList.delete_last();
        circularLinkedList.display();

        circularLinkedList.prepend(00);
        circularLinkedList.display();

/*        circularLinkedList.delete_first();
        circularLinkedList.display();

        circularLinkedList.delete_first();
        circularLinkedList.display();

        circularLinkedList.delete_last();
        circularLinkedList.display();*/

        System.out.println(circularLinkedList.hasCycle());

    }

}
