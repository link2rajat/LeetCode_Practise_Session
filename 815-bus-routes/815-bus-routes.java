// https://leetcode.com/problems/bus-routes/discuss/122712/Simple-Java-Solution-using-BFS, https://www.youtube.com/watch?v=R58Q0J52qzI&feature=youtu.be&ab_channel=code_report
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer,ArrayList<Integer>> stopToBusMap = new HashMap<>();
        
        for(int busNum=0;busNum<routes.length;busNum++)
        {
            for(int stop=0;stop<routes[busNum].length;stop++)
            {
                stopToBusMap.putIfAbsent(routes[busNum][stop], new ArrayList<>());
                stopToBusMap.get(routes[busNum][stop]).add(busNum);
            }
        }
        if(S==T)return 0;
        
        Set<Integer>visited = new HashSet<>();
        int busCount=0;
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.offer(S);
        
        while(!bfsQ.isEmpty())
        {
            int size = bfsQ.size();
            busCount++;
                for(int i=0;i<size;i++)
                {
                    Integer currentStop = bfsQ.poll();
           ArrayList<Integer> busesfromcurrentStop = stopToBusMap.get(currentStop);
            for(Integer bus : busesfromcurrentStop)
             { if(visited.contains(bus))continue;
               visited.add(bus);
    for(int stopsinthisBus=0;stopsinthisBus<routes[bus].length;stopsinthisBus++)
                     { 
                   if(routes[bus][stopsinthisBus]== T)
                         return busCount;
                      bfsQ.offer(routes[bus][stopsinthisBus]);
                     }
                    }
                    
                }
        }
        return -1;
    }
}