class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++)
        {
          for(int j=0;j<matrix[0].length;j++)
           {
           pq.offer(matrix[i][j]);
              while(pq.size()>k)
              {
                  pq.poll();
              }
                
           }
        }
        return pq.peek();
    }
}//T-O(NMlognk),S-O(k)