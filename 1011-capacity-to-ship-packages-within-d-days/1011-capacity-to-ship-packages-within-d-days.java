//https://www.youtube.com/watch?v=1w4-rZhP7BM&ab_channel=Pepcoding
class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int max = 0;
     int sum =0;
     int ans = 0;
        
        for(int weight: weights){
            max=Math.max(max,weight);
            sum+=weight;
        }
        
        if(weights.length==days){
            ans = max;
        }
        
        int low = max;
        int high = sum;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(isPossible(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }//T-O(nlogn),S-O(1)
   
    boolean isPossible(int[] weights,int mid,int days){
        int day=1;
        int sum=0;
        
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>mid){
                day++;
                sum=weights[i];
            }
        }
        return day<=days;
    }
}