class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean emptyLeftSpot = (i==0) || (flowerbed[i-1]==0);
                boolean emptyRightSpot = (i==flowerbed.length-1) || (flowerbed[i+1]==0);
                
                if(emptyLeftSpot && emptyRightSpot){
                    flowerbed[i] = 1;
                    count++;
                    if(count>=n){
                        return true;
                    }
                }
                
            }
        }
        return count>=n;
    }
}//T-O(n),S-O(1)