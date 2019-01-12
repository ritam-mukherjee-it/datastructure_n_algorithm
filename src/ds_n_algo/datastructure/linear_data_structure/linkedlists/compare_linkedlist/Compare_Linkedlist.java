package ds_n_algo.datastructure.linear_data_structure.linkedlists.compare_linkedlist;

/**
 * Source   :   Hackerrank
 * Link     :
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
public class Compare_Linkedlist {
    static int compareLists(Node headA, Node headB) {

        Node currentA=headA;
        Node currentB=headB;
        boolean isEqual=true;
        check_equality:
        while(currentA!=null && currentB!=null ){

            if((currentA==null && currentB!=null) || (currentB==null && currentA!=null)){
               return 0;
            }
            if(currentA.data!=currentB.data ){
               return 0;

            }

            currentA = currentA.next;
            currentB = currentB.next;

        }
        if(currentA==null && currentB==null)
             return 1;
        else
            return 0;

    }

    public static void main(String[] args) {

        Node headA=new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = new Node(4);


        Node headB=new Node(1);
        headB.next = new Node(2);
        headB.next.next = new Node(3);
        headB.next.next.next = new Node(4);
        int val=compareLists(headA,headB);
        System.out.println(val);
    }
}
