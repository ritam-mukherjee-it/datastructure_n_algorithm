package ds_n_algo.datastructure.linear_data_structure.stacks.generic_approach.array_implementation;
class Stack<X>{
    private X[] data;
    public int head = 0;

    public Stack(int size) {
        data = (X[]) new Object[size];
    }

    public Stack() {
        this(10);
    }


    public void push(X item) {
        data[head++] = item; /*Postfix operator used that means first value inserted then increase*/
    }

    public X pop() {
        /*checking Queue is empty or not*/
        if (head == 0)
            throw new IllegalStateException("UnderFlow");

        X item = data[--head];
        data[head] = null;
        return item;
        /* return data[--head]; [also by prefix operator we can decrement, just make the last element detachable]*/
    }

    public boolean contains(X item) {
        boolean found = false;

        find_item_location:
        for (int i = 0; i < head; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item) {

        search_until_head_0:
        while (head > 0) {
            X temp = pop();
            if (item.equals(temp))
                return temp;

        }
        throw new IllegalArgumentException("Item not found:" + item);
    }

    public int size(){
        return head;
    }

    public void display() {
        for (X x : data
        ) {
            System.out.print(x + "<->");
        }
        System.out.println("\n");
    }
}
public class StackArrayImplementation<X> {

    public static void main(String[] args) {
        Stack<Integer> integerStack=new Stack<>(8);

        integerStack.push(11);
        integerStack.push(22);
        integerStack.push(33);
        integerStack.push(44);
        integerStack.push(55);
        integerStack.display();
        integerStack.pop();
        integerStack.pop();
        integerStack.display();
        System.out.println(integerStack.contains(11));
        System.out.println(integerStack.access(22));
    }

}
