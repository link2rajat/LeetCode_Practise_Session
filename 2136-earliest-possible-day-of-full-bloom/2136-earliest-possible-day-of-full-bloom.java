class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            indices.add(i);
        }
        
        Collections.sort(indices,Comparator.comparingInt(i->-growTime[i]));
        
        int result=0;
        
        for(int i=0,currentTime=0;i<n;i++)
        {
            int idx=indices.get(i);
            int time= currentTime+plantTime[idx]+growTime[idx];
            result=Math.max(result,time);
            currentTime+=plantTime[idx];
        }
        
        return result;
        
    }
}//T-O(nlogn),S-O(n)