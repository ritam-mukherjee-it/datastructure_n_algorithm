package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree.level_order_traversal.queue_approach;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_LevelOrder_Queue {

    Node root;
    public void PrintLevelOrder(Node root){
        if(root==null)
            throw new IllegalArgumentException("Underflow");
        Queue<Node> queue=new LinkedList<>() ;

        queue.add(root);

        while(true){
            int node_count=queue.size();
            if(node_count==0)
                break;

            while (node_count>0){
                Node node=queue.peek();
                System.out.println(node.data);
                queue.remove();//elemenate printed element

                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                node_count--;
            }
        }


    }

    public static void main(String[] args) {
        BinaryTree_LevelOrder_Queue tree=new BinaryTree_LevelOrder_Queue();
        tree.root= new Node(1);
        tree.root.left= new Node(8);
        tree.root.right= new Node(6);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.PrintLevelOrder(tree.root);
    }


    }
