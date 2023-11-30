class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int m=potions.length;
        for(int i=0;i<spells.length;i++){
            int j=binarysearch(potions,(double)success/spells[i]);
            ans[i]=m-j;
        }
        return ans;
    }
    int binarysearch(int[] array,double target){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(array[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}