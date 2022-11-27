class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        
        HashMap<Integer,Integer>[] maps = new HashMap[nums.length];
        
        for(int i=0;i<nums.length;i++){
            maps[i] = new HashMap<Integer,Integer>();
        }
        
        for(int i=1;i<maps.length;i++){
            for(int j=0;j<i;j++){
                long diff = (long) nums[i] -(long)nums[j];
                if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE){
                    continue;
                }
                
                int apsEndingonJ = maps[j].getOrDefault((int)diff,0);
                int apsEndingonI = maps[i].getOrDefault((int)diff,0);
                
                ans+=apsEndingonJ;
                maps[i].put((int)diff,apsEndingonI+apsEndingonJ+1);
            }
        }
        
        
        return ans;
    }
}//T-O(n^2),S-O(n^2)