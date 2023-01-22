class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        checkPalindromePartition(result, new ArrayList<String>(),0,s);
        return result;
    }//T-O(n*2^N),S-O(n)
    void checkPalindromePartition(List<List<String>> result, List<String> currentList,int index,String s){
        if(index==s.length()){
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            
            if(isPalindrome(s,index,i)){
            currentList.add(s.substring(index,i+1));
            checkPalindromePartition(result, currentList,i+1,s);    
            currentList.remove(currentList.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}