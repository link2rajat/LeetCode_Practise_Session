class Solution {
    public int[] getOrder(int[][] tasks) {
        
        
        PriorityQueue<int[]> nextTaskPriorityQueue = new PriorityQueue<int[]>((a,b)->(a[1]!=b[1])?(a[1]-b[1]):(a[2]-b[2]));
        
        int n = tasks.length;
        
        int sortedTasks [][] = new int[n][3];
        
        for(int i=0;i<tasks.length;i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        
        Arrays.sort(sortedTasks,(a,b)->Integer.compare(a[0],b[0]));

        int[] taskOrder = new int[n];
        
        long currentTime = 0;
        int taskIndex =0;
        int orderIndex = 0;
        
        while(taskIndex<n || !nextTaskPriorityQueue.isEmpty()){
            //CPU IdleTime, to be updated to next task 
            if(nextTaskPriorityQueue.isEmpty() && currentTime < sortedTasks[taskIndex][0]){
                currentTime = sortedTasks[taskIndex][0];
            }
            
            while(taskIndex<n && currentTime >= sortedTasks[taskIndex][0]){
                
                nextTaskPriorityQueue.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }
            
            int processTime = nextTaskPriorityQueue.peek()[1];
            currentTime+=processTime;
            int index = nextTaskPriorityQueue.peek()[2];
            taskOrder[orderIndex++]=index;
            nextTaskPriorityQueue.remove();
        }
        
        return taskOrder;
    }
}//T-O(NlogN),S-O(N)