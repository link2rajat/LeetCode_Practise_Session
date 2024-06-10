class Solution {
    class LargeNumberComparator implements Comparator<String>{
        
        @Override
        public int compare(String a,String b){
            String order1= a+b;
            String order2= b+a;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] numsCharArray = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numsCharArray[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsCharArray,new LargeNumberComparator());
        
        if(numsCharArray[0].equals("0")){
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        for(String numChar :numsCharArray){
            result.append(numChar);
        }
        
        return result.toString();
    }
}//T-O(nlogn),S-O(n)