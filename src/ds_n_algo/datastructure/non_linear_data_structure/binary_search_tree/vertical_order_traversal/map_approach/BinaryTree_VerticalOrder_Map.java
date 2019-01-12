package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.vertical_order_traversal.map_approach;

import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

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

public class BinaryTree_VerticalOrder_Map {

    Node root;

    void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
        // Break point
        if (root == null)
            return;

        //get the vector list at 'hd'
        Vector<Integer> hd_vertical_list = m.get(hd);

        // Store current node in map 'm'
        if (hd_vertical_list == null) {
            hd_vertical_list = new Vector<>();
            hd_vertical_list.add(root.data);
        } else
            hd_vertical_list.add(root.data);

        m.put(hd, hd_vertical_list);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd - 1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd + 1, m);
    }

    // The main function to print vertical oder of a binary tree
    // with given root
    void printVerticalOrder(Node root) {
        // Create a map and store vertical oder in map using
        // function getVerticalOrder()
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        BinaryTree_VerticalOrder_Map tree = new BinaryTree_VerticalOrder_Map();

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
        System.out.println("Vertical Order traversal is");

        tree.root = root;
        tree.printVerticalOrder(tree.root);
    }

    /**
     Source  :   GeekForGeek
     Link    :   https://www.geeksforgeeks.org/level-order-tree-traversal/
     */


}
