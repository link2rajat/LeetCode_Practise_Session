/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int celebrityCandidate = 0;
        
        for(int index=0;index<n;index++){
            if(knows(celebrityCandidate,index)){
                celebrityCandidate = index;
            }
        }
        if(isCelebrity(celebrityCandidate,n)){
            return celebrityCandidate;
        }
        return -1;
    }//T-O(N),S-O(1)
    
    public boolean isCelebrity(int i,int n){
        for(int j=0;j<n;j++){
            if(i==j) continue;
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }
}