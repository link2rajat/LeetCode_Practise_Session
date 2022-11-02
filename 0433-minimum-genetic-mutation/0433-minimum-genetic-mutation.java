class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        queue.add(start);
        set.add(start);

        int step =0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int j=0;j<size;j++)
            {
             String node = queue.remove();
             
                if(node.equals(end)){
                    return step;
                }
                
                for(char ch : new char[]{'A','C','G','T'}){
                    for(int i=0;i<node.length();i++)
                    {
                    String newNode = node.substring(0,i)+ch+node.substring(i+1);
                    
                        if(!set.contains(newNode) && Arrays.asList(bank).contains(newNode))
                        {
                            queue.add(newNode);
                            set.add(newNode);
                        }
                    }
                }
            }
            step++;
        }
        
        return -1;
        
    }
}//T-O(N) , S-O(1)