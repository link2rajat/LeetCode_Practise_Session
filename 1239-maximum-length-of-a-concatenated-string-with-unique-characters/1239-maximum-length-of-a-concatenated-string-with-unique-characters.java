class Solution {
    
    int count=0;
    public int maxLength(List<String> arr) {
        dfs(arr,"",0);
        return count;
    }//T-O(2^N),S-O(N)
    
    void dfs(List<String>arr,String concat,int index)
    {
        if(isUnique(concat)) count=Math.max(count,concat.length());
        
        if(index==arr.size()|| !isUnique(concat))return;
        
        for(int i=index;i<arr.size();i++)
        {
            dfs(arr,concat+arr.get(i),i+1);
        }
    }
    
    boolean isUnique(String str)
    {
        int[] charArr = new int[26];
        
        for(int i=0;i<str.length();i++)
            charArr[str.charAt(i)-'a']++;
        
        for(int i=0;i<charArr.length;i++)
        {
            if(charArr[i]>1)
                return false;
        }
        
        return true;
    }
}