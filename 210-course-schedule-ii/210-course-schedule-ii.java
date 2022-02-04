class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
       int[] inDegree = new int[numCourses];
        
        
        for(int i=0;i<numCourses;i++)
        {    
            
            graph.putIfAbsent(i,new ArrayList<>());
            
        }
        
        
        for(int i=0;i<prerequisites.length;i++)
        {
   
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        int[] order = new int[numCourses];
 
        Queue<Integer> queue = new LinkedList<>();
        
         for(int i=0;i<numCourses;i++)
        {    
             if(inDegree[i]==0)             {
               queue.add(i);  
             }
            
        }

        int count=0;

        while(!queue.isEmpty())
        {
            int course = queue.poll();
            order[count++]=course;
           
            if(graph.containsKey(course))
            {
                
                for(Integer neighbour : graph.get(course))
                {
                    inDegree[neighbour]--;
                 if(inDegree[neighbour]==0)
                 {
                    queue.add(neighbour);  
                 }
                }
            }
        }
            
        if(count==numCourses)
        {
            return order;
        }
        
        return new int[0];
            
    }
}//T-_O(V+E),S-O(V+E)