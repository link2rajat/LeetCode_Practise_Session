class Solution {
    public int[] sortByBits(int[] arr) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        
        for(int i=0;i<arr.length;i++)
        {
            int count = countBits(arr[i]);
                
            pq.offer(new int[]{count,arr[i]});
        }
        
        int index=0;
        int[] result = new int[arr.length];
        
        while(!pq.isEmpty())
        {
            result[index++]=pq.poll()[1];
        }
        
        return result;
        
    }//T-O(nlogn),S-O(n)
    
    int countBits(int num)
    {
        int count=0;
        while(num !=0)
        {
            num=num&(num-1);
            count++;
        }
        return count;
    }
}