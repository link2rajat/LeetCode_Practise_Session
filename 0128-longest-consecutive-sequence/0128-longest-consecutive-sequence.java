class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }
        int longestConsSeq= 0;
        for(int num: nums){
            int count=1;
            if(!set.contains(num-1)){
                int currentNumber = num;
            while(set.contains(currentNumber+1)){
            currentNumber++;
              count++;
            }
            }
           longestConsSeq= Math.max(longestConsSeq,count);
        }
        return longestConsSeq;
    }
}