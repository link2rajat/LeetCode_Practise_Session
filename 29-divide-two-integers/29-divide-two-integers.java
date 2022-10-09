class Solution {
    private static int HALF_INT_MIN = -1073741824;

    public int divide(int dividend, int divisor) {
        
        if(dividend==Integer.MIN_VALUE && divisor==-1)
        {
            return Integer.MAX_VALUE;
        }
        
        int negative=2;
        
        if(dividend>0)
        {
            dividend=-dividend;
            negative--;
        }
        if(divisor>0)
        {
            divisor=-divisor;
            negative--;
        }
        
        int quotient=0;
            
         while(divisor>=dividend)
         {
             int powOfTow=-1;
             int val=divisor;
             while(val>=HALF_INT_MIN && val+val>=dividend)
             {
                 val+=val;
                 powOfTow+=powOfTow;
             }
             quotient+=powOfTow;
             dividend-=val;
         }
        
        if(negative!=1)
        {
            quotient=-quotient;
        }
        
        return quotient;
        
    }
}//T-O(logn*logn),S-O(1)