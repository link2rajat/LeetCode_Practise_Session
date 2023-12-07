class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        int target = n;
        for(int i=1;i<=9;i++){
            candidate.add(i);
        }
         List<Integer> subset = new ArrayList<>();
        backtrack(0,candidate,subset,target,k,ans);
        return ans;
    }
    void backtrack(int i, List<Integer> candidate, List<Integer> subset
                   ,int target, int k, List<List<Integer>> ans ){
        int n=candidate.size();
        if(target==0 && k==0){
            ans.add(new ArrayList<>(subset));
        }
        
        for(int j=i;j<n;j++){
            if(j>i && candidate.get(j)==candidate.get(j-1)){
                continue;
            }
            if(candidate.get(j)<=target){
                subset.add(candidate.get(j));
                  backtrack(j+1,candidate,subset,target-candidate.get(j),k-1,ans);
                 subset.remove(subset.size()-1);

            }
        }
    }
}