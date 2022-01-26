class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> numberStack = new ArrayDeque<>();
        String operator = "+-*/";
        
        for(String currentToken : tokens )
        {
            if(!operator.contains(currentToken))
            {
               numberStack.push(Integer.valueOf(currentToken));
               continue;
            }
            int number2 = numberStack.pop();
            int number1 = numberStack.pop();
            int result = 0;
            
            switch(currentToken)
            {
                case "+":
                result = number1 + number2;
                break;
                case "-":
                result = number1 - number2;
                break;    
                case "*":
                result = number1 * number2;    
                break;
                case "/":    
                result = number1 / number2;
                break;    
            }
            numberStack.push(result);
        }
        return numberStack.pop();
    }
}//Time Complexity-O(N)
 //Space Complexity-O(N)