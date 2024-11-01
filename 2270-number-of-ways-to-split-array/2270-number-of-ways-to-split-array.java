class Solution {
    public int waysToSplitArray(int[] nums) {
        int numberofDivision =0;
        long left =0;
        long right =0;
        long total=0;
        
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        
        for(int i=0;i<nums.length-1;i++){
        left+=nums[i];
        right=total-left;
            if(left>=right){
                numberofDivision++;
            }
        }
        return numberofDivision;
    }
}