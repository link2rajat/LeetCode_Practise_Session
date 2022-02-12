public class Solution {
    public List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++)
        {
            if(i>0 && num[i]==num[i-1])
            {
                continue;
            }
            int j=i+1, k= num.length-1;
            int target = -num[i];
            while(j<k)
            { 
                if(num[j]+num[k]==target)
                {
                result.add(Arrays.asList(num[i],num[j],num[k]));
                j++;
                k--;
                
                while(j<k &&num[j]==num[j-1]){j++;}
                while(j<k &&num[k]==num[k+1]){k--;}
                }
                
                else if(num[j]+num[k]>target)
                {
                    k--;
                }
                else{
                    j++;
                }

            }
            
        }
        return result;
    }
    
}//T-O(N^2),S-O(N)