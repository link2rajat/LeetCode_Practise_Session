class Solution {
    public String removeDuplicates(String s) {
        
        if(s==null || s.length()==0)
        {
            return s;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray())
        {

            if(stack.size() != 0 && ch == stack.getLast()) {
                stack.removeLast();
            } else {
            stack.addLast(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}//T-O(n),S-O(n)