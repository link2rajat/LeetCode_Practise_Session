class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashMap<Character,Integer> jewelsCount =counts(jewels);
        HashMap<Character,Integer> stonesCount =counts(stones);
        
        for(char c:jewelsCount.keySet()){
            if(stonesCount.containsKey(c)){
                count+=stonesCount.get(c);
            }
        }
        return count;
    }
    
    HashMap<Character,Integer> counts(String s){
        HashMap<Character,Integer> countMap = new HashMap<Character,Integer>();
        for(char c: s.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        return countMap;
    }
}