class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums== null || nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }
        
        int longestConsecutiveSequence = 0;
        
        for(int num : set){
            
            if(!set.contains(num-1)){
                int currentNumber = num;
                int currentStreak=1;
                
                while(set.contains(currentNumber+1)){
                    currentNumber++;
                    currentStreak++;
                }
               longestConsecutiveSequence = Math.max(longestConsecutiveSequence,currentStreak); 
            }
           
        }
         return longestConsecutiveSequence;
    }
}