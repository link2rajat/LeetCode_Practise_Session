class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer,Integer> map;
    List<Integer> list;
    Random ran = new Random();
    
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) 
        return false;
        
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) 
        return false;
        
        int lastvalue = list.get(list.size()-1);
        int idx = map.get(val);
        list.set(idx,lastvalue);
        map.put(lastvalue,idx);
        
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}//T-O(1),S-O(N)

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */