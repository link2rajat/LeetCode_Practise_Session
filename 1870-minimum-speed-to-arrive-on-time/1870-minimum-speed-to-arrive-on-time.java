class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length>Math.ceil(hour)){
            return -1;
        }
        int left=0;
        int right = (int) Math.pow(10, 7);
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,dist,hour)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    
    boolean check(int speed,int[] dist,double hour){
        
        double time=0.0;
        
        for(double d:dist){
            time=Math.ceil(time);
            time+=d/speed;
        }
        
        return time<=hour;
        
    }
}