class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums1!=null && nums2==null)
        {
            return; 
        }
        else if(nums1==null && nums2!=null)
        {
            nums1 = nums2;
            return;
        }
        
        int i=m-1,j=n-1;
        int k=nums1.length-1;
            while(i>=0 && j>=0)
            {
                if(nums1[i]>nums2[j])
                {
                    nums1[k--] = nums1[i--];
                }
                else {
                    nums1[k--] = nums2[j--];
                }
           }

          if(i>=0 && j<=0)
          {
            while(i>=0)
                {
                    nums1[k--] = nums1[i--];
                }
          }
        
          if(j>=0 && i<=0)
          {
            while(j>=0)
                {
                    nums1[k--] = nums2[j--];
                }
          }
    }
}//T-O(m+n),S-O(1),m is length of nums1 and n is length of nums2