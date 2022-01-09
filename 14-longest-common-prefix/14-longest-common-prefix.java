class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null ||strs.length==0) return "";
        
        String commonprefix = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            
            while(strs[i].indexOf(commonprefix) != 0)
            {
            commonprefix= commonprefix.substring(0,commonprefix.length()-1);
            if(commonprefix.isEmpty()) return "";
            }   
        }
        return commonprefix;
    }
}//T-O(N),S-O(1)