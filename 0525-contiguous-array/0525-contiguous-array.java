class Solution {
    public int findMaxLength(int[] nums) {
    
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=(nums[i]==1)?1:-1;
            if(count==0)
                max=Math.max(max,i+1);
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        
        return max;
        
    }
}