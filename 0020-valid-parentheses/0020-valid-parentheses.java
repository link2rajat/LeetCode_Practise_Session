class Solution {
    public boolean isValid(String s) {
        
        if(s.length()%2==1)
            return false;
        
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for(Character ch : s.toCharArray())
        {
                if(ch =='(' || ch =='{' || ch =='[')
                {
                    stack.push(ch);
                }
                else if(ch ==')' && !stack.isEmpty() && stack.peek() == '(')
                {
                    stack.pop();
                }
                else if(ch =='}' && !stack.isEmpty() && stack.peek() == '{')
                {
                    stack.pop();
                }

               else if(ch ==']' && !stack.isEmpty() && stack.peek() == '[')
                {
                    stack.pop();
                }
               else  
                {
                    return false;
                }
        }
        
        return stack.isEmpty();
    }
}//T-O(n),S-O(n)