package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.level_order_traversal.queue_comparable;

import java.util.LinkedList;
import java.util.Queue;
/*All tree a private class 'Node' which specify building block of a TREE*/
 class Node<X extends Comparable<X>>{

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
        this.left=null;
        this.right=null;
        this.parent=null;
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
public class BinaryTree_LevelOrder_Comparable_Queue<X extends Comparable<X>> {

    Node Root;

    public Node getRoot() {
        return Root;
    }

    public void setRoot(Node root) {
        Root = root;
    }

    public void PrintLevelOrder(Node root) {
        if (root == null)
            throw new IllegalArgumentException("Underflow");
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (true) {
            int node_count = queue.size();
            if (node_count == 0)
                break;

            while (node_count > 0) {
                Node node = queue.peek();
                System.out.println(node.getItem());
                queue.remove();//elemenate printed element

                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
                node_count--;
            }
            System.out.println("<->");
        }
    }
    public static void main(String[] args) {
        BinaryTree_LevelOrder_Comparable_Queue tree=new BinaryTree_LevelOrder_Comparable_Queue();

        Node root=new Node(1);
        root.setLeft(new Node(6));
        root.setRight( new Node(8));
        root.getLeft().setLeft(new Node(10));
        root.getLeft().setRight(new Node(12));
        root.getRight().setLeft(new Node(16));
        root.getRight().setRight(new Node(18));

        tree.setRoot(root);
        tree.PrintLevelOrder(tree.getRoot());
    }

}
