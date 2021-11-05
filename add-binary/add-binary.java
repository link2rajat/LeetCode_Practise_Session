class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        StringBuilder result = new StringBuilder();
        int carry=0;
        while (m >=0 || n>=0)
        { 
            int sum=carry;
         if(m >=0)
            {
            //-'0' to convert char to int
             sum+=a.charAt(m--)-'0';   
            }
          if(n >=0)
            {
             sum+=b.charAt(n--)-'0';   
            }
             result.insert(0,sum%2);
             carry = sum/2;
        }
        if(carry>0)
          {
          result.insert(0,1);
          }
             
             return result.toString();

    }
}//T-O(max(m,n)),S-O(max(m,n))