
public class Solution {
//https://www.youtube.com/watch?v=JfB3BugMht8
    public List<String> restoreIpAddresses(String s) 
    {
    List<String> result = new ArrayList<String>();
        int len = s.length();
        for(int i=1;i<len-2&&i<4;i++)
        {for(int j=i+1;j<len-1&&j<i+4;j++)
          {       for(int k=j+1;k<len&&k<j+4;k++)
                {
                  String s1 = s.substring(0,i), s2=s.substring(i,j) ,s3=s.substring(j,k),s4 = s.substring(k,len);
              
              if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
              {
                  result.add(s1+"."+s2+"."+s3+"."+s4);
              }
              
              }
          }
        
        }
        return result;
    }
    
    boolean isValid(String s)
    {
        if(s.length()>3||s.length()==0 ||(s.charAt(0)=='0' && s.length()>1)|| Integer.parseInt(s)>255)
            return false;
        return true;
    }
    
    
}