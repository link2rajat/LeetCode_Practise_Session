class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        
        for(int a: arr){
           frequencyMap.put(a,frequencyMap.getOrDefault(a,0)+1); 
        }
        
        HashSet<Integer> frequencySet = new HashSet<Integer>(frequencyMap.values());
        
       return frequencyMap.size()==frequencySet.size();
        
    }
} //T-O(N),S-O(N)