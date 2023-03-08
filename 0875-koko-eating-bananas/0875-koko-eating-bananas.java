class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxbanana(piles);
     
        
        while(low< high)
        {
            int k = (low +high)/2;
                
                if(isminEatingSpeed(k,piles,h))
                {
                    high = k; 
                }
            else{
                low = k+1;
            }
            
        }
        
        return high;
            
    }
    
    boolean isminEatingSpeed(int k, int[] piles, int h)
    {
        int countHrs =0;
        for(int p: piles)
        {
            countHrs+=Math.ceil((double)p/k);
           
        }
        
        
        return countHrs <= h ;
        
    }
    
    
    int maxbanana(int[] piles)
    {
        int max = Integer.MIN_VALUE;
        
        for(int p: piles)
        {
            max = Math.max(p,max);
        }
        
        return max;
    }
}