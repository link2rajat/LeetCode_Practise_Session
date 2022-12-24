class Solution {
    //Get recurrence relation from here
    //https://www.youtube.com/watch?v=aVIFpdAg33U&ab_channel=KashishMehndiratta
    //f(k) = 2*f(k-1)+f(k-3)
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if(n<=2){
            return n;
        }
        long fCurrent = 5L; //f(k-1)
        long fPrevious = 2; //f(k-2)
        long fBeforePrevious = 1; //f(k-3)
        
        for(int k=4;k<n+1;k++){
            long tmp = fPrevious;  
            fPrevious = fCurrent;
            fCurrent = (2*fCurrent + fBeforePrevious) % MOD;
            fBeforePrevious = tmp;
        }
        
        return (int)(fCurrent % MOD);
    }
}//T-O(N),S-O(1)