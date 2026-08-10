class MyHashSet {
    List<Integer>[] chain;
    int size = 10000;

    public MyHashSet() {
        chain = new ArrayList[size];
        for(int i=0; i < size; i++){
            chain[i] = new ArrayList<>();
        }    
    }
    
    public void add(int key) {
        int hash = key % size;
        if(!chain[hash].contains(key)){
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