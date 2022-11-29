class RandomizedSet {

    Map<Integer,Integer> map; 
    List<Integer> list ;
    Random random = new Random();
    public RandomizedSet() {
         map = new HashMap<Integer,Integer>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }//T-O(1),S-O(n)
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int lastValue = list.get(list.size()-1);
        int valueIndex = map.get(val);
        list.set(valueIndex, lastValue);
        map.put(lastValue,valueIndex);
        
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }//T-O(1),S-O(n)
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */