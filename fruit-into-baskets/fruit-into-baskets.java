class Solution {
    
    public int totalFruit(int[] fruits) {
        int max_fruit=0;
        HashMap<Integer,Integer> freq_map = new HashMap<>();
        int winstart=0;
        for(int winEnd=0;winEnd<fruits.length;winEnd++)
        {
           freq_map.put(fruits[winEnd],freq_map.getOrDefault(fruits[winEnd],0)+1);
            
            while(freq_map.size()>2)
            {
                
                freq_map.put(fruits[winstart],freq_map.get(fruits[winstart])-1);
                
                if(freq_map.get(fruits[winstart])==0)
                {
                    freq_map.remove(fruits[winstart]);
                }
                winstart++;
            }
            
            max_fruit=Math.max(max_fruit,winEnd-winstart+1);
        }
        
        return max_fruit;
    }
}//T-O(n),S-O(1)