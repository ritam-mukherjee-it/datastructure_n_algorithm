package ds_n_algo.datastructure.linear_data_structure.linkedlists.single_linkedlist.comparable_approach.two_pointer;

/*Node represents basic underlying data structure within LinkedList*/
class Node<X extends Comparable> {

    X item;  // also refer as data
    Node nextNode;  //pointer to keep link of Next node

    /*Constructor: make compulsory of providing data at the time of Node creation*/
    public Node(X item) {
        this.item=item;
    }

    public X getItem() {
        return item;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedList<X extends Comparable>{

    /*these two pointer keeps track of starting point and end point of List*/
    private Node first;
    private Node last;

    /*nodeCount variable responsible to keep count of size*/
    private int nodeCount;

    /*Compulsory Initialization*/
    public LinkedList() {
        first=null;
        last=null;
        nodeCount=0;
    }

    /*Utility method: to track size of List with NODECOUNT variable*/
    public int size(){
        return nodeCount;
    }

    /*Complexity    :   O(1)*/
    public void add(X item){
            /*if NODE-COUNT is zero i.e SIZE is empty
                1. The newly instantiated node is consider as FIRST node ;
                2. The FIRST node is also treated as LAST node*/
        if(nodeCount==0){
            first=new Node(item);
            last=first;
        }
        else{
           /* otherwise
                1. the newly instantiated node consider as new last node;
                2. Grab the old LAST NODE and point that to new last node;
                3. The new last node now onwards treat as LAST*/
            Node newLastNode=new Node(item);
            last.setNextNode(newLastNode);
            last=newLastNode;
        }
        nodeCount++; //increase size of List

    }

    public X remove(){

        /*Pre Caution: If List is empty UNDERFLOW*/
        if(first==null)
            throw new IllegalArgumentException("Underflow");

        X nodeItem= (X) first.getItem();/*pull the item of FIRST*/
        first=first.getNextNode(); /*FIRST now point to its next node*/
        nodeCount--; //decrement size

        return nodeItem;
    }

    public void insert(X item,int position){

        /*if the position of insertion greater than size then the position consider as INVALID position*/
        if(position<0 || size()<position)
            throw new IllegalArgumentException("Invalid position");

        /*A temporary Node  is created "CURRENT NODE" which point to the first node*/
        Node currentNode=first;
        if(position ==0){
            Node newFirst=new Node(item);
            newFirst.setNextNode(first);
            first=newFirst;
            nodeCount++;
        }
        else {

            /*start navigation at 1 position because we already on the 0th node i.e first node*/
            Find_Position_IN_Loop:
            for (int i = 0; i < position - 1 && currentNode != null; i++)
                currentNode = currentNode.getNextNode();

            /*severe the Link chan and reconnect with new Node*/
            Node newNode = new Node(item);
            Node nextNode = currentNode.getNextNode(); /*NEXT-NODE keep reference of Current node's next element'*/
            currentNode.setNextNode(newNode);
            newNode.setNextNode(nextNode);

            nodeCount++; //increase size of List
        }
    }

    public X removeAt(int position){
        /*Pre Caution: If List is empty UNDERFLOW*/
        X nodeItem;
        if(first==null)
            throw new IllegalArgumentException("Underflow");
        if(position ==0){
            nodeItem = remove();
        }
        else {
            /*Two temporary Node[POINTER]  is created "CURRENT NODE" and "PREVIOUS NODE"which point to the first node*/
            Node previousNode = first;
            Node currentNode = first;

            for (int i = 0; i < position && currentNode != null; i++) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();

            }

            /*Update the Previous Node and throw away the current Node*/
            nodeItem = (X) currentNode.getItem();
            previousNode.setNextNode(currentNode.getNextNode());
            nodeCount--;
        }
        return nodeItem;

    }

    public  X get(int position){
        if(first==null)
            throw new IllegalArgumentException("Underflow");

        Node currentNode=first;

        for (int i = 0; i <size() && currentNode!=null ; i++) {
            if(i==position)
                return (X) currentNode.getItem();

            currentNode=currentNode.getNextNode();

        }
        return null;// if not found item
    }

    public int find(X itrm){
        if(first==null)
            throw new IllegalArgumentException("Underflow");
        Node currentNode=first;
        for (int i = 0; i <size() && currentNode!=null ; i++) {
            if(currentNode.getItem().equals(itrm))
                return i;

            currentNode=currentNode.getNextNode();

        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuffer content=new StringBuffer();
        Node currentNode=first;
        while (currentNode!=null){
            content.append(currentNode.getItem());
            currentNode=currentNode.getNextNode();

            if(currentNode!=null){
                content.append("->");
            }
        }
        return content.toString();
    }

}
public class BasicLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> integerList=new LinkedList<>();

        integerList.add(11);
        integerList.add(22);
        integerList.add(33);
        integerList.add(44);
        integerList.add(55);

        System.out.println(integerList);

        integerList.remove();
        System.out.println(integerList);

        integerList.insert(11,0);
        System.out.println(integerList);

        integerList.removeAt(0);
        System.out.println(integerList);

        System.out.println(integerList.find(66));

        System.out.println(integerList.get(3));


        LinkedList<String> stringList=new LinkedList<>();

        stringList.add("Ritam");
        stringList.add("Astha");
        stringList.add("Poulami");
        stringList.add("Tina");
        stringList.add("Ramisha");

        System.out.println(stringList);

        stringList.remove();
        System.out.println(stringList);

        stringList.insert("Priyanka",0);
        System.out.println(stringList);

        stringList.removeAt(0);
        System.out.println(stringList);

        System.out.println(stringList.find("Astha"));

        System.out.println(stringList.get(3));
    }
}
