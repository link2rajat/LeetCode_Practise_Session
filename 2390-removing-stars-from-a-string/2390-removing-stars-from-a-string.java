class Solution {
    public String removeStars(String s) {
       Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch =='*'){
               stack.pop();
            }else{
                stack.push(ch);
            }
        }
 
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}//T-O(n),S-O(n)