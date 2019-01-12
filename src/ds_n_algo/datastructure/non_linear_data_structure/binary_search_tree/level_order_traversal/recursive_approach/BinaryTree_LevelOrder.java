package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.level_order_traversal.recursive_approach;

import java.util.LinkedList;
import java.util.Queue;

/**
Source  :   GeekForGeek
Link    :   https://www.geeksforgeeks.org/level-order-tree-traversal/
 */
/*
METHOD 1 (Use function to print a given level)

        Algorithm:
        There are basically two functions in this method.
        1. printGivenLevel	:	First One is to print all nodes at a given level;
        2. printLevelorder	:	The other is to print level order traversal of the tree .
        printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

        Another utility function is needed to determine height of the tree;
        3. height(root)		:  this method is used by printlevelorder() to determine how many levels it has to print

        Function to print level order traversal of tree
        ------------------------------------------------
                    printLevelorder(tree)
                    for d = 1 to height(tree)
                    printGivenLevel(tree, d);

        Function to print all nodes at a given level
        ---------------------------------------------
                    printGivenLevel(tree, level)
                    if tree is NULL then return;
                    if level is 1, then
                    print(tree->data);
                    else if level greater than 1, then
                    printGivenLevel(tree->left, level-1);
                    printGivenLevel(tree->right, level-1);

		Function(utility) to print all nodes at a given level
		-----------------------------------------------------
                    height(tree)
                    if root is NULL then return;
                    if root has left or right child increase height by 1
                    whichever bigger among left and right height return that


        Time Complexity:
         O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
        So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
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
        if (value > data) {
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);/*recursion: call right nodes insert method*/
        }
    }
}
public class  BinaryTree_LevelOrder {
    Node root;
    public BinaryTree_LevelOrder() {
        root=null;
    }
    /* function to print level order traversal of tree*/
    void printLevelOrder_classical_approach()
    {
        int h = getHeight(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public int getHeight(Node root){
        if(root==null)
            return 0;
        else{
            int lheight=getHeight(root.left);
            int rheight=getHeight(root.right);

            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }
    }

    public void printGivenLevel(Node root,int level){
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }


    void printLevelOrder_queue_approach(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }




    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree_LevelOrder tree = new BinaryTree_LevelOrder();
        tree.root= new Node(1);
        tree.root.left= new Node(8);
        tree.root.right= new Node(6);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.right.left= new Node(2);
        tree.root.right.right= new Node(3);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder_classical_approach();
        System.out.println("\n---------------------------");
        tree.printLevelOrder_queue_approach();
    }
}
