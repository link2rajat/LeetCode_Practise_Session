class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int [nums1.length];
        
        for(int num: nums2){
            while(!stack.isEmpty() && num>stack.peek()){
                map.put(stack.pop(),num);
            }
            stack.push(num);
          }
        
        while(!stack.isEmpty()){
             map.put(stack.pop(),-1);
         }
        
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                answer[i]=map.get(nums1[i]);
            }
        }

        return answer;
    }
}