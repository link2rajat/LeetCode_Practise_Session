class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int size=arr.length;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
         List<Integer> valueList = new ArrayList<>();
        for(int val:map.values()){
            valueList.add(val);
        }
        Collections.sort(valueList);
          Collections.reverse(valueList);
       
        
        int numElementRemove=0;
        int ans =0;
        for(int val:valueList){
            numElementRemove+=val;
            ans++;
            if(numElementRemove>=size/2){
                break;
            }
        }
        return ans;
        
    }
}