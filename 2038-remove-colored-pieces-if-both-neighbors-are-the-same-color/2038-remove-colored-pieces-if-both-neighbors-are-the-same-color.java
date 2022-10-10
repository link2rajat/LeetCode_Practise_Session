class Solution {
    public boolean winnerOfGame(String colors) {
        int a=0,b=0;
        
        for(int i=1;i<colors.length()-1;i++)
        {
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i+1)==colors.charAt(i))
            {
                if(colors.charAt(i)=='A')
                {
                    a++;
                }
                else{
                    b++;
                }
            }
        }
        return a>b;
    }
}//T-O(n),S-O(1)