class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result; 
    }
    void backtrack(List<String> result, StringBuilder current,int left,int right,int n){
        if(current.length()==2*n){
            result.add(current.toString());
            return;
        }
        if(left<n){
             current.append('(');
             backtrack(result,current,left+1,right,n);
             current.deleteCharAt(current.length()-1);
        }
        if(right<left){
             current.append(')');
             backtrack(result,current,left,right+1,n);
             current.deleteCharAt(current.length()-1);
        }
    }
}