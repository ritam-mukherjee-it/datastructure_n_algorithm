package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.recursion_approach;

/**
 * Created by Ritam Mukherjee on 01-11-2017.
 * Source   :   HackerRank
 * Link     :   https://www.youtube.com/watch?v=oSWTXtMglKE&t=2s
 */

/*BinaryTree:
Each node having no more than two child nodes
*/
class Node {
    /*each node having a data*/
    int data;

    /*also two child nodes*/
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

   /* Method 1# insert(data) -> insert a value*/
    public void insert(int value) {

        value_less_or_equal_data:
        if (value <= data) {
            if (left == null)
                left = new Node(value);
            else
                left.insert(value);/*recursion: call left nodes insert method*/
        }
        value_greater_data:
        if(value>data){
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);/*recursion: call right nodes insert method*/
        }
    }

    /* Method 2# contains(data) -> insert a value*/
    public boolean contains(int value){

        value_matches_data:
        /*Situation 1   :   When the value is same as data*/
        if(value==data)
            return Boolean.TRUE;

        value_smaller_data:
        /*Situation 2   :   When the value is smaller than data*/
        if(value<data){
            
            /*when reaches to last element of left*/
            if(left==null)
                return Boolean.FALSE;
            else
                return  left.contains(value); /*recursion: call left nodes contain method*/
        }

        value_bigger_data:
        /*Situation 3  :   When the value is bigger than data*/
        if(value>data){

              /*when reaches to last element of right*/
            if(right==null)
                return Boolean.FALSE;
            else
                return right.contains(value); /*recursion: call right nodes contain method*/
        }
        else
            return Boolean.FALSE; //All other scenario which hardly needed
    }

    /* display methods */
    /*INORDER ->  LEFT-ROOT-RIGHT*/
    public void printInorder() {
        left:
        if (left != null)
            left.printInorder();
        root:
        System.out.print(data + ",");
        right:
        if (right != null)
            right.printInorder();
    }

    /*PREORDER ->  ROOT-LEFT-RIGHT*/
    public void printPreorder() {
        root:
        System.out.print(data + ",");
        left:
        if (left != null)
            left.printPreorder();
        right:
        if (right != null)
            right.printPreorder();
    }

    /*POSTORDER ->  LEFT-RIGHT-ROOT*/
    public void printPostorder() {
        left:
        if (left != null)
            left.printPreorder();
        right:
        if (right != null)
            right.printPreorder();
        root:
        System.out.print(data + ",");
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root_node = new Node(40);
        root_node.insert(20);
        root_node.insert(60);
        root_node.insert(80);
        root_node.insert(100);

        System.out.println("\n----------Printing :display-----------");
        System.out.println("\nInorder");
        root_node.printInorder();
        System.out.println("\nPreorder");
        root_node.printPreorder();
        System.out.println("\nPostorder");
        root_node.printPostorder();

        System.out.println("\n----------Testing :contains(value)-----------");
        System.out.println(root_node.contains(60));
        System.out.println(root_node.contains(55));
    }
}
