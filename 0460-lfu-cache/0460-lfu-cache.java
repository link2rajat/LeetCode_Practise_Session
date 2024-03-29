public class LFUCache {
    // https://leetcode.com/problems/lfu-cache/discuss/94536/Java-solution-using-PriorityQueue-with-detailed-explanation
     class Cache implements Comparable<Cache> {
        int key;
        int value;
        int freq;
        int time;
        
        public Cache(int k, int v, int f, int t) {
            key = k;
            value = v;
            freq = f;
            time = t;
        }
        
        public boolean equals(Object o) {
            if(!(o instanceof Cache)) return false;
            return key == ((Cache) o).key;
        }
        
        public int hashCode() {
            return key;
        }
        
        public int compareTo(Cache c) {
            return freq == c.freq? time - c.time : freq - c.freq;
        }
    }
    
    Map<Integer, Cache> caches;
    int cap, time;
    TreeSet<Cache> set;

    public LFUCache(int capacity) {
        cap = capacity;
        time = 0;
        caches = new HashMap<>();
        set = new TreeSet<>();
    }
    
    public int get(int key) {
        if(!caches.containsKey(key)) return -1;
        time++;
        update(key, caches.get(key).value);
        return caches.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cap <= 0) return;
        
        time++;
        if(caches.containsKey(key)) {
            update(key, value);
            return;
        }
        if(caches.size() == cap) {
            Cache first = set.pollFirst();
            caches.remove(first.key);
        }
        Cache curr = new Cache(key, value, 1, time);
        caches.put(key, curr);
        set.add(curr);
    }
    
    private void update(int key, int value) {
        Cache old = caches.get(key);
        Cache curr = new Cache(key, value, old.freq + 1, time);
        set.remove(old); // remove() uses 'equals()' to judge the equality
        set.add(curr);
        caches.put(key, curr);
    }
    
   
}