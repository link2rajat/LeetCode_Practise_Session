//
class Solution {
    public boolean circularArrayLoop(int[] nums) {
    
        if(nums.length<=1)
            return false;
   
    for(int i=0;i<nums.length;i++)
     {
        
      int slow,fast;
      slow = fast = i;
      boolean dir = nums[i]>0;
        while(true)
        {
        slow = nextPoint(slow,nums,dir);
            
        if(slow==-1)
        {
            break;
        }
            
        fast = nextPoint(fast,nums,dir);
        if(fast==-1)
        {
            break;
        }
 
        fast = nextPoint(fast,nums,dir);
        if(fast==-1)
        {
            break;
        }
            
        if(slow==fast)
        {
        return true;
        }
      }
     }
        return false;
    }//T-O(n^2).S-O(1)
    
    int nextPoint(int index,int[] nums,boolean dir)
    {
        boolean newdir = nums[index]>=0;
        
        if(dir != newdir)
        {
            return -1;
        }
        
        int nextIndex = (index+nums[index])% nums.length;
        
        if(nextIndex<0)
        {
            nextIndex+= nums.length;
        }
         
       //self loop
        if(nextIndex== index)
        {
            return -1;
        }
        
        return nextIndex;
        
    }
    
}