package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.programs;



public class BinaryTreeNodeAdd<X> {
    public static void main(String[] args) {
/*        BiConsumer<Node,Node> add= (Node parent, Node child)->{
            *//*if child is less than parent, it goes to left side*//*
            if (child.getItem().compareTo(parent.getItem()) < 0) {
                *//*if left node is null, child node will inserted that place*//*
                if (parent.getLeft() == null) {
                    parent.setLeft(child);
                    child.setParent(parent);
                    this.size++;
                } else
                    insert(parent.getLeft(), child);//recursive call
            } else if (child.getItem().compareTo(parent.getItem()) > 0) {
                *//*if right node is null, child node will inserted that place*//*
                if (parent.getRight() == null) {
                    parent.setRight(child);
                    child.setParent(parent);
                    this.size++;
                } else
                    insert(parent.getRight(), child);//recursive call
            }*/
    }
}
