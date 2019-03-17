package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.comparable_approach;

import ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.TreeColor;

public class BasicBinaryTree<X extends Comparable<X>> {

    /*All tree a private class 'Node' which specify building block of a TREE*/
    private class Node {

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


        /*This is Utility method print elements of tree{Ex: From inner class we can call outer class method}*/
        @Override
        public String toString() {
            print_in_order(this);
            return "";
        }
    }


    /*constructor of Basic Binary Treee  */

    private Node root;
    public BasicBinaryTree() {
        root = null;
    }

    private int size;
    public int size() {
        return size;
    }
    /* we start computation from ROOT node. If the data which we want to insert is greater than the ROOT node
        it goes to RIGHT if it is less than the root node then goes to left.*/

    /**
     * start computation from ROOT node. If the data which we want to insert is greater than the ROOT node
     * it goes to RIGHT, if it is less than the root node then goes to LEFT.
     * @param item : It represents the value of node,which instantiate at the time of node creation
     */
    public void add(X item) {
        Node node = new Node(item);
        if (root == null) {
            this.root = node;
            System.out.println("Root Node set as :" + node.getItem());
            this.size++;
        } else
            insert(this.root, node);
    }


    /**
     * Utility method use to link between two nodes: takes CURRENT-NODE and NEW-NODE node and associate them
     * @param currentNode    :   refers presently computing node.
     * @param newNode     :   the node which to be inserted
     */
    private void insert(Node currentNode, Node newNode) {

        /*if newNode value is less than currentNode, then newNode goes to left side*/
        if (newNode.getItem().compareTo(currentNode.getItem()) < 0) {
            /*if left node is null,then newNode node will inserted as left child*/
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                newNode.setParent(currentNode);
                this.size++;
            } else
                insert(currentNode.getLeft(), newNode);//recursive call
        } else if (newNode.getItem().compareTo(currentNode.getItem()) > 0) {
            /*if right node is null, is null,then newNode node will inserted as left child*/
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                newNode.setParent(currentNode);
                this.size++;
            } else
                insert(currentNode.getRight(), newNode);//recursive call
        }
    }

    /**
     * @apiNote Whether any NODE exist in TREE with provided value
     * @param value
     * @return if a node found with provided element return TRUE else FALSE
     */
    public boolean contains(X value) {
        Node currentNode = getNode(value);

        if (currentNode == null)
            return false;
        else
            return true;
    }

    /**
     * @apiNote It is an utility method start comparing element with ROOT node value,
     * if element==item then consider MATCHED
     *      if element< item than process LEFT subtrees
     *      if element> item than process RIGHT subtrees
     * @param element  : check whether any NODE available with provided element
     * @return Node : if NODE match then return NODE otherwise return null
     */
    private Node getNode(X element) {
        Node currentNode = this.root;
        while (currentNode != null) {
            int val = element.compareTo(currentNode.getItem());

            match:/*if the value is match return the Node*/
            if (val == 0)
                return currentNode;
            else
                less_than_current:/*if the value is less than CURRENT start looking in LEFT side*/
                if (val < 0)
                currentNode = currentNode.getLeft();
            else
                more_than_current:/*if the value is more than CURRENT start looking in RIGHT side*/
                currentNode = currentNode.getRight();
        }
        return null;
    }

    /**
     * @apiNote fnd the nodewith assiing argument value and delete that
     * @param value  :   The value of the NODE to be deleted
     * @return
     */
    public boolean delete(X value) {
        boolean deleted = false;

        if (this.root == null)
            return false;

        Node currentNode = this.getNode(value);

        if (currentNode != null) {

            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                deleted = true;
            } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            } else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                unlink(currentNode, currentNode.getLeft());
                deleted = true;
            } else {
                Node child = currentNode.getLeft();

                while (child.getRight() != null && child.getLeft() != null) {
                    child = child.getRight();
                }

                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlink(currentNode, child);
                deleted = true;

            }
            if(deleted) {
                this.size--;
            }
        }
        return deleted;
    }

    /**
     * This utility method does detaching activity
     * @param currentNode   :   refers the node which will be deleted
     * @param newNode       :   refers the node which will take place the location
     */
    private void unlink(Node currentNode, Node newNode) {
        /*if currentNode is a root Node, that is no Parent node then newNode will consider as root*/
        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        }
        else if (currentNode.getParent().getRight() == currentNode)
            currentNode.getParent().setRight(newNode); /*Is current node RIGHT child of its parent node?*/
        else
            currentNode.getParent().setLeft(newNode);/*Is current node LEFT child of its parent node?*/
    }


    /**
     * INORDER traversal
     * @apiNote LEFT-NODE - ROOT-NODE - RIGHT-NODE
     * @param node  : the node to be inserted
     */
    public void print_in_order(Node node) {

        if (node == null) //break-point
            return;
        left:
        if (node.getLeft() != null) {
            //node=node.getLeft();
            print_in_order(node.getLeft());
        }
        root:
        System.out.print(node.getItem() + "<->");
        right:
        if (node.getRight() != null) {
            //node = node.getRight();
            print_in_order(node.getRight());
        }
    }

    /**
     * PRE-ORDER traversal
     * @apiNote ROOT-LEFT-RIGHT
     * @param node
     */
    public void print_pre_order(Node node) {

        if (node == null)//break-point
            return;
        root:
        System.out.print(node.getItem() + "<->");
        left:
        if (node.getLeft() != null) {
            //node=node.getLeft();
            print_pre_order(node.getLeft());
        }

        right:
        if (node.getRight() != null) {
            //node = node.getRight();
            print_pre_order(node.getRight());
        }
    }

    /**
     * POST ORDER traversal
     * @apiNote LEFT-RIGHT-ROOT
     * @param node
     */
    public void print_post_order(Node node) {

        if (node == null)
            return;
        left:
        if (node.getLeft() != null) {
            //node=node.getLeft();
            print_post_order(node.getLeft());
        }
        right:
        if (node.getRight() != null) {
            //node = node.getRight();
            print_post_order(node.getRight());
        }
        root:
        System.out.print(node.getItem() + "<->");
    }

    public static void main(String[] args) {
        BasicBinaryTree<Integer> integer_tree = new BasicBinaryTree<>();
        integer_tree.add(60);
        integer_tree.add(30);
        integer_tree.add(90);
        integer_tree.add(20);
        integer_tree.add(40);
        integer_tree.add(80);
        integer_tree.add(100);
        System.out.println(TreeColor.ANSI_GREEN+"\nInorder traversal view of the tree");
        integer_tree.print_in_order(integer_tree.root);
        System.out.println(TreeColor.ANSI_CYAN+"\nPre traversal view of the tree");
        integer_tree.print_pre_order(integer_tree.root);
        System.out.println(TreeColor.ANSI_PURPLE+"\nPost order traversal view of the tree");
        integer_tree.print_post_order(integer_tree.root);

        System.out.println(TreeColor.ANSI_RESET+"\nFind element in a tree_____________________");
        System.out.println(TreeColor.ANSI_BLUE+"Is the tree contains 100?"+integer_tree.contains(100));
        System.out.println(TreeColor.ANSI_BLUE+"Is the tree contains 40?"+integer_tree.contains(40));
        System.out.println(TreeColor.ANSI_BLUE+"Is the tree contains 75?"+integer_tree.contains(75));



        System.out.println(TreeColor.ANSI_RESET+"Delete element in a tree_____________________");
        System.out.println(TreeColor.ANSI_RED+"Is the tree contains 30?"+integer_tree.contains(30));
        System.out.println(TreeColor.ANSI_RED+"Is the tree contains 90?"+integer_tree.contains(90));
        integer_tree.delete(30);
        integer_tree.delete(90);

        /*a bug is here: if after deletion we are going to print getting stack overflow error*/
        System.out.println(TreeColor.ANSI_RED+"Is the tree contains 30?"+integer_tree.contains(30));
        System.out.println(TreeColor.ANSI_RED+"Is the tree contains 90?"+integer_tree.contains(90));



       // integer_tree.print_in_order(integer_tree.root);

        BasicBinaryTree<String> string_tree = new BasicBinaryTree<>();
        string_tree.add("ritam");
        string_tree.add("poulami");
        string_tree.add("astha");
        string_tree.add("tina");
        string_tree.add("priyanka");

        System.out.println(string_tree.root);

    }
}












