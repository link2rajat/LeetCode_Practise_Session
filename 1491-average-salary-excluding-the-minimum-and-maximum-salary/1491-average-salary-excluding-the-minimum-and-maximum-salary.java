class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum =0;
        
        for(int individualSalary : salary){
            
            sum+=individualSalary;
            minSalary= Math.min(minSalary,individualSalary);
            maxSalary= Math.max(maxSalary,individualSalary);
        }
        
        return (double)(sum-minSalary-maxSalary)/(double)(salary.length-2);
    }
}//T-O(N),S-O(1)