class Solution {
    public int longestConsecutive(int[] nums) {
         if(nums.length==0 || nums==null){
            return 0;
        }
        
        Set<Integer> hashSet = new HashSet<>();
        
        for(int number:nums){
            hashSet.add(number);
        }
      
        
        int longestStreak=0;

        for(int num:nums){
            
            if(!hashSet.contains(num-1)){
   
            int currentNumber = num;
            int currentStreak=1;
            
            while(hashSet.contains(currentNumber+1)){
                currentNumber+=1;
                currentStreak+=1;
            }
                
           longestStreak=Math.max(longestStreak,currentStreak) ;   
         }
        }
        
        return longestStreak;
    }
}//T-O(n),S-O(1)