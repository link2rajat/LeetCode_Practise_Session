class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(arr[node]==0){
                return true;
            }
            if(arr[node]<0){
                continue;
            }
            if(node+arr[node]<n){
                queue.offer(node+arr[node]);
            }
             if(node-arr[node]>=0){
                queue.offer(node-arr[node]);
            }
            arr[node]=-arr[node];
        }
         return false;
    }
}