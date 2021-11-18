class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
        if(numCourses<=1)
            return true;
        if(prerequisites==null || prerequisites.length==0)
            return true;
        
        Map<Integer,Set<Integer>> courseMap = new HashMap<>();
        
        for(int course=0;course<numCourses;course++)
        {
            courseMap.put(course,new HashSet<>());
        }
        
        for(int couseinprereq=0;couseinprereq<prerequisites.length;couseinprereq++)
        {
           courseMap.get(prerequisites[couseinprereq][0]).add(prerequisites[couseinprereq][1]);
        }
        
        Queue<Integer> courseQueue = new LinkedList<>(); 
        
        int totalCourse=numCourses;
        
        for(Map.Entry<Integer,Set<Integer>>map : courseMap.entrySet())
        {
            
            if(map.getValue().size()==0)
            {
                courseQueue.offer(map.getKey());    
                totalCourse--;
            }
            
        }
        
        while(!courseQueue.isEmpty())
        {
            Integer course = courseQueue.poll();
         for(Map.Entry<Integer,Set<Integer>>map : courseMap.entrySet())
        {
            
            if(map.getValue().contains(course))
            {
                map.getValue().remove(course);   
            if(map.getValue().size()==0)
            {
                courseQueue.offer(map.getKey());    
                totalCourse--;
            }
            }
            
        }
            }
        
        
        return totalCourse==0;
        
    }
}//T-O(E+V),S-O(E+V)