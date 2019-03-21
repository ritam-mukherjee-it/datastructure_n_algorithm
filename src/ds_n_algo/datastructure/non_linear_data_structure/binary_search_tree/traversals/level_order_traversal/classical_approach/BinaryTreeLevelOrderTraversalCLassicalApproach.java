package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.traversals.level_order_traversal.classical_approach;


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
     * @apiNote find height of the tree and and traverse each level
     */
    public void printLevelOrder()
    {
        int h = getHeight(root);
        for (int i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /**
     * @apiNote  print all nodes at a given level
     * @param root
     * @param level
     */
    private void printGivenLevel(Node root,int level){
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getItem() + " ");
        else if (level > 1)
        {
            printGivenLevel(root.getLeft(), level-1);
            printGivenLevel(root.getRight(), level-1);
        }
    }

    /**
     * @apiNote longest path from given node to leaf node among it's children
     * @param node : determine the height of tree from given node
     * @return numeric value of height
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        else {
            int lheight = getHeight(node.getLeft());
            int rheight = getHeight(node.getRight());

            if (lheight > rheight)
                return lheight + 1;
            else
                return rheight + 1;
        }
    }
}
public class BinaryTreeLevelOrderTraversalCLassicalApproach {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree=new BinarySearchTree<>();

        Node root=new Node(1);
        root.setLeft(new Node(6));
        root.setRight( new Node(8));
        root.getLeft().setLeft(new Node(10));
        root.getLeft().setRight(new Node(12));
        root.getRight().setLeft(new Node(16));
        root.getRight().setRight(new Node(18));

        tree.setRoot(root);
        tree.printLevelOrder();
    }
}
