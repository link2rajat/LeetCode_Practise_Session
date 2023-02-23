//Sort capital based on profits,
//with w take capital which has highest profit
//deduct it from list and with next profit
//again take from cap which has highest profit 
// repeat this step till k projects

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
         //pq with inc order of cap   
        PriorityQueue<int[]> pqCap = new  PriorityQueue<>((a1,a2)->(a1[0]-a2[0]));
        // pq with dec order of pro
        PriorityQueue<int[]> pqPro = new  PriorityQueue<>((b1,b2)->(b2[1]-b1[1]));

        for(int i=0;i<profits.length;i++)
        {
            pqCap.offer(new int[]{capital[i],profits[i]});
        }
        
        
        for(int j=0;j<k;j++)
        {
            while(!pqCap.isEmpty() && pqCap.peek()[0] <=w)
            {
                pqPro.offer(pqCap.poll());
            }
            
            if(pqPro.isEmpty()) 
                break;
          
            w+= pqPro.poll()[1];
        }
        
        return w;
        
    }
}//T-O(Nlogk),S-O(N)