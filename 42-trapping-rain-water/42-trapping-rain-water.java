class Solution {
    public int trap(int[] height) {
        
        int l=0,r=height.length-1;
     int left_max=0,right_max=0;
     int ans=0;
     while(l<r)
     {
         if(height[l]<height[r]) {
         if (height[l]>=left_max)
         {
             left_max = height[l];
             
         }
         else
         {
         ans+=(left_max-height[l]);
         }
         ++l;
     }
     else
         {
             if(height[r]>right_max)
             {
                 right_max = height[r];
             }
             else
             {
                 ans+=(right_max-height[r]);
             }
         --r;
         }
     }
     return ans;
    }
} //T-O(n),S-O(1)