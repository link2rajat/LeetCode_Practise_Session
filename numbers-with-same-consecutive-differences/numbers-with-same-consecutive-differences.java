class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if(n==1)
            result.add(0);
        
        for(int i=1;i<10;i++){
            backtrack(i,n-1,k,result);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    void backtrack(int digit,int n,int k,List<Integer> result){
        if(n==0){
            result.add(digit);
            return;
        }
        int lastDigit=digit%10;
        if(lastDigit>=k){
            backtrack(digit*10+lastDigit-k,n-1,k,result);
        }
        if(k>0 && lastDigit+k<10){
            backtrack(digit*10+lastDigit+k,n-1,k,result);
        }
    }
}