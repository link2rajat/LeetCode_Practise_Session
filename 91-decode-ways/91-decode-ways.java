class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s== null) 
            return 0;
        
        return recursewithInputIndex(s,0);
    }//Time Complexity-O(n) , Space Complexity-O(n)
    
    HashMap<Integer,Integer> memoisedMap = new HashMap<>();
    
    int recursewithInputIndex(String input, int index)
    {
     
        
        if(index==input.length())
        {
            return 1;
        }
        if(input.charAt(index)=='0')
        {
            return 0;
        }
        if(index==input.length()-1)
        {
            return 1;
        }
        if(memoisedMap.containsKey(index))
        {
            return memoisedMap.get(index);
        }
      
        
        int result = recursewithInputIndex(input,index+1);
        
        if(Integer.parseInt(input.substring(index,index+2))<=26)
        {
           result+= recursewithInputIndex(input,index+2);
        }

        memoisedMap.put(index,result);
        
        return result;
    }
}