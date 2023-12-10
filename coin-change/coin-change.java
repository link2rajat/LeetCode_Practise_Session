class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] denoms = new int[amount+1];
        Arrays.fill(denoms,Integer.MAX_VALUE);
        denoms[0]=0;
        int toCompare=0;
        for(int coin:coins){
            for(int i=0;i<amount+1;i++){
                if(coin<=i){
                    if(denoms[i-coin]==Integer.MAX_VALUE){
                        toCompare=denoms[i-coin];
                    }else{
                         toCompare=denoms[i-coin]+1;
                    }
                    denoms[i]=Math.min(denoms[i],toCompare);
                }
            }
        }
        return denoms[amount]!=Integer.MAX_VALUE ? denoms[amount]: -1;
    }
}