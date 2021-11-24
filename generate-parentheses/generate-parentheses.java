class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
         recurse(0,0,new StringBuilder(),result,n);
        return result;
    }

    void recurse(int left,int right,StringBuilder parenthesis,List<String> result,int n)
    {
        if(parenthesis.length() == 2*n)
        {
            result.add(parenthesis.toString());
            return;
        }
        
        if(left<n)
        {
         parenthesis.append("(");   
         recurse(left+1,right,parenthesis,result,n);
         parenthesis.deleteCharAt(parenthesis.length()-1);   

        }
         if(right<left)
        {
         parenthesis.append(")");   
         recurse(left,right+1,parenthesis,result,n);
         parenthesis.deleteCharAt(parenthesis.length()-1);   
        }
        
        
    }
    
    
}//T-O(4^n /n^1/2),S-O(4^n /n^1/2)
