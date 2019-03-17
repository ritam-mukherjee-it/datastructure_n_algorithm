TREE:
Tree is a data structure having NODES and there are connection between NODES.

In tree there is only one path to go from a ROOT node to any other node.
If there are more than one way to traverse from ROOT to other node then that is not tree.

Leaf NODE: Node having no child.

---------------------------------------------------------------------------------------------------
										BINARY TREE
---------------------------------------------------------------------------------------------------
1. Every node having almost one child,Left child should be smaller than the parent
	and Right child should be greater than the parent.
2. Keep always its keys as sorted so that for look up and other application,
	the rule of "binary search" is valid.
3. Advantage	:On every decision we get rid of half of the data in which we are searching.
	Time Complexity	:	O(log N)
4. This is much better than the linear search of an unsorted array[ O(N)] but slower than the
	corresponding operation of unsorted array.
5. If we want to find smallest node we have to go left as far as possible and if we want to find largest
    we have to go Right as much as possible.




Building Block if a Tree is Node:


===========================================================================================================
										NODE [ GENERIC COMPLEX FORM]
============================================================================================================
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


=================================================================================================
											NODE [SIMPLEST FORMAT]
=================================================================================================

class Node
{
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
=====================================================================================================
                            HEIGHT of a Tree
-----------------------------------------------------------------------------------------------------
HEIGHT: 
1. No of 'Layers' the tree contain.
2. The length  of the path from the 'ROOT" to the deepest node in the tree.



RULE #1	"If the height of a tree is 'h' then the layer 'h' maximum can contain 2^(h-1) nodes."

RULE #2	 h~O(log N) the height 'h' is always proportional to O(log N)
		If the rule is true then we can say the tree is 'Balanced Binary Tree'.
		If it is not tree, then the tree is 'Unbalanced' and 'Asymmetric'
		
RULE #3 The height of the tree should maintain minimum i.e. h=log n	
		for unbalanced tree this relationship is not valid and operation's running time no more logarithmic.
		It is contradictory for the thumb rule of the BST.
		
		
		
Computation Policy:
-------------------
Compute the "height" of a tree -- the number of  nodes along the longest path from the root node
    down to the farthest leaf node.


    public int getHeight(Node root){
        if(root==null)
            return 0;
        else{
            int lheight=getHeight(root.left);
            int rheight=getHeight(root.right);

            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }
    }
---------------------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------------
										LEVEL ORDER TRAVERSAL
-----------------------------------------------------------------------------------------------
METHOD 1 (Use function to print a given level)

Algorithm:
There are basically two functions in this method. 
		1. printGivenLevel	:	First One is to print all nodes at a given level; 
		2. printLevelorder	:	The other is to print level order traversal of the tree . 
					printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

Another utility function is needed to determine height of the tree;
		3. height(root)		:  this method is used by printlevelorder() to determine how many levels it has to print

					/*Function to print level order traversal of tree*/
					printLevelorder(tree)
						for d = 1 to height(tree)
						   printGivenLevel(tree, d);

					/*Function to print all nodes at a given level*/
					printGivenLevel(tree, level)
						if tree is NULL then return;
						if level is 1, then
						    print(tree->data);
						else if level greater than 1, then
						    printGivenLevel(tree->left, level-1);
						    printGivenLevel(tree->right, level-1);

					/*Function(utility) to print all nodes at a given level*/    	
					height(tree)
						if root is NULL then return;
						if root has left or right child increase height by 1
						whichever bigger among left and right height return that


Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
 So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).




METHOD 2 (Use Queue)

Algorithm:
For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

printLevelorder(tree)
		1) Create an empty queue q
		2) temp_node = root /*start from root*/
		3) Loop while temp_node is not NULL
		    a) print temp_node->data.
		    b) Enqueue temp_node’s children (first left then right children) to q
		    c) Dequeue a node from q and assign it’s value to temp_node

Time Complexity: O(n) where n is number of nodes in the binary tree



--------------------------------------------------------------------------------------------------------------------
							VERTICAL ORDER TRAVERSAL
--------------------------------------------------------------------------------------------------------------------
 The efficient solution based on hash map is discussed. 

 HD[Horizontal Distance ]
	 1. We need to check the Horizontal Distances from root for all nodes. 
	 2. If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. 
	 HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance
	 and a left edge is considered as -1 horizontal distance.
	
