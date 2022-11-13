class Solution {
    public String reverseWords(String s) {
    
        StringBuilder sb = new StringBuilder();
       
        Deque<String> stack = new ArrayDeque<>();
        
        s+=' ';
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ' && sb.length()>0)
            {
                stack.addLast(sb.toString());
                sb =  new StringBuilder();
            }
            else if(s.charAt(i)!=' ')
            {
                sb.append(s.charAt(i));
            }
        }
        
        StringBuilder  ans = new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.append(stack.removeLast());
            if(stack.size()>0)ans.append(" ");
        }
        
        return ans.toString();
    }
}//T-O(n),S-O(n)