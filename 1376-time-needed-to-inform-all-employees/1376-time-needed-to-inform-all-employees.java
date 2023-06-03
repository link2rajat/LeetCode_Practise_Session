//https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
     Map<Integer,List<Integer>> managerMap = new HashMap<>();
        
        for(int i=0;i<manager.length;i++)
        {
            managerMap.putIfAbsent(manager[i],new ArrayList<Integer>());
            managerMap.get(manager[i]).add(i);
        }
        
     return dfs(managerMap,informTime,headID);
    }
    
    int dfs(Map<Integer,List<Integer>> managerMap ,int[] informTime, int mngrID)
    {
        int maxTime =0;
        if(!managerMap.containsKey(mngrID))
            return maxTime;
       
        for(int i = 0 ; i<managerMap.get(mngrID).size();i++)
            {
              maxTime=Math.max(maxTime,dfs(managerMap,informTime,managerMap.get(mngrID).get(i)));   
            }
        return maxTime+informTime[mngrID] ;
    }
}