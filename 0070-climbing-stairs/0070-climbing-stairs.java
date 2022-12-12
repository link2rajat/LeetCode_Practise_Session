class Solution {
    public int climbStairs(int n) {
        
        int [] memo = new int[n+1];
        return climStairsHelper(0,n,memo);
    } //T-O(n),S-O(n)
    
    int climStairsHelper(int i,int n,int [] memo){
        
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(memo[i]>0){
            return memo[i];
        }
        memo[i] =  climStairsHelper(i+1,n,memo) +  climStairsHelper(i+2,n,memo);
        return  memo[i];
    }
}