class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Deque<StringBuilder> charStack = new ArrayDeque<>();  
        Deque<Integer> numStack = new ArrayDeque<>(); 
        int k= 0;
        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                k=k*10+ch-'0';
            }
            else if(ch=='[')
            {
                numStack.push(k);
                charStack.push(result);
                result = new StringBuilder();
                k=0;
            }
            else if(ch==']')
            {
                StringBuilder decodedString= charStack.pop();
                    
                    for(int counter=numStack.pop();counter>0;counter--)
                    {
                        decodedString.append(result);
                    }
                    result = decodedString;
            }
            else
            {
                result.append(ch);
            }
            
        }
        
        return result.toString();

        
    }
}//T-O(maxK*n),S-O(m+n)