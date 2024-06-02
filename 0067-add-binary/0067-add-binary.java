class Solution {
    public String addBinary(String a, String b) {
        int n=a.length(),m=b.length();
        StringBuilder result = new StringBuilder();
        int i=n-1,j=m-1;
        int carry=0;
        while(i>=0 || j>=0){
            int sum=carry;
            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }
            if(j>=0){
                sum+=b.charAt(j--)-'0';
            }
            result.insert(0,sum%2);
            carry=sum/2;
        }
        if(carry>0){
            result.insert(0,1);
        }
        return result.toString();
    }
}