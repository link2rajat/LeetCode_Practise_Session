class Pair{
    String node;
    int steps;
    Pair(String node,int steps){
        this.node=node;
        this.steps=steps;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        
        for(String s:deadends){
            if(s.equals("0000")){
                return -1;
            }
            seen.add(s);
        }
        
        queue.offer(new Pair("0000",0));
        seen.add("0000");
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String node = pair.node;
            int steps = pair.steps;
            if(node.equals(target)){
                return steps;
            }
            for(String neighbour: neighbours(node)){
                if(!seen.contains(neighbour)){
                    seen.add(neighbour);
                    queue.offer(new Pair(neighbour,steps+1));
                }
            }
        }
        return -1;
    }
    
    public List<String> neighbours(String node){
        List<String> neighbour = new ArrayList<>();
        for(int i=0;i<4;i++){
            //convert String to num using -'0'
            int num = (node.charAt(i)-'0');
            for(int change: new int[]{-1,1}){
                
                int changed = (num+change+10)%10;
                //convert num to String using ""
                neighbour.add(node.substring(0,i)+(""+changed)+node.substring(i+1));
            }
        }
        return neighbour;
    }
}