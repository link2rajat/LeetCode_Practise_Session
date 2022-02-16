class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int inputLength = nums.length;
        
        int[] leftProduct = new int[inputLength];
        
        int[] rightProduct = new int[inputLength];
        
        int[] result = new int[inputLength];
        
        leftProduct[0] =1;
        
        for(int index =1;index<inputLength;index++)
        {
         leftProduct[index]=nums[index-1]*leftProduct[index-1];  
        }
        
        rightProduct[inputLength-1]=1;
        
         for(int index =inputLength-2;index>=0;index--)
        {
         rightProduct[index]=nums[index+1]*rightProduct[index+1];  
        }
        
         for(int index= 0;index<inputLength;index++)
         {
          result[index]=leftProduct[index]*rightProduct[index];
         }
        
        return result;
    }
}//T-O(n),S-O(n)