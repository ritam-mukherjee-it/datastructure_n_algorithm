package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.level_order_traversal.queue_approach;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This is the Most Simplest Approach
 * Algorithm:
 * For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

 printLevelorder(tree)
        1. Create an empty queue q
        2. temp_node = root //start from root
        3. Loop while temp_node is not NULL
                a) print temp_node->data.
                b) Enqueue temp_node’s children (first left then right children) to q
                c) Dequeue a node from q and assign it’s value to temp_node

        Time Complexity: O(n) where n is number of nodes in the binary tree
        *
 */
public class BinaryTree_LevelOrder_Queue_II {

    Node root;
    public void PrintLevelOrder(Node root){
        if(root==null)
            throw new IllegalArgumentException("Underflow");
        Queue<Node> queue=new LinkedList<>() ;

        queue.add(root);

       while(!queue.isEmpty()){
           Node tempNode=queue.poll();
           System.out.print(tempNode.data+" ");

           if(tempNode.left!=null)
               queue.add(tempNode.left);
           if(tempNode.right!=null)
               queue.add(tempNode.right);
       }


    }

    public static void main(String[] args) {
        BinaryTree_LevelOrder_Queue_II tree=new BinaryTree_LevelOrder_Queue_II();
        tree.root= new Node(1);
        tree.root.left= new Node(8);
        tree.root.right= new Node(6);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.right.left= new Node(4);
        tree.root.right.right= new Node(5);

        tree.PrintLevelOrder(tree.root);
    }


    }
