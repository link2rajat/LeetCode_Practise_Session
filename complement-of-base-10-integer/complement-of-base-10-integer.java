class Solution {
    public int bitwiseComplement(int num) {
           if (num == 0) return 1;
        int i=0;
        int result=0;
        
        while(num>0)
        {
           if((num&1)==0)
               result+=1<<i;
            
            i+=1;
            num>>=1;
        }
        
        return result;
    }
}//T-O(1),S-O(1)