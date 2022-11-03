class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> wordMap = new HashMap<>();

        for(String s: words)
        {
            wordMap.put(s,wordMap.getOrDefault(s,0)+1);
        }
        int ans=0;
        
        boolean oddCount =false;
        
        for(Map.Entry<String,Integer> map: wordMap.entrySet())
        {
            String word = map.getKey();
            Integer count = map.getValue();
            
            if(word.charAt(0)==word.charAt(1))
            {
                if(count%2==0)
                {
                    ans+=count;
                }
                else{
                    ans+=count-1;
                    oddCount=true;
                }
            }
            else if(word.charAt(0)<word.charAt(1))
            {
                String reverseWord =""+word.charAt(1)+word.charAt(0);
                
                if(wordMap.containsKey(reverseWord))
                {
                    ans+=2*Math.min(count,wordMap.get(reverseWord));
                }
                
            }
            
        }
        
        if(oddCount){
            ans++;
        }
        
        return 2*ans;
        
        
    }
}//T-O(N),S-O(N)