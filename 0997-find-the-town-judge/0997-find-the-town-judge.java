class Solution {
    public int findJudge(int n, int[][] trust) {
       
        if(trust.length<n-1) return -1;
        
       int[] trustArray = new int[n+1];
        
        for(int[] trustPerson: trust){
            trustArray[trustPerson[0]]--;
            trustArray[trustPerson[1]]++;
        }
        
        for(int i=1;i<=n;i++){
            if(trustArray[i]==n-1)
                return i;
        }
    return -1;
    }
}//T-O(E),S-O(N)