class Solution {
    //https://www.youtube.com/watch?v=AFCk84AXvsA&ab_channel=Fraz
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> countMap = new HashMap<>();
        int [] list = new int[arr.length+1];
        
        for(int ar: arr)
        {
          countMap.put(ar,countMap.getOrDefault(ar,0)+1);  
        }
        
        for(int number : countMap.keySet())
        {
            int count = countMap.get(number);
            list[count]+=1;
        }
        
        int step=0,res=0;
        
        for(int i=arr.length;i>0;i--)
        {
            int cur=list[i];
            
            while(cur-->0)
            {
                step+=i;
                res++;
                if(step>=arr.length/2)
                {
                    return res;
                }
                    
            }
        }
        
        return arr.length;
        
        
    }
}//T-O(n),S-O(n)