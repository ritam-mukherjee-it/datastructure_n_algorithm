package ds_n_algo.datastructure.non_linear_data_structure.hash;

public class BasicHashTable<X, Y> {

    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }

    private HashEntry[] data;
    private int capacity;  /*represent how big the hash table is*/
    private int size; /*represent how many elements are exist in array*/


    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        data = new HashEntry[this.capacity];
        this.size = 0;/*the sizehas initialized as empty table*/
    }

    public int size() {
        return this.size;
    }


    public Y get(X key) {
        int hash = calculateHash(key);


        if (data[hash] == null)
            return null;
        else
            return (Y) data[hash].getValue();
    }

    private int calculateHash(X key) {
        /*find the appropriate bucket: get hashcode and modulo operation with capacity*/
        int hash = (key.hashCode() % this.capacity);

        /*deal with collision
         *   data[hash] !=null   : It means the collision happened, already any element is in that location
         *   data[hash].getKey().equals(key) :If that particular location's key and item's key same
         * */
        while (data[hash] != null && !data[hash].getKey().equals(key))
            hash = (hash + 1) % this.capacity;

        return hash;
    }


    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry<X, Y>(key, value);
        size++;
    }

    public Y delete(X key) {

        /*first get the value from the table so that it can be return*/
        Y value = get(key);

        /* clear the hash table slot for the key*/
        if (value != null) {
            int hash = calculateHash(key);
            data[hash] = null;/*make the location in table as null;*/
            size--;

            hash = (hash + 1) % this.capacity;

            /*If the next slot is not empty we should re add it so we can keep the hash algorithm clean */
            while (data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                put((X) he.getKey(), (Y) he.getValue());
                /*we repositioned the hash item and did not  really add a new one so back off the size*/
                size--;
                hash = (hash + 1) % this.capacity;
            }
        }
        return value;
    }

    /* Its Big(O) is constant time*/
    public boolean hasKey(X key) {
        int hash = calculateHash(key);
        if (data[hash] == null)
            return false;
        else {
            if (data[hash].getKey().equals(key))
                return true;
        }
        return false;
    }

    /* Its Big(O) is lenear time*/
    public boolean hasValue(Y value) {
        for (int i = 0; i < this.capacity; i++) {
            HashEntry entry = data[i];

            if (entry != null && entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    public void printElement() {
        for (int i = 0; i < this.capacity; i++) {
            System.out.print((data[i] != null) ? "Key:" + data[i].getKey() + " Value:" + data[i].getValue() + "\n" : "");
        }
    }

    public static void main(String[] args) {
        BasicHashTable<Integer, String> table1 = new BasicHashTable<>(10);
        table1.put(11, "RAM");
        table1.put(22, "SAM");
        table1.put(33, "JADU");
        table1.put(88, "MADHU");
        table1.printElement();
        System.out.println("-------------------------------------------------");

        table1.delete(33);
        table1.printElement();
        table1.put(1, "TINA");
        table1.printElement();
        System.out.println("-------------------------------------------------");

        System.out.println("Is table1 have key '11'?" + table1.hasKey(11));
        System.out.println("Is table1 have value 'MADHU'?" + table1.hasValue("MADHU"));
    }
}
