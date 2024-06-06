class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int reminder[] = new int[60];
        int count=0;
        
        for(int t: time){
            if(t%60==0){
                count+=reminder[0];
            }else{
                count+=reminder[60-t%60];
            }
            reminder[t%60]++;
        }
        return count;
    }
}//T-O(n),O(1)