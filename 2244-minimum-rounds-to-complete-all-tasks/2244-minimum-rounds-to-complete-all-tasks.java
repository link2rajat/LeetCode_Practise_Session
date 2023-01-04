class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
       
      
        int count=0;
        for(int value:map.values()){
            if(value==1) return -1;
          
            if(value%3==0)count+=value/3;
            else
                count+=value/3+1;
        }
            
    return count;
    }
}//T-O(n),S-O(n)