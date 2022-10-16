//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/739493/Java-Recursive-Intuitive-Solution-%3A-Top-Down
/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/739493/Java-Recursive-Intuitive-Solution-%3A-Top-Down ,https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/491590/Java-DP-Top-Down-Solution-Clean-code , https://medium.com/@chuncaohenli/1335-minimum-difficulty-of-a-job-schedule-5ee30d10a88b
*/
class Solution {
    static int memo[][];
    public int minDifficulty(int[] jobDifficulty, int d) {
        memo = new int[jobDifficulty.length+1][d+1];
        for(int[] row: memo)
        {
            Arrays.fill(row,-1);
        }
        if(jobDifficulty.length<d)
        {
            return -1;
        }
        int startday=0;
        return mindifjobschdfs(startday,d,jobDifficulty);
    }
    
    static int mindifjobschdfs(int startday,int dayleft,int[] jobDifficulty)
    { 
        if(memo[startday][dayleft]!= -1)
        {return memo[startday][dayleft];}
        
        if(dayleft==1)
        {
            int max = Integer.MIN_VALUE;
            for(int i=startday;i<jobDifficulty.length;i++)
            {
                max = Math.max(max,jobDifficulty[i]);
            }
            return memo[startday][dayleft] = max;
        }
        int maxForday=0;
        int result = Integer.MAX_VALUE;
        for(int i=startday;i<=jobDifficulty.length-dayleft;i++)
            {
                maxForday = Math.max(maxForday,jobDifficulty[i]);
                result = Math.min(result ,maxForday + mindifjobschdfs(i+1,dayleft-1,jobDifficulty));
            }
         return memo[startday][dayleft] = result;
    }
}