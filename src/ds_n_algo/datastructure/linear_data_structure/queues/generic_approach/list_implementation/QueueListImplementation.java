package ds_n_algo.datastructure.linear_data_structure.queues.generic_approach.list_implementation;

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

class Queue<X> {
    /* All que should having one producer_consumer Node called "Head" and one ending node called "Tail"*/
    private Node head; //value should be dequeue from head
    private Node tail; //value should be added at tail

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /*Method 1 #  isEmpty() ->If head is null return true else return false*/
    public boolean isEmpty() {
        if (head == null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    /*Method 2# peek() -> If queue is not empty return head data*/
    public X peek() {
        if (isEmpty())
            return null;
        else
            return (X) head.getData();
    }

    /*Method 3 # enqueue(data)    -> this will enqueue element at the end of the Queue*/
    public void enqueue(X data) {

        /*create a node with provided data*/
        Node node = new Node(data);

        /*if tail not null then tail will point new Node and new Node will consider as "tail"*/
        if (tail != null) {
            tail.setNext(node);
        }
        this.setTail(node);


        /*If in special scenario where head is null, then new node will also consider as head node
         * This is the situation when queue have only one element*/
        if (head == null)
            this.setHead(node);

    }

    /*Method 4 # dequeue() -> elemenete data from head node*/
    public X dequeue() {

        /*dequeue will happen from head so head element's data should select,
         * and head elements's reference node will consider as new "head" element*/
        X data = (X) head.getData();
        this.setHead(head.getNext());

        /*if new head element is null then same node will also consider as tail element*/
        if (head == null)
            tail = null;

        return data;
    }

    public void display() {

        Node current=head;
        while (current != null) {
            System.out.print("| " + current.getData() + " |->");
            current=current.getNext();
        }

    }
}
public class QueueListImplementation {
    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.enqueue(55);

        queue.display();
        System.out.println("---------------------");


        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
