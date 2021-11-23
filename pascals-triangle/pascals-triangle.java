class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for(int i=1;i<numRows;i++)
        {
            List<Integer> current = new ArrayList<>();
            List<Integer> prev = result.get(i-1); 

            current.add(1);
            for(int j =1;j<i;j++)
            {
                current.add(prev.get(j-1)+prev.get(j));
            }
             current.add(1);
            result.add(current);
        }
        return result;
    }
}
//T-O(n^2),S-O(n^2)