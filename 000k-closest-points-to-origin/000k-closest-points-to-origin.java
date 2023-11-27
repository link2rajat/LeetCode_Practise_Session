class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        PriorityQueue<int[]> queue = new PriorityQueue<>((n1,n2)->n2[0]-n1[0]);
        
        for(int i=0;i<points.length;i++){
            
         int[] entry= {distance(points[i]),i};
            
            if(queue.size()<k){
                queue.offer(entry);
            }else if(entry[0]<queue.peek()[0]){
                queue.poll();
                queue.add(entry);
            }
        }
        int [][] ans = new int [k][2];
        
        for(int i=0;i<k;i++){
            int index =queue.poll()[1];
            ans[i]=points[index];
        }
        
        return ans;
        
    }
    int distance(int[] points){
        return (points[0])*(points[0])+(points[1])*(points[1]);
    }
}