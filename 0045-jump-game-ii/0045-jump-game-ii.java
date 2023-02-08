//https://www.youtube.com/watch?v=vBdo7wtwlXs&ab_channel=IDeserve
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MinJumpToReachEnd.java
//https://www.youtube.com/watch?v=cETfFsSTGJI&ab_channel=TusharRoy-CodingMadeSimple
class Solution {
    public int jump(int[] arr) {
       if(arr.length<=1)return 0;
        int ladder=arr[0];
        int stairs=arr[0];
        int jump=1;
        for(int level=1;level<arr.length;level++)
        {
            if(level==arr.length-1)return jump;
            
            if(ladder<level+arr[level])ladder=level+arr[level];
            
            stairs--;
            if(stairs==0)
            {
                jump++;
                stairs=ladder-level;
            }
            
        }
        return jump;
    }
}