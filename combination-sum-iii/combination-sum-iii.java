//https://www.youtube.com/watch?v=rP_K3WJnRR4
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        backtrack(1,candidate,n,k,ans);
        return ans;
    }
    void backtrack(int start, List<Integer> candidate,int n, int k,List<List<Integer>> ans ){
        if( k==candidate.size()){
            if(n==0)
            ans.add(new ArrayList<>(candidate));
            return;
        }
        
        for(int j=start;j<=9;j++){
                candidate.add(j);
                backtrack(j+1,candidate,n-j,k,ans);
                 candidate.remove(candidate.size()-1);
        }
    }
}