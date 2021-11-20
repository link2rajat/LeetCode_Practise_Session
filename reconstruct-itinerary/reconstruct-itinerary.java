class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        
        for(List<String> ticket: tickets)
        {
            graph.putIfAbsent(ticket.get(0),new PriorityQueue<>());

            graph.get(ticket.get(0)).offer(ticket.get(1));
            
        }
        
        Deque<String> stack = new ArrayDeque<>();
        

        List<String> result = new ArrayList<>();
        
        dfs(stack, graph,"JFK");
        
        while(!stack.isEmpty())
        {
            result.add(stack.pop());
        }
        
        return result;
        
    }
    
    void  dfs(Deque<String> stack, Map<String,PriorityQueue<String>> graph, String from_city)
    {
     
        PriorityQueue<String> arrival_cities = graph.get(from_city);
        while(arrival_cities!= null && !arrival_cities.isEmpty())
        {
            String to_city = graph.get(from_city).poll();
        
            dfs(stack,graph,to_city);
        }
        
        stack.push(from_city);
        
    }
    
}//T-O(Elog(E/V)),S-O(V+E)where V in # of airport anf E # of flights
