class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits==null || fruits.length==0)
        {
            return 0;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int maxFruits=Integer.MIN_VALUE;
        
        int winStart=0;
        
        for(int winEnd=0;winEnd<fruits.length;winEnd++)
        {
            map.put(fruits[winEnd],map.getOrDefault(fruits[winEnd],0)+1);
            
            while(map.size()>2)
            {
                map.put(fruits[winStart],map.get(fruits[winStart])-1);
                
                if(map.get(fruits[winStart])==0)
                {
                    map.remove(fruits[winStart]);
                }
                winStart++;
            }
           maxFruits = Math.max(maxFruits,winEnd-winStart+1);
            
        }
        
        return maxFruits;
    }
}//T-O(n),S-O(1)