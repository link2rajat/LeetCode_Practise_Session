class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int m=haystack.length();
        int n=needle.length();
           if(m<n) return -1;
        for(int i=0;i<=m-n;i++)
        {
            for(int j=0;j<n && haystack.charAt(i+j) == needle.charAt(j); j++)
             if(j==n-1)
                return i;
        }
        
        return -1;
    }
}//T-O(M*N),S-O(1)