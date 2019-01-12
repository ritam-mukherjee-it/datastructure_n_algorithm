package ds_n_algo.datastructure.linear_data_structure.stacks.list_implementation;

public class Stack_List {
    /*The Queue class should have a static node field*/
    private static class Node{
        /*The node should have one data field and reference of another node field*/
        private int data;
        private Node next;
        /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    /*Method 1 #  isEmpty() ->If head is null return true else return false*/
    public boolean isEmpty(){
        if(top==null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    /*Method 2# peek() -> If queue is not empty return head data*/
    public int peek(){
        return top.data;
    }

    /*Method 3 # push(data)    -> this will push element at the top of the stacks*/
    public void push(int data){
        Node node=new Node(data);

        /*new node is now pointing top element and itself will consider as "top" element*/
        node.next=top;
        top=node;

    }

    /*Method 4 # pop() -> element's data from top node */
    public Integer pop(){
        /*select top elements data*/
            int data=top.data;
        /* the next element is now consider as top element*/
            top=top.next;
            return  data;
    }

    public void display(){
        while(top!=null){

            System.out.println("[   "+top.data+"    ]");
            System.out.println("    ||  ");
            pop();
        }
    }

    public static void main(String[] args) {
        Stack_List stack= new Stack_List();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);

        stack.display();
    }
}
