class Solution {
    public int compress(char[] chars) { 
        
        int index=0;
        int start =0;
        
        while(start<chars.length)
        {
            int end=start;
            
            while(end<chars.length && chars[start]==chars[end])
            {
              end++;  
            }
            
            chars[index++]=chars[start];
            if(end-start>1)
            { 
                // " " addition to converting count to string since count can be in multiples
                String count = end -start+"";
                
                for(char ch : count.toCharArray())
                {
                    chars[index++]= ch;
                }
                
            }
            
            start=end;
            
        }
        
        return index;
        
        
    }
}//T-O(n),S-O(1)