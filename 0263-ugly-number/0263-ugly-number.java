class Solution {
    public boolean isUgly(int n) {
        
        if(n>0)
            for(int i=2;i<6;i++)
            {
                while(n%i==0)
                    n=n/i;
            }
        return n==1;
        
    }
}//T-O(log n),S-O(1)