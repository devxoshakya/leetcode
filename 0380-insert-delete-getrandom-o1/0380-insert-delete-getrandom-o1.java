class RandomizedSet {

    HashMap<Integer, Boolean> map;

    public RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, true);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        Set<Integer> set = map.keySet();

        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */