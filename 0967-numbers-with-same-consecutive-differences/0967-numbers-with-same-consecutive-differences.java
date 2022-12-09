//https://www.youtube.com/watch?v=TAfXh2l9FyA&ab_channel=KnowledgeCenter
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if(n==1){
         result.add(0);   
        }
        
            for(int i=1;i<10;i++){
                dfsHelper(i,n-1,k,result);
            }
        
        return result.stream().mapToInt(i->i).toArray();
    }//T-O(2^N),S-O(2^N)
    
    void dfsHelper(int digit, int n,int k, List<Integer> result){

        if(n==0){
            result.add(digit);
            return;
        }
        
        int lastDigit = digit%10;
        
        if(lastDigit >= k){
            dfsHelper(digit*10+lastDigit-k,n-1,k,result);
        }
        if(k>0 && lastDigit+ k < 10){
            dfsHelper(digit*10+lastDigit+k,n-1,k,result);
        }

    }
}