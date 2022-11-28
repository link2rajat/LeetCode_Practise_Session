class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int[] match: matches){
            int winner = match[0] , loser = match[1] ;
            
            map.put(winner,map.getOrDefault(winner,0));
            map.put(loser,map.getOrDefault(loser,0)+1);
        }
        
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(),new ArrayList<>());
        
        for(Integer player : map.keySet()){
            if(map.get(player) == 0){
                result.get(0).add(player);
            } else if(map.get(player) == 1){
                result.get(1).add(player);
            }
        }

        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
            
        return result;
    } 
} //T-O(nlogn),S-O(n)