We can do pre-order traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs.
We initially pass the horizontal distance as 0 for root. 
			For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. 
			For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1. 
			For every HD value, we maintain a list of nodes in a hasp map. Whenever we see a node in traversal, 
we go to the hash map/ tree map entry and add the node to the hash map using HD;
key 	:	HD as a key in map.
value 	:	A vector or List which contains all nodes having same HD value.

The Ideology is All nodes having same HD value consider as they falls in same vertical line.



-------------------------------------------------------------------------------------------------------------
										INSERTION
--------------------------------------------------------------------------------------------------------------

	we start computation from ROOT node. If the data which we want to insert is greater than the ROOT node
	it goes to RIGHT if it is less than the root node then goes to left.

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



-------------------------------------------------------------------------------------------------------------------
		                                SEARCH
-------------------------------------------------------------------------------------------------------------------

1.we start searching from ROOT node. If the data which we want to search is greater than the ROOT node
we search to RIGHT  if it is less than the root node then search at left side.
2. Every searching we discard half of its children. searching Complexity : O(log N)


--------------------------------------------------------------------------------------------------------------------
										DELETE
--------------------------------------------------------------------------------------------------------------------
For delete there are three situations may arise:
1. LEAF node delete:
	Just have to make that leaf node as 'NULL'
	Complexity:
				we have o find the item 			:	O(log N)
				we have to delete it or set to null	:	O(1)
				--------------------------------------------------
				TOTAL								~= 	O(log N)
				---------------------------------------------------
2. Single child node delete: 
	We have to update the reference. the 'to be deleted' nodes PARENT should point to its CHILD.
	Complexity:
				we have o find the item 			:	O(log N)
				we have to update the reference		:	O(1)
				--------------------------------------------------
				TOTAL								~= 	O(log N)
				---------------------------------------------------
3. two children we have to delete:
	We have to find out largest item in left subtree('Predecessor' of the to be deleted node) or 
	smallest item in right subtree('Successor' of to be deleted node).
	Either we have to swap predecessor or successor with to be deleted node.
	Complexity:
				we have o find the item 			:	O(log N)
				we have to successor/predecessor	:	O(log N)
				we have to update the reference		:	O(1)
				--------------------------------------------------
				TOTAL								~= 	O(log N)
				---------------------------------------------------
				
				
---------------------------------------------------------------------------------------------------------------------------
								TRAVERSAL
---------------------------------------------------------------------------------------------------------------------------
Visit every node of the tree known as Traversal.


1. INORDER traversal	: traverse LEFT subtree + ROOT subtree + RIGHT subtree recursively
					
					/*INORDER->  LEFT-ROOT-RIGHT*/
						public void print_in_order(Node node) {

							if(node==null)
								return;
							left:
							if ( node.getLeft()!= null) {
								//node=node.getLeft();
								print_in_order(node.getLeft());
							}
							root:
							System.out.print(node.getItem()+"<->");
							right:
							if ( node.getRight()!= null) {
								//node = node.getRight();
								print_in_order(node.getRight());
							}
						}
						
2. PREORDER traversal	: traverse ROOT subtree+ LEFT subtree + RIGHT subtree recursively
						/*PREORDER->  ROOT-LEFT-RIGHT*/
						public void print_pre_order(Node node) {

							if(node==null)
								return;
							root:
							System.out.print(node.getItem()+"<->");
							left:
							if ( node.getLeft()!= null) {
								//node=node.getLeft();
								print_in_order(node.getLeft());
							}

							right:
							if ( node.getRight()!= null) {
								//node = node.getRight();
								print_in_order(node.getRight());
							}
						}

2. POSTORDER traversal	: traverse  LEFT subtree + RIGHT subtree + ROOT subtree recursively

						/*POSTORDER->  LEFT-RIGHT-ROOT*/
						public void print_post_order(Node node) {

							if(node==null)
								return;
							left:
							if ( node.getLeft()!= null) {
								//node=node.getLeft();
								print_post_order(node.getLeft());
							}
							right:
							if ( node.getRight()!= null) {
								//node = node.getRight();
								print_post_order(node.getRight());
							}
							root:
							System.out.print(node.getItem()+"<->");
						}
						
