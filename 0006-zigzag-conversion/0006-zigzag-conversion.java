public class Solution {
    public String convert(String s, int numRows) 
    {
        if(numRows<= 1) return s;
        StringBuilder sb[] = new StringBuilder[numRows];
        
        for(int i =0;i<sb.length;i++)
        {
            sb[i]= new StringBuilder("");
        }
        int incre=1;
        int ind=0;
        for(int i=0;i<s.length();i++)
        {
           sb[ind].append(s.charAt(i)); 
           if(ind==0){incre=1;}
           if(ind==numRows-1){incre=-1;}
           ind+=incre;
        }
        String rem="";
        for(int i=0;i<sb.length;i++)
        {
            rem+=sb[i];
        }
        return rem.toString();
    }
}