class Solution {
    public int singleNumber(int[] nums) {
     
        int number=0;
        for(int num:nums)
        {
            number=number^num;
        }
        
        return number;
    }
}//T-O(n),S-O(1)