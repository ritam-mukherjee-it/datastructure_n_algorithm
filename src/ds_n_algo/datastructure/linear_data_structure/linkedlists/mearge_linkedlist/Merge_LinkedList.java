package ds_n_algo.datastructure.linear_data_structure.linkedlists.mearge_linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.

 * Analysis

 The key to solve the problem is defining a fake head.
 Then compare the first elements from each list.
 Add the smaller one to the merged list.
 Finally, when one of them is empty, simply append it to the merged list, since it is already sorted.
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
public  class Merge_LinkedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pointerNode = head;


        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val < l2.val){
                    pointerNode.next = l1;
                    l1=l1.next;
                }else{
                    pointerNode.next=l2;
                    l2=l2.next;
                }
                pointerNode = pointerNode.next;
            }else if(l1==null){
                pointerNode.next = l2;
                break;
            }else if(l2==null){
                pointerNode.next = l1;
                break;
            }
        }

        return head.next;
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
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(5);
        headA.next.next.next.next = new ListNode(8);


        ListNode headB=new ListNode(1);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(3);
        headB.next.next.next = new ListNode(4);
        headB.next.next.next.next = new ListNode(7);

        ListNode headC=mergeTwoLists(headA,headB);

         printList(headC);
    }
}
