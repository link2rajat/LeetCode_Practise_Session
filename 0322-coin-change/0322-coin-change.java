class Solution {
    public int coinChange(int[] denoms, int n) {
        
 int[] numsOfCoins = new int[n+1];
  Arrays.fill(numsOfCoins,Integer.MAX_VALUE);
    numsOfCoins[0]=0;
    int toCompare =0;
    for(int denom:denoms){
      for(int amount=0;amount<numsOfCoins.length;amount++){
        if(denom<=amount){
          if(numsOfCoins[amount-denom]==Integer.MAX_VALUE){
            toCompare = numsOfCoins[amount-denom];
          }
          else{
            toCompare = 1+numsOfCoins[amount-denom];
          }
          numsOfCoins[amount] = Math.min(numsOfCoins[amount],toCompare);
        }
      }
    }
  return numsOfCoins[n] !=Integer.MAX_VALUE? numsOfCoins[n] : -1;
        
    }
}//T-O(S*n),S-O(S)