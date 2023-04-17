class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        
        for(int candy:candies){
            max=Math.max(candy,max);
        }
        
        List<Boolean> result =new ArrayList<>();
        
        for(int i=0;i<candies.length;i++){
                result.add(candies[i]+extraCandies>=max);
        }
        return result;
    }
}//T-O(n),S-O(1)