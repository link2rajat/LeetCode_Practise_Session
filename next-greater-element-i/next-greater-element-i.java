class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[nums1.length];
        
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        while(!stack.isEmpty()){
                map.put(stack.pop(),-1);
            }
        
        for(int i=0;i<nums1.length;i++){
            answer[i]= map.get(nums1[i]);
        }
        return answer;
    }
}