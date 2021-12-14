class Solution {
    public boolean isHappy(int n) {
     HashSet<Integer> set = new HashSet<Integer>();
        while(n!=1 && !set.contains(n))
        {
            set.add(n);
            n=getNextN(n);
        }
        return n==1;
    }
    
    int getNextN(int n)
    {
      int  result = 0;
          
     while(n>0)
     {
         int digit= n%10;
         n=n/10;
         result+=digit*digit;
     }
         return result;
            
        }
    }//T-O(log n ),S-O(log n)
