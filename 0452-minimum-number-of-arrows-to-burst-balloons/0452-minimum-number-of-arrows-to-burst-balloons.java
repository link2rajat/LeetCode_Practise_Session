class Solution {
    public int findMinArrowShots(int[][] points) {
    if(points == null || points.length == 0) return 0;
    Arrays.sort(points, ( x, y) -> x[1] < y[1]? -1:1);
    
    int min = points[0][1], arrowCount = 1;
    for(int i = 1; i < points.length; i++) {
        // if does not intersect, need one more arrow for next set of balloons
        if(points[i][0] > min) { 
            arrowCount++;
            min = points[i][1];
        }
    }
    return arrowCount;
}
}//T-O(nlogn),S-O(nlogn)