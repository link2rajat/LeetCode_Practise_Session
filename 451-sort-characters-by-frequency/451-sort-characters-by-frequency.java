/*
compare character 

*/
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> tmap = new HashMap<Character,Integer>();
        
        for(char ch:s.toCharArray())
        {
            if(!tmap.containsKey(ch))
            {
                tmap.put(ch,0);
            }
            tmap.put(ch,tmap.get(ch)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->b.getValue()-a.getValue());
        
        pq.addAll(tmap.entrySet());
        
        StringBuilder result = new StringBuilder();
        
        while(!pq.isEmpty())
        {
           Map.Entry<Character,Integer> map = pq.poll();
            
            for(int i=0;i<map.getValue();i++)
            {
                result.append(map.getKey());
            }
        }
        
        return result.toString();
        
    }
}//T-(nlogk),S-O(n)