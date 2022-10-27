//https://leetcode.com/problems/image-overlap/discuss/138976/A-generic-and-easy-to-understand-method
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int rows=img1.length,cols=img1[0].length;
        
        List<int[]> la = new ArrayList<>();
        List<int[]> lb= new ArrayList<>();

        for(int i=0;i<rows;i++)
          for(int j=0;j<cols;j++)
          {
              if(img1[i][j]==1) la.add(new int[]{i,j});
              if(img2[i][j]==1) lb.add(new int[]{i,j});
          }
        Map<String,Integer> map = new HashMap<>();
        
        for(int[] p1: la)
            for(int[] p2: lb)
            {
                String s =(p1[0]-p2[0])+" "+(p1[1]-p2[1]);
                map.put(s,map.getOrDefault(s,0)+1);
            }
        
        int max=0;
        
        for(int count:map.values())
        {
            max=Math.max(max,count);
        }
        
        return max;
        
    }
}//T-O(n^4),S-O(n)