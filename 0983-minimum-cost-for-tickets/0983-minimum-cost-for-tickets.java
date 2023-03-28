class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[366];
        Set<Integer> daySet = new HashSet();
        for(int d:days)daySet.add(d);
        
        return recurse(1,costs,memo,daySet);
    }//T-O(W),S-O(W),W is maximum number of days in your travel plan
    
    int recurse(int i,int[] costs,Integer[] memo,Set<Integer> daySet){
        if(i>365)
            return 0;
        if(memo[i]!=null)
            return memo[i];
        
        int ans;
        
        if(daySet.contains(i)){
            ans = Math.min(recurse(i+1,costs,memo,daySet)+costs[0],recurse(i+7,costs,memo,daySet)+costs[1]);
            ans = Math.min(ans,recurse(i+30,costs,memo,daySet)+costs[2]);
        }else{
            ans = recurse(i+1,costs,memo,daySet);
        }
        
        memo[i]=ans;
        return ans;
    }
}