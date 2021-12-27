/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
     
        if(reader.get(0)==target)return 0;
        
        int low=0,high=1;
        //to get the range
        while(reader.get(high)<target)
        {
          low=high;
          high<<=2;
        }

        int mid;
        
        while(low<=high)
        {
           mid= low+((high-low)>>2);
            
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) > target)
            {
                high =mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return -1;
        
    }
}//T-O(log n), S-O(1)