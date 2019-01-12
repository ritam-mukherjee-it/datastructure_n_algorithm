package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.iterative_approach;
/**
 * Created by Ritam Mukherjee on 01-11-2017.
 * Source   :   HackerRankD
 * Link     :   https://www.youtube.com/watch?v=M6lYob8STMI&index=13&list=PLGLfVvz_LVvReUrWr94U-ZMgjYTQ538nT
 */


class Node{
    int key;
    String name;

    Node left;
    Node right;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "key=" + key +
                ", name='" + name + '\'' ;
    }


}
public class BinarySearchTreeIterative {
    Node root;

    public void addNode(int key,String name){
        Node node=new Node(key,name);

        if(root==null)
            root=node;
        else{
            Node current=root;
            Node parent;
            while (true){
                parent=current;
                if(node.key<current.key){
                    current=current.left;
                    if(current==null) {
                        parent.left= node;
                        return;
                    }

                }else{
                    current=current.right;
                    if(current==null) {
                        parent.right = node;
                        return;
                    }

                }

            }
        }


    }

    public  boolean remove(int data){
        /*to be added later from Darek banas*/
        return false;
    }

    public void printInorder(Node node) {
        left:
        if (node.left != null)
           printInorder(node.left);
        root:
        System.out.println(node);
        right:
        if (node.right != null)
            printInorder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTreeIterative tree=new BinarySearchTreeIterative();

        tree.addNode(33,"Poulami");
        tree.addNode(22,"astha");
        tree.addNode(11,"ritanm");
        tree.addNode(55,"debosmita");
        tree.addNode(55,"deboleena");

        tree.printInorder(tree.root);
    }
}
