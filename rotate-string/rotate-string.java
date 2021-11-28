class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length())
            return false;
        int i=0;
        int j=s.length();
        
        while(i<j)
        {
            s=s.substring(1,s.length()).concat(s.substring(0,1));
            
            if(s.equals(goal))
            {
                return true;
            }
            i++;
        }
        return false;
    }
}