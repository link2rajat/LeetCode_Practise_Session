class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
       Arrays.sort(asteroids);
        long massSum=mass;
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>massSum){
                return false;
            }
            massSum+=asteroids[i];
        }
        return true;
    }
}