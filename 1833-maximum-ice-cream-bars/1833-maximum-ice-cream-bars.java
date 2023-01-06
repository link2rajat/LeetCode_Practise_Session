class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
       
        for(int i=0;i<costs.length;i++){
            if(coins>=costs[i]){
                coins-=costs[i];
                count++;
            }
        }
        return count;
    }
}//T-O(nlogn),S-O(1)