package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.traversals.spiral_order_traversal.comparable_approach_double_stack.anticlockwise;

import java.util.Stack;

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
     *
     * @param rootNode
     */
    public void printSpiralOrder(Node rootNode) {

        // break point if null then return
        if (rootNode == null) {
            return;
        }

        /**
         * current level    :  the processing level
         * nextLevel        :   while processing currentLevel all its child nodes are added at nextLevel
         */
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        /* start processing from root node , currentLevel-> root*/
        currentLevel.push(rootNode);

        /*as it is 'clockwise traversal' 'root' is left to right and its immediate child 'right to left'*/
        boolean rightToLeft = true;

        /*traverse current level until it reaches empty*/
        while (!currentLevel.isEmpty()) {

            /*pop out of stack : As stack is LIFO so the order inserted node opposite order it pop*/
            Node node = currentLevel.pop();

            /* print the element of the node  */
            System.out.print(node.getItem() + " ");

            /** store data according to current order
             * leftToRight -> first push left child then push right child.
             * rightToLeft -> first push right child then push left child.
             */
            if (rightToLeft) {
                if (node.getRight() != null) {
                    nextLevel.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    nextLevel.push(node.getLeft());
                }
            }
            else {
                if (node.getLeft() != null) {
                    nextLevel.push(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevel.push(node.getRight());
                }

            }

            /**
             * swapping happen between 'currentLevel' and 'nextLevel'
             * while processing of currentlevel completes printing order swapping happen.
             */
            if (currentLevel.isEmpty()) {
                rightToLeft = !rightToLeft;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                System.out.println("");
            }
        }


}

    public void printSpiralOrder() {
        printSpiralOrder(this.root);
    }
}

public class BinaryTreeSpiralOrderTraversal<X extends Comparable<X>> {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        Node root = new Node(1);

        root.setLeft(new Node(2));
        root.setRight(new Node(3));

        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));

        root.getLeft().getLeft().setLeft(new Node(8));
        root.getLeft().getLeft().setRight(new Node(9));
        root.getLeft().getRight().setLeft(new Node(10));
        root.getLeft().getRight().setRight(new Node(11));
        root.getRight().getLeft().setLeft(new Node(12));
        root.getRight().getLeft().setRight(new Node(13));
        root.getRight().getRight().setLeft(new Node(14));
        root.getRight().getRight().setRight(new Node(15));

        tree.setRoot(root);
        tree.printSpiralOrder();
    }

}
