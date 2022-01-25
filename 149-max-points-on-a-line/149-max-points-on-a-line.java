  /*
     *  A line is determined by two factors,say y=ax+b
     *  
     *  If two points(x1,y1) (x2,y2) are on the same line(Of course). 

     *  Consider the gap between two points.

     *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

     *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

     *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  So we can use y0&x0 to track a line;
     */
class Solution {
    public int maxPoints(int[][] points) {
       if(points == null) 
           return 0;
        int pointsCount = points.length;
        
        if(pointsCount<=2) return pointsCount;
        
        Map<Pair<Integer,Integer>, Integer> pointMap = new HashMap<>();
        int result=0;
        
        for(int index1=0; index1<pointsCount; index1++)
        {
            pointMap.clear();
            int overlap=0,current_max=0;
            
            for(int index2 = index1+1; index2<pointsCount;index2++)
            {
               int diff_x = points[index2][0]- points[index1][0];
               int diff_y = points[index2][1]- points[index1][1];
                
                if(diff_x==0 && diff_y==0)
                {
                    overlap++;
                    continue;
                }
                
                int gcd = findGCD(diff_x,diff_y);
                    
                    if(gcd !=0)
                    {
                        diff_x/=gcd;
                        diff_y/=gcd;
                    }
             Pair<Integer,Integer> currentLine = new Pair(diff_x,diff_y);
                
             pointMap.put(currentLine,pointMap.containsKey(currentLine)?pointMap.get(currentLine)+1 :1);   
             current_max = Math.max(current_max,pointMap.get(currentLine));        
            }
            result = Math.max(result, current_max+overlap+1);
        }
       return result; 
    }
    
    int findGCD(int num_1, int num_2)
    {
        return(num_2==0)? num_1:findGCD(num_2,num_1%num_2);
    }
}

/*
As a reminder, two integers are co-primes, if and only if their greatest common divisor is 1.

As one can see, due to the property of co-prime numbers, they can be used to represent the slope values of different lines. For example, for the slope values of \frac{1}{3}, \frac{2}{6}, \frac{3}{9} 
3
1
        
 , 
6
2
        
 , 
9
3       
 , they all can be represented with the co-prime numbers of (1, 3)(1,3).

*/