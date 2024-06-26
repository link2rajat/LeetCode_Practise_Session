class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        
        HashSet<Character> seen =new HashSet<>();
        
        HashMap<Character,Integer> lastOccuranceMap = new HashMap<>();
        for(int i=0;i<s.length();i++)lastOccuranceMap.put(s.charAt(i),i);
        
        for(int i=0;i<s.length();i++){
            
            char c= s.charAt(i);
            
            if(!seen.contains(c)){
                
                while(!stack.isEmpty() && c<stack.peek() && lastOccuranceMap.get(stack.peek())>i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c: stack){
            sb.append(c.charValue());
        }
        return sb.toString();
    }
}//T-O(n),S-O(1)