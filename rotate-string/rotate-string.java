class Solution {
    public boolean rotateString(String s, String goal) {
        String ss = s+s;
        if(s== "" && goal !=null)
            return false;

    if(s!= null && goal =="")
            return true;
        

      
        for(int i=0;i<ss.length()-1;i++)
        {
            for(int j=i+1;j<ss.length();j++)
            {
                
                if((goal.length()== s.length()) && goal.equals(ss.substring(i,j)))
                {
                    return true;
                }
            }
        }
        return false;
        
    }
}
//T->O(n^2), S->O(n), n ->length of s