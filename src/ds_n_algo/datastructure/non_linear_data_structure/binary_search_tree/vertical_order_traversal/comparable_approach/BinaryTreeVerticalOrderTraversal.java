package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.vertical_order_traversal.comparable_approach;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/*All tree a private class 'Node' which specify building block of a TREE*/
class Node<X extends Comparable<X>> {

    /*It represents the value of node,which instantiate at the time of node creation*/
    private X item;
    /*All node having two child node LEFT & RIGHT*/
    private Node left;
    private Node right;

    /*Node also have a reference of PARENT node*/
    private Node parent;

    /*Constructor:
        1.Use to specify item/data at the time of creation
        2.Also use initialize all pointer's*/
    public Node(X item) {
        this.item = item;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public X getItem() {
        return item;
    }

    public void setItem(X item) {
        this.item = item;
    }


}

class BinarySearchTree<X extends Comparable> {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @apiNote recursive method which enter in a MAP
     *  Key :   each horizontal distance as key
     *  Value:  avector list of all nodes for spesified horizontal distance
     * @param node
     * @param horizontalDistance
     * @param horizontalDistanceNodeMap
     */
    private void getVerticalOrder(Node node, int horizontalDistance, TreeMap<Integer, Vector<X>> horizontalDistanceNodeMap) {

        /*Break point of recursive method*/
        if (node == null)
            return;

        /**
         * first check whether for the given horizontal distance any list already enlisted in MAP
         */
        Vector<X> horizontalDistance_vertical_list = horizontalDistanceNodeMap.get(horizontalDistance);

        /**
         * If for the horizontal distance no vector list then create a new vector list and add element
         * If enty is there add element at existing vector list
         */
        if (horizontalDistance_vertical_list == null) {
            horizontalDistance_vertical_list = new Vector<>();
            horizontalDistance_vertical_list.add((X) node.getItem());
        } else
            horizontalDistance_vertical_list.add((X) node.getItem());

        /**
         * put horizontal distance as key in MAP and vector list as value in MAP
         */
        horizontalDistanceNodeMap.put(horizontalDistance, horizontalDistance_vertical_list);

        /**
         * recursive cll for left and right subtree of the node
         */
        getVerticalOrder(node.getLeft(), horizontalDistance - 1, horizontalDistanceNodeMap);
        getVerticalOrder(node.getRight(), horizontalDistance + 1, horizontalDistanceNodeMap);
    }

    /**
     * @apiNote      The main function to print vertical oder of a binary tree with given node
     * @param node
     */
    void printVerticalOrder(Node node) {
        /* Create a map and store vertical oder in map using function getVerticalOrder()*/
        TreeMap<Integer, Vector<X>> horizontalDistanceNodeMap = new TreeMap<>();
        int horizontalDistance = 0;
        getVerticalOrder(node, horizontalDistance, horizontalDistanceNodeMap);

        // Traverse the map and print nodes at every horizontal distance (hd)
        for (Map.Entry<Integer, Vector<X>> entry : horizontalDistanceNodeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    public void printVerticalOrder() {
        printVerticalOrder(this.root);
    }
}
public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.setLeft( new Node(2));
        root.setRight( new Node(3));
        root.getLeft().setLeft( new Node(4));
        root.getLeft().setRight( new Node(5));
        root.getRight().setLeft( new Node(6));
        root.getRight().setRight( new Node(7));
        root.getRight().getLeft().setRight( new Node(8));
        root.getRight().getRight().setRight( new Node(9));
        System.out.println("Vertical Order traversal is");

        tree.setRoot(root);
        tree.printVerticalOrder();
    }

}
