class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char op= '+';
        int result=0;
        int num=0;
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                int digit = ch-'0'; //converting char to int using -'0'
                num=num*10+digit;
            }
            
            if( !Character.isDigit(ch) && ch!=' '|| i==s.length()-1 )
            {
                
                if(op=='+')
                {
                    stack.push(num);
                }
                else if(op=='-')
                {
                    stack.push(-num);
                    
                }
                else if(op=='*')
                {
                    stack.push(stack.pop()*num);

                }
                else if(op=='/')
                {
                    stack.push(stack.pop()/num);
                }
                num=0;    
                op=ch;
            }
            
        }
        
          while(!stack.isEmpty() )
                {
                    result+=stack.pop(); 
                }
                
                return result;
        
    }
}//T-O(n),S-O(n) where n is string length