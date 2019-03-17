package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.programs;



public class Node<X> {

    /*It represents the value of node,which instantiate at the time of node creation*/
    private X item;
    /*All node having two child node LEFT & RIGHT*/
    Node left;
    Node right;

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
