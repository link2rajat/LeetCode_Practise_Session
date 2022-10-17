class Solution {
    public int mySqrt(int x) {
        
        if(x<2) return x;
        
        int low=2,high=x/2;
        
        long sqr;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
           sqr = mid*(long)mid;//since mid*mid is going out of range for int value
            if(sqr>x)
                high=mid-1;
            else if(sqr<x)
                low=mid+1;
            else 
                return mid;
        }
        return high;
        
    }
}//T-O(logn),S-O(1)