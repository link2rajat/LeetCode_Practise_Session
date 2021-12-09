/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
class WordDistance {
    Map<String,ArrayList<Integer>> map = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for(int i=0;i<wordsDict.length;i++)
        {
            ArrayList<Integer> location = map.getOrDefault(wordsDict[i],new ArrayList<Integer>());
            location.add(i);
            map.put(wordsDict[i], location);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        
        ArrayList<Integer> idxList1=map.get(word1);
        ArrayList<Integer> idxList2=map.get(word2);
        int diff=Integer.MAX_VALUE;
        int idx1=0,idx2=0;
        while(idx1<idxList1.size() && idx2<idxList2.size())
        {
            diff=Math.min(diff,Math.abs(idxList1.get(idx1)-idxList2.get(idx2)));
           
            if(idxList1.get(idx1)<idxList2.get(idx2))
            {
                idx1++;
            }
            else{
                idx2++;
            }
        }
        
        return diff;
    }
    
    
}//T-O(n),S-O(n)

