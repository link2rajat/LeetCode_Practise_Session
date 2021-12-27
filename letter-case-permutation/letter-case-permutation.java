class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0)
        {
            return result;
        }
        backtrack(s.toCharArray(),result,0);
        return result;
    }
    
    void backtrack(char[] ch,List<String> result, int index)
    {
        if(index==ch.length)
        {
            result.add(new String(ch));
            return;
        }
        
        if(ch[index] >='0' && ch[index] <= '9')
        {
            backtrack(ch,result,index+1);
            return;
        }
            
        ch[index] = Character.toLowerCase(ch[index]);
        backtrack(ch,result,index+1);
 
        ch[index] = Character.toUpperCase(ch[index]);
        backtrack(ch,result,index+1);
  
        }
}//T-O(N*2^N),S-O(N)