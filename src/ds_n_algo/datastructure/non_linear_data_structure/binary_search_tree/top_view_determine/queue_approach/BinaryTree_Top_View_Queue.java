package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.top_view_determine.queue_approach;

/**
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * Given a binary tree, print the top view of it. The output nodes can be printed in any order.
 * Expected time complexity is O(n)

 A node x is there in output if x is the topmost node at its horizontal distance.
 Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
 and that of right child is horizontal distance of x plus 1.

 The idea is to do something similar to vertical Order Traversal.
 Like vertical Order Traversal, we need to nodes of same horizontal distance together.

 We do a level order traversal so that the topmost node at a horizontal
 node is visited before any other node of same horizontal distance below it.

 Hashing is used to check if a node at given horizontal distance is seen or not.
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    /*each node having a data*/
    int data;

    /*also two child nodes*/
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

}

// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
// distance of node from root
class QItem
{
    Node node;
    int hd;
    public QItem(Node n, int h)
    {
        node = n;
        hd = h;
    }
}

class Tree{
    Node root;

    // Constructors
    public Tree()  { root = null; }
    public Tree(Node n) { root = n; }

    public void printTopView()
    {
        /*     Break Point*/
        if (root == null) {
            return;
        }

        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Create a queue and add root to it
        Queue<QItem> Q = new LinkedList<QItem>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

        // Standard BFS or level order traversal loop
        while (!Q.isEmpty())
        {
            // Remove the front item and get its details
            QItem qi = Q.remove();
            int hd = qi.hd;
            Node n = qi.node;

            // If this is the first node at its horizontal distance,
            // then this node is in top view
            if (!set.contains(hd))
            {
                set.add(hd);
                System.out.print(n.data +" ");
            }

            // Enqueue left and right children of current node
            if (n.left != null)
                Q.add(new QItem(n.left, hd-1));
            if (n.right != null)
                Q.add(new QItem(n.right, hd+1));
        }
    }
}

public class BinaryTree_Top_View_Queue {
    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        Tree tree=new Tree(root);
        tree.printTopView();

    }
}
