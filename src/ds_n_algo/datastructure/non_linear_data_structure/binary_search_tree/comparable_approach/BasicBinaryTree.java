package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.comparable_approach;

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
    private int size;

    public BasicBinaryTree() {
        root = null;
    }

    public int size() {
        return size;
    }
/*      we start computation from ROOT node. If the data which we want to insert is greater than the ROOT node
        it goes to RIGHT if it is less than the root node then goes to left.*/
    public void add(X item) {
        Node node = new Node(item);
        if (root == null) {
            this.root = node;
            System.out.println("Set Node:" + node.getItem());
            this.size++;
        } else
            insert(this.root, node);
    }

    /*Utility method use to link between two nodes: takes PARENT and CHILD node and associate them*/
    private void insert(Node parent, Node child) {
        /*if child is less than parent, it goes to left side*/
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            /*if left node is null, child node will inserted that place*/
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else
                insert(parent.getLeft(), child);//recursive call
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            /*if right node is null, child node will inserted that place*/
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else
                insert(parent.getRight(), child);//recursive call
        }

    }


    public boolean contains(X item) {
        Node currentnode = getNode(item);

        if (currentnode == null)
            return false;
        else
            return true;
    }

    private Node getNode(X item) {
        Node currentNode = this.root;
        while (currentNode != null) {
            int val = item.compareTo(currentNode.getItem());

            if (val == 0)
                return currentNode;
            else if (val < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }
        return null;
    }


    public boolean delete(X item) {
        boolean deleted = false;

        if (this.root == null)
            return false;

        Node currentNode = this.getNode(item);

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
        }
        return deleted;
    }

    private void unlink(Node currentNode, Node newNode) {
        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode)
            currentNode.getParent().setRight(newNode);
        else
            currentNode.getParent().setLeft(newNode);
    }


    /*INORDER->  LEFT-ROOT-RIGHT*/
    public void print_in_order(Node node) {

        if (node == null)
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

    /*PREORDER->  ROOT-LEFT-RIGHT*/
    public void print_pre_order(Node node) {

        if (node == null)
            return;
        root:
        System.out.print(node.getItem() + "<->");
        left:
        if (node.getLeft() != null) {
            //node=node.getLeft();
            print_in_order(node.getLeft());
        }

        right:
        if (node.getRight() != null) {
            //node = node.getRight();
            print_in_order(node.getRight());
        }
    }

    /*POSTORDER->  LEFT-RIGHT-ROOT*/
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
        integer_tree.add(22);
        integer_tree.add(11);
        integer_tree.add(44);
        integer_tree.add(55);
        integer_tree.add(66);

        System.out.println(integer_tree.root);
        integer_tree.delete(55);

        System.out.println(integer_tree.root);
        System.out.println("\n");

        integer_tree.print_in_order(integer_tree.root);
        System.out.println("\n");
        integer_tree.print_pre_order(integer_tree.root);
        System.out.println("\n");
        integer_tree.print_post_order(integer_tree.root);
        System.out.println("\n");

        BasicBinaryTree<String> string_tree = new BasicBinaryTree<>();
        string_tree.add("ritam");
        string_tree.add("poulami");
        string_tree.add("astha");
        string_tree.add("tina");
        string_tree.add("priyanka");

        System.out.println(string_tree.root);

    }
}












