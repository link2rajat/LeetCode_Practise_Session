class Solution {
    public int minStartValue(int[] nums) {
        
        int min=0;
        int total=0;
        
        for(int num:nums){
            total+=num;
            min=Math.min(min,total);
        }
        return 1-min;
    }
}