class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour: rooms.get(node)){
                if(!seen[neighbour]){
                    seen[neighbour]=true;
                    stack.push(neighbour);
                }
            }
        }
        
        for(boolean visited : seen)
            if(!visited) return false;
        return true;
    }
}//T-O(N+E),S-O(E)