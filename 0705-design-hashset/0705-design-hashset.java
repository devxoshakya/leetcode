class MyHashSet {

    LinkedList<Integer>[] chain;
    int size = 10000;

    public MyHashSet() {
        chain = new LinkedList[size];
        for (int i = 0; i < chain.length; i++) {
            chain[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int hash = key % size;
        if (!chain[hash].contains(key)) {
            chain[hash].add(key);
        }
    }

    public void remove(int key) {
        int hash = key % size;
        chain[hash].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hash = key % size;
        return chain[hash].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */