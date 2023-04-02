class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        int[] ans = new int[spells.length];
        
        int positionLength = potions.length;
        
        int maxPotion = potions[positionLength-1];
        
        
        for(int i=0;i<spells.length;i++){
       
            int currentSpell= spells[i];
            
            long minPotion= (long) Math.ceil((1.0*success)/currentSpell);
            
            if(minPotion>maxPotion){
                ans[i]=0;
                continue;
            }
            int index = lowerBound(potions,(int)minPotion);
            ans[i]=positionLength-index;
        }
        return ans;
    }
    
    int lowerBound(int[] potions,int target){
        int low=0,high=potions.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(potions[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
    
}//T-O(m+n(logm)),S-O(m)