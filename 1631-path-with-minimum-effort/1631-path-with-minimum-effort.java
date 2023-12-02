class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    public int minimumEffortPath(int[][] heights) {
        m =heights.length;
        n= heights[0].length;
        int left=0;
        int right = findMax(heights);
        while(left<=right){
         int mid=left+(right-left)/2;
            if(isMinimumEffortPath(mid,heights)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    
    boolean isMinimumEffortPath(int mid,int[][]heights){
        boolean[][] visited = new boolean[m][n];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0,0));
        visited[0][0]=true;
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int row = pair.row;
            int col = pair.col;
            if(row==m-1 && col==n-1){
                return true;
            }
            for(int[] dir: direction){
                int nextRow = row+dir[0];
                int nextCol = col+dir[1];
                if(isValid(nextRow,nextCol) && visited[nextRow][nextCol] != true){
                    if(Math.abs(heights[nextRow][nextCol]-heights[row][col])<=mid){
                        visited[nextRow][nextCol]=true;
                        stack.push(new Pair(nextRow,nextCol));
                    }
                }
            }
        }
        return false;
    }
    
    boolean isValid(int row,int col){
        return 0<=row && row<m && 0<=col && col<n; 
    }
    int findMax(int[][] heights){
        int max=0;
        for(int[] row: heights){
            for(int num:row){
                max=Math.max(max,num);
            }
        }
        return max;
    }
}