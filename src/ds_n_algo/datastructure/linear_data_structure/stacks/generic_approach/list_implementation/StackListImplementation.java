package ds_n_algo.datastructure.linear_data_structure.stacks.generic_approach.list_implementation;

class Node<X> {
    private X data;
    private Node<X> next;

    /*It should have one constructor so that at the time of Node creation providing value is mandatory*/
    public Node(X data) {
        this.data = data;
    }

    public X getData() {
        return data;
    }

    public void setData(X data) {
        this.data = data;
    }

    public Node<X> getNext() {
        return next;
    }

    public void setNext(Node<X> next) {
        this.next = next;
    }
}

class Stack<X> {
    private Node<X> top;


    public Node<X> getTop() {
        return top;
    }

    public void setTop(Node<X> top) {
        this.top = top;
    }

    /*Method 1 #  isEmpty() ->If head is null return true else return false*/
    public boolean isEmpty() {
        if (top == null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    /*Method 2# peek() -> If queue is not empty return head data*/
    public X peek() {
        return top.getData();
    }

    /*Method 3 # push(data)    -> this will push element at the top of the stacks*/
    public void push(X data) {
        Node<X> node = new Node(data);

        /*new node is now pointing top element and itself will consider as "top" element*/
        node.setNext(top);
        this.setTop(node);

    }

    /*Method 4 # pop() -> element's data from top node */
    public X pop() {
        /*checking Queue is empty or not*/
        if (top.getData()==null)
            throw new IllegalStateException("UnderFlow");
        /*select top elements data*/
        X data = top.getData();
        /* the next element is now consider as top element*/
        top = top.getNext();
        return data;
    }

    public void display() {

        Node current=this.getTop();
        while (current != null) {

            System.out.println("[   " + current.getData() + "    ]");
            System.out.println("    ||  ");
            current=current.getNext();
        }
    }
}

public class StackListImplementation {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(11);
        integerStack.push(22);
        integerStack.push(33);
        integerStack.push(44);
        integerStack.push(55);

        integerStack.display();

        System.out.println("--------------------------------------");
        int pop_1=integerStack.pop();
        System.out.println(pop_1+" has popped");
        int pop_2=integerStack.pop();
        System.out.println(pop_2+" has popped");

        integerStack.display();

    }

}
