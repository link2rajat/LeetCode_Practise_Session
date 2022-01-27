class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        if(n==0) return result;
        
        for(int index=1;index<=n;index++)
        {
            if((index%3==0) && (index%5==0))
            {
                result.add("FizzBuzz");
            }
            else if(index%5==0)
            {
               result.add("Buzz");
            }
            else if(index%3==0 )
            {
                 result.add("Fizz");
            }
            else
            {
                result.add(String.valueOf(index));
            }
        }
        return result;
    }
}//T-O(N),S-O(1)