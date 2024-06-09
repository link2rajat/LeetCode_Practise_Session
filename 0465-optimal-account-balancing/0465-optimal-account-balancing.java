class Solution {
    public int minTransfers(int[][] transactions) {
     Map<Integer,Integer> map= new HashMap<>();
        
        for(int[] t: transactions){
            map.put(t[0],map.getOrDefault(t[0],0)-t[2]);
            map.put(t[1],map.getOrDefault(t[1],0)+t[2]);
        }
        
        return backtrackSettle(0,new ArrayList<>(map.values()));
    }
    
    int backtrackSettle(int index,List<Integer> debt){
        while(index<debt.size() && debt.get(index)==0)
            index++;
        if(index==debt.size())return 0;
        int minValue= Integer.MAX_VALUE;
        for(int i=index+1;i<debt.size();i++){
            if(debt.get(index)*debt.get(i)<0){
                debt.set(i,debt.get(i)+debt.get(index));
                minValue=Math.min(minValue,1+backtrackSettle(index+1,debt));
                debt.set(i,debt.get(i)-debt.get(index));
            }
        }
        return minValue;
    }
}