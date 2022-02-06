class Solution {
    public int maxArea(int[] height) {
     int maxArea = 0;
        int low=0, high=height.length-1;
        
        while(low<high)
        {
          
            maxArea=Math.max(maxArea,Math.min(height[low],height[high])*(high-low));
                if(height[low]<height[high])
                    low++;
            else
                high--;
        }
        return maxArea;
        
    }
}//T-O(n),S-O(1)