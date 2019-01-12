package ds_n_algo.datastructure.linear_data_structure.linkedlists.remove_dulicates;

/**
 * Thoughts

 The key of this problem is using the right loop condition.
 And change what is necessary in each loop.
 we can use different iteration conditions like the following 2 solutions.
 */
class ListNode {

    /*the class having two property:
        a. val-> which represent the containing value of the element
        b. next-> reference of next element.*/
    int val;
    ListNode next;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public ListNode(int val) {
        this.val = val;
        next=null;
    }

}
public class RemoveDuplicatesLinkedList {
    public  static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode p = head.next;

        while(p != null){
            if(p.val == prev.val){
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{
                prev = p;
                p = p.next;
            }
        }

        return head;
    }
    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-> ");
            node = node.next;
        }
        System.out.print( "NULL");
    }
    public static void main(String[] args) {
        ListNode headA=new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(5);
        headA.next.next.next.next = new ListNode(5);



        ListNode headC=deleteDuplicates(headA);

        printList(headC);
    }
}
