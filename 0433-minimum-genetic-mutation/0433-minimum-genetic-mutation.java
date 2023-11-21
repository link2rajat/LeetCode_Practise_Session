class Pair{
    String nextStr;
    int steps;
    Pair(String nextStr,int steps){
        this.nextStr=nextStr;
        this.steps=steps;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(String s:bank){
            bankSet.add(s);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene,0));
        seen.add(startGene);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String node = pair.nextStr;
            int steps= pair.steps;
            if(node.equals(endGene)){
                return steps;
            }
            for(String nextString : neighbour(node)){
                if(bankSet.contains(nextString) && !seen.contains(nextString)){
                    queue.offer(new Pair(nextString,steps+1));
                    seen.add(nextString);
                  
                }
            }
        }
        return -1;
    }
    
    List<String> neighbour(String node){
        List<String> ans = new ArrayList<>();
         for(char ch : new char[]{'A', 'C', 'G', 'T'}){
        for(int i=0;i<node.length();i++){
            ans.add(node.substring(0,i)+ch+node.substring(i+1));
            }
        }
        return ans;
    }
}