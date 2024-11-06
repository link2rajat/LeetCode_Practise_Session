class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int left=0;
        int windowSize=0;
        
        Map<Character,Integer> windowMap= new HashMap<>();
        
        for(int right=0;right<s.length();right++){
            char c= s.charAt(right);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            
            while(windowMap.size()>k){
            char remove= s.charAt(left);
            windowMap.put(remove,windowMap.getOrDefault(remove,0)-1);
            if(windowMap.get(remove) ==0){
                windowMap.remove(remove);
              }
                left++;
            }
        windowSize=Math.max(windowSize,right-left+1); 

        }
        return windowSize;
    }
}//T-O(n),S-O(n)