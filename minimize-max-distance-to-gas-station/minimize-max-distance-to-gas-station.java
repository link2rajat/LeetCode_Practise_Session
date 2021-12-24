//https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/113629/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double low=0;
        double high = stations[stations.length-1]-stations[0];
        
        
        while(high-low>=1e-6)
        {
            double mid=(high+low)/2;

            int count=0;
            
            for(int i=0;i<stations.length-1;i++)
            {
                count+=Math.ceil((stations[i+1]-stations[i])/mid)-1;
            }
            
            if(count<=k)
            {
                high=mid;
            }
            else
            {
                low=mid;
            }
        }
        
        return low;
    }
}//T-O(NlogW),S-O(1)