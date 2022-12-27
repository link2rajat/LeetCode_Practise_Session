class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int size=capacity.length;

        int [] remainCapacity = new int[size];
        
        for(int i=0;i<size;i++){
            remainCapacity[i] = capacity[i]-rocks[i];
        }
        
        Arrays.sort(remainCapacity);
       int count = 0;
        for(int i=0;i<size;i++){
            
            if( additionalRocks >= remainCapacity[i] ){
                additionalRocks -= remainCapacity[i];
                count++;
            }
            else
                break;
        }
        
        return count;
        
    }
}//T-O(nlogn),S-O(n)