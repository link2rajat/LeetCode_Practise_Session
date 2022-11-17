class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        
        int areaRectangleA = Math.abs(D-B) * Math.abs(C-A);
        
        int areaRectangleB = Math.abs(H-F)* Math.abs(G-E);
        
        //calculate x Overlap
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        
        int xOverLap = right - left;
        
        //calculate y Overlap
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        
        int yOverLap = top - bottom;
        
        int areaOverlap = 0;
        
        if(xOverLap>0 && yOverLap>0){
            areaOverlap = Math.abs(xOverLap) * Math.abs(yOverLap);
        }
        
        int totalArea = areaRectangleA + areaRectangleB - areaOverlap;
            
            return totalArea;
    }
} //T-O(1) , S-O(1)