class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        for(Character ch: s.toCharArray()){
            
            if(map.containsKey(ch)){
            stack.push(ch);    
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char popChar = stack.pop();
                if(map.get(popChar) !=ch){
                    return false;
                }
                
            }
        }
        return stack.isEmpty();
    }
}