class MyHashMap {
    List<int[]>[] chain;
    int size = 13000;

    public int getHashcode(int key){
        return key % size;
    }

    public MyHashMap() {
        chain = new ArrayList[size];
        for(int i=0; i < size; i++){
            chain[i] = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int hash = getHashcode(key);
        for(int i=0; i < chain[hash].size(); i++){
            if(chain[hash].get(i)[0] == key){
                chain[hash].get(i)[1] = value;
                return;
            }
        }
        chain[hash].add(new int[]{key,value});
    }
    
    public int get(int key) {
        int hash = getHashcode(key);
        for(int i=0; i < chain[hash].size(); i++){
            if(chain[hash].get(i)[0] == key){
                return chain[hash].get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
         int hash = getHashcode(key);
        for(int i=0; i < chain[hash].size(); i++){
            if(chain[hash].get(i)[0] == key){
               chain[hash].remove(i);
            }
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */