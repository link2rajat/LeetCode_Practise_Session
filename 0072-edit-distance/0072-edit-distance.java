class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()+1][word2.length()+1];
        return minDistanceHelper(word1,word2,word1.length(),word2.length());
    }
    
    int minDistanceHelper(String word1, String word2, int word1Index, int word2Index){
        if(word1Index == 0){
            return word2Index;
        }
        if(word2Index == 0){
            return word1Index;
        }
        if(memo[word1Index][word2Index] !=null){
            return memo[word1Index][word2Index];
        }
        int minEditDistane =0;
        if(word1.charAt(word1Index-1) == word2.charAt(word2Index-1)){
         minEditDistane =  minDistanceHelper(word1,word2,word1Index-1,word2Index-1);    
        } else{
            int insertOperation = minDistanceHelper(word1,word2,word1Index,word2Index-1);
            int deleteOperation = minDistanceHelper(word1,word2,word1Index-1,word2Index);
            int replaceOperation = minDistanceHelper(word1,word2,word1Index-1,word2Index-1);
            minEditDistane =1+Math.min(insertOperation,Math.min(deleteOperation,replaceOperation));
        }
        memo[word1Index][word2Index] = minEditDistane;
        return minEditDistane; 
    }
}//T-O(M*N),S-O(M*N)