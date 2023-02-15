class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int length = num.length-1;
        
        while(length>=0 || k!=0){
            if(length>=0){
                k+=num[length];
                length--;
            }
            ans.addFirst(k%10);
            k/=10;
        }
        return ans;
    }
}//T-O(max(n,logk),S-O(max(n,logk))